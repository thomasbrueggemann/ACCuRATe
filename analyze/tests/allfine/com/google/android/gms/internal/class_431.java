package com.google.android.gms.internal;

import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.ez;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.fu
@ez
public final class class_431 {
    private int mOrientation = -1;
    // $FF: renamed from: pn java.lang.String
    private String field_1587;
    // $FF: renamed from: uA java.util.List
    private List<String> field_1588;
    // $FF: renamed from: uB long
    private long field_1589 = -1L;
    // $FF: renamed from: uC boolean
    private boolean field_1590 = false;
    // $FF: renamed from: uD long
    private final long field_1591 = -1L;
    // $FF: renamed from: uE long
    private long field_1592 = -1L;
    // $FF: renamed from: uF boolean
    private boolean field_1593 = false;
    // $FF: renamed from: uG boolean
    private boolean field_1594 = false;
    // $FF: renamed from: uH boolean
    private boolean field_1595 = false;
    // $FF: renamed from: uI boolean
    private boolean field_1596 = false;
    // $FF: renamed from: ua java.util.List
    private List<String> field_1597;
    // $FF: renamed from: uv java.lang.String
    private String field_1598;
    // $FF: renamed from: uw java.lang.String
    private String field_1599;
    // $FF: renamed from: ux java.util.List
    private List<String> field_1600;
    // $FF: renamed from: uy java.lang.String
    private String field_1601;
    // $FF: renamed from: uz java.lang.String
    private String field_1602;

    // $FF: renamed from: a (java.util.Map, java.lang.String) java.lang.String
    static String method_2723(Map<String, List<String>> var0, String var1) {
        List var2 = (List)var0.get(var1);
        return var2 != null && !var2.isEmpty()?(String)var2.get(0):null;
    }

    // $FF: renamed from: b (java.util.Map, java.lang.String) long
    static long method_2724(Map<String, List<String>> var0, String var1) {
        List var2 = (List)var0.get(var1);
        if(var2 != null && !var2.isEmpty()) {
            String var3 = (String)var2.get(0);

            float var5;
            try {
                var5 = Float.parseFloat(var3);
            } catch (NumberFormatException var6) {
                class_378.method_2461("Could not parse float from " + var1 + " header: " + var3);
                return -1L;
            }

            return (long)(var5 * 1000.0F);
        } else {
            return -1L;
        }
    }

    // $FF: renamed from: c (java.util.Map, java.lang.String) java.util.List
    static List<String> method_2725(Map<String, List<String>> var0, String var1) {
        List var2 = (List)var0.get(var1);
        if(var2 != null && !var2.isEmpty()) {
            String var3 = (String)var2.get(0);
            if(var3 != null) {
                return Arrays.asList(var3.trim().split("\\s+"));
            }
        }

        return null;
    }

    // $FF: renamed from: d (java.util.Map, java.lang.String) boolean
    private boolean method_2726(Map<String, List<String>> var1, String var2) {
        List var3 = (List)var1.get(var2);
        return var3 != null && !var3.isEmpty() && Boolean.valueOf((String)var3.get(0)).booleanValue();
    }

    // $FF: renamed from: f (java.util.Map) void
    private void method_2727(Map<String, List<String>> var1) {
        this.field_1598 = method_2723(var1, "X-Afma-Ad-Size");
    }

    // $FF: renamed from: g (java.util.Map) void
    private void method_2728(Map<String, List<String>> var1) {
        List var2 = method_2725(var1, "X-Afma-Click-Tracking-Urls");
        if(var2 != null) {
            this.field_1600 = var2;
        }

    }

    // $FF: renamed from: h (java.util.Map) void
    private void method_2729(Map<String, List<String>> var1) {
        List var2 = (List)var1.get("X-Afma-Debug-Dialog");
        if(var2 != null && !var2.isEmpty()) {
            this.field_1601 = (String)var2.get(0);
        }

    }

    // $FF: renamed from: i (java.util.Map) void
    private void method_2730(Map<String, List<String>> var1) {
        List var2 = method_2725(var1, "X-Afma-Tracking-Urls");
        if(var2 != null) {
            this.field_1588 = var2;
        }

    }

    // $FF: renamed from: j (java.util.Map) void
    private void method_2731(Map<String, List<String>> var1) {
        long var2 = method_2724(var1, "X-Afma-Interstitial-Timeout");
        if(var2 != -1L) {
            this.field_1589 = var2;
        }

    }

    // $FF: renamed from: k (java.util.Map) void
    private void method_2732(Map<String, List<String>> var1) {
        this.field_1602 = method_2723(var1, "X-Afma-ActiveView");
    }

    // $FF: renamed from: l (java.util.Map) void
    private void method_2733(Map<String, List<String>> var1) {
        this.field_1594 |= this.method_2726(var1, "X-Afma-Native");
    }

    // $FF: renamed from: m (java.util.Map) void
    private void method_2734(Map<String, List<String>> var1) {
        this.field_1593 |= this.method_2726(var1, "X-Afma-Custom-Rendering-Allowed");
    }

    // $FF: renamed from: n (java.util.Map) void
    private void method_2735(Map<String, List<String>> var1) {
        this.field_1590 |= this.method_2726(var1, "X-Afma-Mediation");
    }

    // $FF: renamed from: o (java.util.Map) void
    private void method_2736(Map<String, List<String>> var1) {
        List var2 = method_2725(var1, "X-Afma-Manual-Tracking-Urls");
        if(var2 != null) {
            this.field_1597 = var2;
        }

    }

    // $FF: renamed from: p (java.util.Map) void
    private void method_2737(Map<String, List<String>> var1) {
        long var2 = method_2724(var1, "X-Afma-Refresh-Rate");
        if(var2 != -1L) {
            this.field_1592 = var2;
        }

    }

    // $FF: renamed from: q (java.util.Map) void
    private void method_2738(Map<String, List<String>> var1) {
        List var2 = (List)var1.get("X-Afma-Orientation");
        if(var2 != null && !var2.isEmpty()) {
            String var3 = (String)var2.get(0);
            if("portrait".equalsIgnoreCase(var3)) {
                this.mOrientation = class_383.method_2525();
            } else if("landscape".equalsIgnoreCase(var3)) {
                this.mOrientation = class_383.method_2524();
                return;
            }
        }

    }

    // $FF: renamed from: r (java.util.Map) void
    private void method_2739(Map<String, List<String>> var1) {
        List var2 = (List)var1.get("X-Afma-Use-HTTPS");
        if(var2 != null && !var2.isEmpty()) {
            this.field_1595 = Boolean.valueOf((String)var2.get(0)).booleanValue();
        }

    }

    // $FF: renamed from: s (java.util.Map) void
    private void method_2740(Map<String, List<String>> var1) {
        List var2 = (List)var1.get("X-Afma-Content-Url-Opted-Out");
        if(var2 != null && !var2.isEmpty()) {
            this.field_1596 = Boolean.valueOf((String)var2.get(0)).booleanValue();
        }

    }

    // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String) void
    public void method_2741(String var1, Map<String, List<String>> var2, String var3) {
        this.field_1599 = var1;
        this.field_1587 = var3;
        this.method_2742(var2);
    }

    // $FF: renamed from: e (java.util.Map) void
    public void method_2742(Map<String, List<String>> var1) {
        this.method_2727(var1);
        this.method_2728(var1);
        this.method_2729(var1);
        this.method_2730(var1);
        this.method_2731(var1);
        this.method_2735(var1);
        this.method_2736(var1);
        this.method_2737(var1);
        this.method_2738(var1);
        this.method_2732(var1);
        this.method_2739(var1);
        this.method_2734(var1);
        this.method_2733(var1);
        this.method_2740(var1);
    }

    // $FF: renamed from: i (long) com.google.android.gms.internal.fk
    public class_447 method_2743(long var1) {
        return new class_447(this.field_1599, this.field_1587, this.field_1600, this.field_1588, this.field_1589, this.field_1590, -1L, this.field_1597, this.field_1592, this.mOrientation, this.field_1598, var1, this.field_1601, this.field_1602, this.field_1593, this.field_1594, this.field_1595, this.field_1596);
    }
}
