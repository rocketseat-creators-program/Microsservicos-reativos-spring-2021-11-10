package com.rocketseat.dowhile.paymentservice.service;

import com.rocketseat.dowhile.paymentservice.model.Payment;
import com.rocketseat.dowhile.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentService {

    PaymentRepository paymentRepository;


    public Mono<Payment> savePayment(Payment payment) {
        log.info("Criando um novo pagamento [{}]", payment);
        return paymentRepository.save(payment);
    }

    public Mono<Payment> findPayment(String id) {
        log.info("Buscando pagamento com o id [{}]", id);
        return paymentRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)));

    }

    public Flux<Payment> findAllPayments() {
        log.info("listando todos os pagamentos cadastrados na base");
        return paymentRepository.findAll();

    }


}
