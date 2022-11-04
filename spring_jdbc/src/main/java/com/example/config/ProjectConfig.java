package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Value("${custom.datasource.url}")
  private String dbUrl;

  @Value("${custom.datasource.username}")
  private String dbUserName;

  @Value("${custom.datasource.password}")
  private String dbPassword;

  @Bean
  public HikariDataSource dataSource() {

    System.out.println("ProjectConfig setDataSource()!");

    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(dbUrl);
    dataSource.setUsername(dbUserName);
    dataSource.setPassword(dbPassword);
    dataSource.setConnectionTimeout(1000);
    return dataSource;
  }


}
