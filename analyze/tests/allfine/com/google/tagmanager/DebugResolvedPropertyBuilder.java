package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.DebugValueBuilder;
import com.google.tagmanager.ResolvedPropertyBuilder;
import com.google.tagmanager.ValueBuilder;

class DebugResolvedPropertyBuilder implements ResolvedPropertyBuilder {
    private Debug.ResolvedProperty resolvedProperty;

    public DebugResolvedPropertyBuilder(Debug.ResolvedProperty var1) {
        this.resolvedProperty = var1;
    }

    public ValueBuilder createPropertyValueBuilder(TypeSystem.Value var1) {
        TypeSystem.Value var2 = DebugValueBuilder.copyImmutableValue(var1);
        this.resolvedProperty.value = var2;
        return new DebugValueBuilder(var2);
    }
}
