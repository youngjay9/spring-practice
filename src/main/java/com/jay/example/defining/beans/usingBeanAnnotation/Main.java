package com.jay.example.defining.beans.usingBeanAnnotation;

import com.jay.example.defining.beans.usingBeanAnnotation.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {

    var context = new AnnotationConfigApplicationContext(
        ProjectConfig.class);

    Parrot parrotGigi = context.getBean("Gigi", Parrot.class);

    System.out.println("parrotGigi name: " + parrotGigi.getName());

    Parrot parrotKiki = context.getBean("Kiki", Parrot.class);

    System.out.println("parrotKiki name: " + parrotKiki.getName());


  }
}
