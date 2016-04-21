package com.google.android.gms.internal;

import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_480;
import com.google.android.gms.internal.class_484;
import com.google.android.gms.internal.class_485;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.cc
@ez
public class class_463 implements class_9 {
    // $FF: renamed from: pK java.util.Map
    static final Map<String, Integer> field_1792 = new HashMap();

    static {
        field_1792.put("resize", Integer.valueOf(1));
        field_1792.put("playVideo", Integer.valueOf(2));
        field_1792.put("storePicture", Integer.valueOf(3));
        field_1792.put("createCalendarEvent", Integer.valueOf(4));
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
    public void method_24(gv var1, Map<String, String> var2) {
        String var3 = (String)var2.get("a");
        switch(((Integer)field_1792.get(var3)).intValue()) {
            case 1:
                (new class_484(var1, var2)).execute();
                return;
            case 2:
            default:
                class_378.method_2459("Unknown MRAID command called.");
                return;
            case 3:
                (new class_485(var1, var2)).execute();
                return;
            case 4:
                (new class_480(var1, var2)).execute();
        }
    }
}
