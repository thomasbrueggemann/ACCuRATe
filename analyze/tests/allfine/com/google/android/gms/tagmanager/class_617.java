package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.tagmanager.class_643;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ay
class class_617 {
    private static String apy;
    static Map<String, String> apz = new HashMap();

    // $FF: renamed from: cF (java.lang.String) void
    static void method_3479(String param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (android.content.Context, java.lang.String) void
    static void method_3480(Context var0, String var1) {
        class_643.method_3633(var0, "gtm_install_referrer", "referrer", var1);
        method_3483(var0, var1);
    }

    // $FF: renamed from: e (android.content.Context, java.lang.String) java.lang.String
    static String method_3481(Context param0, String param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (android.content.Context, java.lang.String, java.lang.String) java.lang.String
    static String method_3482(Context var0, String var1, String var2) {
        String var3 = (String)apz.get(var1);
        if(var3 == null) {
            SharedPreferences var4 = var0.getSharedPreferences("gtm_click_referrers", 0);
            if(var4 != null) {
                var3 = var4.getString(var1, "");
            } else {
                var3 = "";
            }

            apz.put(var1, var3);
        }

        return method_3484(var3, var2);
    }

    // $FF: renamed from: f (android.content.Context, java.lang.String) void
    static void method_3483(Context var0, String var1) {
        String var2 = method_3484(var1, "conv");
        if(var2 != null && var2.length() > 0) {
            apz.put(var2, var1);
            class_643.method_3633(var0, "gtm_click_referrers", var2, var1);
        }

    }

    // $FF: renamed from: x (java.lang.String, java.lang.String) java.lang.String
    static String method_3484(String var0, String var1) {
        return var1 == null?(var0.length() > 0?var0:null):Uri.parse("http://hostname/?" + var0).getQueryParameter(var1);
    }
}
