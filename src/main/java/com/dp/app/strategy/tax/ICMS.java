package com.dp.app.strategy.tax;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class ICMS implements Tax {

    @Override
    public BigDecimal calculate(Budget budget) {
        return budget.getAmount().multiply(new BigDecimal("0.1"));
    }
    
}
