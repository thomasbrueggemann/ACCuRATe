package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import java.util.Map;

class ConstantMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_739;
    private static final String VALUE;

    static {
        field_739 = FunctionType.CONSTANT.toString();
        VALUE = Key.VALUE.toString();
    }

    public ConstantMacro() {
        String var1 = field_739;
        String[] var2 = new String[] {VALUE};
        super(var1, var2);
    }

    public static String getFunctionId() {
        return field_739;
    }

    public static String getValueKey() {
        return VALUE;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        return (TypeSystem.Value)var1.get(VALUE);
    }

    public boolean isCacheable() {
        return true;
    }
}
