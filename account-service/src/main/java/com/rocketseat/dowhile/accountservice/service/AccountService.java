package com.rocketseat.dowhile.accountservice.service;

import com.rocketseat.dowhile.accountservice.model.Account;
import com.rocketseat.dowhile.accountservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;

    public Account createAccount(Account account) {
        log.info("criando um nova conta com as informacoes [{}]", account);
        return accountRepository.save(account);
    }

    public List<Account> listAllAccounts() {
        log.info("Listando todas as contas cadastradas na base");
        return accountRepository.findAll();
    }

    public ResponseEntity<Account> findAccountById(Long id) {
        log.info("Buscando uma conta  pelo id [{}]", id);
        return accountRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }
}
