package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.DefaultLogger;
import com.google.tagmanager.Logger;
import com.google.tagmanager.NoOpLogger;

final class Log {
    @VisibleForTesting
    static Logger sLogger = new DefaultLogger();

    // $FF: renamed from: d (java.lang.String) void
    public static void method_5501(String var0) {
        sLogger.method_67(var0);
    }

    // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
    public static void method_5502(String var0, Throwable var1) {
        sLogger.method_68(var0, var1);
    }

    // $FF: renamed from: e (java.lang.String) void
    public static void method_5503(String var0) {
        sLogger.method_69(var0);
    }

    // $FF: renamed from: e (java.lang.String, java.lang.Throwable) void
    public static void method_5504(String var0, Throwable var1) {
        sLogger.method_70(var0, var1);
    }

    public static Logger.LogLevel getLogLevel() {
        return sLogger.getLogLevel();
    }

    public static Logger getLogger() {
        return sLogger.getClass() == NoOpLogger.class?null:sLogger;
    }

    // $FF: renamed from: i (java.lang.String) void
    public static void method_5505(String var0) {
        sLogger.method_71(var0);
    }

    // $FF: renamed from: i (java.lang.String, java.lang.Throwable) void
    public static void method_5506(String var0, Throwable var1) {
        sLogger.method_72(var0, var1);
    }

    public static void setLogger(Logger var0) {
        if(var0 == null) {
            sLogger = new NoOpLogger();
        } else {
            sLogger = var0;
        }
    }

    // $FF: renamed from: v (java.lang.String) void
    public static void method_5507(String var0) {
        sLogger.method_73(var0);
    }

    // $FF: renamed from: v (java.lang.String, java.lang.Throwable) void
    public static void method_5508(String var0, Throwable var1) {
        sLogger.method_74(var0, var1);
    }

    // $FF: renamed from: w (java.lang.String) void
    public static void method_5509(String var0) {
        sLogger.method_75(var0);
    }

    // $FF: renamed from: w (java.lang.String, java.lang.Throwable) void
    public static void method_5510(String var0, Throwable var1) {
        sLogger.method_76(var0, var1);
    }
}
