package com.dp.app.templatemethod;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountForBudgetWithAmountBiggerThanFiveHundrend extends Discount {

    public DiscountForBudgetWithAmountBiggerThanFiveHundrend(Discount next) {
        super(next);
    }

    public BigDecimal calcApply(Budget budget) {
        return budget.getAmount().multiply(new BigDecimal("0.05"));
    }

    @Override
    public boolean shouldApply(Budget budget) {
        return budget.getAmount().compareTo(new BigDecimal("500")) > 0;
    }
    
}
