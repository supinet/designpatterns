package com.dp.app.chainresponsability.discount;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class WithoutDiscount extends Discount {
    public WithoutDiscount() {
        super(null);
    }

    public BigDecimal calculate(Budget budget) {
        return BigDecimal.ZERO;
    }
}
