package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.NotificationCompatImpl21;
import android.support.v7.app.NotificationCompatImplBase;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {
   private static void addBigMediaStyleToBuilderJellybean(Notification var0, android.support.v4.app.NotificationCompat.Builder var1) {
      if(var1.mStyle instanceof NotificationCompat.MediaStyle) {
         NotificationCompat.MediaStyle var2 = (NotificationCompat.MediaStyle)var1.mStyle;
         NotificationCompatImplBase.overrideBigContentView(var0, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mNumber, var1.mLargeIcon, var1.mSubText, var1.mUseChronometer, var1.mNotification.when, var1.mActions, var2.mShowCancelButton, var2.mCancelButtonIntent);
      }

   }

   private static void addMediaStyleToBuilderIcs(NotificationBuilderWithBuilderAccessor var0, android.support.v4.app.NotificationCompat.Builder var1) {
      if(var1.mStyle instanceof NotificationCompat.MediaStyle) {
         NotificationCompat.MediaStyle var2 = (NotificationCompat.MediaStyle)var1.mStyle;
         NotificationCompatImplBase.overrideContentView(var0, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mNumber, var1.mLargeIcon, var1.mSubText, var1.mUseChronometer, var1.mNotification.when, var1.mActions, var2.mActionsToShowInCompact, var2.mShowCancelButton, var2.mCancelButtonIntent);
      }

   }

   private static void addMediaStyleToBuilderLollipop(NotificationBuilderWithBuilderAccessor var0, android.support.v4.app.NotificationCompat.Style var1) {
      if(var1 instanceof NotificationCompat.MediaStyle) {
         NotificationCompat.MediaStyle var2 = (NotificationCompat.MediaStyle)var1;
         int[] var3 = var2.mActionsToShowInCompact;
         Object var4;
         if(var2.mToken != null) {
            var4 = var2.mToken.getToken();
         } else {
            var4 = null;
         }

         NotificationCompatImpl21.addMediaStyle(var0, var3, var4);
      }

   }

   public static class Builder extends android.support.v4.app.NotificationCompat.Builder {
      public Builder(Context var1) {
         super(var1);
      }

      protected android.support.v4.app.NotificationCompat.BuilderExtender getExtender() {
         return (android.support.v4.app.NotificationCompat.BuilderExtender)(VERSION.SDK_INT >= 21?new NotificationCompat.LollipopExtender():(VERSION.SDK_INT >= 16?new NotificationCompat.JellybeanExtender():(VERSION.SDK_INT >= 14?new NotificationCompat.IceCreamSandwichExtender():super.getExtender())));
      }
   }

   private static class IceCreamSandwichExtender extends android.support.v4.app.NotificationCompat.BuilderExtender {
      private IceCreamSandwichExtender() {
      }

      // $FF: synthetic method
      IceCreamSandwichExtender(Object var1) {
         this();
      }

      public Notification build(android.support.v4.app.NotificationCompat.Builder var1, NotificationBuilderWithBuilderAccessor var2) {
         NotificationCompat.addMediaStyleToBuilderIcs(var2, var1);
         return var2.build();
      }
   }

   private static class JellybeanExtender extends android.support.v4.app.NotificationCompat.BuilderExtender {
      private JellybeanExtender() {
      }

      // $FF: synthetic method
      JellybeanExtender(Object var1) {
         this();
      }

      public Notification build(android.support.v4.app.NotificationCompat.Builder var1, NotificationBuilderWithBuilderAccessor var2) {
         NotificationCompat.addMediaStyleToBuilderIcs(var2, var1);
         Notification var3 = var2.build();
         NotificationCompat.addBigMediaStyleToBuilderJellybean(var3, var1);
         return var3;
      }
   }

   private static class LollipopExtender extends android.support.v4.app.NotificationCompat.BuilderExtender {
      private LollipopExtender() {
      }

      // $FF: synthetic method
      LollipopExtender(Object var1) {
         this();
      }

      public Notification build(android.support.v4.app.NotificationCompat.Builder var1, NotificationBuilderWithBuilderAccessor var2) {
         NotificationCompat.addMediaStyleToBuilderLollipop(var2, var1.mStyle);
         return var2.build();
      }
   }

   public static class MediaStyle extends android.support.v4.app.NotificationCompat.Style {
      int[] mActionsToShowInCompact = null;
      PendingIntent mCancelButtonIntent;
      boolean mShowCancelButton;
      MediaSessionCompat.Token mToken;

      public MediaStyle() {
      }

      public MediaStyle(android.support.v4.app.NotificationCompat.Builder var1) {
         this.setBuilder(var1);
      }

      public NotificationCompat.MediaStyle setCancelButtonIntent(PendingIntent var1) {
         this.mCancelButtonIntent = var1;
         return this;
      }

      public NotificationCompat.MediaStyle setMediaSession(MediaSessionCompat.Token var1) {
         this.mToken = var1;
         return this;
      }

      public NotificationCompat.MediaStyle setShowActionsInCompactView(int... var1) {
         this.mActionsToShowInCompact = var1;
         return this;
      }

      public NotificationCompat.MediaStyle setShowCancelButton(boolean var1) {
         this.mShowCancelButton = var1;
         return this;
      }
   }
}
