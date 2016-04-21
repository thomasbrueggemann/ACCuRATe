package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class SdkVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_761;

    static {
        field_761 = FunctionType.SDK_VERSION.toString();
    }

    public SdkVersionMacro() {
        super(field_761, new String[0]);
    }

    public static String getFunctionId() {
        return field_761;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean isCacheable() {
        return true;
    }
}
