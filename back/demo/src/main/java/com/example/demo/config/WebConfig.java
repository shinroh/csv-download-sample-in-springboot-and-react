package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // ReactアプリケーションのURLを指定します
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS") // 必要なHTTPメソッドを許可します
                .allowedHeaders("*") // 任意のリクエストヘッダを許可します
                .allowCredentials(true); // クレデンシャルを許可します
    }
}
