package org.spring.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.spring.springdata.models.Account;
import org.spring.springdata.repositories.AccountRepository;
import org.spring.springdata.services.AccountService;

import java.math.BigDecimal;
import java.util.Optional;


public class AccountServiceUnitTests {
    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow(){
        AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);

        Account senderAccount = new Account();
        senderAccount.setId(1L);
        senderAccount.setBalance(new BigDecimal(100));

        Account receiverAccount = new Account();
        receiverAccount.setId(2L);
        receiverAccount.setBalance(new BigDecimal(100));

        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(senderAccount));
        Mockito.when(accountRepository.findById(2L)).thenReturn(Optional.of(receiverAccount));

        accountService.transferMoney(1L, 2L, new BigDecimal(10));

        Mockito.verify(accountRepository).updateAccountBalanceById(1L, new BigDecimal(90));
        Mockito.verify(accountRepository).updateAccountBalanceById(2L, new BigDecimal(110));
    }
}
