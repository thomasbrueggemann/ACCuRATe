package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.ValueBuilder;

interface ResolvedPropertyBuilder {
    ValueBuilder createPropertyValueBuilder(TypeSystem.Value var1);
}
