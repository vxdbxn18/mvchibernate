package com.kata.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.kata.springmvc", "com.kata.springmvc.dao"})
@EnableTransactionManagement
public class AppConfig {}