package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;
import com.google.android.gms.internal.class_392;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.fs
@ez
public final class class_433 {
    // $FF: renamed from: up java.text.SimpleDateFormat
    private static final SimpleDateFormat field_1611 = new SimpleDateFormat("yyyyMMdd");

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.fi, java.lang.String) com.google.android.gms.internal.fk
    public static class_447 method_2749(Context param0, class_448 param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.fi, com.google.android.gms.internal.fw, android.location.Location, java.lang.String, java.lang.String) java.lang.String
    public static String method_2750(class_448 param0, class_440 param1, Location param2, String param3, String param4) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.util.HashMap, android.location.Location) void
    private static void method_2751(HashMap<String, Object> var0, Location var1) {
        HashMap var2 = new HashMap();
        Float var3 = Float.valueOf(1000.0F * var1.getAccuracy());
        Long var4 = Long.valueOf(1000L * var1.getTime());
        Long var5 = Long.valueOf((long)(1.0E7D * var1.getLatitude()));
        Long var6 = Long.valueOf((long)(1.0E7D * var1.getLongitude()));
        var2.put("radius", var3);
        var2.put("lat", var5);
        var2.put("long", var6);
        var2.put("time", var4);
        var0.put("uule", var2);
    }

    // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.av) void
    private static void method_2752(HashMap<String, Object> var0, av var1) {
        String var2 = class_392.method_2596();
        if(var2 != null) {
            var0.put("abf", var2);
        }

        if(var1.field_550 != -1L) {
            var0.put("cust_age", field_1611.format(new Date(var1.field_550)));
        }

        if(var1.extras != null) {
            var0.put("extras", var1.extras);
        }

        if(var1.field_551 != -1) {
            var0.put("cust_gender", Integer.valueOf(var1.field_551));
        }

        if(var1.field_552 != null) {
            var0.put("kw", var1.field_552);
        }

        if(var1.field_554 != -1) {
            var0.put("tag_for_child_directed_treatment", Integer.valueOf(var1.field_554));
        }

        if(var1.field_553) {
            var0.put("adtest", "on");
        }

        if(var1.versionCode >= 2) {
            if(var1.field_555) {
                var0.put("d_imp_hdr", Integer.valueOf(1));
            }

            if(!TextUtils.isEmpty(var1.field_556)) {
                var0.put("ppid", var1.field_556);
            }

            if(var1.field_557 != null) {
                method_2753(var0, var1.field_557);
            }
        }

        if(var1.versionCode >= 3 && var1.field_559 != null) {
            var0.put("url", var1.field_559);
        }

    }

    // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.bj) void
    private static void method_2753(HashMap<String, Object> var0, bj var1) {
        if(Color.alpha(var1.field_684) != 0) {
            var0.put("acolor", method_2756(var1.field_684));
        }

        if(Color.alpha(var1.backgroundColor) != 0) {
            var0.put("bgcolor", method_2756(var1.backgroundColor));
        }

        if(Color.alpha(var1.field_685) != 0 && Color.alpha(var1.field_686) != 0) {
            var0.put("gradientto", method_2756(var1.field_685));
            var0.put("gradientfrom", method_2756(var1.field_686));
        }

        if(Color.alpha(var1.field_687) != 0) {
            var0.put("bcolor", method_2756(var1.field_687));
        }

        var0.put("bthick", Integer.toString(var1.field_688));
        String var3;
        switch(var1.field_689) {
            case 0:
                var3 = "none";
                break;
            case 1:
                var3 = "dashed";
                break;
            case 2:
                var3 = "dotted";
                break;
            case 3:
                var3 = "solid";
                break;
            default:
                var3 = null;
        }

        if(var3 != null) {
            var0.put("btype", var3);
        }

        int var4 = var1.field_690;
        String var5 = null;
        switch(var4) {
            case 0:
                var5 = "light";
                break;
            case 1:
                var5 = "medium";
                break;
            case 2:
                var5 = "dark";
        }

        if(var5 != null) {
            var0.put("callbuttoncolor", var5);
        }

        if(var1.field_691 != null) {
            var0.put("channel", var1.field_691);
        }

        if(Color.alpha(var1.field_692) != 0) {
            var0.put("dcolor", method_2756(var1.field_692));
        }

        if(var1.field_693 != null) {
            var0.put("font", var1.field_693);
        }

        if(Color.alpha(var1.field_694) != 0) {
            var0.put("hcolor", method_2756(var1.field_694));
        }

        var0.put("headersize", Integer.toString(var1.field_695));
        if(var1.field_696 != null) {
            var0.put("q", var1.field_696);
        }

    }

    // $FF: renamed from: a (java.util.HashMap, com.google.android.gms.internal.fw) void
    private static void method_2754(HashMap<String, Object> var0, fw var1) {
        var0.put("am", Integer.valueOf(var1.field_1648));
        var0.put("cog", method_2755(var1.field_1649));
        var0.put("coh", method_2755(var1.field_1650));
        if(!TextUtils.isEmpty(var1.field_1651)) {
            var0.put("carrier", var1.field_1651);
        }

        var0.put("gl", var1.field_1652);
        if(var1.field_1653) {
            var0.put("simulator", Integer.valueOf(1));
        }

        var0.put("ma", method_2755(var1.field_1654));
        var0.put("sp", method_2755(var1.field_1655));
        var0.put("hl", var1.field_1656);
        if(!TextUtils.isEmpty(var1.field_1657)) {
            var0.put("mv", var1.field_1657);
        }

        var0.put("muv", Integer.valueOf(var1.field_1658));
        if(var1.field_1659 != -2) {
            var0.put("cnt", Integer.valueOf(var1.field_1659));
        }

        var0.put("gnt", Integer.valueOf(var1.field_1660));
        var0.put("pt", Integer.valueOf(var1.field_1661));
        var0.put("rm", Integer.valueOf(var1.field_1662));
        var0.put("riv", Integer.valueOf(var1.field_1663));
        var0.put("u_sd", Float.valueOf(var1.field_1664));
        var0.put("sh", Integer.valueOf(var1.field_1666));
        var0.put("sw", Integer.valueOf(var1.field_1665));
        Bundle var17 = new Bundle();
        var17.putInt("active_network_state", var1.field_1670);
        var17.putBoolean("active_network_metered", var1.field_1669);
        var0.put("connectivity", var17);
        Bundle var19 = new Bundle();
        var19.putBoolean("is_charging", var1.field_1668);
        var19.putDouble("battery_level", var1.field_1667);
        var0.put("battery", var19);
    }

    // $FF: renamed from: s (boolean) java.lang.Integer
    private static Integer method_2755(boolean var0) {
        byte var1;
        if(var0) {
            var1 = 1;
        } else {
            var1 = 0;
        }

        return Integer.valueOf(var1);
    }

    // $FF: renamed from: t (int) java.lang.String
    private static String method_2756(int var0) {
        Locale var1 = Locale.US;
        Object[] var2 = new Object[] {Integer.valueOf(16777215 & var0)};
        return String.format(var1, "#%06x", var2);
    }
}
