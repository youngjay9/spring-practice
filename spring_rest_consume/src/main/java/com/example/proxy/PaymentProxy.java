package com.example.proxy;

import com.example.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// 加入 @FeignClient 讓 spring cloud openfeign 知道要調用的 url
@FeignClient(name = "payments",
    url = "${name.service.url}")
public interface PaymentProxy {

  // 調用遠端 url 的 API：http://${name.service.url}/payment
  @PostMapping("/payment")
  Payment createPayment(
      @RequestHeader String requestId,
      @RequestBody Payment payment);
}
