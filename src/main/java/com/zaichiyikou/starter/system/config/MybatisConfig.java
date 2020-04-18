package com.zaichiyikou.starter.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
@EnableTransactionManagement
@MapperScan({ "com.zaichiyikou.starter.system.mapper" })
public class MybatisConfig {

    // mbp内置分页插件
    // 注册分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 这种是基础配置，如果还要扩展，去官网看具体的配置
        // 不用再写limit了
        return new PaginationInterceptor();
    }
}
