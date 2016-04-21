package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NoopResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedFunctionCallTranslatorList;
import com.google.tagmanager.ResolvedRuleBuilder;
import com.google.tagmanager.ResourceUtil;
import java.util.List;

class NoopResolvedRuleBuilder implements ResolvedRuleBuilder {
    public ResolvedFunctionCallBuilder createNegativePredicate() {
        return new NoopResolvedFunctionCallBuilder();
    }

    public ResolvedFunctionCallBuilder createPositivePredicate() {
        return new NoopResolvedFunctionCallBuilder();
    }

    public ResolvedFunctionCallTranslatorList getAddedMacroFunctions() {
        return new NoopResolvedRuleBuilder.NoopResolvedFunctionCallTranslatorList();
    }

    public ResolvedFunctionCallTranslatorList getAddedTagFunctions() {
        return new NoopResolvedRuleBuilder.NoopResolvedFunctionCallTranslatorList();
    }

    public ResolvedFunctionCallTranslatorList getRemovedMacroFunctions() {
        return new NoopResolvedRuleBuilder.NoopResolvedFunctionCallTranslatorList();
    }

    public ResolvedFunctionCallTranslatorList getRemovedTagFunctions() {
        return new NoopResolvedRuleBuilder.NoopResolvedFunctionCallTranslatorList();
    }

    public void setValue(TypeSystem.Value var1) {
    }

    public class NoopResolvedFunctionCallTranslatorList implements ResolvedFunctionCallTranslatorList {
        public void translateAndAddAll(List<ResourceUtil.ExpandedFunctionCall> var1, List<String> var2) {
        }
    }
}
