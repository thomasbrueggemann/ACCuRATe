package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Log;
import com.google.tagmanager.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class CustomFunctionCall extends FunctionCallImplementation {
    private static final String ADDITIONAL_PARAMS;
    private static final String FUNCTION_CALL_NAME;
    // $FF: renamed from: ID java.lang.String
    private static final String field_775;
    private final CustomFunctionCall.CustomEvaluator mFunctionCallEvaluator;

    static {
        field_775 = FunctionType.FUNCTION_CALL.toString();
        FUNCTION_CALL_NAME = Key.FUNCTION_CALL_NAME.toString();
        ADDITIONAL_PARAMS = Key.ADDITIONAL_PARAMS.toString();
    }

    public CustomFunctionCall(CustomFunctionCall.CustomEvaluator var1) {
        String var2 = field_775;
        String[] var3 = new String[] {FUNCTION_CALL_NAME};
        super(var2, var3);
        this.mFunctionCallEvaluator = var1;
    }

    public static String getAdditionalParamsKey() {
        return ADDITIONAL_PARAMS;
    }

    public static String getFunctionCallNameKey() {
        return FUNCTION_CALL_NAME;
    }

    public static String getFunctionId() {
        return field_775;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        String var2 = Types.valueToString((TypeSystem.Value)var1.get(FUNCTION_CALL_NAME));
        HashMap var3 = new HashMap();
        TypeSystem.Value var4 = (TypeSystem.Value)var1.get(ADDITIONAL_PARAMS);
        if(var4 != null) {
            Object var7 = Types.valueToObject(var4);
            if(!(var7 instanceof Map)) {
                Log.method_5509("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return Types.getDefaultValue();
            }

            Iterator var8 = ((Map)var7).entrySet().iterator();

            while(var8.hasNext()) {
                Entry var9 = (Entry)var8.next();
                var3.put(var9.getKey().toString(), var9.getValue());
            }
        }

        try {
            TypeSystem.Value var6 = Types.objectToValue(this.mFunctionCallEvaluator.evaluate(var2, var3));
            return var6;
        } catch (Exception var10) {
            Log.method_5509("Custom macro/tag " + var2 + " threw exception " + var10.getMessage());
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable() {
        return false;
    }

    public interface CustomEvaluator {
        Object evaluate(String var1, Map<String, Object> var2);
    }
}
