package com.hfz.hfzzuul.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;

/**
 * @author youjin
 * @Description:
 * @date 2018-03-22-15:31
 */
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("operator","forezp");
        System.out.print(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
