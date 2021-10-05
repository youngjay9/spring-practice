package org.springframework.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dependency.examples.IocContainerAware;
import org.springframework.dependency.examples.PrototypeBean;

public class ApplicationContextAwareExample {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("allConfig.xml");

    /*
      因為 singleton bean 只會在 spring 的 Ioc container 啟動時載入(只有一次),
      當後續有 singleton bean 需要存取其它 prototype bean 時只能在 IoC container
      第一次載入 singleton bean 時透過 setter 取得 prototype bean;
      SpringFramework 提出了一個 API: ApplicationContextAware,只要實作它,
      當有 bean 需要存取時, 它會自動執行 setApplicationContext 取得最新的 Ioc container.
    */
    IocContainerAware containerAware = context
        .getBean("iocContainerAware", IocContainerAware.class);

    containerAware.getPrototypeBean(PrototypeBean.class);

  }
}
