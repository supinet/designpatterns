package com.dp.app;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.dp.app.budget.Budget;
import com.dp.app.strategy.tax.ICMS;
import com.dp.app.strategy.tax.ISS;
import com.dp.app.strategy.tax.TaxCalculator;

public class StrategyTaxCalculatorTest {

    @Test
    public void testCalculate() {
        Budget budget = new Budget(new BigDecimal("100"), 5L);
        Budget budget2 = new Budget(new BigDecimal("100"), 10L);

        TaxCalculator taxCalculate = new TaxCalculator();
        BigDecimal icms = taxCalculate.calculate(budget, new ICMS());
        BigDecimal iss = taxCalculate.calculate(budget2, new ISS());

        assertEquals(icms, new BigDecimal("10.0"));
        assertEquals(iss, new BigDecimal("6.00"));
    }
}
