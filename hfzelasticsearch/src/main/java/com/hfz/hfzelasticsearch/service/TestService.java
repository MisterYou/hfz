package com.hfz.hfzelasticsearch.service;

import com.hfz.hfzelasticsearch.dao.EmployeeRepository;
import com.hfz.hfzelasticsearch.vo.entity.Employee;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author youjin
 * @Description:
 * @date 2018-07-24-14:53
 */
@Service
public class TestService {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> select() {
        //创建builder
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        //builder下有must、should以及mustNot 相当于sql中的and、or以及not
        //设置模糊搜索
        builder.must(QueryBuilders.fuzzyQuery("name", "五常米"));
        //设置性别必须为man
        builder.must(new QueryStringQueryBuilder("man").field("sex"));

        //按照年龄从高到低
        FieldSortBuilder sort = SortBuilders.fieldSort("age").order(SortOrder.DESC);

        //设置分页(拿第一页，一页显示两条)
        //注意!es的分页api是从第0页开始的(坑)
        PageRequest page = new PageRequest(0, 2);

        //构建查询
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //将搜索条件设置到构建中
        nativeSearchQueryBuilder.withQuery(builder);
        //将分页设置到构建中
        nativeSearchQueryBuilder.withPageable(page);
        //将排序设置到构建中
        nativeSearchQueryBuilder.withSort(sort);
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        //执行
        Page<Employee> search = employeeRepository.search(query);

        //获取总条数(前端分页需要使用)
        int total = (int) search.getTotalElements();

        //获取查询到的数据内容
        List<Employee> content = search.getContent();

        //为了方便我就不显示总条数了，只在控制台给各位同学打印总条数看一下了
        System.out.println(total);
        return content;
    }


}
