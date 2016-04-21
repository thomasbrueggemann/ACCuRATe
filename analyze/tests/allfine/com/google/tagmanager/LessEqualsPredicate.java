package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.NumberPredicate;
import com.google.tagmanager.TypedNumber;
import java.util.Map;

class LessEqualsPredicate extends NumberPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_765;

    static {
        field_765 = FunctionType.LESS_EQUALS.toString();
    }

    public LessEqualsPredicate() {
        super(field_765);
    }

    public static String getFunctionId() {
        return field_765;
    }

    protected boolean evaluateNumber(TypedNumber var1, TypedNumber var2, Map<String, TypeSystem.Value> var3) {
        return var1.compareTo(var2) <= 0;
    }
}
