package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.StringPredicate;
import java.util.Map;

class StartsWithPredicate extends StringPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_768;

    static {
        field_768 = FunctionType.STARTS_WITH.toString();
    }

    public StartsWithPredicate() {
        super(field_768);
    }

    public static String getFunctionId() {
        return field_768;
    }

    protected boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3) {
        return var1.startsWith(var2);
    }
}
