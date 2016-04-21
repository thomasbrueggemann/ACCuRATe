package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class AdvertisingTrackingEnabledMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_760;

    static {
        field_760 = FunctionType.ADVERTISING_TRACKING_ENABLED.toString();
    }

    public AdvertisingTrackingEnabledMacro() {
        super(field_760, new String[0]);
    }

    public static String getFunctionId() {
        return field_760;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue(Boolean.valueOf(true));
    }

    public boolean isCacheable() {
        return true;
    }
}
