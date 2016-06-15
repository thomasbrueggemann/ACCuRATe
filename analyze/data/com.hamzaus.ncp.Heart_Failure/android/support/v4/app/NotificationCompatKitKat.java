package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Action;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.NotificationCompatJellybean;
import android.support.v4.app.RemoteInputCompatBase;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

class NotificationCompatKitKat {
   public static NotificationCompatBase.Action getAction(Notification var0, int var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3) {
      Action var4 = var0.actions[var1];
      SparseArray var5 = var0.extras.getSparseParcelableArray("android.support.actionExtras");
      Bundle var6 = null;
      if(var5 != null) {
         var6 = (Bundle)var5.get(var1);
      }

      return NotificationCompatJellybean.readAction(var2, var3, var4.icon, var4.title, var4.actionIntent, var6);
   }

   public static int getActionCount(Notification var0) {
      return var0.actions != null?var0.actions.length:0;
   }

   public static Bundle getExtras(Notification var0) {
      return var0.extras;
   }

   public static String getGroup(Notification var0) {
      return var0.extras.getString("android.support.groupKey");
   }

   public static boolean getLocalOnly(Notification var0) {
      return var0.extras.getBoolean("android.support.localOnly");
   }

   public static String getSortKey(Notification var0) {
      return var0.extras.getString("android.support.sortKey");
   }

   public static boolean isGroupSummary(Notification var0) {
      return var0.extras.getBoolean("android.support.isGroupSummary");
   }

   public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_3751;
      private List<Bundle> mActionExtrasList = new ArrayList();
      private Bundle mExtras;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, int var15, CharSequence var16, boolean var17, Bundle var18, String var19, boolean var20, String var21) {
         android.app.Notification.Builder var22 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         boolean var23;
         if((2 & var2.flags) != 0) {
            var23 = true;
         } else {
            var23 = false;
         }

         android.app.Notification.Builder var24 = var22.setOngoing(var23);
         boolean var25;
         if((8 & var2.flags) != 0) {
            var25 = true;
         } else {
            var25 = false;
         }

         android.app.Notification.Builder var26 = var24.setOnlyAlertOnce(var25);
         boolean var27;
         if((16 & var2.flags) != 0) {
            var27 = true;
         } else {
            var27 = false;
         }

         android.app.Notification.Builder var28 = var26.setAutoCancel(var27).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var16).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         boolean var29;
         if((128 & var2.flags) != 0) {
            var29 = true;
         } else {
            var29 = false;
         }

         this.field_3751 = var28.setFullScreenIntent(var9, var29).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var14).setPriority(var15).setProgress(var11, var12, var13);
         this.mExtras = new Bundle();
         if(var18 != null) {
            this.mExtras.putAll(var18);
         }

         if(var17) {
            this.mExtras.putBoolean("android.support.localOnly", true);
         }

         if(var19 != null) {
            this.mExtras.putString("android.support.groupKey", var19);
            if(var20) {
               this.mExtras.putBoolean("android.support.isGroupSummary", true);
            } else {
               this.mExtras.putBoolean("android.support.useSideChannel", true);
            }
         }

         if(var21 != null) {
            this.mExtras.putString("android.support.sortKey", var21);
         }

      }

      public void addAction(NotificationCompatBase.Action var1) {
         this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.field_3751, var1));
      }

      public Notification build() {
         SparseArray var1 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
         if(var1 != null) {
            this.mExtras.putSparseParcelableArray("android.support.actionExtras", var1);
         }

         this.field_3751.setExtras(this.mExtras);
         return this.field_3751.build();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_3751;
      }
   }
}
