package com.criteo.events;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.criteo.events.CRTOLog;
import com.criteo.events.EventService;
import java.lang.reflect.Method;
import java.util.Locale;

final class DeviceInfo {
   private static Boolean LATEnabled;
   private static String advertisingId;

   static String getAdvertisingId() {
      if(advertisingId == null || LATEnabled == null) {
         loadAdvertisingInfo();
      }

      return advertisingId;
   }

   static String getAndroidVersion() {
      return VERSION.RELEASE;
   }

   static String getAppVersion() {
      try {
         String var1 = EventService.context.getPackageManager().getPackageInfo(EventService.context.getPackageName(), 0).versionName;
         return var1;
      } catch (NameNotFoundException var2) {
         CRTOLog.method_474("Error getting AppVersion", var2);
         return "";
      }
   }

   static String getBundleName() {
      return EventService.context.getPackageName();
   }

   static String getCountry() {
      return Locale.getDefault().getCountry();
   }

   static String getLanguage() {
      return Locale.getDefault().getLanguage();
   }

   static boolean getLimitAdTrackingEnabled() {
      if(LATEnabled == null) {
         loadAdvertisingInfo();
      }

      return LATEnabled.booleanValue();
   }

   static String getManufacturer() {
      return Build.MANUFACTURER;
   }

   static String getModel() {
      return Build.MODEL;
   }

   static String getSDKVersion() {
      return "1.0";
   }

   private static void loadAdvertisingInfo() {
      try {
         Class var1 = Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
         Method var2 = var1.getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class});
         Object[] var3 = new Object[]{EventService.context};
         if(((Integer)var2.invoke(var1, var3)).intValue() == 0) {
            if(EventService.context.getPackageManager().getApplicationInfo(EventService.context.getPackageName(), 128).metaData.getInt("com.google.android.gms.version") == 0) {
               CRTOLog.method_473("You must include and then set the com.google.android.gms.version value in the AndroidManifest.xml file in order to use the GAID");
            } else {
               Class var4 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
               Method var5 = var4.getDeclaredMethod("getAdvertisingIdInfo", new Class[]{Context.class});
               Object[] var6 = new Object[]{EventService.context};
               Object var7 = var5.invoke(var4, var6);
               advertisingId = reflectedGetAdvertisingId(var7, (String)null);
               LATEnabled = Boolean.valueOf(reflectedIsLimitAdTrackingEnabled(var7, false));
            }
         } else {
            CRTOLog.method_473("Unable to retrieve Google Ad ID");
            advertisingId = "";
            LATEnabled = Boolean.valueOf(false);
         }
      } catch (Exception var8) {
         CRTOLog.method_474("Unable to retrieve Google Ad ID", var8);
         advertisingId = "";
         LATEnabled = Boolean.valueOf(false);
      }
   }

   private static String reflectedGetAdvertisingId(Object var0, String var1) {
      try {
         String var3 = (String)var0.getClass().getDeclaredMethod("getId", new Class[0]).invoke(var0, new Object[0]);
         return var3;
      } catch (Exception var4) {
         return var1;
      }
   }

   private static boolean reflectedIsLimitAdTrackingEnabled(Object var0, boolean var1) {
      try {
         boolean var3 = ((Boolean)var0.getClass().getDeclaredMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(var0, new Object[0])).booleanValue();
         return var3;
      } catch (Exception var4) {
         return var1;
      }
   }
}
