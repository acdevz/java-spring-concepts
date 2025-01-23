package org.spring.jdbctemplatemysql.controllers;

import org.spring.jdbctemplatemysql.models.Purchase;
import org.spring.jdbctemplatemysql.repositories.PurchaseRepository;
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