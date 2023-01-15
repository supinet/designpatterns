package com.dp.app.chainresponsability.discount;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountForBudgetWithMoreThanFiveItems extends Discount {
    public DiscountForBudgetWithMoreThanFiveItems(Discount next) {
        super(next);
    }

    public BigDecimal calculate(Budget budget) {
        if (budget.getQuantity() > 5) {
            return budget.getAmount().multiply(new BigDecimal("0.10"));
        }
        return next.calculate(budget);
    }
}
