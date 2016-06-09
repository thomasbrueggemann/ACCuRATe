package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

class NotificationCompatHoneycomb {
   static Notification add(Context var0, Notification var1, CharSequence var2, CharSequence var3, CharSequence var4, RemoteViews var5, int var6, PendingIntent var7, PendingIntent var8, Bitmap var9) {
      Builder var10 = (new Builder(var0)).setWhen(var1.when).setSmallIcon(var1.icon, var1.iconLevel).setContent(var1.contentView).setTicker(var1.tickerText, var5).setSound(var1.sound, var1.audioStreamType).setVibrate(var1.vibrate).setLights(var1.ledARGB, var1.ledOnMS, var1.ledOffMS);
      boolean var11;
      if((2 & var1.flags) != 0) {
         var11 = true;
      } else {
         var11 = false;
      }

      Builder var12 = var10.setOngoing(var11);
      boolean var13;
      if((8 & var1.flags) != 0) {
         var13 = true;
      } else {
         var13 = false;
      }

      Builder var14 = var12.setOnlyAlertOnce(var13);
      boolean var15;
      if((16 & var1.flags) != 0) {
         var15 = true;
      } else {
         var15 = false;
      }

      Builder var16 = var14.setAutoCancel(var15).setDefaults(var1.defaults).setContentTitle(var2).setContentText(var3).setContentInfo(var4).setContentIntent(var7).setDeleteIntent(var1.deleteIntent);
      boolean var17;
      if((128 & var1.flags) != 0) {
         var17 = true;
      } else {
         var17 = false;
      }

      return var16.setFullScreenIntent(var8, var17).setLargeIcon(var9).setNumber(var6).getNotification();
   }
}
