package com.google.tagmanager;

import android.os.Build;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class DeviceNameMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_751;

    static {
        field_751 = FunctionType.DEVICE_NAME.toString();
    }

    public DeviceNameMacro() {
        super(field_751, new String[0]);
    }

    public static String getFunctionId() {
        return field_751;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2 = Build.MANUFACTURER;
        String var3 = Build.MODEL;
        if(!var3.startsWith(var2) && !var2.equals("unknown")) {
            var3 = var2 + " " + var3;
        }

        return Types.objectToValue(var3);
    }

    public boolean isCacheable() {
        return true;
    }
}
