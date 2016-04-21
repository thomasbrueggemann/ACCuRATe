package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class TimeMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_743;

    static {
        field_743 = FunctionType.TIME.toString();
    }

    public TimeMacro() {
        super(field_743, new String[0]);
    }

    public static String getFunctionId() {
        return field_743;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean isCacheable() {
        return false;
    }
}
