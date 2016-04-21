package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ai;
import com.google.android.gms.analytics.class_176;
import com.google.android.gms.analytics.class_923;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_954;
import com.google.android.gms.analytics.j;

// $FF: renamed from: com.google.android.gms.analytics.ah
class class_924 extends j<ai> {
    public class_924(Context var1) {
        super(var1, new class_924.class_1312());
    }

    private static class class_1312 implements class_923.class_1618<ai> {
        // $FF: renamed from: BB com.google.android.gms.analytics.ai
        private final class_954 field_2212 = new class_954();

        // $FF: renamed from: c (java.lang.String, int) void
        public void method_1047(String var1, int var2) {
            if("ga_sessionTimeout".equals(var1)) {
                this.field_2212.field_4472 = var2;
            } else {
                class_938.method_4861("int configuration name not recognized:  " + var1);
            }
        }

        // $FF: renamed from: d (java.lang.String, boolean) void
        public void method_1048(String var1, boolean var2) {
            byte var3 = 1;
            if("ga_autoActivityTracking".equals(var1)) {
                class_954 var6 = this.field_2212;
                if(!var2) {
                    var3 = 0;
                }

                var6.field_4473 = var3;
            } else if("ga_anonymizeIp".equals(var1)) {
                class_954 var5 = this.field_2212;
                if(!var2) {
                    var3 = 0;
                }

                var5.field_4474 = var3;
            } else if("ga_reportUncaughtExceptions".equals(var1)) {
                class_954 var4 = this.field_2212;
                if(!var2) {
                    var3 = 0;
                }

                var4.field_4475 = var3;
            } else {
                class_938.method_4861("bool configuration name not recognized:  " + var1);
            }
        }

        // $FF: renamed from: dW () com.google.android.gms.analytics.i
        // $FF: synthetic method
        public class_176 method_1049() {
            return this.method_3151();
        }

        // $FF: renamed from: eY () com.google.android.gms.analytics.ai
        public class_954 method_3151() {
            return this.field_2212;
        }

        // $FF: renamed from: f (java.lang.String, java.lang.String) void
        public void method_1050(String var1, String var2) {
            this.field_2212.field_4476.put(var1, var2);
        }

        // $FF: renamed from: g (java.lang.String, java.lang.String) void
        public void method_1051(String var1, String var2) {
            if("ga_trackingId".equals(var1)) {
                this.field_2212.field_4470 = var2;
            } else if("ga_sampleFrequency".equals(var1)) {
                try {
                    this.field_2212.field_4471 = Double.parseDouble(var2);
                } catch (NumberFormatException var4) {
                    class_938.method_4858("Error parsing ga_sampleFrequency value: " + var2);
                }
            } else {
                class_938.method_4861("string configuration name not recognized:  " + var1);
            }
        }
    }
}
