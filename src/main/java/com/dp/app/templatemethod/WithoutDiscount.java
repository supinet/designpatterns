package com.dp.app.templatemethod;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class WithoutDiscount extends Discount {
    public WithoutDiscount() {
        super(null);
    }

    public BigDecimal calcApply(Budget budget) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean shouldApply(Budget budget) {
        return true;
    }
}
