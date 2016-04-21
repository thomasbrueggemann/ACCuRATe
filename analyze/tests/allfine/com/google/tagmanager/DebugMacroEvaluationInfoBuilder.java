package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.tagmanager.DebugResolvedFunctionCallBuilder;
import com.google.tagmanager.DebugRuleEvaluationStepInfoBuilder;
import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;

class DebugMacroEvaluationInfoBuilder implements MacroEvaluationInfoBuilder {
    private Debug.MacroEvaluationInfo macroEvaluationInfo;

    public DebugMacroEvaluationInfoBuilder(Debug.MacroEvaluationInfo var1) {
        this.macroEvaluationInfo = var1;
    }

    public ResolvedFunctionCallBuilder createResult() {
        this.macroEvaluationInfo.result = new Debug.ResolvedFunctionCall();
        return new DebugResolvedFunctionCallBuilder(this.macroEvaluationInfo.result);
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        this.macroEvaluationInfo.rulesEvaluation = new Debug.RuleEvaluationStepInfo();
        return new DebugRuleEvaluationStepInfoBuilder(this.macroEvaluationInfo.rulesEvaluation);
    }
}
