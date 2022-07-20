package com.kuang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 如果我们要扩展 SpringMVC，官方建议我们这样去做
@Configuration
@EnableWebMvc // 该注解主要就是导入了一个类：DelegatingWebMvcConfiguration（从容器中获取所有的WebMvcConfigurer）
public class MyMvcConfig1 implements WebMvcConfigurer {

    // 视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kuang").setViewName("test");
    }
}
