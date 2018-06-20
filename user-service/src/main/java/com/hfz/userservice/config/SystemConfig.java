package com.hfz.userservice.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-20-11:33
 */
@Configuration
public class SystemConfig {
    @Bean
    public PropertiesFactoryBean drugstorageMsg() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/exception_config/exception.properties"));
        return propertiesFactoryBean;
    }
}
