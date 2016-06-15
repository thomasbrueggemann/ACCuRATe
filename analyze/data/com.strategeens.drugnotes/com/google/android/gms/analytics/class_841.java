package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.am;
import com.google.android.gms.analytics.class_171;
import com.google.android.gms.analytics.class_840;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_867;
import com.google.android.gms.analytics.n;

// $FF: renamed from: com.google.android.gms.analytics.al
class class_841 extends n<am> {
   public class_841(Context var1) {
      super(var1, new class_841.class_1319());
   }

   private static class class_1319 implements class_840.class_1318<am> {
      // $FF: renamed from: Cu com.google.android.gms.analytics.am
      private final class_867 field_4001 = new class_867();

      // $FF: renamed from: c (java.lang.String, int) void
      public void method_868(String var1, int var2) {
         if("ga_sessionTimeout".equals(var1)) {
            this.field_4001.field_3714 = var2;
         } else {
            class_863.method_4842("int configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: e (java.lang.String, java.lang.String) void
      public void method_869(String var1, String var2) {
         this.field_4001.field_3711.put(var1, var2);
      }

      // $FF: renamed from: e (java.lang.String, boolean) void
      public void method_870(String var1, boolean var2) {
         byte var3 = 1;
         if("ga_autoActivityTracking".equals(var1)) {
            class_867 var6 = this.field_4001;
            if(!var2) {
               var3 = 0;
            }

            var6.field_3715 = var3;
         } else if("ga_anonymizeIp".equals(var1)) {
            class_867 var5 = this.field_4001;
            if(!var2) {
               var3 = 0;
            }

            var5.field_3716 = var3;
         } else if("ga_reportUncaughtExceptions".equals(var1)) {
            class_867 var4 = this.field_4001;
            if(!var2) {
               var3 = 0;
            }

            var4.field_3710 = var3;
         } else {
            class_863.method_4842("bool configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: er () com.google.android.gms.analytics.m
      // $FF: synthetic method
      public class_171 method_871() {
         return this.method_5298();
      }

      // $FF: renamed from: f (java.lang.String, java.lang.String) void
      public void method_872(String var1, String var2) {
         if("ga_trackingId".equals(var1)) {
            this.field_4001.field_3712 = var2;
         } else if("ga_sampleFrequency".equals(var1)) {
            try {
               this.field_4001.field_3713 = Double.parseDouble(var2);
            } catch (NumberFormatException var4) {
               class_863.method_4839("Error parsing ga_sampleFrequency value: " + var2);
            }
         } else {
            class_863.method_4842("string configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: fs () com.google.android.gms.analytics.am
      public class_867 method_5298() {
         return this.field_4001;
      }
   }
}
