package com.rocketseat.dowhile.paymentservice.repository;

import com.rocketseat.dowhile.paymentservice.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {


}
