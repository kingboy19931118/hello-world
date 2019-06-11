package com.arbor.note.framework.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-01-30 14:05
 **/
@Component
public class SentinelTest {

    private static final List<FlowRule> FLOW_RULES = Lists.newArrayList();

    private static final String RESOURCE_NAME = "compensateOrderConsignConsumer";

    private static final String APP_NAME = "default";

    @PostConstruct
    public void init() {
        FlowRule rule = new FlowRule();
        rule.setResource(RESOURCE_NAME);
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp(APP_NAME);
        FLOW_RULES.add(rule);
        FlowRuleManager.loadRules(FLOW_RULES);
    }

    public void test() {


        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry(RESOURCE_NAME);
                System.out.println("hello world");
            } catch (BlockException e) {
                System.out.println("Block");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {

//        List<FlowRule> rules = Lists.newArrayList();
//        FlowRule rule = new FlowRule();
////        ClusterFlowConfig config = new ClusterFlowConfig();
////        config.setThresholdType()
////        rule.setClusterConfig()
//        rule.setResource("tutorial");
//        rule.setCount(1);
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule.setLimitApp("default");
//        rules.add(rule);

//        FlowRuleManager.loadRules(rules);
//        FlowRuleManager.loadRules(FLOW_RULES);
        SentinelTest test = new SentinelTest();
        test.init();
        test.test();

    }
}
