package com.kuang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

// 如果，你想 diy 一些定制化的功能，只需要写这个组件，然后将它交给 SpringBoot，SpringBoot 就会帮我们自动装配
// 扩展 SpringMVC   dispatcherServlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 实现了 ViewResolver 接口的类，我们就可以把它看作视图解析器

    @Bean // 这里将MyViewResolver注册到bean中，由SpringBoot管理，从而实现自动装配
    public MyViewResolver getViewResolver() {
        return new MyViewResolver();
    }


    // 自定义了一个自己的视图解析器 MyViewResolver
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
