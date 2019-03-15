package com.arbor.note.framework.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.ClusterFlowConfig;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-01-30 14:05
 **/
public class SentinelTest {

    public static void main(String[] args) {

        List<FlowRule> rules = Lists.newArrayList();
        FlowRule rule = new FlowRule();
//        ClusterFlowConfig config = new ClusterFlowConfig();
//        config.setThresholdType()
//        rule.setClusterConfig()
        rule.setResource("tutorial");
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);

        FlowRuleManager.loadRules(rules);

        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("tutorial");
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
}
