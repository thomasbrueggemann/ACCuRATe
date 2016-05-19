package com.goodrx.utils.tracker;

import android.content.Context;
import com.goodrx.model.Key;
import com.goodrx.utils.AccountInfoUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import java.util.Map;

public class GAHelper {
   public static void pushCloseScreenEvent(Context var0, String var1) {
      TagManager.getInstance(var0).getDataLayer().pushEvent("closeScreen", DataLayer.mapOf(new Object[]{"screenName", var1}));
   }

   public static void pushMapToDataLayer(Context var0, Map<String, Object> var1) {
      TagManager.getInstance(var0).getDataLayer().push(var1);
   }

   public static void pushOpenScreenEvent(Context var0, String var1) {
      TagManager.getInstance(var0).getDataLayer().pushEvent("openScreen", DataLayer.mapOf(new Object[]{"screenName", var1}));
   }

   public static void sendGoogleAnalyticsEvent(Context param0, String param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public static void sendGoogleAnalyticsScreenView(Context var0, int var1) {
      synchronized(GAHelper.class){}

      try {
         sendGoogleAnalyticsScreenView(var0, var0.getString(var1));
      } finally {
         ;
      }

   }

   public static void sendGoogleAnalyticsScreenView(Context var0, String var1) {
      synchronized(GAHelper.class){}

      try {
         Context var3 = var0.getApplicationContext();
         Tracker var4 = GoogleAnalytics.getInstance(var3).newTracker(2131230720);
         Key var5 = AccountInfoUtils.getKey(var3);
         if(var5.isValid()) {
            var4.set("&uid", var5.getToken_id());
         }

         var4.setScreenName(var1);
         var4.send((new HitBuilders.ScreenViewBuilder()).build());
         pushOpenScreenEvent(var3, var1);
      } finally {
         ;
      }

   }
}
