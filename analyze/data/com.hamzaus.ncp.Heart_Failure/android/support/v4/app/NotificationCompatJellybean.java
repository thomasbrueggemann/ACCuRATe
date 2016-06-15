package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.InboxStyle;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.BundleUtil;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatBase;
import android.support.v4.app.RemoteInputCompatJellybean;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class NotificationCompatJellybean {
   static final String EXTRA_ACTION_EXTRAS = "android.support.actionExtras";
   static final String EXTRA_GROUP_KEY = "android.support.groupKey";
   static final String EXTRA_GROUP_SUMMARY = "android.support.isGroupSummary";
   static final String EXTRA_LOCAL_ONLY = "android.support.localOnly";
   static final String EXTRA_REMOTE_INPUTS = "android.support.remoteInputs";
   static final String EXTRA_SORT_KEY = "android.support.sortKey";
   static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
   private static final String KEY_ACTION_INTENT = "actionIntent";
   private static final String KEY_EXTRAS = "extras";
   private static final String KEY_ICON = "icon";
   private static final String KEY_REMOTE_INPUTS = "remoteInputs";
   private static final String KEY_TITLE = "title";
   public static final String TAG = "NotificationCompat";
   private static Class<?> sActionClass;
   private static Field sActionIconField;
   private static Field sActionIntentField;
   private static Field sActionTitleField;
   private static boolean sActionsAccessFailed;
   private static Field sActionsField;
   private static final Object sActionsLock = new Object();
   private static Field sExtrasField;
   private static boolean sExtrasFieldAccessFailed;
   private static final Object sExtrasLock = new Object();

   public static void addBigPictureStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, Bitmap var4, Bitmap var5, boolean var6) {
      BigPictureStyle var7 = (new BigPictureStyle(var0.getBuilder())).setBigContentTitle(var1).bigPicture(var4);
      if(var6) {
         var7.bigLargeIcon(var5);
      }

      if(var2) {
         var7.setSummaryText(var3);
      }

   }

   public static void addBigTextStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, CharSequence var4) {
      BigTextStyle var5 = (new BigTextStyle(var0.getBuilder())).setBigContentTitle(var1).bigText(var4);
      if(var2) {
         var5.setSummaryText(var3);
      }

   }

   public static void addInboxStyle(NotificationBuilderWithBuilderAccessor var0, CharSequence var1, boolean var2, CharSequence var3, ArrayList<CharSequence> var4) {
      InboxStyle var5 = (new InboxStyle(var0.getBuilder())).setBigContentTitle(var1);
      if(var2) {
         var5.setSummaryText(var3);
      }

      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         var5.addLine((CharSequence)var6.next());
      }

   }

   public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> var0) {
      SparseArray var1 = null;
      int var2 = 0;

      for(int var3 = var0.size(); var2 < var3; ++var2) {
         Bundle var4 = (Bundle)var0.get(var2);
         if(var4 != null) {
            if(var1 == null) {
               var1 = new SparseArray();
            }

            var1.put(var2, var4);
         }
      }

      return var1;
   }

   private static boolean ensureActionReflectionReadyLocked() {
      boolean var0 = true;
      if(sActionsAccessFailed) {
         return false;
      } else {
         try {
            if(sActionsField == null) {
               sActionClass = Class.forName("android.app.Notification$Action");
               sActionIconField = sActionClass.getDeclaredField("icon");
               sActionTitleField = sActionClass.getDeclaredField("title");
               sActionIntentField = sActionClass.getDeclaredField("actionIntent");
               sActionsField = Notification.class.getDeclaredField("actions");
               sActionsField.setAccessible(true);
            }
         } catch (ClassNotFoundException var4) {
            Log.e("NotificationCompat", "Unable to access notification actions", var4);
            sActionsAccessFailed = var0;
         } catch (NoSuchFieldException var5) {
            Log.e("NotificationCompat", "Unable to access notification actions", var5);
            sActionsAccessFailed = var0;
         }

         if(sActionsAccessFailed) {
            var0 = false;
         }

         return var0;
      }
   }

   public static NotificationCompatBase.Action getAction(Notification param0, int param1, NotificationCompatBase.Factory param2, RemoteInputCompatBase.Factory param3) {
      // $FF: Couldn't be decompiled
   }

   public static int getActionCount(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   private static NotificationCompatBase.Action getActionFromBundle(Bundle var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      return var1.build(var0.getInt("icon"), var0.getCharSequence("title"), (PendingIntent)var0.getParcelable("actionIntent"), var0.getBundle("extras"), RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(var0, "remoteInputs"), var2));
   }

   private static Object[] getActionObjectsLocked(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      NotificationCompatBase.Action[] var3;
      if(var0 == null) {
         var3 = null;
      } else {
         var3 = var1.newArray(var0.size());

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4] = getActionFromBundle((Bundle)var0.get(var4), var1, var2);
         }
      }

      return var3;
   }

   private static Bundle getBundleForAction(NotificationCompatBase.Action var0) {
      Bundle var1 = new Bundle();
      var1.putInt("icon", var0.getIcon());
      var1.putCharSequence("title", var0.getTitle());
      var1.putParcelable("actionIntent", var0.getActionIntent());
      var1.putBundle("extras", var0.getExtras());
      var1.putParcelableArray("remoteInputs", RemoteInputCompatJellybean.toBundleArray(var0.getRemoteInputs()));
      return var1;
   }

   public static Bundle getExtras(Notification param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getGroup(Notification var0) {
      return getExtras(var0).getString("android.support.groupKey");
   }

   public static boolean getLocalOnly(Notification var0) {
      return getExtras(var0).getBoolean("android.support.localOnly");
   }

   public static ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompatBase.Action[] var0) {
      ArrayList var1;
      if(var0 == null) {
         var1 = null;
      } else {
         var1 = new ArrayList(var0.length);
         int var2 = var0.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.add(getBundleForAction(var0[var3]));
         }
      }

      return var1;
   }

   public static String getSortKey(Notification var0) {
      return getExtras(var0).getString("android.support.sortKey");
   }

   public static boolean isGroupSummary(Notification var0) {
      return getExtras(var0).getBoolean("android.support.isGroupSummary");
   }

   public static NotificationCompatBase.Action readAction(NotificationCompatBase.Factory var0, RemoteInputCompatBase.Factory var1, int var2, CharSequence var3, PendingIntent var4, Bundle var5) {
      RemoteInputCompatBase.RemoteInput[] var6 = null;
      if(var5 != null) {
         var6 = RemoteInputCompatJellybean.fromBundleArray(BundleUtil.getBundleArrayFromBundle(var5, "android.support.remoteInputs"), var1);
      }

      return var0.build(var2, var3, var4, var5, var6);
   }

   public static Bundle writeActionAndGetExtras(android.app.Notification.Builder var0, NotificationCompatBase.Action var1) {
      var0.addAction(var1.getIcon(), var1.getTitle(), var1.getActionIntent());
      Bundle var3 = new Bundle(var1.getExtras());
      if(var1.getRemoteInputs() != null) {
         var3.putParcelableArray("android.support.remoteInputs", RemoteInputCompatJellybean.toBundleArray(var1.getRemoteInputs()));
      }

      return var3;
   }

   public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
      // $FF: renamed from: b android.app.Notification.Builder
      private android.app.Notification.Builder field_3515;
      private List<Bundle> mActionExtrasList = new ArrayList();
      private final Bundle mExtras;

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

         this.field_3515 = var28.setFullScreenIntent(var9, var29).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var14).setPriority(var15).setProgress(var11, var12, var13);
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
         this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.field_3515, var1));
      }

      public Notification build() {
         Notification var1 = this.field_3515.build();
         Bundle var2 = NotificationCompatJellybean.getExtras(var1);
         Bundle var3 = new Bundle(this.mExtras);
         Iterator var4 = this.mExtras.keySet().iterator();

         while(var4.hasNext()) {
            String var6 = (String)var4.next();
            if(var2.containsKey(var6)) {
               var3.remove(var6);
            }
         }

         var2.putAll(var3);
         SparseArray var5 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
         if(var5 != null) {
            NotificationCompatJellybean.getExtras(var1).putSparseParcelableArray("android.support.actionExtras", var5);
         }

         return var1;
      }

      public android.app.Notification.Builder getBuilder() {
         return this.field_3515;
      }
   }
}
