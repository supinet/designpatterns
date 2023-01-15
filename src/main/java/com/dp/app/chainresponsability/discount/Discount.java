package com.dp.app.chainresponsability.discount;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public abstract class Discount {

    protected Discount next;

    public Discount(Discount next) {
        this.next = next;
    }

    public abstract BigDecimal calculate(Budget budget);
    
}
