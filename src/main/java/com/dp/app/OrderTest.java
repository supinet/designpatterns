package com.dp.app;

import java.math.BigDecimal;
import java.util.Arrays;

import com.dp.app.order.OrderGenerator;
import com.dp.app.order.OrderGeneratorHandler;
import com.dp.app.order.action.SaveOrderDatabase;
import com.dp.app.order.action.SendOrderEmail;

public class OrderTest {
    public static void main(String[] args) {
        String client = "Jhon"; //args[0];
        BigDecimal budgetAmount = new BigDecimal("300"); //new BigDecimal(args[1]);
        Long quantity = 2L; //Long.valueOf(args[2]);

        OrderGenerator orderGenerator = new OrderGenerator(client, budgetAmount, quantity);
        OrderGeneratorHandler orderGeneratorHandler = new OrderGeneratorHandler(
            Arrays.asList(new SaveOrderDatabase(), new SendOrderEmail())
        );
        orderGeneratorHandler.execute(orderGenerator);
    }
}
