package com.dp.app.strategy.tax;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class TaxCalculator {
    public BigDecimal calculate(Budget budget, Tax tax) {
        return tax.calculate(budget);
    }
}
