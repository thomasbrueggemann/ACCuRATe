package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.TypedNumber;
import com.google.tagmanager.Types;
import java.util.Map;

class RandomMacro extends FunctionCallImplementation {
    // $FF: renamed from: ID java.lang.String
    private static final String field_758;
    private static final String MAX;
    private static final String MIN;

    static {
        field_758 = FunctionType.RANDOM.toString();
        MIN = Key.MIN.toString();
        MAX = Key.MAX.toString();
    }

    public RandomMacro() {
        super(field_758, new String[0]);
    }

    public static String getFunctionId() {
        return field_758;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        double var2 = 0.0D;
        double var4 = 2.147483647E9D;
        TypeSystem.Value var6 = (TypeSystem.Value)var1.get(MIN);
        TypeSystem.Value var7 = (TypeSystem.Value)var1.get(MAX);
        if(var6 != null && var6 != Types.getDefaultValue() && var7 != null && var7 != Types.getDefaultValue()) {
            TypedNumber var8 = Types.valueToNumber(var6);
            TypedNumber var9 = Types.valueToNumber(var7);
            if(var8 != Types.getDefaultNumber() && var9 != Types.getDefaultNumber()) {
                double var10 = var8.doubleValue();
                double var12 = var9.doubleValue();
                if(var10 <= var12) {
                    var2 = var10;
                    var4 = var12;
                }
            }
        }

        return Types.objectToValue(Long.valueOf(Math.round(var2 + Math.random() * (var4 - var2))));
    }

    public boolean isCacheable() {
        return false;
    }
}
