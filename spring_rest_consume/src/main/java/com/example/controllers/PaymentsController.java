package com.example.controllers;

import com.example.model.Payment;
import com.example.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {

  private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

  private final PaymentProxy paymentProxy;

  public PaymentsController(PaymentProxy paymentProxy) {
    this.paymentProxy = paymentProxy;
  }

  @PostMapping("/payment")
  public Payment createPayment(
      @RequestBody Payment payment
  ) {

    String requestId = UUID.randomUUID().toString();
    return paymentProxy.createPayment(requestId, payment);
  }
}
