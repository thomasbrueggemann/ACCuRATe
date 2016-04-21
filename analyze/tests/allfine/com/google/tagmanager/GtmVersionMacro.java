package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Map;

class GtmVersionMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_747;

    static {
        field_747 = FunctionType.GTM_VERSION.toString();
    }

    public GtmVersionMacro() {
        super(field_747, new String[0]);
    }

    public static String getFunctionId() {
        return field_747;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return Types.objectToValue("3.02");
    }

    public boolean isCacheable() {
        return true;
    }
}
