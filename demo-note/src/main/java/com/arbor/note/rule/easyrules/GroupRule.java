package com.arbor.note.rule.easyrules;

import org.jeasy.rules.support.UnitRuleGroup;

public class GroupRule extends UnitRuleGroup {
    @Override
    public void addRule(Object rule) {
        super.addRule(rule);
    }

    public GroupRule() {
        addRule(new Rule1());
        addRule(new Rule2());
        addRule(new Rule3());
    }
}
