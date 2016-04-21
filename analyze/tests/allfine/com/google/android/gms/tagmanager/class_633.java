package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.class_612;

// $FF: renamed from: com.google.android.gms.tagmanager.df
class class_633 {
    private GoogleAnalytics arQ;
    private Context mContext;
    // $FF: renamed from: xY com.google.android.gms.analytics.Tracker
    private Tracker field_3156;

    class_633(Context var1) {
        this.mContext = var1;
    }

    // $FF: renamed from: cV (java.lang.String) void
    private void method_3536(String var1) {
        synchronized(this) {}

        try {
            if(this.arQ == null) {
                this.arQ = GoogleAnalytics.getInstance(this.mContext);
                this.arQ.setLogger(new class_633.class_1381());
                this.field_3156 = this.arQ.newTracker(var1);
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: cU (java.lang.String) com.google.android.gms.analytics.Tracker
    public Tracker method_3537(String var1) {
        this.method_3536(var1);
        return this.field_3156;
    }

    static class class_1381 implements Logger {
        // $FF: renamed from: fn (int) int
        private static int method_3376(int var0) {
            switch(var0) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                default:
                    return 3;
            }
        }

        public void error(Exception var1) {
            class_612.method_3460("", var1);
        }

        public void error(String var1) {
            class_612.method_3456(var1);
        }

        public int getLogLevel() {
            return method_3376(class_612.getLogLevel());
        }

        public void info(String var1) {
            class_612.method_3457(var1);
        }

        public void setLogLevel(int var1) {
            class_612.method_3459("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String var1) {
            class_612.method_3458(var1);
        }

        public void warn(String var1) {
            class_612.method_3459(var1);
        }
    }
}
