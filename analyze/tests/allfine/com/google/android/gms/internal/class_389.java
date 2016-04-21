package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_21;
import com.google.android.gms.internal.class_230;
import com.google.android.gms.internal.class_231;
import com.google.android.gms.internal.class_233;
import com.google.android.gms.internal.class_245;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_390;
import com.google.android.gms.internal.class_391;
import com.google.android.gms.internal.class_393;
import com.google.android.gms.internal.class_420;
import com.google.android.gms.internal.class_466;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.ge;
import java.lang.Thread.UncaughtExceptionHandler;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.gb
@ez
public class class_389 implements class_466.class_1659 {
    // $FF: renamed from: vJ com.google.android.gms.internal.gb
    private static final class_389 field_1420 = new class_389();
    // $FF: renamed from: vK java.lang.String
    public static final String field_1421;
    private Context mContext;
    // $FF: renamed from: mw java.lang.Object
    private final Object field_1422 = new Object();
    // $FF: renamed from: nu com.google.android.gms.internal.am
    private class_230 field_1423;
    // $FF: renamed from: nv com.google.android.gms.internal.al
    private class_233 field_1424;
    // $FF: renamed from: nw com.google.android.gms.internal.ey
    private class_420 field_1425;
    // $FF: renamed from: qs com.google.android.gms.internal.gt
    private class_379 field_1426;
    // $FF: renamed from: uH boolean
    private boolean field_1427;
    // $FF: renamed from: uI boolean
    private boolean field_1428;
    // $FF: renamed from: vL java.lang.String
    public final String field_1429;
    // $FF: renamed from: vM com.google.android.gms.internal.gc
    private final class_391 field_1430;
    // $FF: renamed from: vN java.math.BigInteger
    private BigInteger field_1431;
    // $FF: renamed from: vO java.util.HashSet
    private final HashSet<ga> field_1432;
    // $FF: renamed from: vP java.util.HashMap
    private final HashMap<String, ge> field_1433;
    // $FF: renamed from: vQ boolean
    private boolean field_1434;
    // $FF: renamed from: vR boolean
    private boolean field_1435;
    // $FF: renamed from: vS com.google.android.gms.internal.an
    private class_231 field_1436;
    // $FF: renamed from: vT java.util.LinkedList
    private LinkedList<Thread> field_1437;
    // $FF: renamed from: vU boolean
    private boolean field_1438;
    // $FF: renamed from: vV android.os.Bundle
    private Bundle field_1439;
    // $FF: renamed from: vW java.lang.String
    private String field_1440;

    static {
        field_1421 = field_1420.field_1429;
    }

    private class_389() {
        this.field_1431 = BigInteger.ONE;
        this.field_1432 = new HashSet();
        this.field_1433 = new HashMap();
        this.field_1434 = false;
        this.field_1427 = true;
        this.field_1435 = false;
        this.field_1428 = true;
        this.field_1423 = null;
        this.field_1436 = null;
        this.field_1424 = null;
        this.field_1437 = new LinkedList();
        this.field_1438 = false;
        this.field_1439 = class_245.method_1600();
        this.field_1425 = null;
        this.field_1429 = class_383.method_2527();
        this.field_1430 = new class_391(this.field_1429);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gd, java.lang.String) android.os.Bundle
    public static Bundle method_2549(Context var0, class_21 var1, String var2) {
        return field_1420.method_2565(var0, var1, var2);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.gt) void
    public static void method_2550(Context var0, class_379 var1) {
        field_1420.method_2566(var0, var1);
    }

    // $FF: renamed from: a (android.content.Context, boolean) void
    public static void method_2551(Context var0, boolean var1) {
        field_1420.method_2567(var0, var1);
    }

    // $FF: renamed from: b (java.util.HashSet) void
    public static void method_2552(HashSet<ga> var0) {
        field_1420.method_2568(var0);
    }

    // $FF: renamed from: bD () android.os.Bundle
    public static Bundle method_2553() {
        return field_1420.method_2576();
    }

    // $FF: renamed from: c (int, java.lang.String) java.lang.String
    public static String method_2554(int var0, String var1) {
        return field_1420.method_2572(var0, var1);
    }

    // $FF: renamed from: cU () com.google.android.gms.internal.gb
    public static class_389 method_2555() {
        return field_1420;
    }

    // $FF: renamed from: cW () java.lang.String
    public static String method_2556() {
        return field_1420.method_2570();
    }

    // $FF: renamed from: cY () com.google.android.gms.internal.gc
    public static class_391 method_2557() {
        return field_1420.method_2571();
    }

    // $FF: renamed from: da () boolean
    public static boolean method_2558() {
        return field_1420.method_2573();
    }

    // $FF: renamed from: dc () boolean
    public static boolean method_2559() {
        return field_1420.method_2574();
    }

    // $FF: renamed from: de () java.lang.String
    public static String method_2560() {
        return field_1420.method_2575();
    }

    // $FF: renamed from: e (java.lang.Throwable) void
    public static void method_2561(Throwable var0) {
        field_1420.method_2577(var0);
    }

    // $FF: renamed from: a (android.os.Bundle) void
    public void method_1056(Bundle param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (com.google.android.gms.internal.ga) void
    public void method_2562(class_390 param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.ge) void
    public void method_2563(String param1, class_393 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (java.lang.Thread) void
    public void method_2564(Thread param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.gd, java.lang.String) android.os.Bundle
    public Bundle method_2565(Context param1, class_21 param2, String param3) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.gt) void
    public void method_2566(Context param1, class_379 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: b (android.content.Context, boolean) void
    public void method_2567(Context param1, boolean param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: c (java.util.HashSet) void
    public void method_2568(HashSet<ga> param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cV () boolean
    public boolean method_2569() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cX () java.lang.String
    public String method_2570() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: cZ () com.google.android.gms.internal.gc
    public class_391 method_2571() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: d (int, java.lang.String) java.lang.String
    public String method_2572(int var1, String var2) {
        Resources var3;
        if(this.field_1426.field_1390) {
            var3 = this.mContext.getResources();
        } else {
            var3 = GooglePlayServicesUtil.getRemoteResource(this.mContext);
        }

        return var3 == null?var2:var3.getString(var1);
    }

    // $FF: renamed from: db () boolean
    public boolean method_2573() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dd () boolean
    public boolean method_2574() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: df () java.lang.String
    public String method_2575() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dg () android.os.Bundle
    public Bundle method_2576() {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: f (java.lang.Throwable) void
    public void method_2577(Throwable var1) {
        if(this.field_1435) {
            (new class_420(this.mContext, this.field_1426, (UncaughtExceptionHandler)null, (UncaughtExceptionHandler)null)).method_2677(var1);
        }

    }

    // $FF: renamed from: l (android.content.Context) com.google.android.gms.internal.an
    public class_231 method_2578(Context param1) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: v (boolean) void
    public void method_2579(boolean param1) {
        // $FF: Couldn't be decompiled
    }
}
