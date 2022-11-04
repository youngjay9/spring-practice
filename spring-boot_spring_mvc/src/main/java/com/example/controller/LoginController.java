package com.example.controller;

import com.example.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  private LoginProcessor processor;

  public LoginController(LoginProcessor processor) {
    this.processor = processor;
  }

  public LoginController() {
  }

  @GetMapping("/")
  public String loginGet() {
    return "login.html";
  }

  @PostMapping("/")
  public String loginPost(@RequestParam String username, @RequestParam String password,
      Model page) {

    processor.setUsername(username);
    processor.setPassword(password);

    boolean logined = processor.login();

    if(logined){
      page.addAttribute("","")
    }

    return "login.html";
  }

}
