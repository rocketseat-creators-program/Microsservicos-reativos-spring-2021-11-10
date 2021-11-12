package com.rocketseat.dowhile.paymentservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Document(collection = "customer")
public class Payment {

    @Id
    private String uuid;
    @NotBlank
    private String sellerId;
    @NotBlank
    private String customerId;
    @NotBlank
    private Long amount;
    @NotBlank
    private Long tax;

}
