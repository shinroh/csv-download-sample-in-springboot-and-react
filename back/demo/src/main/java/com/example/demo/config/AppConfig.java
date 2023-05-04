package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.example.demo")
@MapperScan("com.example.demo.mapper")
public class AppConfig {

    @Autowired
    private UserMapper userMapper;

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userMapper);
    }
}