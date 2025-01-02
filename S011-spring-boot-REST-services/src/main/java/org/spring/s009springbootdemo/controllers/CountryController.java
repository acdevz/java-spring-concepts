package org.spring.s009springbootdemo.controllers;

import org.spring.s009springbootdemo.models.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> getFrance() {
        Country france = Country.of("France", 67_000_000);
        return ResponseEntity
                .status(200)
                .header("X-Continent", "Europe")
                .header("X-Country-Code", "FR")
                .body(france);
    }

    @GetMapping("/all")
    public Country[] getAll() {
        return new Country[] {
            Country.of("France", 67_000_000),
            Country.of("Germany", 83_000_000),
            Country.of("Spain", 47_000_000)
        };
    }
}
