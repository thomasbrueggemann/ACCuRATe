package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.class_22;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

class NotificationCompatImplBase {
   static final int MAX_MEDIA_BUTTONS = 5;
   static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

   private static RemoteViews applyStandardTemplate(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, int var10, boolean var11) {
      RemoteViews var12 = new RemoteViews(var0.getPackageName(), var10);
      if(var5 != null && VERSION.SDK_INT >= 16) {
         var12.setViewVisibility(class_22.class_93.icon, 0);
         var12.setImageViewBitmap(class_22.class_93.icon, var5);
      } else {
         var12.setViewVisibility(class_22.class_93.icon, 8);
      }

      if(var1 != null) {
         var12.setTextViewText(class_22.class_93.title, var1);
      }

      boolean var13 = false;
      if(var2 != null) {
         var12.setTextViewText(class_22.class_93.text, var2);
         var13 = true;
      }

      if(var3 != null) {
         var12.setTextViewText(class_22.class_93.info, var3);
         var12.setViewVisibility(class_22.class_93.info, 0);
         var13 = true;
      } else if(var4 > 0) {
         if(var4 > var0.getResources().getInteger(class_22.integer.status_bar_notification_info_maxnum)) {
            var12.setTextViewText(class_22.class_93.info, var0.getResources().getString(class_22.string.status_bar_notification_info_overflow));
         } else {
            NumberFormat var19 = NumberFormat.getIntegerInstance();
            var12.setTextViewText(class_22.class_93.info, var19.format((long)var4));
         }

         var12.setViewVisibility(class_22.class_93.info, 0);
         var13 = true;
      } else {
         var12.setViewVisibility(class_22.class_93.info, 8);
      }

      boolean var14 = false;
      if(var6 != null) {
         int var18 = VERSION.SDK_INT;
         var14 = false;
         if(var18 >= 16) {
            var12.setTextViewText(class_22.class_93.text, var6);
            if(var2 != null) {
               var12.setTextViewText(class_22.class_93.text2, var2);
               var12.setViewVisibility(class_22.class_93.text2, 0);
               var14 = true;
            } else {
               var12.setViewVisibility(class_22.class_93.text2, 8);
               var14 = false;
            }
         }
      }

      if(var14 && VERSION.SDK_INT >= 16) {
         if(var11) {
            float var17 = (float)var0.getResources().getDimensionPixelSize(class_22.dimen.notification_subtext_size);
            var12.setTextViewTextSize(class_22.class_93.text, 0, var17);
         }

         var12.setViewPadding(class_22.class_93.line1, 0, 0, 0, 0);
      }

      if(var8 != 0L) {
         if(var7) {
            var12.setViewVisibility(class_22.class_93.chronometer, 0);
            var12.setLong(class_22.class_93.chronometer, "setBase", var8 + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
            var12.setBoolean(class_22.class_93.chronometer, "setStarted", true);
         } else {
            var12.setViewVisibility(class_22.class_93.time, 0);
            var12.setLong(class_22.class_93.time, "setTime", var8);
         }
      }

      int var15 = class_22.class_93.line3;
      byte var16;
      if(var13) {
         var16 = 0;
      } else {
         var16 = 8;
      }

      var12.setViewVisibility(var15, var16);
      return var12;
   }

   private static <T extends NotificationCompatBase.Action> RemoteViews generateBigContentView(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, List<T> var10, boolean var11, PendingIntent var12) {
      int var13 = Math.min(var10.size(), 5);
      RemoteViews var14 = applyStandardTemplate(var0, var1, var2, var3, var4, var5, var6, var7, var8, getBigLayoutResource(var13), false);
      var14.removeAllViews(class_22.class_93.media_actions);
      if(var13 > 0) {
         for(int var15 = 0; var15 < var13; ++var15) {
            RemoteViews var16 = generateMediaActionButton(var0, (NotificationCompatBase.Action)var10.get(var15));
            var14.addView(class_22.class_93.media_actions, var16);
         }
      }

      if(var11) {
         var14.setViewVisibility(class_22.class_93.cancel_action, 0);
         var14.setInt(class_22.class_93.cancel_action, "setAlpha", var0.getResources().getInteger(class_22.integer.cancel_button_image_alpha));
         var14.setOnClickPendingIntent(class_22.class_93.cancel_action, var12);
         return var14;
      } else {
         var14.setViewVisibility(class_22.class_93.cancel_action, 8);
         return var14;
      }
   }

   private static <T extends NotificationCompatBase.Action> RemoteViews generateContentView(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, List<T> var10, int[] var11, boolean var12, PendingIntent var13) {
      RemoteViews var14 = applyStandardTemplate(var0, var1, var2, var3, var4, var5, var6, var7, var8, class_22.layout.notification_template_media, true);
      int var15 = var10.size();
      int var16;
      if(var11 == null) {
         var16 = 0;
      } else {
         var16 = Math.min(var11.length, 3);
      }

      var14.removeAllViews(class_22.class_93.media_actions);
      if(var16 > 0) {
         for(int var17 = 0; var17 < var16; ++var17) {
            if(var17 >= var15) {
               Object[] var19 = new Object[]{Integer.valueOf(var17), Integer.valueOf(var15 - 1)};
               throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", var19));
            }

            RemoteViews var18 = generateMediaActionButton(var0, (NotificationCompatBase.Action)var10.get(var11[var17]));
            var14.addView(class_22.class_93.media_actions, var18);
         }
      }

      if(var12) {
         var14.setViewVisibility(class_22.class_93.end_padder, 8);
         var14.setViewVisibility(class_22.class_93.cancel_action, 0);
         var14.setOnClickPendingIntent(class_22.class_93.cancel_action, var13);
         var14.setInt(class_22.class_93.cancel_action, "setAlpha", var0.getResources().getInteger(class_22.integer.cancel_button_image_alpha));
         return var14;
      } else {
         var14.setViewVisibility(class_22.class_93.end_padder, 0);
         var14.setViewVisibility(class_22.class_93.cancel_action, 8);
         return var14;
      }
   }

   private static RemoteViews generateMediaActionButton(Context var0, NotificationCompatBase.Action var1) {
      boolean var2;
      if(var1.getActionIntent() == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      RemoteViews var3 = new RemoteViews(var0.getPackageName(), class_22.layout.notification_media_action);
      var3.setImageViewResource(class_22.class_93.action0, var1.getIcon());
      if(!var2) {
         var3.setOnClickPendingIntent(class_22.class_93.action0, var1.getActionIntent());
      }

      if(VERSION.SDK_INT >= 15) {
         var3.setContentDescription(class_22.class_93.action0, var1.getTitle());
      }

      return var3;
   }

   private static int getBigLayoutResource(int var0) {
      return var0 <= 3?class_22.layout.notification_template_big_media_narrow:class_22.layout.notification_template_big_media;
   }

   public static <T extends NotificationCompatBase.Action> void overrideBigContentView(Notification var0, Context var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, Bitmap var6, CharSequence var7, boolean var8, long var9, List<T> var11, boolean var12, PendingIntent var13) {
      var0.bigContentView = generateBigContentView(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13);
      if(var12) {
         var0.flags |= 2;
      }

   }

   public static <T extends NotificationCompatBase.Action> void overrideContentView(NotificationBuilderWithBuilderAccessor var0, Context var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, Bitmap var6, CharSequence var7, boolean var8, long var9, List<T> var11, int[] var12, boolean var13, PendingIntent var14) {
      RemoteViews var15 = generateContentView(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13, var14);
      var0.getBuilder().setContent(var15);
      if(var13) {
         var0.getBuilder().setOngoing(true);
      }

   }
}
