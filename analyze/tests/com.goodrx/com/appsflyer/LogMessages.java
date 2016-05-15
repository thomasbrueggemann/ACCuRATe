package com.appsflyer;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public class LogMessages {
   private static String devKey;
   private static String replacedKey;

   public static void logMessageMaskKey(String var0) {
      if(devKey == null) {
         setDevKey(AppsFlyerProperties.getInstance().getString("AppsFlyerKey"));
      } else if(devKey != null && var0.contains(devKey)) {
         AFLogger.afLog(var0.replace(devKey, replacedKey));
         return;
      }

   }

   public static void setDevKey(String var0) {
      devKey = var0;
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         if(var2 != 0 && var2 != 1 && var2 <= -5 + var0.length()) {
            var1.append("*");
         } else {
            var1.append(var0.charAt(var2));
         }
      }

      replacedKey = var1.toString();
   }
}
