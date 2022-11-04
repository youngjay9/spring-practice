package com.example.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

// OpenFeign 需要知道定義 client contract 的介面在哪裏
@Configuration
@EnableFeignClients(basePackages = "com.example.proxy")
public class ProjectConfig {

}
