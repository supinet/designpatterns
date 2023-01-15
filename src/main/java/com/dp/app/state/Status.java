package com.dp.app.state;

import java.math.BigDecimal;

import com.dp.app.budget.Budget;
import com.dp.app.exception.DomainException;

public abstract class Status {

    public BigDecimal calcExtraDiscount(Budget budget) {
        return BigDecimal.ZERO;
    }

    public void approve(Budget budget) {
        throw new DomainException("Budget can not be Approved");
    }

    public void reprove(Budget budget) {
        throw new DomainException("Budget can not be Reproved");
    }

    public void finish(Budget budget) {
        throw new DomainException("Budget can not be Finished");
    }

}
