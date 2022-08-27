package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

  private String name = "Parosy";

  private final Parrot parrot;


  public Person(@Qualifier("parrot2") Parrot parrot3) {
    this.parrot = parrot3;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Parrot getParrot() {
    return parrot;
  }
}
