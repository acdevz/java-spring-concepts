package org.spring.s013springbootjdbctemplate.repositories;

import org.spring.s013springbootjdbctemplate.models.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;
    public PurchaseRepository( JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbc.update(sql,
                purchase.getProduct(),
                purchase.getPrice()
        );
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";
        RowMapper<Purchase> purchaseRowMapper = (rs, rowNum) -> {
            Purchase purchase = new Purchase();
            purchase.setId(rs.getInt("id"));
            purchase.setProduct(rs.getString("product"));
            purchase.setPrice(rs.getBigDecimal("price"));
            return purchase;
        };
        return jdbc.query(sql, purchaseRowMapper);
    }
}
