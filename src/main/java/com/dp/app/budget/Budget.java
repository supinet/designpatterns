package com.dp.app.budget;

import java.math.BigDecimal;

import com.dp.app.state.Review;
import com.dp.app.state.Status;

public class Budget {
    private BigDecimal amount;
    private Long quantity;
    private BigDecimal discount;
    private Status status;

    public Budget(BigDecimal amount, Long quantity) {
        this.amount = amount;
        this.quantity = quantity;
        this.status = new Review();
    }

    public void applyExtraDiscount() {
        BigDecimal amountExtraDiscount = this.status.calcExtraDiscount(this);
        this.amount = this.amount.subtract(amountExtraDiscount);
    }

    public void approve() {
        this.status.approve(this);
    }

    public void reprove() {
        this.status.approve(this);
    }

    public void finish() {
        this.status.finish(this);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    
    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

}
