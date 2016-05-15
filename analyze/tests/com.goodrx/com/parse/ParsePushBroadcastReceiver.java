package com.parse;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.parse.ManifestInfo;
import com.parse.NotificationCompat;
import com.parse.PLog;
import com.parse.ParseAnalytics;
import com.parse.ParseNotificationManager;
import com.parse.TaskStackBuilderHelper;
import java.util.Locale;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class ParsePushBroadcastReceiver extends BroadcastReceiver {
   public static final String ACTION_PUSH_DELETE = "com.parse.push.intent.DELETE";
   public static final String ACTION_PUSH_OPEN = "com.parse.push.intent.OPEN";
   public static final String ACTION_PUSH_RECEIVE = "com.parse.push.intent.RECEIVE";
   public static final String KEY_PUSH_CHANNEL = "com.parse.Channel";
   public static final String KEY_PUSH_DATA = "com.parse.Data";
   public static final String PROPERTY_PUSH_ICON = "com.parse.push.notification_icon";
   protected static final int SMALL_NOTIFICATION_MAX_CHARACTER_LIMIT = 38;
   private static final String TAG = "com.parse.ParsePushReceiver";

   private JSONObject getPushData(Intent var1) {
      try {
         new JSONObject;
         JSONObject var4 = JSONObjectInstrumentation.init(var1.getStringExtra("com.parse.Data"));
         return var4;
      } catch (JSONException var5) {
         PLog.method_362("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", var5);
         return null;
      }
   }

   protected Class<? extends Activity> getActivity(Context var1, Intent var2) {
      String var3 = var1.getPackageName();
      Intent var4 = var1.getPackageManager().getLaunchIntentForPackage(var3);
      if(var4 == null) {
         return null;
      } else {
         String var5 = var4.getComponent().getClassName();

         try {
            Class var7 = Class.forName(var5);
            return var7;
         } catch (ClassNotFoundException var8) {
            return null;
         }
      }
   }

   protected Bitmap getLargeIcon(Context var1, Intent var2) {
      return null;
   }

   protected Notification getNotification(Context var1, Intent var2) {
      JSONObject var3 = this.getPushData(var2);
      if(var3 != null && (var3.has("alert") || var3.has("title"))) {
         String var4 = var3.optString("title", ManifestInfo.getDisplayName(var1));
         String var5 = var3.optString("alert", "Notification received.");
         String var6 = String.format(Locale.getDefault(), "%s: %s", new Object[]{var4, var5});
         Bundle var7 = var2.getExtras();
         Random var8 = new Random();
         int var9 = var8.nextInt();
         int var10 = var8.nextInt();
         String var11 = var1.getPackageName();
         Intent var12 = new Intent("com.parse.push.intent.OPEN");
         var12.putExtras(var7);
         var12.setPackage(var11);
         Intent var15 = new Intent("com.parse.push.intent.DELETE");
         var15.putExtras(var7);
         var15.setPackage(var11);
         PendingIntent var18 = PendingIntent.getBroadcast(var1, var9, var12, 134217728);
         PendingIntent var19 = PendingIntent.getBroadcast(var1, var10, var15, 134217728);
         NotificationCompat.Builder var20 = new NotificationCompat.Builder(var1);
         var20.setContentTitle(var4).setContentText(var5).setTicker(var6).setSmallIcon(this.getSmallIconId(var1, var2)).setLargeIcon(this.getLargeIcon(var1, var2)).setContentIntent(var18).setDeleteIntent(var19).setAutoCancel(true).setDefaults(-1);
         if(var5 != null && var5.length() > 38) {
            var20.setStyle((new NotificationCompat.BigTextStyle()).bigText(var5));
         }

         return var20.build();
      } else {
         return null;
      }
   }

   protected int getSmallIconId(Context var1, Intent var2) {
      Bundle var3 = ManifestInfo.getApplicationMetadata(var1);
      int var4 = 0;
      if(var3 != null) {
         var4 = var3.getInt("com.parse.push.notification_icon");
      }

      return var4 != 0?var4:ManifestInfo.getIconId();
   }

   protected void onPushDismiss(Context var1, Intent var2) {
   }

   protected void onPushOpen(Context var1, Intent var2) {
      ParseAnalytics.trackAppOpenedInBackground(var2);

      String var5;
      label22: {
         String var12;
         try {
            new JSONObject;
            var12 = JSONObjectInstrumentation.init(var2.getStringExtra("com.parse.Data")).optString("uri", (String)null);
         } catch (JSONException var13) {
            PLog.method_362("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", var13);
            var5 = null;
            break label22;
         }

         var5 = var12;
      }

      Class var6 = this.getActivity(var1, var2);
      Intent var7;
      if(var5 != null) {
         var7 = new Intent("android.intent.action.VIEW", Uri.parse(var5));
      } else {
         var7 = new Intent(var1, var6);
      }

      var7.putExtras(var2.getExtras());
      if(VERSION.SDK_INT >= 16) {
         TaskStackBuilderHelper.startActivities(var1, var6, var7);
      } else {
         var7.addFlags(268435456);
         var7.addFlags(67108864);
         var1.startActivity(var7);
      }
   }

   protected void onPushReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("com.parse.Data");
      if(var3 == null) {
         PLog.method_361("com.parse.ParsePushReceiver", "Can not get push data from intent.");
      } else {
         PLog.method_365("com.parse.ParsePushReceiver", "Received push data: " + var3);

         JSONObject var5;
         label26: {
            JSONObject var14;
            try {
               new JSONObject;
               var14 = JSONObjectInstrumentation.init(var3);
            } catch (JSONException var15) {
               PLog.method_362("com.parse.ParsePushReceiver", "Unexpected JSONException when receiving push data: ", var15);
               var5 = null;
               break label26;
            }

            var5 = var14;
         }

         String var6 = null;
         if(var5 != null) {
            var6 = var5.optString("action", (String)null);
         }

         if(var6 != null) {
            Bundle var8 = var2.getExtras();
            Intent var9 = new Intent();
            var9.putExtras(var8);
            var9.setAction(var6);
            var9.setPackage(var1.getPackageName());
            var1.sendBroadcast(var9);
         }

         Notification var7 = this.getNotification(var1, var2);
         if(var7 != null) {
            ParseNotificationManager.getInstance().showNotification(var1, var7);
            return;
         }
      }

   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getAction();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case -824874927:
         if(var3.equals("com.parse.push.intent.DELETE")) {
            var4 = 1;
         }
         break;
      case -269490979:
         if(var3.equals("com.parse.push.intent.RECEIVE")) {
            var4 = 0;
         }
         break;
      case 374898288:
         if(var3.equals("com.parse.push.intent.OPEN")) {
            var4 = 2;
         }
      }

      switch(var4) {
      case 0:
         this.onPushReceive(var1, var2);
         return;
      case 1:
         this.onPushDismiss(var1, var2);
         return;
      case 2:
         this.onPushOpen(var1, var2);
         return;
      default:
      }
   }
}
