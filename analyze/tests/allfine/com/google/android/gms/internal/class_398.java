package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.hp
public class class_398 {
    // $FF: renamed from: Cm java.lang.String[]
    private static final String[] field_1485;
    // $FF: renamed from: Cn java.util.Map
    private static final Map<String, Integer> field_1486;

    static {
        int var0 = 0;
        field_1485 = new String[] {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};

        for(field_1486 = new HashMap(field_1485.length); var0 < field_1485.length; ++var0) {
            field_1486.put(field_1485[var0], Integer.valueOf(var0));
        }

    }

    // $FF: renamed from: O (int) java.lang.String
    public static String method_2623(int var0) {
        return var0 >= 0 && var0 < field_1485.length?field_1485[var0]:null;
    }

    // $FF: renamed from: as (java.lang.String) int
    public static int method_2624(String var0) {
        Integer var1 = (Integer)field_1486.get(var0);
        if(var1 == null) {
            throw new IllegalArgumentException("[" + var0 + "] is not a valid global search section name");
        } else {
            return var1.intValue();
        }
    }

    // $FF: renamed from: fl () int
    public static int method_2625() {
        return field_1485.length;
    }
}
