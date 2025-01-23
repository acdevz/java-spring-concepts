package org.spring.springdata.repositories;

import org.spring.springdata.models.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE id = :id")
    void updateAccountBalanceById(Long id, BigDecimal balance);

    @Query("SELECT * FROM account")
    List<Account> getAllAccounts();
}
