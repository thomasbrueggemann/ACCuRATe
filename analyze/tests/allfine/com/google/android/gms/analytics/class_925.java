package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_176;
import com.google.android.gms.analytics.class_923;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_942;
import com.google.android.gms.analytics.j;
import com.google.android.gms.analytics.v;

// $FF: renamed from: com.google.android.gms.analytics.u
class class_925 extends j<v> {
    public class_925(Context var1) {
        super(var1, new class_925.class_1619());
    }

    private static class class_1619 implements class_923.class_1618<v> {
        // $FF: renamed from: Ar com.google.android.gms.analytics.v
        private final class_942 field_4668 = new class_942();

        // $FF: renamed from: c (java.lang.String, int) void
        public void method_1047(String var1, int var2) {
            if("ga_dispatchPeriod".equals(var1)) {
                this.field_4668.field_4312 = var2;
            } else {
                class_938.method_4861("int configuration name not recognized:  " + var1);
            }
        }

        // $FF: renamed from: d (java.lang.String, boolean) void
        public void method_1048(String var1, boolean var2) {
            if("ga_dryRun".equals(var1)) {
                class_942 var3 = this.field_4668;
                byte var4;
                if(var2) {
                    var4 = 1;
                } else {
                    var4 = 0;
                }

                var3.field_4313 = var4;
            } else {
                class_938.method_4861("bool configuration name not recognized:  " + var1);
            }
        }

        // $FF: renamed from: dW () com.google.android.gms.analytics.i
        // $FF: synthetic method
        public class_176 method_1049() {
            return this.method_5274();
        }

        // $FF: renamed from: es () com.google.android.gms.analytics.v
        public class_942 method_5274() {
            return this.field_4668;
        }

        // $FF: renamed from: f (java.lang.String, java.lang.String) void
        public void method_1050(String var1, String var2) {
        }

        // $FF: renamed from: g (java.lang.String, java.lang.String) void
        public void method_1051(String var1, String var2) {
            if("ga_appName".equals(var1)) {
                this.field_4668.field_4314 = var2;
            } else if("ga_appVersion".equals(var1)) {
                this.field_4668.field_4315 = var2;
            } else if("ga_logLevel".equals(var1)) {
                this.field_4668.field_4311 = var2;
            } else {
                class_938.method_4861("string configuration name not recognized:  " + var1);
            }
        }
    }
}
