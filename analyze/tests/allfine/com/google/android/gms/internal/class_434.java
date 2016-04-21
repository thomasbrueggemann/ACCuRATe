package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_244;
import com.google.android.gms.internal.class_252;
import com.google.android.gms.internal.class_36;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_37;
import com.google.android.gms.internal.class_377;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_433;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.class_441;
import com.google.android.gms.internal.class_447;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_45;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ez;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.fr
@ez
public final class class_434 extends class_37.class_1335 {
    // $FF: renamed from: uf java.lang.Object
    private static final Object field_1612 = new Object();
    // $FF: renamed from: ug com.google.android.gms.internal.fr
    private static class_434 field_1613;
    private final Context mContext;
    // $FF: renamed from: uh com.google.android.gms.internal.fx
    private final class_36 field_1614;
    // $FF: renamed from: ui com.google.android.gms.internal.ci
    private final class_45 field_1615;
    // $FF: renamed from: uj com.google.android.gms.internal.bm
    private final class_252 field_1616;

    class_434(Context var1, class_252 var2, class_45 var3, class_36 var4) {
        this.mContext = var1;
        this.field_1614 = var4;
        this.field_1615 = var3;
        this.field_1616 = var2;
    }

    // $FF: renamed from: I (java.lang.String) com.google.android.gms.internal.gw$a
    private static class_364.class_1738 method_2758(final String var0) {
        return new class_364.class_1738() {
            // $FF: renamed from: a (com.google.android.gms.internal.gv) void
            public void method_831(class_381 var1) {
                Object[] var2 = new Object[] {"AFMA_buildAdURL", var0};
                String var3 = String.format("javascript:%s(%s);", var2);
                class_378.method_2460("About to execute: " + var3);
                var1.loadUrl(var3);
            }
        };
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.bm, com.google.android.gms.internal.ci, com.google.android.gms.internal.fx, com.google.android.gms.internal.fi) com.google.android.gms.internal.fk
    private static class_447 method_2759(final Context var0, class_252 var1, class_45 var2, class_36 var3, final class_448 var4) {
        class_378.method_2457("Starting ad request from service.");
        var2.init();
        class_440 var5 = new class_440(var0);
        if(var5.field_1659 == -1) {
            class_378.method_2457("Device is offline.");
            return new class_447(2);
        } else {
            final class_432 var6 = new class_432(var4.applicationInfo.packageName);
            if(var4.field_1722.extras != null) {
                String var16 = var4.field_1722.extras.getString("_ad");
                if(var16 != null) {
                    return class_433.method_2749(var0, var4, var16);
                }
            }

            Location var7 = var2.method_181(250L);
            final String var8 = var1.method_1614();
            String var9 = class_433.method_2750(var4, var5, var7, var1.method_1615(), var1.method_1616());
            if(var9 == null) {
                return new class_447(0);
            } else {
                final class_364.class_1738 var10 = method_2758(var9);
                class_377.field_1386.post(new Runnable() {
                    public void run() {
                        class_381 var1 = class_381.method_2470(var0, new class_242(), false, false, (class_548)null, var4.field_1712);
                        var1.setWillNotDraw(true);
                        var6.method_2747(var1);
                        class_364 var2 = var1.method_2486();
                        var2.method_2400("/invalidRequest", var6.field_1607);
                        var2.method_2400("/loadAdURL", var6.field_1608);
                        var2.method_2400("/log", class_244.field_646);
                        var2.method_2397(var10);
                        class_378.method_2457("Loading the JS library.");
                        var1.loadUrl(var8);
                    }
                });

                class_441 var13;
                try {
                    var13 = (class_441)var6.method_2748().get(10L, TimeUnit.SECONDS);
                } catch (Exception var17) {
                    return new class_447(0);
                }

                if(var13 == null) {
                    return new class_447(0);
                } else if(var13.getErrorCode() != -2) {
                    return new class_447(var13.getErrorCode());
                } else {
                    boolean var14 = var13.method_2782();
                    String var15 = null;
                    if(var14) {
                        var15 = var3.method_165(var4.field_1723.packageName);
                    }

                    return method_2760(var0, var4.field_1712.field_1387, var13.getUrl(), var15, var13);
                }
            }
        }
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.fv) com.google.android.gms.internal.fk
    public static class_447 method_2760(Context param0, String param1, String param2, String param3, class_441 param4) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.bm, com.google.android.gms.internal.ci, com.google.android.gms.internal.fx) com.google.android.gms.internal.fr
    public static class_434 method_2761(Context param0, class_252 param1, class_45 param2, class_36 param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, java.util.Map, java.lang.String, int) void
    private static void method_2762(String var0, Map<String, List<String>> var1, String var2, int var3) {
        if(class_378.method_2466(2)) {
            class_378.method_2460("Http Response: {\n  URL:\n    " + var0 + "\n  Headers:");
            if(var1 != null) {
                Iterator var5 = var1.keySet().iterator();

                while(var5.hasNext()) {
                    String var6 = (String)var5.next();
                    class_378.method_2460("    " + var6 + ":");
                    Iterator var7 = ((List)var1.get(var6)).iterator();

                    while(var7.hasNext()) {
                        String var8 = (String)var7.next();
                        class_378.method_2460("      " + var8);
                    }
                }
            }

            class_378.method_2460("  Body:");
            if(var2 != null) {
                for(int var4 = 0; var4 < Math.min(var2.length(), 100000); var4 += 1000) {
                    class_378.method_2460(var2.substring(var4, Math.min(var2.length(), var4 + 1000)));
                }
            } else {
                class_378.method_2460("    null");
            }

            class_378.method_2460("  Response Code:\n    " + var3 + "\n}");
        }

    }

    // $FF: renamed from: b (com.google.android.gms.internal.fi) com.google.android.gms.internal.fk
    public class_447 method_166(class_448 var1) {
        return method_2759(this.mContext, this.field_1616, this.field_1615, this.field_1614, var1);
    }
}
