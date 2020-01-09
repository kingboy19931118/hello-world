package com.arbor.note.rule.easyrules;

import org.jeasy.rules.annotation.*;

@Rule(name = "rule1", description = "rule1")
public class Rule1 {

    @Condition
    public boolean support(@Fact("demo") String demo) {

        System.out.println("support 1" + demo);
        return true;
    }

    @Action
    public void action() {
        System.out.println("action 1");
    }

    @Priority
    public int getPriorty() {
        return 2;
    }

}
