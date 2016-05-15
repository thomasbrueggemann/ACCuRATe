package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

public final class Connectivity {
   private static final String ANDROID = "Android";
   private static AgentLog log = AgentLogManager.getAgentLog();

   public static String carrierNameFromContext(Context var0) {
      NetworkInfo var2;
      try {
         var2 = getNetworkInfo(var0);
      } catch (SecurityException var5) {
         return "unknown";
      }

      if(!isConnected(var2)) {
         return "none";
      } else if(isWan(var2)) {
         return carrierNameFromTelephonyManager(var0);
      } else if(isWifi(var2)) {
         return "wifi";
      } else {
         AgentLog var3 = log;
         Object[] var4 = new Object[]{var2.getTypeName(), Integer.valueOf(var2.getType())};
         var3.warning(MessageFormat.format("Unknown network type: {0} [{1}]", var4));
         return "unknown";
      }
   }

   private static String carrierNameFromTelephonyManager(Context var0) {
      String var1 = ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperatorName();
      boolean var2;
      if(!Build.PRODUCT.equals("google_sdk") && !Build.PRODUCT.equals("sdk") && !Build.PRODUCT.equals("sdk_x86") && !Build.FINGERPRINT.startsWith("generic")) {
         var2 = false;
      } else {
         var2 = true;
      }

      if(var1.equals("Android") && var2) {
         var1 = "wifi";
      }

      return var1;
   }

   private static String connectionNameFromNetworkSubtype(int var0) {
      switch(var0) {
      case 1:
         return "GPRS";
      case 2:
         return "EDGE";
      case 3:
         return "UMTS";
      case 4:
         return "CDMA";
      case 5:
         return "EVDO rev 0";
      case 6:
         return "EVDO rev A";
      case 7:
         return "1xRTT";
      case 8:
         return "HSDPA";
      case 9:
         return "HSUPA";
      case 10:
         return "HSPA";
      case 11:
         return "IDEN";
      case 12:
         return "EVDO rev B";
      case 13:
         return "LTE";
      case 14:
         return "HRPD";
      case 15:
         return "HSPAP";
      default:
         return "unknown";
      }
   }

   private static NetworkInfo getNetworkInfo(Context var0) throws SecurityException {
      ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");

      try {
         NetworkInfo var3 = var1.getActiveNetworkInfo();
         return var3;
      } catch (SecurityException var4) {
         log.warning("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
         throw var4;
      }
   }

   private static boolean isConnected(NetworkInfo var0) {
      return var0 != null && var0.isConnected();
   }

   private static boolean isWan(NetworkInfo var0) {
      switch(var0.getType()) {
      case 0:
      case 2:
      case 3:
      case 4:
      case 5:
         return true;
      case 1:
      default:
         return false;
      }
   }

   private static boolean isWifi(NetworkInfo var0) {
      switch(var0.getType()) {
      case 1:
      case 6:
      case 7:
      case 9:
         return true;
      case 2:
      case 3:
      case 4:
      case 5:
      case 8:
      default:
         return false;
      }
   }

   public static String wanType(Context var0) {
      NetworkInfo var2;
      try {
         var2 = getNetworkInfo(var0);
      } catch (SecurityException var3) {
         return "unknown";
      }

      return !isConnected(var2)?"none":(isWifi(var2)?"wifi":(isWan(var2)?connectionNameFromNetworkSubtype(var2.getSubtype()):"unknown"));
   }
}
