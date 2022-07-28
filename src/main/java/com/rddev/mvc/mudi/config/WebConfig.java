package com.rddev.mvc.mudi.config;

import com.rddev.mvc.mudi.interceptor.InterceptorAdapter;
import com.rddev.mvc.mudi.repository.AcessoRepository;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private AcessoRepository acessoRepository;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorAdapter(acessoRepository)).addPathPatterns("/**");
    }
}
