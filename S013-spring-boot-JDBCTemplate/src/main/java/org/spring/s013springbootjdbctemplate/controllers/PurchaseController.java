package org.spring.s013springbootjdbctemplate.controllers;

import org.spring.s013springbootjdbctemplate.models.Purchase;
import org.spring.s013springbootjdbctemplate.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    @PostMapping
    public void storePurchase( @RequestBody Purchase purchase ) {
        purchaseRepository.storePurchase(purchase);
    }
}
