package com.hp.config;

import com.hp.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin/login").setViewName("admin/login");
        registry.addViewController("/admin/index").setViewName("admin/index");
        registry.addViewController("/index/login").setViewName("index/login");
        registry.addViewController("/index/register").setViewName("index/register");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/admin/*","/index/*").
                excludePathPatterns("/admin/login","/admin/tologin").
                excludePathPatterns("/index/index","/index/logout","/index/tologin","/index/login","/index/today","/index/new","/index/hot","/index/type","/index/detail"
                ,"/index/register","/index/reg","/index/search");
    }
}
