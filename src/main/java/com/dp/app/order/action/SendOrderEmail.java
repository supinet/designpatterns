package com.dp.app.order.action;

import com.dp.app.order.ActionAfterOrderGenerated;
import com.dp.app.order.Order;

public class SendOrderEmail implements ActionAfterOrderGenerated {

    @Override
    public void actionExecute(Order order) {
        System.out.println("Sending order mail");
    }
    
}
