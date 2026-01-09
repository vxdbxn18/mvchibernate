package com.kata.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("com.kata.springmvc.controller")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        var r = new SpringResourceTemplateResolver();
        r.setPrefix("/WEB-INF/view/");
        r.setSuffix(".html");
        r.setTemplateMode("HTML");
        r.setCharacterEncoding("UTF-8");
        r.setCacheable(false);
        return r;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        var e = new SpringTemplateEngine();
        e.setTemplateResolver(templateResolver());
        e.setEnableSpringELCompiler(true);
        return e;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        var vr = new ThymeleafViewResolver();
        vr.setTemplateEngine(templateEngine());
        vr.setCharacterEncoding("UTF-8");
        return vr;
    }
}