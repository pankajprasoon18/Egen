package com.egen.rules;

import com.egen.model.Metric;
import com.egen.rules.MetricsRule.RuleType;


public class RulesFactory {

    public static MetricsRule getRule (RuleType type, Metric metric) {

        if (type == RuleType.Above_WT)
            return new OverweightRule(metric);
        else if (type == RuleType.Below_WT)
            return new UnderweightRule(metric);

        return null;
    }
}
