package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NoopValueBuilder;
import com.google.tagmanager.ResolvedPropertyBuilder;
import com.google.tagmanager.ValueBuilder;

class NoopResolvedPropertyBuilder implements ResolvedPropertyBuilder {
    public ValueBuilder createPropertyValueBuilder(TypeSystem.Value var1) {
        return new NoopValueBuilder();
    }
}
