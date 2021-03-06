package com.wiley.internal.apps.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private VerifyAccessInterceptor verifyAccessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifyAccessInterceptor).addPathPatterns("/**");
    }
    
    @Override 
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) { 
        configurer.favorPathExtension(false); 
    }
}
