package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.tagmanager.ArrayUtils;
import com.google.tagmanager.DebugResolvedRuleBuilder;
import com.google.tagmanager.ResolvedRuleBuilder;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.RuleEvaluationStepInfoBuilder;
import java.util.Iterator;
import java.util.Set;

class DebugRuleEvaluationStepInfoBuilder implements RuleEvaluationStepInfoBuilder {
    private Debug.RuleEvaluationStepInfo ruleEvaluationStepInfo;

    public DebugRuleEvaluationStepInfoBuilder(Debug.RuleEvaluationStepInfo var1) {
        this.ruleEvaluationStepInfo = var1;
    }

    public ResolvedRuleBuilder createResolvedRuleBuilder() {
        Debug.ResolvedRule var1 = new Debug.ResolvedRule();
        this.ruleEvaluationStepInfo.rules = ArrayUtils.appendToArray(this.ruleEvaluationStepInfo.rules, var1);
        return new DebugResolvedRuleBuilder(var1);
    }

    public void setEnabledFunctions(Set<ResourceUtil.ExpandedFunctionCall> var1) {
        ResourceUtil.ExpandedFunctionCall var3;
        for(Iterator var2 = var1.iterator(); var2.hasNext(); this.ruleEvaluationStepInfo.enabledFunctions = ArrayUtils.appendToArray(this.ruleEvaluationStepInfo.enabledFunctions, DebugResolvedRuleBuilder.translateExpandedFunctionCall(var3))) {
            var3 = (ResourceUtil.ExpandedFunctionCall)var2.next();
        }

    }
}
