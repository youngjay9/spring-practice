package org.springframework.dependency.examples;

import org.springframework.beans.factory.annotation.Autowired;

public class ExampleBean {

  private int years;

  private String ultimateAnswer;

  @Autowired
  private LazyBean lazyBean;

  public ExampleBean(int years, String ultimateAnswer) {
    this.years = years;
    this.ultimateAnswer = ultimateAnswer;
    System.out.println("ExampleBean init!!");
  }

  public int getYears() {
    return years;
  }

  public void setYears(int years) {
    this.years = years;
  }

  public String getUltimateAnswer() {
    return ultimateAnswer;
  }

  public void setUltimateAnswer(String ultimateAnswer) {
    this.ultimateAnswer = ultimateAnswer;
  }
}
