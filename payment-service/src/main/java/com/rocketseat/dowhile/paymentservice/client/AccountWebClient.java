package com.rocketseat.dowhile.paymentservice.client;

import com.rocketseat.dowhile.paymentservice.response.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class AccountWebClient {


    private final WebClient webClient;


    public AccountWebClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:8082/account").build();
    }


    public Flux<AccountResponse> ListAccounts() {
        log.info("Buscando todas as contas criadas no serviço de account");
        return webClient.get()
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(AccountResponse.class);
    }
}
