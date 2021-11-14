package com.jay.example.defining.beans.usingStereotypeAnnotations;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
