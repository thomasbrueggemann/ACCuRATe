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
   public static void addAction(android.app.Notification.Builder var0, NotificationCompatBase.Action var1) {
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

      var0.addAction(var2.build());
   }

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

   public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_218;
      private Bundle mExtras;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, boolean var15, int var16, CharSequence var17, boolean var18, ArrayList<String> var19, Bundle var20, String var21, boolean var22, String var23) {
         android.app.Notification.Builder var24 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setShowWhen(var14).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         boolean var25;
         if((2 & var2.flags) != 0) {
            var25 = true;
         } else {
            var25 = false;
         }

         android.app.Notification.Builder var26 = var24.setOngoing(var25);
         boolean var27;
         if((8 & var2.flags) != 0) {
            var27 = true;
         } else {
            var27 = false;
         }

         android.app.Notification.Builder var28 = var26.setOnlyAlertOnce(var27);
         boolean var29;
         if((16 & var2.flags) != 0) {
            var29 = true;
         } else {
            var29 = false;
         }

         android.app.Notification.Builder var30 = var28.setAutoCancel(var29).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var17).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         boolean var31;
         if((128 & var2.flags) != 0) {
            var31 = true;
         } else {
            var31 = false;
         }

         this.field_218 = var30.setFullScreenIntent(var9, var31).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var15).setPriority(var16).setProgress(var11, var12, var13).setLocalOnly(var18).setGroup(var21).setGroupSummary(var22).setSortKey(var23);
         this.mExtras = new Bundle();
         if(var20 != null) {
            this.mExtras.putAll(var20);
         }

         if(var19 != null && !var19.isEmpty()) {
            this.mExtras.putStringArray("android.people", (String[])var19.toArray(new String[var19.size()]));
         }

      }

      public void addAction(NotificationCompatBase.Action var1) {
         NotificationCompatApi20.addAction(this.field_218, var1);
      }

      public Notification build() {
         this.field_218.setExtras(this.mExtras);
         return this.field_218.build();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_218;
      }
   }
}
