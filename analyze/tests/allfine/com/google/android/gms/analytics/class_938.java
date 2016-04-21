package com.google.android.gms.analytics;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;

// $FF: renamed from: com.google.android.gms.analytics.z
public class class_938 {
    // $FF: renamed from: AT com.google.android.gms.analytics.GoogleAnalytics
    private static GoogleAnalytics field_4294;

    // $FF: renamed from: T (java.lang.String) void
    public static void method_4858(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.error(var0);
        }

    }

    // $FF: renamed from: U (java.lang.String) void
    public static void method_4859(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.info(var0);
        }

    }

    // $FF: renamed from: V (java.lang.String) void
    public static void method_4860(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.verbose(var0);
        }

    }

    // $FF: renamed from: W (java.lang.String) void
    public static void method_4861(String var0) {
        Logger var1 = getLogger();
        if(var1 != null) {
            var1.warn(var0);
        }

    }

    // $FF: renamed from: eK () boolean
    public static boolean method_4862() {
        Logger var0 = getLogger();
        boolean var1 = false;
        if(var0 != null) {
            int var2 = getLogger().getLogLevel();
            var1 = false;
            if(var2 == 0) {
                var1 = true;
            }
        }

        return var1;
    }

    private static Logger getLogger() {
        if(field_4294 == null) {
            field_4294 = GoogleAnalytics.method_3058();
        }

        return field_4294 != null?field_4294.getLogger():null;
    }
}
