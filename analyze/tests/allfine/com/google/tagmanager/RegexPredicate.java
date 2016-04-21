package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.StringPredicate;
import com.google.tagmanager.Types;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class RegexPredicate extends StringPredicate {
    // $FF: renamed from: ID java.lang.String
    private static final String field_771;
    private static final String IGNORE_CASE;

    static {
        field_771 = FunctionType.REGEX.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
    }

    public RegexPredicate() {
        super(field_771);
    }

    public static String getFunctionId() {
        return field_771;
    }

    public static String getIgnoreCaseKey() {
        return IGNORE_CASE;
    }

    protected boolean evaluateString(String var1, String var2, Map<String, TypeSystem.Value> var3) {
        int var4 = 64;
        if(Types.valueToBoolean((TypeSystem.Value)var3.get(IGNORE_CASE)).booleanValue()) {
            var4 |= 2;
        }

        try {
            boolean var6 = Pattern.compile(var2, var4).matcher(var1).find();
            return var6;
        } catch (PatternSyntaxException var7) {
            return false;
        }
    }
}
