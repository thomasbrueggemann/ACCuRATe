package com.google.android.gms.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.by;
import com.google.android.gms.internal.class_243;
import com.google.android.gms.internal.class_244;
import com.google.android.gms.internal.class_251;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_381;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_42;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_46;
import com.google.android.gms.internal.class_462;
import com.google.android.gms.internal.class_463;
import com.google.android.gms.internal.class_464;
import com.google.android.gms.internal.class_469;
import com.google.android.gms.internal.class_48;
import com.google.android.gms.internal.class_483;
import com.google.android.gms.internal.class_486;
import com.google.android.gms.internal.class_487;
import com.google.android.gms.internal.class_539;
import com.google.android.gms.internal.class_63;
import com.google.android.gms.internal.class_8;
import com.google.android.gms.internal.class_9;
import com.google.android.gms.internal.ez;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.internal.gw
@ez
public class class_364 extends WebViewClient {
    // $FF: renamed from: md com.google.android.gms.internal.gv
    protected final class_381 field_1328;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1329;
    // $FF: renamed from: pJ com.google.android.gms.internal.cb
    private class_43 field_1330;
    // $FF: renamed from: pL com.google.android.gms.internal.bz
    private class_42 field_1331;
    // $FF: renamed from: pM com.google.android.gms.internal.v
    private class_539 field_1332;
    // $FF: renamed from: pz com.google.android.gms.internal.bw
    private class_8 field_1333;
    // $FF: renamed from: tg com.google.android.gms.internal.gw$a
    private class_364.class_1738 field_1334;
    // $FF: renamed from: wP java.util.HashMap
    private final HashMap<String, by> field_1335;
    // $FF: renamed from: wQ com.google.android.gms.internal.t
    private class_63 field_1336;
    // $FF: renamed from: wR com.google.android.gms.internal.dn
    private class_46 field_1337;
    // $FF: renamed from: wS boolean
    private boolean field_1338;
    // $FF: renamed from: wT boolean
    private boolean field_1339;
    // $FF: renamed from: wU com.google.android.gms.internal.dq
    private class_48 field_1340;
    // $FF: renamed from: wV com.google.android.gms.internal.dg
    private final class_483 field_1341;

    public class_364(class_381 var1, boolean var2) {
        this(var1, var2, new class_483(var1, var1.getContext(), new class_251(var1.getContext())));
    }

    class_364(class_381 var1, boolean var2, class_483 var3) {
        this.field_1335 = new HashMap();
        this.field_1329 = new Object();
        this.field_1338 = false;
        this.field_1328 = var1;
        this.field_1339 = var2;
        this.field_1341 = var3;
    }

    // $FF: renamed from: d (android.net.Uri) boolean
    private static boolean method_2393(Uri var0) {
        String var1 = var0.getScheme();
        return "http".equalsIgnoreCase(var1) || "https".equalsIgnoreCase(var1);
    }

    // $FF: renamed from: e (android.net.Uri) void
    private void method_2394(Uri var1) {
        String var2 = var1.getPath();
        class_9 var3 = (class_9)this.field_1335.get(var2);
        if(var3 == null) {
            class_378.method_2460("No GMSG handler found for GMSG: " + var1);
        } else {
            Map var4 = class_383.method_2520(var1);
            if(class_378.method_2466(2)) {
                class_378.method_2460("Received GMSG: " + var2);
                Iterator var5 = var4.keySet().iterator();

                while(var5.hasNext()) {
                    String var6 = (String)var5.next();
                    class_378.method_2460("  " + var6 + ": " + (String)var4.get(var6));
                }
            }

            var3.method_24(this.field_1328, var4);
        }
    }

    // $FF: renamed from: a (com.google.android.gms.internal.dj) void
    public final void method_2395(class_486 var1) {
        boolean var2 = this.field_1328.method_2490();
        class_63 var3;
        if(var2 && !this.field_1328.method_2475().field_637) {
            var3 = null;
        } else {
            var3 = this.field_1336;
        }

        class_46 var4 = null;
        if(!var2) {
            var4 = this.field_1337;
        }

        this.method_2396(new class_469(var1, var3, var4, this.field_1340, this.field_1328.method_2489()));
    }

    // $FF: renamed from: a (com.google.android.gms.internal.dm) void
    protected void method_2396(class_469 var1) {
        class_487.method_2977(this.field_1328.getContext(), var1);
    }

    // $FF: renamed from: a (com.google.android.gms.internal.gw$a) void
    public final void method_2397(class_364.class_1738 var1) {
        this.field_1334 = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.dn, com.google.android.gms.internal.bw, com.google.android.gms.internal.dq, boolean, com.google.android.gms.internal.bz, com.google.android.gms.internal.cb, com.google.android.gms.internal.v) void
    public void method_2398(class_63 var1, class_46 var2, class_8 var3, class_48 var4, boolean var5, class_42 var6, class_43 var7, class_539 var8) {
        this.method_2399(var1, var2, var3, var4, var5, var6, var8);
        this.method_2400("/setInterstitialProperties", new class_462(var7));
        this.field_1330 = var7;
    }

    // $FF: renamed from: a (com.google.android.gms.internal.t, com.google.android.gms.internal.dn, com.google.android.gms.internal.bw, com.google.android.gms.internal.dq, boolean, com.google.android.gms.internal.bz, com.google.android.gms.internal.v) void
    public void method_2399(class_63 var1, class_46 var2, class_8 var3, class_48 var4, boolean var5, class_42 var6, class_539 var7) {
        if(var7 == null) {
            var7 = new class_539(false);
        }

        this.method_2400("/appEvent", new class_243(var3));
        this.method_2400("/canOpenURLs", class_244.field_641);
        this.method_2400("/click", class_244.field_642);
        this.method_2400("/close", class_244.field_643);
        this.method_2400("/customClose", class_244.field_644);
        this.method_2400("/httpTrack", class_244.field_645);
        this.method_2400("/log", class_244.field_646);
        this.method_2400("/open", new class_464(var6, var7));
        this.method_2400("/touch", class_244.field_647);
        this.method_2400("/video", class_244.field_648);
        this.method_2400("/mraid", new class_463());
        this.field_1336 = var1;
        this.field_1337 = var2;
        this.field_1333 = var3;
        this.field_1331 = var6;
        this.field_1340 = var4;
        this.field_1332 = var7;
        this.method_2408(var5);
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.by) void
    public final void method_2400(String var1, class_9 var2) {
        this.field_1335.put(var1, var2);
    }

    // $FF: renamed from: a (boolean, int) void
    public final void method_2401(boolean var1, int var2) {
        class_63 var3;
        if(this.field_1328.method_2490() && !this.field_1328.method_2475().field_637) {
            var3 = null;
        } else {
            var3 = this.field_1336;
        }

        this.method_2396(new class_469(var3, this.field_1337, this.field_1340, this.field_1328, var1, var2, this.field_1328.method_2489()));
    }

    // $FF: renamed from: a (boolean, int, java.lang.String) void
    public final void method_2402(boolean var1, int var2, String var3) {
        boolean var4 = this.field_1328.method_2490();
        class_63 var5;
        if(var4 && !this.field_1328.method_2475().field_637) {
            var5 = null;
        } else {
            var5 = this.field_1336;
        }

        class_46 var6 = null;
        if(!var4) {
            var6 = this.field_1337;
        }

        this.method_2396(new class_469(var5, var6, this.field_1333, this.field_1340, this.field_1328, var1, var2, var3, this.field_1328.method_2489(), this.field_1331));
    }

    // $FF: renamed from: a (boolean, int, java.lang.String, java.lang.String) void
    public final void method_2403(boolean var1, int var2, String var3, String var4) {
        boolean var5 = this.field_1328.method_2490();
        class_63 var6;
        if(var5 && !this.field_1328.method_2475().field_637) {
            var6 = null;
        } else {
            var6 = this.field_1336;
        }

        class_46 var7;
        if(var5) {
            var7 = null;
        } else {
            var7 = this.field_1337;
        }

        this.method_2396(new class_469(var6, var7, this.field_1333, this.field_1340, this.field_1328, var1, var2, var3, var4, this.field_1328.method_2489(), this.field_1331));
    }

    // $FF: renamed from: bX () void
    public final void method_2404() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dD () com.google.android.gms.internal.v
    public class_539 method_2405() {
        return this.field_1332;
    }

    // $FF: renamed from: dE () boolean
    public boolean method_2406() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dF () void
    public void method_2407() {
        if(this.method_2406()) {
            this.field_1341.method_2960();
        }

    }

    public final void onLoadResource(WebView var1, String var2) {
        class_378.method_2460("Loading resource: " + var2);
        Uri var3 = Uri.parse(var2);
        if("gmsg".equalsIgnoreCase(var3.getScheme()) && "mobileads.google.com".equalsIgnoreCase(var3.getHost())) {
            this.method_2394(var3);
        }

    }

    public final void onPageFinished(WebView var1, String var2) {
        if(this.field_1334 != null) {
            this.field_1334.method_831(this.field_1328);
            this.field_1334 = null;
        }

    }

    public final void reset() {
        // $FF: Couldn't be decompiled
    }

    public final boolean shouldOverrideUrlLoading(WebView param1, String param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: y (boolean) void
    public final void method_2408(boolean var1) {
        this.field_1338 = var1;
    }

    public interface class_1738 {
        // $FF: renamed from: a (com.google.android.gms.internal.gv) void
        void method_831(class_381 var1);
    }
}
