package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.Predicate;
import com.google.tagmanager.TypedNumber;
import com.google.tagmanager.Types;
import java.util.Map;

abstract class NumberPredicate extends Predicate {
    public NumberPredicate(String var1) {
        super(var1);
    }

    protected boolean evaluateNoDefaultValues(TypeSystem.Value var1, TypeSystem.Value var2, Map<String, TypeSystem.Value> var3) {
        TypedNumber var4 = Types.valueToNumber(var1);
        TypedNumber var5 = Types.valueToNumber(var2);
        return var4 != Types.getDefaultNumber() && var5 != Types.getDefaultNumber()?this.evaluateNumber(var4, var5, var3):false;
    }

    protected abstract boolean evaluateNumber(TypedNumber var1, TypedNumber var2, Map<String, TypeSystem.Value> var3);
}
