package com.appsflyer;

import android.util.Log;
import com.appsflyer.AppsFlyerProperties;

public class AFLogger {
   public static void afDebugLog(String var0) {
      if(shouldLog()) {
         Log.d("AppsFlyer_4.3.2", var0);
      }

   }

   public static void afLog(String var0) {
      if(shouldLog()) {
         Log.i("AppsFlyer_4.3.2", var0);
      }

   }

   public static void afLogE(String var0, Throwable var1) {
      if(shouldLog()) {
         Log.e("AppsFlyer_4.3.2", var0, var1);
      }

   }

   public static void afWarnLog(String var0) {
      if(shouldLog()) {
         Log.w("AppsFlyer_4.3.2", var0);
      }

   }

   private static boolean shouldLog() {
      return AppsFlyerProperties.getInstance().isEnableLog();
   }
}
