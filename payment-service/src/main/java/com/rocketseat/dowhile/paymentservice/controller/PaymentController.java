package com.rocketseat.dowhile.paymentservice.controller;

import com.rocketseat.dowhile.paymentservice.client.AccountFeignClient;
import com.rocketseat.dowhile.paymentservice.client.AccountWebClient;
import com.rocketseat.dowhile.paymentservice.model.Payment;
import com.rocketseat.dowhile.paymentservice.response.AccountResponse;
import com.rocketseat.dowhile.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    AccountFeignClient accountFeignClient;

    AccountWebClient accountWebClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Payment> createPayment(@Valid @RequestBody Payment payment) {
        log.info("Cadastrando um novo pagamento com as informações [{}]", payment);
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Payment> findPaymentById(@PathVariable String id) {
        log.info("Buscando pagamento com o id [{}]", id);
        return paymentService.findPayment(id);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Payment> getAllPayments() {
        log.info("Listando todos os pagamentos cadastrados");
        return paymentService.findAllPayments();
    }

    @GetMapping("/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<AccountResponse> findAccountById(@PathVariable String id) {
        log.info("Buscando conta com o id [{}]", id);
        return accountFeignClient.geAccountById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/accounts")
    public Flux<AccountResponse> getAllAccounts() {
        log.info("Listando todos as contas cadastradas");
        return accountWebClient.ListAccounts();
    }
}
