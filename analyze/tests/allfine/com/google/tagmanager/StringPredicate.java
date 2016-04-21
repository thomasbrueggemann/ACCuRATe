package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Predicate;
import com.google.tagmanager.Types;
import java.util.Map;

abstract class StringPredicate extends Predicate {
    public StringPredicate(String var1) {
        super(var1);
    }

    protected boolean evaluateNoDefaultValues(TypeSystem.Value var1, TypeSystem.Value var2, Map<String, TypeSystem.Value> var3) {
        String var4 = Types.valueToString(var1);
        String var5 = Types.valueToString(var2);
        return var4 != Types.getDefaultString() && var5 != Types.getDefaultString()?this.evaluateString(var4, var5, var3):false;
    }

    protected abstract boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3);
}
