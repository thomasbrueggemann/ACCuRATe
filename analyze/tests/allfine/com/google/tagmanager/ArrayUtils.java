package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;

class ArrayUtils {
    public static Debug.EventInfo[] appendToArray(Debug.EventInfo[] var0, Debug.EventInfo var1) {
        Debug.EventInfo[] var2 = new Debug.EventInfo[1 + var0.length];
        System.arraycopy(var0, 0, var2, 0, var0.length);
        var2[var0.length] = var1;
        return var2;
    }

    public static Debug.ResolvedFunctionCall[] appendToArray(Debug.ResolvedFunctionCall[] var0, Debug.ResolvedFunctionCall var1) {
        Debug.ResolvedFunctionCall[] var2 = new Debug.ResolvedFunctionCall[1 + var0.length];
        System.arraycopy(var0, 0, var2, 0, var0.length);
        var2[var0.length] = var1;
        return var2;
    }

    public static Debug.ResolvedProperty[] appendToArray(Debug.ResolvedProperty[] var0, Debug.ResolvedProperty var1) {
        Debug.ResolvedProperty[] var2 = new Debug.ResolvedProperty[1 + var0.length];
        System.arraycopy(var0, 0, var2, 0, var0.length);
        var2[var0.length] = var1;
        return var2;
    }

    public static Debug.ResolvedRule[] appendToArray(Debug.ResolvedRule[] var0, Debug.ResolvedRule var1) {
        Debug.ResolvedRule[] var2 = new Debug.ResolvedRule[1 + var0.length];
        System.arraycopy(var0, 0, var2, 0, var0.length);
        var2[var0.length] = var1;
        return var2;
    }
}
