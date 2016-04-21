package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.StringPredicate;
import java.util.Map;

class ContainsPredicate extends StringPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_769;

    static {
        field_769 = FunctionType.CONTAINS.toString();
    }

    public ContainsPredicate() {
        super(field_769);
    }

    public static String getFunctionId() {
        return field_769;
    }

    protected boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3) {
        return var1.contains(var2);
    }
}
