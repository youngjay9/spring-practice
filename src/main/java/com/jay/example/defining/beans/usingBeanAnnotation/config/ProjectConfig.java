package com.jay.example.defining.beans.usingBeanAnnotation.config;

import com.jay.example.defining.beans.usingBeanAnnotation.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * via @Configuration adding Beans to the SpringContext
 */
@Configuration
public class ProjectConfig {

  /**
   * 在  SpringContext 中相同的物件可透過不同的 Bean name 存取
   *
   * @return Parrot
   */
  @Bean(name = "Gigi")
  Parrot parrot() {
    Parrot parrot = new Parrot();
    parrot.setName("Gigi");
    return parrot;
  }

  @Bean(name = "Kiki")
  Parrot parrot2() {
    Parrot parrot = new Parrot();
    parrot.setName("KiKi");
    return parrot;
  }
}
