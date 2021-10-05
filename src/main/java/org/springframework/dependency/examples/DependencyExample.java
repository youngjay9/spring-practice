package org.springframework.dependency.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyExample {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("allConfig.xml");

    // Constructor-based Dependency Injection
    ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);

    System.out.println(
        "years: " + exampleBean.getYears() + " ,ultimateAnswers:" + exampleBean
            .getUltimateAnswer());

    System.out.println("Prepare to take lazyBean!!");
    // 有了 lazy-init 的屬性, Spring IoC 會在存取該 bean 時才給予初始化
    // 其它沒有 lazy-init 的 bean 會在 applicationcontext 建立時就將 singleton bean 初始化
    LazyBean lazyBean = context.getBean("lazyBean", LazyBean.class);

  }
}
