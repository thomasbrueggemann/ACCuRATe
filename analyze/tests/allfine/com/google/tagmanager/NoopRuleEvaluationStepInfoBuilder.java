package com.google.tagmanager;

import com.google.tagmanager.NoopResolvedRuleBuilder;
import com.google.tagmanager.ResolvedRuleBuilder;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;
import java.util.Set;

class NoopRuleEvaluationStepInfoBuilder implements RuleEvaluationStepInfoBuilder {
    public ResolvedRuleBuilder createResolvedRuleBuilder() {
        return new NoopResolvedRuleBuilder();
    }

    public void setEnabledFunctions(Set<ResourceUtil.ExpandedFunctionCall> var1) {
    }
}
