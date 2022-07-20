package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication：该注解标志该类是一个 springboot 的应用
@SpringBootApplication
public class Springboot01HelloworldApplication {

    public static void main(String[] args) {
        //将 springboot 应用启动
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}
