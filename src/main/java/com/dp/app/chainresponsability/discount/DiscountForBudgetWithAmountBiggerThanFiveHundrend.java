package com.dp.app.chainresponsability.discount;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountForBudgetWithAmountBiggerThanFiveHundrend extends Discount {
    public DiscountForBudgetWithAmountBiggerThanFiveHundrend(Discount next) {
        super(next);
    }

    public BigDecimal calculate(Budget budget) {
        if (budget.getAmount().compareTo(new BigDecimal("500.0")) > 0) {
            return budget.getAmount().multiply(new BigDecimal("0.05"));
        }
        return next.calculate(budget);
    }
}
