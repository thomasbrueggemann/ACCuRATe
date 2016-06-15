package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

class NotificationCompatIceCreamSandwich {
   static Notification add(Context var0, Notification var1, CharSequence var2, CharSequence var3, CharSequence var4, RemoteViews var5, int var6, PendingIntent var7, PendingIntent var8, Bitmap var9, int var10, int var11, boolean var12) {
      Builder var13 = (new Builder(var0)).setWhen(var1.when).setSmallIcon(var1.icon, var1.iconLevel).setContent(var1.contentView).setTicker(var1.tickerText, var5).setSound(var1.sound, var1.audioStreamType).setVibrate(var1.vibrate).setLights(var1.ledARGB, var1.ledOnMS, var1.ledOffMS);
      boolean var14;
      if((2 & var1.flags) != 0) {
         var14 = true;
      } else {
         var14 = false;
      }

      Builder var15 = var13.setOngoing(var14);
      boolean var16;
      if((8 & var1.flags) != 0) {
         var16 = true;
      } else {
         var16 = false;
      }

      Builder var17 = var15.setOnlyAlertOnce(var16);
      boolean var18;
      if((16 & var1.flags) != 0) {
         var18 = true;
      } else {
         var18 = false;
      }

      Builder var19 = var17.setAutoCancel(var18).setDefaults(var1.defaults).setContentTitle(var2).setContentText(var3).setContentInfo(var4).setContentIntent(var7).setDeleteIntent(var1.deleteIntent);
      boolean var20;
      if((128 & var1.flags) != 0) {
         var20 = true;
      } else {
         var20 = false;
      }

      return var19.setFullScreenIntent(var8, var20).setLargeIcon(var9).setNumber(var6).setProgress(var10, var11, var12).getNotification();
   }
}
