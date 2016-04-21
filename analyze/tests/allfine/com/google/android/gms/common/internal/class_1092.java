package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_870;

// $FF: renamed from: com.google.android.gms.common.internal.i
public final class class_1092 {
    // $FF: renamed from: Mf java.lang.String
    private final String field_5133;

    public class_1092(String var1) {
        this.field_5133 = (String)class_1090.method_5685(var1);
    }

    // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, java.lang.Throwable) void
    public void method_5690(Context var1, String var2, String var3, Throwable var4) {
        StackTraceElement[] var5 = var4.getStackTrace();
        StringBuilder var6 = new StringBuilder();

        for(int var7 = 0; var7 < var5.length && var7 < 2; ++var7) {
            var6.append(var5[var7].toString());
            var6.append("\n");
        }

        class_870 var8 = new class_870(var1, 10);
        String[] var9 = new String[] {"GMS_WTF", var6.toString()};
        var8.method_4530("GMS_WTF", (byte[])null, var9);
        var8.send();
        if(this.method_5692(7)) {
            Log.e(var2, var3, var4);
            Log.wtf(var2, var3, var4);
        }

    }

    // $FF: renamed from: a (java.lang.String, java.lang.String, java.lang.Throwable) void
    public void method_5691(String var1, String var2, Throwable var3) {
        if(this.method_5692(4)) {
            Log.i(var1, var2, var3);
        }

    }

    // $FF: renamed from: aC (int) boolean
    public boolean method_5692(int var1) {
        return Log.isLoggable(this.field_5133, var1);
    }

    // $FF: renamed from: b (java.lang.String, java.lang.String, java.lang.Throwable) void
    public void method_5693(String var1, String var2, Throwable var3) {
        if(this.method_5692(5)) {
            Log.w(var1, var2, var3);
        }

    }

    // $FF: renamed from: c (java.lang.String, java.lang.String, java.lang.Throwable) void
    public void method_5694(String var1, String var2, Throwable var3) {
        if(this.method_5692(6)) {
            Log.e(var1, var2, var3);
        }

    }

    // $FF: renamed from: n (java.lang.String, java.lang.String) void
    public void method_5695(String var1, String var2) {
        if(this.method_5692(3)) {
            Log.d(var1, var2);
        }

    }

    // $FF: renamed from: o (java.lang.String, java.lang.String) void
    public void method_5696(String var1, String var2) {
        if(this.method_5692(2)) {
            Log.v(var1, var2);
        }

    }

    // $FF: renamed from: p (java.lang.String, java.lang.String) void
    public void method_5697(String var1, String var2) {
        if(this.method_5692(5)) {
            Log.w(var1, var2);
        }

    }

    // $FF: renamed from: q (java.lang.String, java.lang.String) void
    public void method_5698(String var1, String var2) {
        if(this.method_5692(6)) {
            Log.e(var1, var2);
        }

    }
}
