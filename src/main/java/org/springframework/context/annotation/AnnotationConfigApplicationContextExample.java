package org.springframework.context.annotation;

class MyBean {

  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}


@Configuration
class AppConfig {

  @Bean
  public MyBean myBean() {
    MyBean bean = new MyBean();
    bean.setName("jayBean");
    return bean;
  }
}

/**
 * 讀取有 Annotation: @Configuration 的 class 裡面定義的 Bean
 */
public class AnnotationConfigApplicationContextExample {


  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.register(AppConfig.class);
    ctx.refresh();

    MyBean jayBean = ctx.getBean(MyBean.class);
    System.out.println("beanName: "+jayBean.getName());

  }
}
