package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.ResolvedPropertyBuilder;

interface ResolvedFunctionCallBuilder {
    ResolvedPropertyBuilder createResolvedPropertyBuilder(String var1);

    void setFunctionResult(TypeSystem.Value var1);
}
