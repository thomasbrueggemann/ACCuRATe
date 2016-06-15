package com.google.android.gms.analytics;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;

// $FF: renamed from: com.google.android.gms.analytics.ae
public class class_863 {
   // $FF: renamed from: BL com.google.android.gms.analytics.GoogleAnalytics
   private static GoogleAnalytics field_3696;
   // $FF: renamed from: BM boolean
   private static volatile boolean field_3697 = false;
   // $FF: renamed from: BN com.google.android.gms.analytics.Logger
   private static Logger field_3698;

   // $FF: renamed from: T (java.lang.String) void
   public static void method_4839(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.error(var0);
      }

   }

   // $FF: renamed from: U (java.lang.String) void
   public static void method_4840(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.info(var0);
      }

   }

   // $FF: renamed from: V (java.lang.String) void
   public static void method_4841(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.verbose(var0);
      }

   }

   // $FF: renamed from: W (java.lang.String) void
   public static void method_4842(String var0) {
      Logger var1 = getLogger();
      if(var1 != null) {
         var1.warn(var0);
      }

   }

   // $FF: renamed from: ff () boolean
   public static boolean method_4843() {
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

   static Logger getLogger() {
      // $FF: Couldn't be decompiled
   }
}
