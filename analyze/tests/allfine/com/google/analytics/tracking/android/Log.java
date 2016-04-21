package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger;
import com.google.android.gms.common.util.VisibleForTesting;

public class Log {
    private static GoogleAnalytics sGaInstance;

    @VisibleForTesting
    static void clearGaInstance() {
        sGaInstance = null;
    }

    // $FF: renamed from: e (java.lang.Exception) void
    public static void method_2103(Exception var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.error(var0);
        }

    }

    // $FF: renamed from: e (java.lang.String) void
    public static void method_2104(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.error(var0);
        }

    }

    private static Logger getLogger() {
        if(sGaInstance == null) {
            sGaInstance = GoogleAnalytics.getInstance();
        }

        return sGaInstance != null?sGaInstance.getLogger():null;
    }

    // $FF: renamed from: i (java.lang.String) void
    public static void method_2105(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.info(var0);
        }

    }

    public static boolean isVerbose() {
        return getLogger() != null?Logger.LogLevel.VERBOSE.equals(getLogger().getLogLevel()):false;
    }

    // $FF: renamed from: v (java.lang.String) void
    public static void method_2106(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.verbose(var0);
        }

    }

    // $FF: renamed from: w (java.lang.String) void
    public static void method_2107(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.warn(var0);
        }

    }
}
