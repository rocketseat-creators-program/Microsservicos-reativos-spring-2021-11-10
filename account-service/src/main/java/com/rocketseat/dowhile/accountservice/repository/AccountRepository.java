package com.rocketseat.dowhile.accountservice.repository;

import com.rocketseat.dowhile.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
