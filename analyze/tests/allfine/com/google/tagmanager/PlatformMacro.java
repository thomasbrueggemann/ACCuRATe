package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class PlatformMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_741;
    private static final TypeSystem.Value PLATFORM;

    static {
        field_741 = FunctionType.PLATFORM.toString();
        PLATFORM = Types.objectToValue("Android");
    }

    public PlatformMacro() {
        super(field_741, new String[0]);
    }

    public static String getFunctionId() {
        return field_741;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return PLATFORM;
    }

    public boolean isCacheable() {
        return true;
    }
}
