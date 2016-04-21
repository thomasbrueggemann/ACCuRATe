package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.class_376;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_465;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.gv;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.bx
@ez
public final class class_244 {
    // $FF: renamed from: pA com.google.android.gms.internal.by
    public static final class_9 field_640 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
        }
    };
    // $FF: renamed from: pB com.google.android.gms.internal.by
    public static final class_9 field_641 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
            String var3 = (String)var2.get("urls");
            if(TextUtils.isEmpty(var3)) {
                class_378.method_2461("URLs missing in canOpenURLs GMSG.");
            } else {
                String[] var4 = var3.split(",");
                HashMap var5 = new HashMap();
                PackageManager var6 = var1.getContext().getPackageManager();
                int var7 = var4.length;

                for(int var8 = 0; var8 < var7; ++var8) {
                    String var9 = var4[var8];
                    String[] var10 = var9.split(";", 2);
                    String var11 = var10[0].trim();
                    String var12;
                    if(var10.length > 1) {
                        var12 = var10[1].trim();
                    } else {
                        var12 = "android.intent.action.VIEW";
                    }

                    boolean var13;
                    if(var6.resolveActivity(new Intent(var12, Uri.parse(var11)), 65536) != null) {
                        var13 = true;
                    } else {
                        var13 = false;
                    }

                    var5.put(var9, Boolean.valueOf(var13));
                }

                var1.method_2479("openableURLs", var5);
            }
        }
    };
    // $FF: renamed from: pC com.google.android.gms.internal.by
    public static final class_9 field_642 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv param1, Map<String, String> param2) {
            // $FF: Couldn't be decompiled
        }
    };
    // $FF: renamed from: pD com.google.android.gms.internal.by
    public static final class_9 field_643 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
            class_487 var3 = var1.method_2485();
            if(var3 == null) {
                class_378.method_2461("A GMSG tried to close something that wasn\'t an overlay.");
            } else {
                var3.close();
            }
        }
    };
    // $FF: renamed from: pE com.google.android.gms.internal.by
    public static final class_9 field_644 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
            var1.method_2492("1".equals(var2.get("custom_close")));
        }
    };
    // $FF: renamed from: pF com.google.android.gms.internal.by
    public static final class_9 field_645 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
            String var3 = (String)var2.get("u");
            if(var3 == null) {
                class_378.method_2461("URL missing from httpTrack GMSG.");
            } else {
                (new class_376(var1.getContext(), var1.method_2489().field_1387, var3)).start();
            }
        }
    };
    // $FF: renamed from: pG com.google.android.gms.internal.by
    public static final class_9 field_646 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv var1, Map<String, String> var2) {
            class_378.method_2459("Received log message: " + (String)var2.get("string"));
        }
    };
    // $FF: renamed from: pH com.google.android.gms.internal.by
    public static final class_9 field_647 = new class_9() {
        // $FF: renamed from: a (com.google.android.gms.internal.gv, java.util.Map) void
        public void method_24(gv param1, Map<String, String> param2) {
            // $FF: Couldn't be decompiled
        }
    };
    // $FF: renamed from: pI com.google.android.gms.internal.by
    public static final class_9 field_648 = new class_465();
}
