package com.dp.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.dp.app.budget.Budget;
import com.dp.app.templatemethod.DiscountCalculator;

public class TemplateMethodDiscountCalculatorTest {

    @Test
    public void testCalculate() {
        Budget budget = new Budget(new BigDecimal("1000"), 5L);
        Budget budget2 = new Budget(new BigDecimal("100"), 10L);

        DiscountCalculator discCalculate = new DiscountCalculator();
        BigDecimal amout = discCalculate.calculate(budget);
        BigDecimal qtd = discCalculate.calculate(budget2);

        assertEquals(amout, new BigDecimal("50.00"));
        assertEquals(qtd, new BigDecimal("10.0"));
    }

    @Test
    public void noDiscount() {
        Budget budget = new Budget(new BigDecimal("100"), 5L);
        Budget budget2 = new Budget(new BigDecimal("499"), 1L);

        DiscountCalculator discCalculate = new DiscountCalculator();
        BigDecimal amout = discCalculate.calculate(budget);
        BigDecimal qtd = discCalculate.calculate(budget2);

        assertEquals(amout, new BigDecimal("0"));
        assertEquals(qtd, new BigDecimal("0"));
    }
}
