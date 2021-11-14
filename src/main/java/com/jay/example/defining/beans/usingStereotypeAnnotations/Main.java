package com.jay.example.defining.beans.usingStereotypeAnnotations;

import com.jay.example.defining.beans.usingStereotypeAnnotations.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Parrot parrot = context.getBean(Parrot.class);

    System.out.println("Parrot name: " + parrot.getName());
  }
}
