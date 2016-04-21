package com.google.tagmanager;

import com.google.tagmanager.DataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.NoopResolvedFunctionCallBuilder;
import com.google.tagmanager.NoopRuleEvaluationStepInfoBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;

class NoopDataLayerEventEvaluationInfoBuilder implements DataLayerEventEvaluationInfoBuilder {
    public ResolvedFunctionCallBuilder createAndAddResult() {
        return new NoopResolvedFunctionCallBuilder();
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        return new NoopRuleEvaluationStepInfoBuilder();
    }
}
