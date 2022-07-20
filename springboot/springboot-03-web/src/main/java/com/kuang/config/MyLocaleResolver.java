package com.kuang.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    // 解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求中的语言参数
        String language = request.getParameter("l");

        // 如果没有就使用默认的
        Locale locale = Locale.getDefault();

        // 如果请求的链接携带了国际化的参数
        if (StringUtils.hasLength(language)) {
            // zh_CN
            String[] s = language.split("_");
            // 参数：s[0] 语言，s[1] 国家
            locale = new Locale(s[0], s[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
