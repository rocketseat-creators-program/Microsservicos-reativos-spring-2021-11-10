package com.rocketseat.dowhile.paymentservice.client;

import com.rocketseat.dowhile.paymentservice.response.AccountResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(url = "http://localhost:8082/account", name = "accountservice")
public interface AccountFeignClient {


    @GetMapping("/{id}")
    Mono<AccountResponse> geAccountById(@RequestParam(value = "id") String id);
}
