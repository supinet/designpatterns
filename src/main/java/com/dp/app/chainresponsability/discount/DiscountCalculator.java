package com.dp.app.chainresponsability.discount;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountCalculator {
    public BigDecimal calculate(Budget budget) {
        Discount discount = new DiscountForBudgetWithAmountBiggerThanFiveHundrend(
            new DiscountForBudgetWithMoreThanFiveItems(
                new WithoutDiscount()));
    
        return discount.calculate(budget);
    }
}
