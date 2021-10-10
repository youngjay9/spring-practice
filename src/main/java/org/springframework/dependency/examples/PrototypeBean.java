package org.springframework.dependency.examples;

public class PrototypeBean {

  public PrototypeBean() {
    System.out.println("Prototype bean init!!");
  }

  public String getName() {
    return "Prototype Bean";
  }
}
