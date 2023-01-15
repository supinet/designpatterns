package com.dp.app.state;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;

public class Approved extends Status {
    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getAmount().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finish(Budget budget)  {
        budget.setStatus(new Finished());
    }
}
