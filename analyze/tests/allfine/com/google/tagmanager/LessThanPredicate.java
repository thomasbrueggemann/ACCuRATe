package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NumberPredicate;
import com.google.tagmanager.TypedNumber;
import java.util.Map;

class LessThanPredicate extends NumberPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_766;

    static {
        field_766 = FunctionType.LESS_THAN.toString();
    }

    public LessThanPredicate() {
        super(field_766);
    }

    public static String getFunctionId() {
        return field_766;
    }

    protected boolean evaluateNumber(TypedNumber var1, TypedNumber var2, Map<String, TypeSystem.Value> var3) {
        return var1.compareTo(var2) < 0;
    }
}
