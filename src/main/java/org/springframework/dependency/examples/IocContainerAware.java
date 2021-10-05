package org.springframework.dependency.examples;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class IocContainerAware implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("IocContainerAware setApplicationContext!!");
    this.applicationContext = applicationContext;
  }

  public Object getPrototypeBean(Class clazz) {
    return applicationContext.getBean(clazz);
  }
}
