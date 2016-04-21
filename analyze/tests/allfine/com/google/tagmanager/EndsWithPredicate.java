package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.StringPredicate;
import java.util.Map;

class EndsWithPredicate extends StringPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_770;

    static {
        field_770 = FunctionType.ENDS_WITH.toString();
    }

    public EndsWithPredicate() {
        super(field_770);
    }

    public static String getFunctionId() {
        return field_770;
    }

    protected boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3) {
        return var1.endsWith(var2);
    }
}
