package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.aj;
import com.google.android.gms.analytics.class_137;
import com.google.android.gms.analytics.class_644;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_670;
import com.google.android.gms.analytics.k;

// $FF: renamed from: com.google.android.gms.analytics.ai
class class_645 extends k<aj> {
   public class_645(Context var1) {
      super(var1, new class_645.class_1204());
   }

   private static class class_1204 implements class_644.class_1322<aj> {
      // $FF: renamed from: xt com.google.android.gms.analytics.aj
      private final class_670 field_3262 = new class_670();

      // $FF: renamed from: a (java.lang.String, int) void
      public void method_766(String var1, int var2) {
         if("ga_sessionTimeout".equals(var1)) {
            this.field_3262.field_3587 = var2;
         } else {
            class_669.method_3891("int configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: c (java.lang.String, java.lang.String) void
      public void method_767(String var1, String var2) {
         this.field_3262.field_3584.put(var1, var2);
      }

      // $FF: renamed from: c (java.lang.String, boolean) void
      public void method_768(String var1, boolean var2) {
         byte var3 = 1;
         if("ga_autoActivityTracking".equals(var1)) {
            class_670 var6 = this.field_3262;
            if(!var2) {
               var3 = 0;
            }

            var6.field_3588 = var3;
         } else if("ga_anonymizeIp".equals(var1)) {
            class_670 var5 = this.field_3262;
            if(!var2) {
               var3 = 0;
            }

            var5.field_3589 = var3;
         } else if("ga_reportUncaughtExceptions".equals(var1)) {
            class_670 var4 = this.field_3262;
            if(!var2) {
               var3 = 0;
            }

            var4.field_3590 = var3;
         } else {
            class_669.method_3891("bool configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: cw () com.google.android.gms.analytics.j
      // $FF: synthetic method
      public class_137 method_769() {
         return this.method_3456();
      }

      // $FF: renamed from: d (java.lang.String, java.lang.String) void
      public void method_770(String var1, String var2) {
         if("ga_trackingId".equals(var1)) {
            this.field_3262.field_3585 = var2;
         } else if("ga_sampleFrequency".equals(var1)) {
            try {
               this.field_3262.field_3586 = Double.parseDouble(var2);
            } catch (NumberFormatException var4) {
               class_669.method_3888("Error parsing ga_sampleFrequency value: " + var2);
            }
         } else {
            class_669.method_3891("string configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: dy () com.google.android.gms.analytics.aj
      public class_670 method_3456() {
         return this.field_3262;
      }
   }
}
