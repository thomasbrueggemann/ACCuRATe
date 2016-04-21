package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.StringPredicate;
import java.util.Map;

class EqualsPredicate extends StringPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_772;

    static {
        field_772 = FunctionType.EQUALS.toString();
    }

    public EqualsPredicate() {
        super(field_772);
    }

    public static String getFunctionId() {
        return field_772;
    }

    protected boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3) {
        return var1.equals(var2);
    }
}
