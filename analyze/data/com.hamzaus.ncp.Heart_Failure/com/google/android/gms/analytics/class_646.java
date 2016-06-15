package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.class_137;
import com.google.android.gms.analytics.class_644;
import com.google.android.gms.analytics.class_655;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.k;
import com.google.android.gms.analytics.w;

// $FF: renamed from: com.google.android.gms.analytics.v
class class_646 extends k<w> {
   public class_646(Context var1) {
      super(var1, new class_646.class_1269());
   }

   private static class class_1269 implements class_644.class_1322<w> {
      // $FF: renamed from: wf com.google.android.gms.analytics.w
      private final class_655 field_3508 = new class_655();

      // $FF: renamed from: a (java.lang.String, int) void
      public void method_766(String var1, int var2) {
         if("ga_dispatchPeriod".equals(var1)) {
            this.field_3508.field_3428 = var2;
         } else {
            class_669.method_3891("int configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: c (java.lang.String, java.lang.String) void
      public void method_767(String var1, String var2) {
      }

      // $FF: renamed from: c (java.lang.String, boolean) void
      public void method_768(String var1, boolean var2) {
         if("ga_dryRun".equals(var1)) {
            class_655 var3 = this.field_3508;
            byte var4;
            if(var2) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var3.field_3429 = var4;
         } else {
            class_669.method_3891("bool configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: cS () com.google.android.gms.analytics.w
      public class_655 method_3852() {
         return this.field_3508;
      }

      // $FF: renamed from: cw () com.google.android.gms.analytics.j
      // $FF: synthetic method
      public class_137 method_769() {
         return this.method_3852();
      }

      // $FF: renamed from: d (java.lang.String, java.lang.String) void
      public void method_770(String var1, String var2) {
         if("ga_appName".equals(var1)) {
            this.field_3508.field_3426 = var2;
         } else if("ga_appVersion".equals(var1)) {
            this.field_3508.field_3425 = var2;
         } else if("ga_logLevel".equals(var1)) {
            this.field_3508.field_3427 = var2;
         } else {
            class_669.method_3891("string configuration name not recognized:  " + var1);
         }
      }
   }
}
