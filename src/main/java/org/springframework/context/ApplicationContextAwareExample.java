package org.springframework.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dependency.examples.IocContainerAware;
import org.springframework.dependency.examples.PrototypeBean;

public class ApplicationContextAwareExample {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("allConfig.xml");

    /*
      因為 singleton bean 只會在 spring 的 Ioc container 啟動時載入(只有一次),
      當 singleton bean 需要存取其它 prototype bean 時只能在 IoC container
      第一次載入時透過 setter 取得 prototype bean;
      SpringFramework 提出了一個 API: ApplicationContextAware;
      當有 bean 需要存取時, 它會自動執行 setApplicationContext 取得最新的 Ioc container.
    */
    IocContainerAware containerAware = context
        .getBean("iocContainerAware", IocContainerAware.class);

    PrototypeBean prototypeBean = (PrototypeBean) containerAware
        .getPrototypeBean(PrototypeBean.class);

    System.out.println(prototypeBean.getName());

  }
}
