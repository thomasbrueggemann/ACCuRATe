package com.parse;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

class ParseNotificationManager {
   public static final String TAG = "com.parse.ParseNotificationManager";
   private final AtomicInteger notificationCount = new AtomicInteger(0);
   private volatile boolean shouldShowNotifications = true;

   public static ParseNotificationManager getInstance() {
      return ParseNotificationManager.Singleton.INSTANCE;
   }

   public int getNotificationCount() {
      return this.notificationCount.get();
   }

   public void setShouldShowNotifications(boolean var1) {
      this.shouldShowNotifications = var1;
   }

   public void showNotification(Context var1, Notification var2) {
      if(var1 != null && var2 != null) {
         this.notificationCount.incrementAndGet();
         if(this.shouldShowNotifications) {
            NotificationManager var4 = (NotificationManager)var1.getSystemService("notification");
            int var5 = (int)System.currentTimeMillis();

            try {
               var4.notify(var5, var2);
            } catch (SecurityException var7) {
               var2.defaults = 5;
               var4.notify(var5, var2);
               return;
            }
         }
      }

   }

   public static class Singleton {
      private static final ParseNotificationManager INSTANCE = new ParseNotificationManager();
   }
}
