package org.spring.springdata.services;

import org.spring.springdata.exceptions.AccountNotFoundException;
import org.spring.springdata.models.Account;
import org.spring.springdata.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));
        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));

        BigDecimal newFromAccountBalance = fromAccount.getBalance().subtract(amount);
        BigDecimal newToAccountBalance = toAccount.getBalance().add(amount);

        accountRepository.updateAccountBalanceById(fromAccountId, newFromAccountBalance);
        accountRepository.updateAccountBalanceById(toAccountId, newToAccountBalance);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
