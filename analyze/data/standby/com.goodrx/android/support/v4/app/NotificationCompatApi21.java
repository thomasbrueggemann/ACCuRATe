package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatApi20;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompatApi21 {
   public static final String CATEGORY_ALARM = "alarm";
   public static final String CATEGORY_CALL = "call";
   public static final String CATEGORY_EMAIL = "email";
   public static final String CATEGORY_ERROR = "err";
   public static final String CATEGORY_EVENT = "event";
   public static final String CATEGORY_MESSAGE = "msg";
   public static final String CATEGORY_PROGRESS = "progress";
   public static final String CATEGORY_PROMO = "promo";
   public static final String CATEGORY_RECOMMENDATION = "recommendation";
   public static final String CATEGORY_SERVICE = "service";
   public static final String CATEGORY_SOCIAL = "social";
   public static final String CATEGORY_STATUS = "status";
   public static final String CATEGORY_SYSTEM = "sys";
   public static final String CATEGORY_TRANSPORT = "transport";
   private static final String KEY_AUTHOR = "author";
   private static final String KEY_MESSAGES = "messages";
   private static final String KEY_ON_READ = "on_read";
   private static final String KEY_ON_REPLY = "on_reply";
   private static final String KEY_PARTICIPANTS = "participants";
   private static final String KEY_REMOTE_INPUT = "remote_input";
   private static final String KEY_TEXT = "text";
   private static final String KEY_TIMESTAMP = "timestamp";

   private static android.app.RemoteInput fromCompatRemoteInput(RemoteInputCompatBase.RemoteInput var0) {
      return (new android.app.RemoteInput.Builder(var0.getResultKey())).setLabel(var0.getLabel()).setChoices(var0.getChoices()).setAllowFreeFormInput(var0.getAllowFreeFormInput()).addExtras(var0.getExtras()).build();
   }

   static Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation var0) {
      if(var0 == null) {
         return null;
      } else {
         Bundle var1 = new Bundle();
         String[] var2 = var0.getParticipants();
         String var3 = null;
         if(var2 != null) {
            int var8 = var0.getParticipants().length;
            var3 = null;
            if(var8 > 1) {
               var3 = var0.getParticipants()[0];
            }
         }

         Parcelable[] var4 = new Parcelable[var0.getMessages().length];

         for(int var5 = 0; var5 < var4.length; ++var5) {
            Bundle var6 = new Bundle();
            var6.putString("text", var0.getMessages()[var5]);
            var6.putString("author", var3);
            var4[var5] = var6;
         }

         var1.putParcelableArray("messages", var4);
         RemoteInputCompatBase.RemoteInput var7 = var0.getRemoteInput();
         if(var7 != null) {
            var1.putParcelable("remote_input", fromCompatRemoteInput(var7));
         }

         var1.putParcelable("on_reply", var0.getReplyPendingIntent());
         var1.putParcelable("on_read", var0.getReadPendingIntent());
         var1.putStringArray("participants", var0.getParticipants());
         var1.putLong("timestamp", var0.getLatestTimestamp());
         return var1;
      }
   }

   public static String getCategory(Notification var0) {
      return var0.category;
   }

   static NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      if(var0 != null) {
         Parcelable[] var3 = var0.getParcelableArray("messages");
         String[] var4 = null;
         if(var3 != null) {
            String[] var10 = new String[var3.length];
            boolean var11 = true;

            for(int var12 = 0; var12 < var10.length; ++var12) {
               if(!(var3[var12] instanceof Bundle)) {
                  var11 = false;
                  break;
               }

               var10[var12] = ((Bundle)var3[var12]).getString("text");
               if(var10[var12] == null) {
                  var11 = false;
                  break;
               }
            }

            if(!var11) {
               return null;
            }

            var4 = var10;
         }

         PendingIntent var5 = (PendingIntent)var0.getParcelable("on_read");
         PendingIntent var6 = (PendingIntent)var0.getParcelable("on_reply");
         android.app.RemoteInput var7 = (android.app.RemoteInput)var0.getParcelable("remote_input");
         String[] var8 = var0.getStringArray("participants");
         if(var8 != null && var8.length == 1) {
            RemoteInputCompatBase.RemoteInput var9 = null;
            if(var7 != null) {
               var9 = toCompatRemoteInput(var7, var2);
            }

            return var1.build(var4, var9, var6, var5, var8, var0.getLong("timestamp"));
         }
      }

      return null;
   }

   private static RemoteInputCompatBase.RemoteInput toCompatRemoteInput(android.app.RemoteInput var0, RemoteInputCompatBase.Factory var1) {
      return var1.build(var0.getResultKey(), var0.getLabel(), var0.getChoices(), var0.getAllowFreeFormInput(), var0.getExtras());
   }

   public static class Builder implements NotificationBuilderWithActions, NotificationBuilderWithBuilderAccessor {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_612;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, boolean var15, int var16, CharSequence var17, boolean var18, String var19, ArrayList<String> var20, Bundle var21, int var22, int var23, Notification var24, String var25, boolean var26, String var27) {
         android.app.Notification.Builder var28 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setShowWhen(var14).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         boolean var29;
         if((2 & var2.flags) != 0) {
            var29 = true;
         } else {
            var29 = false;
         }

         android.app.Notification.Builder var30 = var28.setOngoing(var29);
         boolean var31;
         if((8 & var2.flags) != 0) {
            var31 = true;
         } else {
            var31 = false;
         }

         android.app.Notification.Builder var32 = var30.setOnlyAlertOnce(var31);
         boolean var33;
         if((16 & var2.flags) != 0) {
            var33 = true;
         } else {
            var33 = false;
         }

         android.app.Notification.Builder var34 = var32.setAutoCancel(var33).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var17).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         boolean var35;
         if((128 & var2.flags) != 0) {
            var35 = true;
         } else {
            var35 = false;
         }

         this.field_612 = var34.setFullScreenIntent(var9, var35).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var15).setPriority(var16).setProgress(var11, var12, var13).setLocalOnly(var18).setExtras(var21).setGroup(var25).setGroupSummary(var26).setSortKey(var27).setCategory(var19).setColor(var22).setVisibility(var23).setPublicVersion(var24);
         Iterator var36 = var20.iterator();

         while(var36.hasNext()) {
            String var37 = (String)var36.next();
            this.field_612.addPerson(var37);
         }

      }

      public void addAction(NotificationCompatBase.Action var1) {
         NotificationCompatApi20.addAction(this.field_612, var1);
      }

      public Notification build() {
         return this.field_612.build();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_612;
      }
   }
}
