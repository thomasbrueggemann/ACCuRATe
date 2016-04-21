package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedFunctionCallTranslatorList;

interface ResolvedRuleBuilder {
    ResolvedFunctionCallBuilder createNegativePredicate();

    ResolvedFunctionCallBuilder createPositivePredicate();

    ResolvedFunctionCallTranslatorList getAddedMacroFunctions();

    ResolvedFunctionCallTranslatorList getAddedTagFunctions();

    ResolvedFunctionCallTranslatorList getRemovedMacroFunctions();

    ResolvedFunctionCallTranslatorList getRemovedTagFunctions();

    void setValue(TypeSystem.Value var1);
}
