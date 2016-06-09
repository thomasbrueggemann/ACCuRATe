package com.mobileapptracker;

import android.content.Context;
import android.os.Bundle;
import com.mobileapptracker.MATEvent;
import java.lang.reflect.Method;

class MATFBBridge {
   private static boolean justActivated = false;
   private static Object logger;

   private static void addBundleValue(Bundle var0, String var1, String var2) {
      if(var2 != null) {
         var0.putString(var1, var2);
      }

   }

   public static void logEvent(MATEvent param0) {
      // $FF: Couldn't be decompiled
   }

   public static void startLogger(Context var0, boolean var1) {
      try {
         Class[] var2 = new Class[]{Context.class};
         Class[] var4 = new Class[]{Context.class, Boolean.TYPE};
         Method var5 = Class.forName("com.facebook.appevents.AppEventsLogger").getMethod("activateApp", var2);
         Object[] var6 = new Object[]{var0};
         var5.invoke((Object)null, var6);
         justActivated = true;
         Method var8 = Class.forName("com.facebook.FacebookSdk").getMethod("setLimitEventAndDataUsage", var4);
         Object[] var9 = new Object[]{var0, Boolean.valueOf(var1)};
         var8.invoke((Object)null, var9);
         logger = Class.forName("com.facebook.appevents.AppEventsLogger").getMethod("newLogger", var2).invoke((Object)null, var6);
      } catch (Exception var10) {
         var10.printStackTrace();
      }
   }
}
