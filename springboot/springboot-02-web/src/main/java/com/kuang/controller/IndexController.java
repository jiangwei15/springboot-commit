package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * 在 templates 目录下的所有页面，只能通过 controller 来跳转，
 *  并且需要模板引擎（Thymeleaf）的支持！
 *
 *  模板引擎：引入模板引擎Thymeleaf的依赖，将 html页面放入 templates中，
 *            controller便能跳转到templates下的指定的html视图中
 */
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model) {

        model.addAttribute("msg", "<h1>hello, springboot!</h1>");

        model.addAttribute("users", Arrays.asList("luolei", "feichao", "feikai"));

        return "test";
    }
}
