package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NoopResolvedPropertyBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedPropertyBuilder;

class NoopResolvedFunctionCallBuilder implements ResolvedFunctionCallBuilder {
    public ResolvedPropertyBuilder createResolvedPropertyBuilder(String var1) {
        return new NoopResolvedPropertyBuilder();
    }

    public void setFunctionResult(TypeSystem.Value var1) {
    }
}
