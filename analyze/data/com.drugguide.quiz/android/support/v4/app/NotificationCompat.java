package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompatHoneycomb;
import android.support.v4.app.NotificationCompatIceCreamSandwich;
import android.support.v4.app.NotificationCompatJellybean;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

public class NotificationCompat {
   public static final int FLAG_HIGH_PRIORITY = 128;
   private static final NotificationCompat.NotificationCompatImpl IMPL;
   public static final int PRIORITY_DEFAULT = 0;
   public static final int PRIORITY_HIGH = 1;
   public static final int PRIORITY_LOW = -1;
   public static final int PRIORITY_MAX = 2;
   public static final int PRIORITY_MIN = -2;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new NotificationCompat.NotificationCompatImplJellybean();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new NotificationCompat.NotificationCompatImplIceCreamSandwich();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new NotificationCompat.NotificationCompatImplHoneycomb();
      } else {
         IMPL = new NotificationCompat.NotificationCompatImplBase();
      }
   }

   public static class Action {
      public PendingIntent actionIntent;
      public int icon;
      public CharSequence title;

      public Action(int var1, CharSequence var2, PendingIntent var3) {
         this.icon = var1;
         this.title = var2;
         this.actionIntent = var3;
      }
   }

   public static class BigPictureStyle extends NotificationCompat.Style {
      Bitmap mBigLargeIcon;
      boolean mBigLargeIconSet;
      Bitmap mPicture;

      public BigPictureStyle() {
      }

      public BigPictureStyle(NotificationCompat.Builder var1) {
         this.setBuilder(var1);
      }

      public NotificationCompat.BigPictureStyle bigLargeIcon(Bitmap var1) {
         this.mBigLargeIcon = var1;
         this.mBigLargeIconSet = true;
         return this;
      }

      public NotificationCompat.BigPictureStyle bigPicture(Bitmap var1) {
         this.mPicture = var1;
         return this;
      }

      public NotificationCompat.BigPictureStyle setBigContentTitle(CharSequence var1) {
         this.mBigContentTitle = var1;
         return this;
      }

      public NotificationCompat.BigPictureStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = var1;
         this.mSummaryTextSet = true;
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

   public static class Builder {
      ArrayList<NotificationCompat.Action> mActions = new ArrayList();
      CharSequence mContentInfo;
      PendingIntent mContentIntent;
      CharSequence mContentText;
      CharSequence mContentTitle;
      Context mContext;
      PendingIntent mFullScreenIntent;
      Bitmap mLargeIcon;
      Notification mNotification = new Notification();
      int mNumber;
      int mPriority;
      int mProgress;
      boolean mProgressIndeterminate;
      int mProgressMax;
      NotificationCompat.Style mStyle;
      CharSequence mSubText;
      RemoteViews mTickerView;
      boolean mUseChronometer;

      public Builder(Context var1) {
         this.mContext = var1;
         this.mNotification.when = System.currentTimeMillis();
         this.mNotification.audioStreamType = -1;
         this.mPriority = 0;
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

      public NotificationCompat.Builder addAction(int var1, CharSequence var2, PendingIntent var3) {
         this.mActions.add(new NotificationCompat.Action(var1, var2, var3));
         return this;
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

      public NotificationCompat.Builder setContent(RemoteViews var1) {
         this.mNotification.contentView = var1;
         return this;
      }

      public NotificationCompat.Builder setContentInfo(CharSequence var1) {
         this.mContentInfo = var1;
         return this;
      }

      public NotificationCompat.Builder setContentIntent(PendingIntent var1) {
         this.mContentIntent = var1;
         return this;
      }

      public NotificationCompat.Builder setContentText(CharSequence var1) {
         this.mContentText = var1;
         return this;
      }

      public NotificationCompat.Builder setContentTitle(CharSequence var1) {
         this.mContentTitle = var1;
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

      public NotificationCompat.Builder setFullScreenIntent(PendingIntent var1, boolean var2) {
         this.mFullScreenIntent = var1;
         this.setFlag(128, var2);
         return this;
      }

      public NotificationCompat.Builder setLargeIcon(Bitmap var1) {
         this.mLargeIcon = var1;
         return this;
      }

      public NotificationCompat.Builder setLights(int var1, int var2, int var3) {
         byte var4 = 1;
         this.mNotification.ledARGB = var1;
         this.mNotification.ledOnMS = var2;
         this.mNotification.ledOffMS = var3;
         byte var5;
         if(this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
            var5 = var4;
         } else {
            var5 = 0;
         }

         Notification var6 = this.mNotification;
         int var7 = -2 & this.mNotification.flags;
         if(var5 == 0) {
            var4 = 0;
         }

         var6.flags = var4 | var7;
         return this;
      }

      public NotificationCompat.Builder setNumber(int var1) {
         this.mNumber = var1;
         return this;
      }

      public NotificationCompat.Builder setOngoing(boolean var1) {
         this.setFlag(2, var1);
         return this;
      }

      public NotificationCompat.Builder setOnlyAlertOnce(boolean var1) {
         this.setFlag(8, var1);
         return this;
      }

      public NotificationCompat.Builder setPriority(int var1) {
         this.mPriority = var1;
         return this;
      }

      public NotificationCompat.Builder setProgress(int var1, int var2, boolean var3) {
         this.mProgressMax = var1;
         this.mProgress = var2;
         this.mProgressIndeterminate = var3;
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

      public NotificationCompat.Builder setSound(Uri var1) {
         this.mNotification.sound = var1;
         this.mNotification.audioStreamType = -1;
         return this;
      }

      public NotificationCompat.Builder setSound(Uri var1, int var2) {
         this.mNotification.sound = var1;
         this.mNotification.audioStreamType = var2;
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

      public NotificationCompat.Builder setSubText(CharSequence var1) {
         this.mSubText = var1;
         return this;
      }

      public NotificationCompat.Builder setTicker(CharSequence var1) {
         this.mNotification.tickerText = var1;
         return this;
      }

      public NotificationCompat.Builder setTicker(CharSequence var1, RemoteViews var2) {
         this.mNotification.tickerText = var1;
         this.mTickerView = var2;
         return this;
      }

      public NotificationCompat.Builder setUsesChronometer(boolean var1) {
         this.mUseChronometer = var1;
         return this;
      }

      public NotificationCompat.Builder setVibrate(long[] var1) {
         this.mNotification.vibrate = var1;
         return this;
      }

      public NotificationCompat.Builder setWhen(long var1) {
         this.mNotification.when = var1;
         return this;
      }
   }

   public static class InboxStyle extends NotificationCompat.Style {
      ArrayList<CharSequence> mTexts = new ArrayList();

      public InboxStyle() {
      }

      public InboxStyle(NotificationCompat.Builder var1) {
         this.setBuilder(var1);
      }

      public NotificationCompat.InboxStyle addLine(CharSequence var1) {
         this.mTexts.add(var1);
         return this;
      }

      public NotificationCompat.InboxStyle setBigContentTitle(CharSequence var1) {
         this.mBigContentTitle = var1;
         return this;
      }

      public NotificationCompat.InboxStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = var1;
         this.mSummaryTextSet = true;
         return this;
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

   static class NotificationCompatImplHoneycomb implements NotificationCompat.NotificationCompatImpl {
      public Notification build(NotificationCompat.Builder var1) {
         return NotificationCompatHoneycomb.add(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon);
      }
   }

   static class NotificationCompatImplIceCreamSandwich implements NotificationCompat.NotificationCompatImpl {
      public Notification build(NotificationCompat.Builder var1) {
         return NotificationCompatIceCreamSandwich.add(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate);
      }
   }

   static class NotificationCompatImplJellybean implements NotificationCompat.NotificationCompatImpl {
      public Notification build(NotificationCompat.Builder var1) {
         NotificationCompatJellybean var2 = new NotificationCompatJellybean(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mUseChronometer, var1.mPriority, var1.mSubText);
         Iterator var3 = var1.mActions.iterator();

         while(var3.hasNext()) {
            NotificationCompat.Action var7 = (NotificationCompat.Action)var3.next();
            var2.addAction(var7.icon, var7.title, var7.actionIntent);
         }

         if(var1.mStyle != null) {
            if(var1.mStyle instanceof NotificationCompat.BigTextStyle) {
               NotificationCompat.BigTextStyle var6 = (NotificationCompat.BigTextStyle)var1.mStyle;
               var2.addBigTextStyle(var6.mBigContentTitle, var6.mSummaryTextSet, var6.mSummaryText, var6.mBigText);
            } else if(var1.mStyle instanceof NotificationCompat.InboxStyle) {
               NotificationCompat.InboxStyle var5 = (NotificationCompat.InboxStyle)var1.mStyle;
               var2.addInboxStyle(var5.mBigContentTitle, var5.mSummaryTextSet, var5.mSummaryText, var5.mTexts);
            } else if(var1.mStyle instanceof NotificationCompat.BigPictureStyle) {
               NotificationCompat.BigPictureStyle var4 = (NotificationCompat.BigPictureStyle)var1.mStyle;
               var2.addBigPictureStyle(var4.mBigContentTitle, var4.mSummaryTextSet, var4.mSummaryText, var4.mPicture, var4.mBigLargeIcon, var4.mBigLargeIconSet);
            }
         }

         return var2.build();
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
}
