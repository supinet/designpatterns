package com.dp.app.order;

import java.math.BigDecimal;

public class OrderGenerator {
    private String client;
    private BigDecimal budgetAmount;
    private Long quantity;
    
    public OrderGenerator(String client, BigDecimal budgetAmount, Long quantity) {
        this.client = client;
        this.budgetAmount = budgetAmount;
        this.quantity = quantity;
    }

    public String getClient() {
        return client;
    }

    public BigDecimal getBudgetAmount() {
        return budgetAmount;
    }

    public Long getQuantity() {
        return quantity;
    }

    
}
