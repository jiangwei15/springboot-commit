package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    // 后台监控：ServletRegistrationBean 相当于 web.xml
    // 因为 SpringBoot 内置了 servlet 容器，所以没有 web.xml ，替代方法 ：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 当我们访问路径 /druid/* 则会进入自带的后台监控页面
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();

        // 增加配置   *（通过当前用户进入 Druid 后台）
        initParameters.put("loginUsername", "admin"); //  登录 key 是固定的：loginUsername  loginPassword
        initParameters.put("loginPassword", "123456");

        // 允许谁可以访问
        initParameters.put("allow", ""); // "" 表示允许所有人

        // 禁止谁能访问
//        initParameters.put("kuangshen", "192.168.3.105"); // key：禁止的人  value：该用户对应的 ip 地址

        // 设置初始化参数
        bean.setInitParameters(initParameters);

        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());

        // 可以过滤哪些请求呢？
        HashMap<String, String> initParameters = new HashMap<>();

        // 这些东西不进行统计~
        initParameters.put("exclusion", "*.js, *.css, /druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
