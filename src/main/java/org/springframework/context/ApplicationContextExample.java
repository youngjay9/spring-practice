package org.springframework.context;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.jpetstore.dao.jpa.JpaAccountDao;
import org.springframework.samples.jpetstore.services.PetStoreService;

public class ApplicationContextExample {

  public static void main(String[] args) {
    /*
      ApplicationContext 是一個 Ioc container, 負責控管 Bean 物件;
      在 resources 目錄下的設定檔(xxx.xml), compile 過後會在 classes 的根目錄下;
      ClassPathXmlApplicationContext 讀取 allConfig.xml, 它會去 import 其它所有的設定檔
    */
    ApplicationContext context = new ClassPathXmlApplicationContext("allConfig.xml");

    PetStoreService petStoreService = context.getBean("petStore", PetStoreService.class);
    System.out.println(petStoreService.providedService());

    JpaAccountDao accountDao = context.getBean("accountDao", JpaAccountDao.class);
    System.out.println(accountDao.getAccountInfo("A199992"));


  }
}
