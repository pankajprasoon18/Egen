package com.egen.service;

import com.egen.dao.AlertDAO;
import com.egen.dao.MetricDAO;
import com.egen.model.Alert;
import com.egen.model.Metric;
import com.egen.rules.MetricsRule;
import com.egen.rules.RulesFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;



@Component
public class AlertService {


    @Autowired
    private AlertDAO aDAO;

    public AlertService() {
    }

    public ObjectId create (Alert alert) {
        return aDAO.create(alert);
    }

    public List<Alert> read () {
        return aDAO.read();
    }

    public List<Alert> readByRange(long startTime, long endTime) {
        return aDAO.readByRange(startTime, endTime);
    }
}
