package com.rocketseat.dowhile.accountservice.controller;


import com.rocketseat.dowhile.accountservice.model.Account;
import com.rocketseat.dowhile.accountservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
@Slf4j
public class AccountController {

    AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        log.info("Criando uma nova conta com as informações [{}]", account);
        return accountService.createAccount(account);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        log.info("Listando todas as contas cadastradas");
        return accountService.listAllAccounts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long id) {
        log.info("Buscando conta com o id [{}]", id);
        return accountService.findAccountById(id);
    }
}
