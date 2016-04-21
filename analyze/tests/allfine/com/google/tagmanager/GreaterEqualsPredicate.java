package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NumberPredicate;
import com.google.tagmanager.TypedNumber;
import java.util.Map;

class GreaterEqualsPredicate extends NumberPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_767;

    static {
        field_767 = FunctionType.GREATER_EQUALS.toString();
    }

    public GreaterEqualsPredicate() {
        super(field_767);
    }

    public static String getFunctionId() {
        return field_767;
    }

    protected boolean evaluateNumber(TypedNumber var1, TypedNumber var2, Map<String, TypeSystem.Value> var3) {
        return var1.compareTo(var2) >= 0;
    }
}
