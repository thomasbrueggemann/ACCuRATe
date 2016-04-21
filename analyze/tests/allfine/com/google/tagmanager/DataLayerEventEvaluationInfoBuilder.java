package com.google.tagmanager;

import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;

interface DataLayerEventEvaluationInfoBuilder {
    ResolvedFunctionCallBuilder createAndAddResult();

    RuleEvaluationStepInfoBuilder createRulesEvaluation();
}
