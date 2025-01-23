package org.spring.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.spring.springdata.exceptions.AccountNotFoundException;
import org.spring.springdata.models.Account;
import org.spring.springdata.repositories.AccountRepository;
import org.spring.springdata.services.AccountService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AccountServiceWithAnnotationUnitTests {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferHappyFlow(){
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

    @Test
    @DisplayName("Test the exception is thrown when the receiver account is not found.")
    public void moneyTransferReceiverAccountNotFoundFlow() {
        Account senderAccount = new Account();
        senderAccount.setId(1L);
        senderAccount.setBalance(new BigDecimal(100));

        given(accountRepository.findById(1L)).willReturn(Optional.of(senderAccount));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.transferMoney(1L, 2L, new BigDecimal(10)));

        Mockito.verify(accountRepository, Mockito.never()).updateAccountBalanceById(1L, new BigDecimal(90));
    }
}
