package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import com.google.analytics.midtier.proto.containertag.TypeSystem;
import com.google.tagmanager.FunctionCallImplementation;
import java.util.Map;

class RegexGroupMacro extends FunctionCallImplementation {
    private static final String GROUP;
    // $FF: renamed from: ID java.lang.String
    private static final String field_736;
    private static final String IGNORE_CASE;
    private static final String REGEX;
    private static final String TO_MATCH;

    static {
        field_736 = FunctionType.REGEX_GROUP.toString();
        TO_MATCH = Key.ARG0.toString();
        REGEX = Key.ARG1.toString();
        IGNORE_CASE = Key.IGNORE_CASE.toString();
        GROUP = Key.GROUP.toString();
    }

    public RegexGroupMacro() {
        String var1 = field_736;
        String[] var2 = new String[] {TO_MATCH, REGEX};
        super(var1, var2);
    }

    public static String getFunctionId() {
        return field_736;
    }

    public TypeSystem.Value evaluate(Map<String, TypeSystem.Value> param1) {
        // $FF: Couldn't be decompiled
    }

    public boolean isCacheable() {
        return true;
    }
}
