package com.parse;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;

class NotificationCompat {
   public static final int FLAG_HIGH_PRIORITY = 128;
   private static final NotificationCompat.NotificationCompatImpl IMPL;
   public static final int PRIORITY_DEFAULT;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new NotificationCompat.NotificationCompatPostJellyBean();
      } else {
         IMPL = new NotificationCompat.NotificationCompatImplBase();
      }
   }

   public static class Builder {
      private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
      PendingIntent mContentIntent;
      CharSequence mContentText;
      CharSequence mContentTitle;
      Context mContext;
      Bitmap mLargeIcon;
      Notification mNotification = new Notification();
      int mPriority;
      NotificationCompat.Style mStyle;

      public Builder(Context var1) {
         this.mContext = var1;
         this.mNotification.when = System.currentTimeMillis();
         this.mNotification.audioStreamType = -1;
         this.mPriority = 0;
      }

      protected static CharSequence limitCharSequenceLength(CharSequence var0) {
         return var0 != null && var0.length() > 5120?var0.subSequence(0, 5120):var0;
      }

      private void setFlag(int var1, boolean var2) {
         if(var2) {
            Notification var4 = this.mNotification;
            var4.flags |= var1;
         } else {
            Notification var3 = this.mNotification;
            var3.flags &= ~var1;
         }
      }

      public Notification build() {
         return NotificationCompat.IMPL.build(this);
      }

      @Deprecated
      public Notification getNotification() {
         return NotificationCompat.IMPL.build(this);
      }

      public NotificationCompat.Builder setAutoCancel(boolean var1) {
         this.setFlag(16, var1);
         return this;
      }

      public NotificationCompat.Builder setContentIntent(PendingIntent var1) {
         this.mContentIntent = var1;
         return this;
      }

      public NotificationCompat.Builder setContentText(CharSequence var1) {
         this.mContentText = limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.Builder setContentTitle(CharSequence var1) {
         this.mContentTitle = limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.Builder setDefaults(int var1) {
         this.mNotification.defaults = var1;
         if((var1 & 4) != 0) {
            Notification var2 = this.mNotification;
            var2.flags |= 1;
         }

         return this;
      }

      public NotificationCompat.Builder setDeleteIntent(PendingIntent var1) {
         this.mNotification.deleteIntent = var1;
         return this;
      }

      public NotificationCompat.Builder setLargeIcon(Bitmap var1) {
         this.mLargeIcon = var1;
         return this;
      }

      public NotificationCompat.Builder setPriority(int var1) {
         this.mPriority = var1;
         return this;
      }

      public NotificationCompat.Builder setSmallIcon(int var1) {
         this.mNotification.icon = var1;
         return this;
      }

      public NotificationCompat.Builder setSmallIcon(int var1, int var2) {
         this.mNotification.icon = var1;
         this.mNotification.iconLevel = var2;
         return this;
      }

      public NotificationCompat.Builder setStyle(NotificationCompat.Style var1) {
         if(this.mStyle != var1) {
            this.mStyle = var1;
            if(this.mStyle != null) {
               this.mStyle.setBuilder(this);
            }
         }

         return this;
      }

      public NotificationCompat.Builder setTicker(CharSequence var1) {
         this.mNotification.tickerText = limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.Builder setWhen(long var1) {
         this.mNotification.when = var1;
         return this;
      }
   }

   public static class BigTextStyle extends NotificationCompat.Style {
      CharSequence mBigText;

      public BigTextStyle() {
      }

      public BigTextStyle(NotificationCompat.Builder var1) {
         this.setBuilder(var1);
      }

      public NotificationCompat.BigTextStyle bigText(CharSequence var1) {
         this.mBigText = var1;
         return this;
      }

      public NotificationCompat.BigTextStyle setBigContentTitle(CharSequence var1) {
         this.mBigContentTitle = var1;
         return this;
      }

      public NotificationCompat.BigTextStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = var1;
         this.mSummaryTextSet = true;
         return this;
      }
   }

   public abstract static class Style {
      CharSequence mBigContentTitle;
      NotificationCompat.Builder mBuilder;
      CharSequence mSummaryText;
      boolean mSummaryTextSet = false;

      public Notification build() {
         NotificationCompat.Builder var1 = this.mBuilder;
         Notification var2 = null;
         if(var1 != null) {
            var2 = this.mBuilder.build();
         }

         return var2;
      }

      public void setBuilder(NotificationCompat.Builder var1) {
         if(this.mBuilder != var1) {
            this.mBuilder = var1;
            if(this.mBuilder != null) {
               this.mBuilder.setStyle(this);
            }
         }

      }
   }

   interface NotificationCompatImpl {
      Notification build(NotificationCompat.Builder var1);
   }

   static class NotificationCompatImplBase implements NotificationCompat.NotificationCompatImpl {
      public Notification build(NotificationCompat.Builder var1) {
         Notification var2 = var1.mNotification;
         var2.setLatestEventInfo(var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent);
         if(var1.mPriority > 0) {
            var2.flags |= 128;
         }

         return var2;
      }
   }

   @TargetApi(16)
   static class NotificationCompatPostJellyBean implements NotificationCompat.NotificationCompatImpl {
      private android.app.Notification.Builder postJellyBeanBuilder;

      public Notification build(NotificationCompat.Builder var1) {
         this.postJellyBeanBuilder = new android.app.Notification.Builder(var1.mContext);
         android.app.Notification.Builder var2 = this.postJellyBeanBuilder.setContentTitle(var1.mContentTitle).setContentText(var1.mContentText).setTicker(var1.mNotification.tickerText).setSmallIcon(var1.mNotification.icon, var1.mNotification.iconLevel).setContentIntent(var1.mContentIntent).setDeleteIntent(var1.mNotification.deleteIntent);
         boolean var3;
         if((16 & var1.mNotification.flags) != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         var2.setAutoCancel(var3).setLargeIcon(var1.mLargeIcon).setDefaults(var1.mNotification.defaults);
         if(var1.mStyle != null && var1.mStyle instanceof NotificationCompat.BigTextStyle) {
            NotificationCompat.BigTextStyle var5 = (NotificationCompat.BigTextStyle)var1.mStyle;
            android.app.Notification.BigTextStyle var6 = (new android.app.Notification.BigTextStyle(this.postJellyBeanBuilder)).setBigContentTitle(var5.mBigContentTitle).bigText(var5.mBigText);
            if(var5.mSummaryTextSet) {
               var6.setSummaryText(var5.mSummaryText);
            }
         }

         return this.postJellyBeanBuilder.build();
      }
   }
}
