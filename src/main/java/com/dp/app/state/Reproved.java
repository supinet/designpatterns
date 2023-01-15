package com.dp.app.state;

import com.dp.app.budget.Budget;

public class Reproved extends Status {

    public void finish(Budget budget) {
        budget.setStatus(new Finished());
    }
    
}
