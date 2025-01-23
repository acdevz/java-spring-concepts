package org.spring.springdata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.spring.springdata.models.Account;
import org.spring.springdata.repositories.AccountRepository;
import org.spring.springdata.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest // ExtendWith(SpringExtension.class) is not needed
public class AccountServiceSpringIntegrationTests {
    @MockitoBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Test
    @DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
    public void moneyTransferAccountServiceTest(){
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
