package com.dp.app.templatemethod;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class DiscountCalculator {
    public BigDecimal calculate(Budget budget) {
        Discount discountChain = new DiscountForBudgetWithMoreThanFiveItems(
            new DiscountForBudgetWithAmountBiggerThanFiveHundrend(
                new WithoutDiscount()));
        
        return discountChain.calculate(budget);

    }
}
