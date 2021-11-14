package com.jay.example.defining.beans.usingStereotypeAnnotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * using component scan to fine the specific package @Component Class to add to the Spring Context
 */
@Configuration
@ComponentScan(basePackages = "com.jay.example.defining.beans.usingStereotypeAnnotations")
public class ProjectConfig {

}
