package com.goodrx.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import com.goodrx.activity.price.RxPriceActivity;
import com.goodrx.model.MyRx;
import com.goodrx.utils.MyRxUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class ReminderAlarmReceiver extends BroadcastReceiver {
   public static ReminderAlarmReceiver instance;
   private PendingIntent alarmIntent;
   private AlarmManager alarmManager;
   private PendingIntent[] inactiveAlarmIntents = null;

   public static ReminderAlarmReceiver getInstance() {
      if(instance == null) {
         instance = new ReminderAlarmReceiver();
      }

      return instance;
   }

   private void sendNotification(Context var1, String var2, String var3) {
      MyRx var4 = MyRxUtils.findRxByDrugId(var1, var2);
      NotificationManagerCompat var5 = NotificationManagerCompat.from(var1);
      Intent var6 = new Intent(var1, RxPriceActivity.class);
      var6.putExtra("drug_id", var2);
      var6.putExtra("default_page", var1.getString(2131427794));
      var6.putExtra("create_back_stack", true);
      var6.setFlags(67108864);
      PendingIntent var11 = PendingIntent.getActivity(var1, 23, var6, 134217728);
      NotificationCompat.Builder var12 = (new NotificationCompat.Builder(var1)).setContentTitle(var1.getString(2131427431)).setContentText(var3).setAutoCancel(true).setDefaults(-1).setColor(ContextCompat.getColor(var1, 2131755163)).setCategory("event").setContentIntent(var11);
      if(VERSION.SDK_INT >= 21) {
         var12.setSmallIcon(2130903040);
      } else {
         var12.setSmallIcon(2130903041);
      }

      if(var4 != null && var4.getDrug().getImage() != null) {
         String var14 = var4.getDrug().getImage();
         var12.setLargeIcon(ImageLoader.getInstance().loadImageSync(var14));
         NotificationCompat.WearableExtender var16 = new NotificationCompat.WearableExtender();
         var16.setBackground(BitmapFactoryInstrumentation.decodeResource(var1.getResources(), 2130837722));
         var12.extend(var16);
      }

      var5.notify(1, var12.build());
   }

   public void cancelAlarm() {
      if(this.alarmManager != null) {
         this.alarmManager.cancel(this.alarmIntent);
         if(this.inactiveAlarmIntents != null) {
            PendingIntent[] var1 = this.inactiveAlarmIntents;
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               PendingIntent var4 = var1[var3];
               this.alarmManager.cancel(var4);
            }
         }
      }

   }

   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("message_content");
      String var4 = var2.getStringExtra("drug_id");
      Tracker var5 = GoogleAnalytics.getInstance(var1).newTracker(2131230720);
      HitBuilders.EventBuilder var6 = new HitBuilders.EventBuilder();
      var6.setCategory(var1.getString(2131427471));
      var6.setAction(var1.getString(2131427584));
      var6.setLabel(var1.getString(2131427578));
      var5.send(var6.build());
      this.sendNotification(var1, var4, var3);
   }

   public void scheduleAlarm(Context var1) {
      if(MyRxUtils.isNotificationEnabled(var1)) {
         ArrayList var2 = MyRxUtils.getClosetReminder(var1);
         if(var2 != null && var2.size() != 0) {
            this.alarmManager = (AlarmManager)var1.getSystemService("alarm");
            Intent var3 = new Intent(var1, ReminderAlarmReceiver.class);
            MyRx var4 = (MyRx)var2.get(0);
            String var5;
            if(var2.size() == 1) {
               var5 = var1.getString(2131427628) + " " + var4.getDrug().getSelected_drug() + " ";
               var3.putExtra("drug_id", var4.getDrug().getDrug_id());
            } else {
               var5 = var1.getString(2131427628) + " " + var2.size() + " ";
            }

            var3.putExtra("message_content", var5 + var1.getResources().getQuantityString(2131361820, var2.size()));
            this.alarmIntent = PendingIntent.getBroadcast(var1, 10, var3, 134217728);
            DateTime var7 = var4.getReminder().getCombinedNextDate();
            this.alarmManager.set(0, var7.getMillis(), this.alarmIntent);
         } else {
            getInstance().cancelAlarm();
         }
      }
   }
}
