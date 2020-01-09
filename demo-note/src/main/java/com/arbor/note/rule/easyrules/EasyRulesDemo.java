package com.arbor.note.rule.easyrules;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.InferenceRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;
import org.jeasy.rules.mvel.MVELRule;

public class EasyRulesDemo {

    public static void main(String[] args) {
        RulesEngineParameters parameters = new RulesEngineParameters()
                .skipOnFirstFailedRule(true)
                ;
        RulesEngine rulesEngine = new DefaultRulesEngine(parameters);
        Rules rules = new Rules();
//        rules.register(new Rule1());
//        rules.register(new Rule2());
//        rules.register(new Rule3());
//        rules.register(new GroupRule[]{new GroupRule(), new GroupRule()});
        Rule weatherRule = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when("true")
                .then("System.out.println(\"It rains, take an umbrella!\");return 1;");

        rules.register(weatherRule);
        rules.register(new GroupRule());
        Facts facts = new Facts();
        facts.put("demo", "hello");
        System.out.println("doing");
        rulesEngine.fire(rules, facts);
        System.out.println("done");

        RulesEngine rulesEngine1 = new DefaultRulesEngine(parameters);
        rulesEngine1.fire(rules, facts);


    }

    public class DDD {
        public DDD() {
            System.out.println("DDD is newing");
        }
    }
}
