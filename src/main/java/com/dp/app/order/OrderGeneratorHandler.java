package com.dp.app.order;

import java.time.LocalDateTime;
import java.util.List;

import com.dp.app.budget.Budget;

public class OrderGeneratorHandler {

    private List<ActionAfterOrderGenerated> actions;

     public OrderGeneratorHandler(List<ActionAfterOrderGenerated> actions) {
        this.actions = actions;
    }

     public void execute(OrderGenerator data) {
        Budget budget = new Budget(data.getBudgetAmount(), data.getQuantity());
        Order order = new Order(data.getClient(), LocalDateTime.now(), budget);

        actions.forEach(a -> a.actionExecute(order));
     }

}
