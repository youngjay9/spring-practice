package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Parrot {

  private String name = "Gigi";

  public Parrot() {
    System.out.println("Parrot created!!");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
