package org.spring.springdata.controllers;

import org.spring.springdata.dto.TransferRequest;
import org.spring.springdata.models.Account;
import org.spring.springdata.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public List<Account> getAllAccounts(
            @RequestBody(required = false) String name
    ) {
        if (name != null) {
            return accountService.findAccountsByName(name);
        }
        return accountService.getAllAccounts();
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ){
        accountService.transferMoney(
                transferRequest.getFromAccountId(),
                transferRequest.getToAccountId(),
                transferRequest.getAmount()
        );
    }
}
