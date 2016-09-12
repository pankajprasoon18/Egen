package com.egen.service;

import com.egen.dao.MetricDAO;
import com.egen.model.Metric;
import com.egen.rules.MetricsRule;
import com.egen.rules.RulesFactory;
import org.bson.types.ObjectId;
import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;


@Component
public class MetricService {

    private RulesEngine rEngine;
    private MetricsRule ruleForMetrics;

    @Autowired
    private MetricDAO mDAO;

    MetricService() {
    	rEngine = aNewRulesEngine().build();
    }

   

    public List<Metric> read () {
        return mDAO.read();
    }

    public List<Metric> readByRange(long startTime, long endTime) {
        return mDAO.readByRange(startTime, endTime);
    }
    
    
    public ObjectId createMetric(Metric metric) {
    	ruleForMetrics = RulesFactory.getRule(MetricsRule.RuleType.Below_WT, metric);
        rEngine.registerRule(ruleForMetrics);
        ruleForMetrics = RulesFactory.getRule(MetricsRule.RuleType.Above_WT, metric);
        rEngine.registerRule(ruleForMetrics);

        rEngine.fireRules();
        rEngine.clearRules();

        return mDAO.createMetric(metric);
    }
}
