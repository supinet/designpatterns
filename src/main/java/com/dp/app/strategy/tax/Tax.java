package com.dp.app.strategy.tax;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public interface Tax {
    BigDecimal calculate(Budget budget);
}
