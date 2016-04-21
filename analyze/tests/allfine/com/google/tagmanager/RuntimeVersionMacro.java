package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class RuntimeVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_773;
    public static final long VERSION_NUMBER = 62676326L;

    static {
        field_773 = FunctionType.RUNTIME_VERSION.toString();
    }

    public RuntimeVersionMacro() {
        super(field_773, new String[0]);
    }

    public static String getFunctionId() {
        return field_773;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(Long.valueOf(62676326L));
    }

    public boolean isCacheable() {
        return true;
    }
}
