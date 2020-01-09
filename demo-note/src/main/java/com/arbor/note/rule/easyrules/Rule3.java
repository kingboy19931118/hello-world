package com.arbor.note.rule.easyrules;

import org.jeasy.rules.annotation.*;

@Rule
public class Rule3 extends Rule1 {

    @Condition
    @Override
    public boolean support(@Fact("demo") String demo) {
        System.out.println("rule3");
        return super.support(demo);

    }

    @Action
    @Override
    public void action() {
        System.out.println("action 3");
        super.action();
    }

    @Priority
    @Override
    public int getPriorty() {
        return super.getPriorty();
    }
}
