package com.google.android.gms.analytics;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;

// $FF: renamed from: com.google.android.gms.analytics.aa
public class class_669 {
   // $FF: renamed from: wH com.google.android.gms.analytics.GoogleAnalytics
   private static GoogleAnalytics field_3583;

   // $FF: renamed from: A (java.lang.String) void
   public static void method_3888(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.error(var0);
      }

   }

   // $FF: renamed from: B (java.lang.String) void
   public static void method_3889(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.info(var0);
      }

   }

   // $FF: renamed from: C (java.lang.String) void
   public static void method_3890(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.verbose(var0);
      }

   }

   // $FF: renamed from: D (java.lang.String) void
   public static void method_3891(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.warn(var0);
      }

   }

   // $FF: renamed from: dk () boolean
   public static boolean method_3892() {
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
      if(field_3583 == null) {
         field_3583 = GoogleAnalytics.method_2715();
      }

      return field_3583 != null?field_3583.getLogger():null;
   }
}
