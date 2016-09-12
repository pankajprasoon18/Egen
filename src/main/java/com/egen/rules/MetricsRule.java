package com.egen.rules;


public interface MetricsRule {

    enum RuleType {Above_WT, Below_WT}

//    int baseWeight = Integer.parseInt(System.getProperty("base.value"));

    int baseWeight = 150;

    boolean when();
    void then();
}
