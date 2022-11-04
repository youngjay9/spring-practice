package config;

import aspects.LoggingAspect;
import aspects.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import services.CommentService;

/**
 * 宣告 @EnableAspectJAutoProxy 代表在這個Spring Context 內的物件 啟用 AOP 機制
 */
@Configuration
@ComponentScan(basePackages = {"services"})
@EnableAspectJAutoProxy
public class ProjectConfig {

  /**
   * 執行 AOP 的 class 需放進 spring context 控管
   *
   * @return
   */
  @Bean
  public LoggingAspect loggingAspect() {
    return new LoggingAspect();
  }

  @Bean
  public SecurityAspect securityAspect() {
    return new SecurityAspect();
  }
}
