package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.class_378;
import com.google.android.gms.internal.class_379;
import com.google.android.gms.internal.class_383;
import com.google.android.gms.internal.class_389;
import com.google.android.gms.internal.ez;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;

// $FF: renamed from: com.google.android.gms.internal.ey
@ez
public class class_420 implements UncaughtExceptionHandler {
    private Context mContext;
    // $FF: renamed from: sR java.lang.Thread.UncaughtExceptionHandler
    private UncaughtExceptionHandler field_1549;
    // $FF: renamed from: sS java.lang.Thread.UncaughtExceptionHandler
    private UncaughtExceptionHandler field_1550;
    // $FF: renamed from: sT com.google.android.gms.internal.gt
    private class_379 field_1551;

    public class_420(Context var1, class_379 var2, UncaughtExceptionHandler var3, UncaughtExceptionHandler var4) {
        this.field_1549 = var3;
        this.field_1550 = var4;
        this.mContext = var1;
        this.field_1551 = var2;
    }

    // $FF: renamed from: a (android.content.Context, java.lang.Thread, com.google.android.gms.internal.gt) com.google.android.gms.internal.ey
    public static class_420 method_2670(Context var0, Thread var1, class_379 var2) {
        if(var0 != null && var1 != null && var2 != null) {
            class_389.method_2553();
            if(!method_2673(var0)) {
                return null;
            } else {
                UncaughtExceptionHandler var4 = var1.getUncaughtExceptionHandler();
                class_420 var5 = new class_420(var0, var2, var4, Thread.getDefaultUncaughtExceptionHandler());
                if(var4 != null && var4 instanceof class_420) {
                    return (class_420)var4;
                } else {
                    try {
                        var1.setUncaughtExceptionHandler(var5);
                        return var5;
                    } catch (SecurityException var7) {
                        class_378.method_2464("Fail to set UncaughtExceptionHandler.", var7);
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
    }

    // $FF: renamed from: cw () java.lang.String
    private String method_2671() {
        String var1 = Build.MANUFACTURER;
        String var2 = Build.MODEL;
        return var2.startsWith(var1)?var2:var1 + " " + var2;
    }

    // $FF: renamed from: d (java.lang.Throwable) java.lang.Throwable
    private Throwable method_2672(Throwable var1) {
        Bundle var2 = class_389.method_2553();
        if(var2 != null && var2.getBoolean("gads:sdk_crash_report_full_stacktrace", false)) {
            return var1;
        } else {
            LinkedList var3;
            for(var3 = new LinkedList(); var1 != null; var1 = var1.getCause()) {
                var3.push(var1);
            }

            Throwable var4;
            Throwable var12;
            for(var4 = null; !var3.isEmpty(); var4 = var12) {
                Throwable var5 = (Throwable)var3.pop();
                StackTraceElement[] var6 = var5.getStackTrace();
                ArrayList var7 = new ArrayList();
                var7.add(new StackTraceElement(var5.getClass().getName(), "<filtered>", "<filtered>", 1));
                int var9 = var6.length;
                int var10 = 0;

                boolean var11;
                for(var11 = false; var10 < var9; ++var10) {
                    StackTraceElement var13 = var6[var10];
                    if(this.method_2674(var13.getClassName())) {
                        var7.add(var13);
                        var11 = true;
                    } else if(this.method_2675(var13.getClassName())) {
                        var7.add(var13);
                    } else {
                        var7.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                    }
                }

                if(var11) {
                    if(var4 == null) {
                        var12 = new Throwable(var5.getMessage());
                    } else {
                        var12 = new Throwable(var5.getMessage(), var4);
                    }

                    var12.setStackTrace((StackTraceElement[])var7.toArray(new StackTraceElement[0]));
                } else {
                    var12 = var4;
                }
            }

            return var4;
        }
    }

    // $FF: renamed from: k (android.content.Context) boolean
    private static boolean method_2673(Context var0) {
        Bundle var1 = class_389.method_2553();
        return var1 != null && var1.getBoolean("gads:sdk_crash_report_enabled", false);
    }

    // $FF: renamed from: G (java.lang.String) boolean
    protected boolean method_2674(String var1) {
        if(TextUtils.isEmpty(var1)) {
            return false;
        } else if(var1.startsWith("com.google.android.gms.ads")) {
            return true;
        } else if(var1.startsWith("com.google.ads")) {
            return true;
        } else {
            try {
                boolean var3 = Class.forName(var1).isAnnotationPresent(ez.class);
                return var3;
            } catch (Exception var4) {
                class_378.method_2462("Fail to check class type for class " + var1, var4);
                return false;
            }
        }
    }

    // $FF: renamed from: H (java.lang.String) boolean
    protected boolean method_2675(String var1) {
        return !TextUtils.isEmpty(var1) && (var1.startsWith("android.") || var1.startsWith("java."));
    }

    // $FF: renamed from: a (java.lang.Throwable) boolean
    protected boolean method_2676(Throwable var1) {
        boolean var2 = true;
        if(var1 == null) {
            return false;
        } else {
            boolean var3 = false;

            boolean var4;
            for(var4 = false; var1 != null; var1 = var1.getCause()) {
                StackTraceElement[] var5 = var1.getStackTrace();
                int var6 = var5.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    StackTraceElement var8 = var5[var7];
                    if(this.method_2674(var8.getClassName())) {
                        var4 = var2;
                    }

                    if(this.getClass().getName().equals(var8.getClassName())) {
                        var3 = var2;
                    }
                }
            }

            if(!var4 || var3) {
                var2 = false;
            }

            return var2;
        }
    }

    // $FF: renamed from: b (java.lang.Throwable) void
    public void method_2677(Throwable var1) {
        if(method_2673(this.mContext)) {
            Throwable var2 = this.method_2672(var1);
            if(var2 != null) {
                ArrayList var3 = new ArrayList();
                var3.add(this.method_2678(var2));
                class_383.method_2509(this.mContext, this.field_1551.field_1387, var3, class_389.method_2560());
                return;
            }
        }

    }

    // $FF: renamed from: c (java.lang.Throwable) java.lang.String
    protected String method_2678(Throwable var1) {
        StringWriter var2 = new StringWriter();
        var1.printStackTrace(new PrintWriter(var2));
        return (new Builder()).scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", this.method_2671()).appendQueryParameter("js", this.field_1551.field_1387).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", var2.toString()).toString();
    }

    public void uncaughtException(Thread var1, Throwable var2) {
        if(this.method_2676(var2)) {
            this.method_2677(var2);
            if(Looper.getMainLooper().getThread() != var1) {
                return;
            }
        }

        if(this.field_1549 != null) {
            this.field_1549.uncaughtException(var1, var2);
        } else if(this.field_1550 != null) {
            this.field_1550.uncaughtException(var1, var2);
        }
    }
}
