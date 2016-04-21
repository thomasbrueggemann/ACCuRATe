package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.ArrayUtils;
import com.google.tagmanager.DebugResolvedPropertyBuilder;
import com.google.tagmanager.DebugValueBuilder;
import com.google.tagmanager.ResolvedFunctionCallBuilder;
import com.google.tagmanager.ResolvedPropertyBuilder;

class DebugResolvedFunctionCallBuilder implements ResolvedFunctionCallBuilder {
    private Debug.ResolvedFunctionCall resolvedFunctionCall;

    public DebugResolvedFunctionCallBuilder(Debug.ResolvedFunctionCall var1) {
        this.resolvedFunctionCall = var1;
    }

    public ResolvedPropertyBuilder createResolvedPropertyBuilder(String var1) {
        Debug.ResolvedProperty var2 = new Debug.ResolvedProperty();
        var2.key = var1;
        this.resolvedFunctionCall.properties = ArrayUtils.appendToArray(this.resolvedFunctionCall.properties, var2);
        return new DebugResolvedPropertyBuilder(var2);
    }

    public void setFunctionResult(TypeSystem.Value var1) {
        this.resolvedFunctionCall.result = DebugValueBuilder.copyImmutableValue(var1);
    }
}
