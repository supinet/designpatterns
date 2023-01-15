package com.dp.app.templatemethod;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountForBudgetWithMoreThanFiveItems extends Discount {

    public DiscountForBudgetWithMoreThanFiveItems(Discount next) {
        super(next);
    }

    public BigDecimal calcApply(Budget budget) {
        return budget.getAmount().multiply(new BigDecimal("0.1"));
    }

    @Override
    public boolean shouldApply(Budget budget) {
        return budget.getQuantity() > 5;
    }


}