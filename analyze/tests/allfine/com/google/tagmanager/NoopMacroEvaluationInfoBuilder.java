package com.google.tagmanager;

import com.google.tagmanager.MacroEvaluationInfoBuilder;
import com.google.tagmanager.NoopResolvedFunctionCallBuilder;
import com.google.tagmanager.NoopRuleEvaluationStepInfoBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;

class NoopMacroEvaluationInfoBuilder implements MacroEvaluationInfoBuilder {
    public ResolvedFunctionCallBuilder createResult() {
        return new NoopResolvedFunctionCallBuilder();
    }

    public RuleEvaluationStepInfoBuilder createRulesEvaluation() {
        return new NoopRuleEvaluationStepInfoBuilder();
    }
}
