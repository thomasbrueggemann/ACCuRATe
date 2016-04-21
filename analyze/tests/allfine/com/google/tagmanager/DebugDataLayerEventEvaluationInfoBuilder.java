package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.tagmanager.ArrayUtils;
import com.google.tagmanager.DataLayerEventEvaluationInfoBuilder;
import com.google.tagmanager.DebugResolvedFunctionCallBuilder;
import com.google.tagmanager.DebugRuleEvaluationStepInfoBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;

class DebugDataLayerEventEvaluationInfoBuilder implements DataLayerEventEvaluationInfoBuilder {
    private Debug.DataLayerEventEvaluationInfo dataLayerEvent;

    public DebugDataLayerEventEvaluationInfoBuilder(Debug.DataLayerEventEvaluationInfo var1) {
        this.dataLayerEvent = var1;
    }

    public ResolvedFunctionCallBuilder createAndAddResult() {
        Debug.ResolvedFunctionCall var1 = new Debug.ResolvedFunctionCall();
        this.dataLayerEvent.results = ArrayUtils.appendToArray(this.dataLayerEvent.results, var1);
        return new DebugResolvedFunctionCallBuilder(var1);
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        this.dataLayerEvent.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
        return new DebugRuleEvaluationStepInfoBuilder(this.dataLayerEvent.rulesEvaluation);
    }
}
