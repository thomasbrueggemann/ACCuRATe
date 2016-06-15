package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Action;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatApi20;
import android.support.v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;

class NotificationCompatApi20 {
   public static NotificationCompatBase.Action getAction(Notification var0, int var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3) {
      return getActionCompatFromAction(var0.actions[var1], var2, var3);
   }

   private static NotificationCompatBase.Action getActionCompatFromAction(Action var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      RemoteInputCompatBase.RemoteInput[] var3 = RemoteInputCompatApi20.toCompat(var0.getRemoteInputs(), var2);
      return var1.build(var0.icon, var0.title, var0.actionIntent, var0.getExtras(), var3);
   }

   private static Action getActionFromActionCompat(NotificationCompatBase.Action var0) {
      android.app.Notification.Action.Builder var1 = (new android.app.Notification.Action.Builder(var0.getIcon(), var0.getTitle(), var0.getActionIntent())).addExtras(var0.getExtras());
      RemoteInputCompatBase.RemoteInput[] var2 = var0.getRemoteInputs();
      if(var2 != null) {
         android.app.RemoteInput[] var3 = RemoteInputCompatApi20.fromCompat(var2);
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            var1.addRemoteInput(var3[var5]);
         }
      }

      return var1.build();
   }

   public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      NotificationCompatBase.Action[] var3;
      if(var0 == null) {
         var3 = null;
      } else {
         var3 = var1.newArray(var0.size());

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4] = getActionCompatFromAction((Action)var0.get(var4), var1, var2);
         }
      }

      return var3;
   }

   public static String getGroup(Notification var0) {
      return var0.getGroup();
   }

   public static boolean getLocalOnly(Notification var0) {
      return (256 & var0.flags) != 0;
   }

   public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] var0) {
      ArrayList var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new ArrayList(var0.length);
         int var2 = var0.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.add(getActionFromActionCompat(var0[var3]));
         }
      }

      return var1;
   }

   public static String getSortKey(Notification var0) {
      return var0.getSortKey();
   }

   public static boolean isGroupSummary(Notification var0) {
      return (512 & var0.flags) != 0;
   }

   public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_3340;

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

         this.field_3340 = var28.setFullScreenIntent(var9, var29).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var14).setPriority(var15).setProgress(var11, var12, var13).setLocalOnly(var17).setExtras(var18).setGroup(var19).setGroupSummary(var20).setSortKey(var21);
      }

      public void addAction(NotificationCompatBase.Action var1) {
         android.app.Notification.Action.Builder var2 = new android.app.Notification.Action.Builder(var1.getIcon(), var1.getTitle(), var1.getActionIntent());
         if(var1.getRemoteInputs() != null) {
            android.app.RemoteInput[] var5 = RemoteInputCompatApi20.fromCompat(var1.getRemoteInputs());
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               var2.addRemoteInput(var5[var7]);
            }
         }

         if(var1.getExtras() != null) {
            var2.addExtras(var1.getExtras());
         }

         this.field_3340.addAction(var2.build());
      }

      public Notification build() {
         return this.field_3340.build();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_3340;
      }
   }
}
