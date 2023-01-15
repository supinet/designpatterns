package com.dp.app.templatemethod;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public abstract class Discount {
    protected Discount next;

    public Discount(Discount next) {
        this.next = next;
    }

    public BigDecimal calculate(Budget Budget) {
        if (shouldApply(Budget)) {
            return calcApply(Budget);
        }

        return next.calculate(Budget);
    }

    protected abstract BigDecimal calcApply(Budget budget);
    protected abstract boolean shouldApply(Budget budget);
    
}
