package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class FunctionCallImplementation {
    private static final String FUNCTION_KEY = "function";
    private final String mFunctionId;
    private final Set<String> mRequiredKeys;

    public FunctionCallImplementation(String var1, String... var2) {
        this.mFunctionId = var1;
        this.mRequiredKeys = new HashSet(var2.length);
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            this.mRequiredKeys.add(var5);
        }

    }

    public static String getFunctionKey() {
        return "function";
    }

    public abstract TypeSystem.Value evaluate(Map<String, TypeSystem.Value> var1);

    public String getInstanceFunctionId() {
        return this.mFunctionId;
    }

    public Set<String> getRequiredKeys() {
        return this.mRequiredKeys;
    }

    boolean hasRequiredKeys(Set<String> var1) {
        return var1.containsAll(this.mRequiredKeys);
    }

    public abstract boolean isCacheable();
}
