package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.widget.RemoteViews;

class NotificationCompatIceCreamSandwich {
   public static class Builder implements NotificationBuilderWithBuilderAccessor {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_461;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13) {
         android.app.Notification.Builder var14 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         boolean var15;
         if((2 & var2.flags) != 0) {
            var15 = true;
         } else {
            var15 = false;
         }

         android.app.Notification.Builder var16 = var14.setOngoing(var15);
         boolean var17;
         if((8 & var2.flags) != 0) {
            var17 = true;
         } else {
            var17 = false;
         }

         android.app.Notification.Builder var18 = var16.setOnlyAlertOnce(var17);
         boolean var19;
         if((16 & var2.flags) != 0) {
            var19 = true;
         } else {
            var19 = false;
         }

         android.app.Notification.Builder var20 = var18.setAutoCancel(var19).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         boolean var21;
         if((128 & var2.flags) != 0) {
            var21 = true;
         } else {
            var21 = false;
         }

         this.field_461 = var20.setFullScreenIntent(var9, var21).setLargeIcon(var10).setNumber(var7).setProgress(var11, var12, var13);
      }

      public Notification build() {
         return this.field_461.getNotification();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_461;
      }
   }
}
