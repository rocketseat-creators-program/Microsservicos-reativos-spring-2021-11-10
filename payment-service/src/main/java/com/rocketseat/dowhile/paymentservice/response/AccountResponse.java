package com.rocketseat.dowhile.paymentservice.response;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class AccountResponse {

    private  Long id;


    private Long amount;

    private LocalDateTime createdAt;

    private  LocalDateTime updatedAt;
}
