package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import com.google.tagmanager.Types;
import java.util.Iterator;
import java.util.Map;

abstract class Predicate extends FunctionCallImplementation {
    private static final String ARG0;
    private static final String ARG1;

    static {
        ARG0 = Key.ARG0.toString();
        ARG1 = Key.ARG1.toString();
    }

    public Predicate(String var1) {
        String[] var2 = new String[] {ARG0, ARG1};
        super(var1, var2);
    }

    public static String getArg0Key() {
        return ARG0;
    }

    public static String getArg1Key() {
        return ARG1;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1) {
        Iterator var2 = var1.values().iterator();

        do {
            if(!var2.hasNext()) {
                TypeSystem.Value var3 = (TypeSystem.Value)var1.get(ARG0);
                TypeSystem.Value var4 = (TypeSystem.Value)var1.get(ARG1);
                boolean var5 = false;
                if(var3 != null) {
                    var5 = false;
                    if(var4 != null) {
                        var5 = this.evaluateNoDefaultValues(var3, var4, var1);
                    }
                }

                return Types.objectToValue(Boolean.valueOf(var5));
            }
        } while((TypeSystem.Value)var2.next() != Types.getDefaultValue());

        return Types.objectToValue(Boolean.valueOf(false));
    }

    protected abstract boolean evaluateNoDefaultValues(TypeSystem.Value var1, TypeSystem.Value var2, Map<String, TypeSystem.Value> var3);

    public boolean isCacheable() {
        return true;
    }
}
