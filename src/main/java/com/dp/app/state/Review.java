package com.dp.app.state;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class Review extends Status {

    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getAmount().multiply(new BigDecimal("0.05"));

    }

    public void aprove(Budget budget) {
        budget.setStatus(new Approved());
    }

    public void reproved(Budget budget) {
        budget.setStatus(new Reproved());
    }
    
}
