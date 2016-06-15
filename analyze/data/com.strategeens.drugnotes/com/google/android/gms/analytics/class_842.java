package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.aa;
import com.google.android.gms.analytics.class_171;
import com.google.android.gms.analytics.class_840;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_866;
import com.google.android.gms.analytics.n;

// $FF: renamed from: com.google.android.gms.analytics.z
class class_842 extends n<aa> {
   public class_842(Context var1) {
      super(var1, new class_842.class_1320());
   }

   private static class class_1320 implements class_840.class_1318<aa> {
      // $FF: renamed from: Bi com.google.android.gms.analytics.aa
      private final class_866 field_3218 = new class_866();

      // $FF: renamed from: c (java.lang.String, int) void
      public void method_868(String var1, int var2) {
         if("ga_dispatchPeriod".equals(var1)) {
            this.field_3218.field_3706 = var2;
         } else {
            class_863.method_4842("int configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: e (java.lang.String, java.lang.String) void
      public void method_869(String var1, String var2) {
      }

      // $FF: renamed from: e (java.lang.String, boolean) void
      public void method_870(String var1, boolean var2) {
         if("ga_dryRun".equals(var1)) {
            class_866 var3 = this.field_3218;
            byte var4;
            if(var2) {
               var4 = 1;
            } else {
               var4 = 0;
            }

            var3.field_3707 = var4;
         } else {
            class_863.method_4842("bool configuration name not recognized:  " + var1);
         }
      }

      // $FF: renamed from: eN () com.google.android.gms.analytics.aa
      public class_866 method_4139() {
         return this.field_3218;
      }

      // $FF: renamed from: er () com.google.android.gms.analytics.m
      // $FF: synthetic method
      public class_171 method_871() {
         return this.method_4139();
      }

      // $FF: renamed from: f (java.lang.String, java.lang.String) void
      public void method_872(String var1, String var2) {
         if("ga_appName".equals(var1)) {
            this.field_3218.field_3708 = var2;
         } else if("ga_appVersion".equals(var1)) {
            this.field_3218.field_3709 = var2;
         } else if("ga_logLevel".equals(var1)) {
            this.field_3218.field_3705 = var2;
         } else {
            class_863.method_4842("string configuration name not recognized:  " + var1);
         }
      }
   }
}
