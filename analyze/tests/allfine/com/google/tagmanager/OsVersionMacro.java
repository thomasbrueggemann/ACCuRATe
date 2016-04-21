package com.google.tagmanager;

import android.os.Build.VERSION;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class OsVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_742;

    static {
        field_742 = FunctionType.OS_VERSION.toString();
    }

    public OsVersionMacro() {
        super(field_742, new String[0]);
    }

    public static String getFunctionId() {
        return field_742;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(VERSION.RELEASE);
    }

    public boolean isCacheable() {
        return true;
    }
}
