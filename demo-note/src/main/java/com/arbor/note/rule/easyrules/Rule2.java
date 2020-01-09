package com.arbor.note.rule.easyrules;

import org.jeasy.rules.annotation.*;

@Rule(name = "rule2", description = "rule2")
public class Rule2 {

    @Condition
    public boolean support(@Fact("demo") String demo) {

        System.out.println("support 2" + demo);
        return true;
    }

    @Action
    public void action() {
        System.out.println("action 2");
    }


    @Priority
    public int getPriority() {
        return 1;
    }

}
