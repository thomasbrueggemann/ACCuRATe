package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

abstract class TrackingTag extends FunctionCallImplementation {
    public TrackingTag(String var1, String... var2) {
        super(var1, var2);
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        this.evaluateTrackingTag(var1);
        return Types.getDefaultValue();
    }

    public abstract void evaluateTrackingTag(Map<String, TypeSystem.Value> var1);

    public boolean isCacheable() {
        return false;
    }
}
