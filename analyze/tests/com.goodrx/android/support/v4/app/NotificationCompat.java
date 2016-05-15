package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatApi20;
import android.support.v4.app.NotificationCompatApi21;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.NotificationCompatGingerbread;
import android.support.v4.app.NotificationCompatHoneycomb;
import android.support.v4.app.NotificationCompatIceCreamSandwich;
import android.support.v4.app.NotificationCompatJellybean;
import android.support.v4.app.NotificationCompatKitKat;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NotificationCompat {
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
   @ColorInt
   public static final int COLOR_DEFAULT = 0;
   public static final int DEFAULT_ALL = -1;
   public static final int DEFAULT_LIGHTS = 4;
   public static final int DEFAULT_SOUND = 1;
   public static final int DEFAULT_VIBRATE = 2;
   public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
   public static final String EXTRA_BIG_TEXT = "android.bigText";
   public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
   public static final String EXTRA_INFO_TEXT = "android.infoText";
   public static final String EXTRA_LARGE_ICON = "android.largeIcon";
   public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
   public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
   public static final String EXTRA_PEOPLE = "android.people";
   public static final String EXTRA_PICTURE = "android.picture";
   public static final String EXTRA_PROGRESS = "android.progress";
   public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
   public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
   public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
   public static final String EXTRA_SHOW_WHEN = "android.showWhen";
   public static final String EXTRA_SMALL_ICON = "android.icon";
   public static final String EXTRA_SUB_TEXT = "android.subText";
   public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
   public static final String EXTRA_TEMPLATE = "android.template";
   public static final String EXTRA_TEXT = "android.text";
   public static final String EXTRA_TEXT_LINES = "android.textLines";
   public static final String EXTRA_TITLE = "android.title";
   public static final String EXTRA_TITLE_BIG = "android.title.big";
   public static final int FLAG_AUTO_CANCEL = 16;
   public static final int FLAG_FOREGROUND_SERVICE = 64;
   public static final int FLAG_GROUP_SUMMARY = 512;
   public static final int FLAG_HIGH_PRIORITY = 128;
   public static final int FLAG_INSISTENT = 4;
   public static final int FLAG_LOCAL_ONLY = 256;
   public static final int FLAG_NO_CLEAR = 32;
   public static final int FLAG_ONGOING_EVENT = 2;
   public static final int FLAG_ONLY_ALERT_ONCE = 8;
   public static final int FLAG_SHOW_LIGHTS = 1;
   private static final NotificationCompat.NotificationCompatImpl IMPL;
   public static final int PRIORITY_DEFAULT = 0;
   public static final int PRIORITY_HIGH = 1;
   public static final int PRIORITY_LOW = -1;
   public static final int PRIORITY_MAX = 2;
   public static final int PRIORITY_MIN = -2;
   public static final int STREAM_DEFAULT = -1;
   public static final int VISIBILITY_PRIVATE = 0;
   public static final int VISIBILITY_PUBLIC = 1;
   public static final int VISIBILITY_SECRET = -1;

   static {
      if(VERSION.SDK_INT >= 21) {
         IMPL = new NotificationCompat.NotificationCompatImplApi21();
      } else if(VERSION.SDK_INT >= 20) {
         IMPL = new NotificationCompat.NotificationCompatImplApi20();
      } else if(VERSION.SDK_INT >= 19) {
         IMPL = new NotificationCompat.NotificationCompatImplKitKat();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new NotificationCompat.NotificationCompatImplJellybean();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new NotificationCompat.NotificationCompatImplIceCreamSandwich();
      } else if(VERSION.SDK_INT >= 11) {
         IMPL = new NotificationCompat.NotificationCompatImplHoneycomb();
      } else if(VERSION.SDK_INT >= 9) {
         IMPL = new NotificationCompat.NotificationCompatImplGingerbread();
      } else {
         IMPL = new NotificationCompat.NotificationCompatImplBase();
      }
   }

   private static void addActionsToBuilder(NotificationBuilderWithActions var0, ArrayList<NotificationCompat.Action> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         var0.addAction((NotificationCompat.Action)var2.next());
      }

   }

   private static void addStyleToBuilderJellybean(NotificationBuilderWithBuilderAccessor var0, NotificationCompat.Style var1) {
      if(var1 != null) {
         if(var1 instanceof NotificationCompat.BigTextStyle) {
            NotificationCompat.BigTextStyle var4 = (NotificationCompat.BigTextStyle)var1;
            NotificationCompatJellybean.addBigTextStyle(var0, var4.mBigContentTitle, var4.mSummaryTextSet, var4.mSummaryText, var4.mBigText);
         } else {
            if(var1 instanceof NotificationCompat.InboxStyle) {
               NotificationCompat.InboxStyle var3 = (NotificationCompat.InboxStyle)var1;
               NotificationCompatJellybean.addInboxStyle(var0, var3.mBigContentTitle, var3.mSummaryTextSet, var3.mSummaryText, var3.mTexts);
               return;
            }

            if(var1 instanceof NotificationCompat.BigPictureStyle) {
               NotificationCompat.BigPictureStyle var2 = (NotificationCompat.BigPictureStyle)var1;
               NotificationCompatJellybean.addBigPictureStyle(var0, var2.mBigContentTitle, var2.mSummaryTextSet, var2.mSummaryText, var2.mPicture, var2.mBigLargeIcon, var2.mBigLargeIconSet);
               return;
            }
         }
      }

   }

   public static NotificationCompat.Action getAction(Notification var0, int var1) {
      return IMPL.getAction(var0, var1);
   }

   public static int getActionCount(Notification var0) {
      return IMPL.getActionCount(var0);
   }

   public static String getCategory(Notification var0) {
      return IMPL.getCategory(var0);
   }

   public static Bundle getExtras(Notification var0) {
      return IMPL.getExtras(var0);
   }

   public static String getGroup(Notification var0) {
      return IMPL.getGroup(var0);
   }

   public static boolean getLocalOnly(Notification var0) {
      return IMPL.getLocalOnly(var0);
   }

   private static Notification[] getNotificationArrayFromBundle(Bundle var0, String var1) {
      Parcelable[] var2 = var0.getParcelableArray(var1);
      if(!(var2 instanceof Notification[]) && var2 != null) {
         Notification[] var3 = new Notification[var2.length];

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var3[var4] = (Notification)var2[var4];
         }

         var0.putParcelableArray(var1, var3);
         return var3;
      } else {
         return (Notification[])((Notification[])var2);
      }
   }

   public static String getSortKey(Notification var0) {
      return IMPL.getSortKey(var0);
   }

   public static boolean isGroupSummary(Notification var0) {
      return IMPL.isGroupSummary(var0);
   }

   public static class Action extends NotificationCompatBase.Action {
      public static final NotificationCompatBase.Factory FACTORY = new NotificationCompatBase.Factory() {
         public NotificationCompat.Action build(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInputCompatBase.RemoteInput[] var5) {
            return new NotificationCompat.Action(var1, var2, var3, var4, (RemoteInput[])((RemoteInput[])var5));
         }

         public NotificationCompat.Action[] newArray(int var1) {
            return new NotificationCompat.Action[var1];
         }
      };
      public PendingIntent actionIntent;
      public int icon;
      private final Bundle mExtras;
      private final RemoteInput[] mRemoteInputs;
      public CharSequence title;

      public Action(int var1, CharSequence var2, PendingIntent var3) {
         this(var1, var2, var3, new Bundle(), (RemoteInput[])null);
      }

      private Action(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInput[] var5) {
         this.icon = var1;
         this.title = NotificationCompat.Builder.limitCharSequenceLength(var2);
         this.actionIntent = var3;
         if(var4 == null) {
            var4 = new Bundle();
         }

         this.mExtras = var4;
         this.mRemoteInputs = var5;
      }

      // $FF: synthetic method
      Action(int var1, CharSequence var2, PendingIntent var3, Bundle var4, RemoteInput[] var5, Object var6) {
         this(var1, var2, var3, var4, var5);
      }

      public PendingIntent getActionIntent() {
         return this.actionIntent;
      }

      public Bundle getExtras() {
         return this.mExtras;
      }

      public int getIcon() {
         return this.icon;
      }

      public RemoteInput[] getRemoteInputs() {
         return this.mRemoteInputs;
      }

      public CharSequence getTitle() {
         return this.title;
      }
   }

   public static final class Builder {
      private final Bundle mExtras;
      private final int mIcon;
      private final PendingIntent mIntent;
      private ArrayList<RemoteInput> mRemoteInputs;
      private final CharSequence mTitle;

      public Builder(int var1, CharSequence var2, PendingIntent var3) {
         this(var1, var2, var3, new Bundle());
      }

      private Builder(int var1, CharSequence var2, PendingIntent var3, Bundle var4) {
         this.mIcon = var1;
         this.mTitle = NotificationCompat.Builder.limitCharSequenceLength(var2);
         this.mIntent = var3;
         this.mExtras = var4;
      }

      public Builder(NotificationCompat.Action var1) {
         this(var1.icon, var1.title, var1.actionIntent, new Bundle(var1.mExtras));
      }

      public NotificationCompat.Builder addExtras(Bundle var1) {
         if(var1 != null) {
            this.mExtras.putAll(var1);
         }

         return this;
      }

      public NotificationCompat.Builder addRemoteInput(RemoteInput var1) {
         if(this.mRemoteInputs == null) {
            this.mRemoteInputs = new ArrayList();
         }

         this.mRemoteInputs.add(var1);
         return this;
      }

      public NotificationCompat.Action build() {
         RemoteInput[] var1;
         if(this.mRemoteInputs != null) {
            var1 = (RemoteInput[])this.mRemoteInputs.toArray(new RemoteInput[this.mRemoteInputs.size()]);
         } else {
            var1 = null;
         }

         return new NotificationCompat.Action(this.mIcon, this.mTitle, this.mIntent, this.mExtras, var1);
      }

      public NotificationCompat.Builder extend(NotificationCompat.Extender var1) {
         var1.extend(this);
         return this;
      }

      public Bundle getExtras() {
         return this.mExtras;
      }
   }

   public interface Extender {
      NotificationCompat.Builder extend(NotificationCompat.Builder var1);
   }

   public static final class WearableExtender implements NotificationCompat.Extender {
      private static final int DEFAULT_FLAGS = 1;
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      private static final int FLAG_AVAILABLE_OFFLINE = 1;
      private static final String KEY_CANCEL_LABEL = "cancelLabel";
      private static final String KEY_CONFIRM_LABEL = "confirmLabel";
      private static final String KEY_FLAGS = "flags";
      private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
      private CharSequence mCancelLabel;
      private CharSequence mConfirmLabel;
      private int mFlags = 1;
      private CharSequence mInProgressLabel;

      public WearableExtender() {
      }

      public WearableExtender(NotificationCompat.Action var1) {
         Bundle var2 = var1.getExtras().getBundle("android.wearable.EXTENSIONS");
         if(var2 != null) {
            this.mFlags = var2.getInt("flags", 1);
            this.mInProgressLabel = var2.getCharSequence("inProgressLabel");
            this.mConfirmLabel = var2.getCharSequence("confirmLabel");
            this.mCancelLabel = var2.getCharSequence("cancelLabel");
         }

      }

      private void setFlag(int var1, boolean var2) {
         if(var2) {
            this.mFlags |= var1;
         } else {
            this.mFlags &= ~var1;
         }
      }

      public NotificationCompat.WearableExtender clone() {
         NotificationCompat.WearableExtender var1 = new NotificationCompat.WearableExtender();
         var1.mFlags = this.mFlags;
         var1.mInProgressLabel = this.mInProgressLabel;
         var1.mConfirmLabel = this.mConfirmLabel;
         var1.mCancelLabel = this.mCancelLabel;
         return var1;
      }

      public NotificationCompat.Builder extend(NotificationCompat.Builder var1) {
         Bundle var2 = new Bundle();
         if(this.mFlags != 1) {
            var2.putInt("flags", this.mFlags);
         }

         if(this.mInProgressLabel != null) {
            var2.putCharSequence("inProgressLabel", this.mInProgressLabel);
         }

         if(this.mConfirmLabel != null) {
            var2.putCharSequence("confirmLabel", this.mConfirmLabel);
         }

         if(this.mCancelLabel != null) {
            var2.putCharSequence("cancelLabel", this.mCancelLabel);
         }

         var1.getExtras().putBundle("android.wearable.EXTENSIONS", var2);
         return var1;
      }

      public CharSequence getCancelLabel() {
         return this.mCancelLabel;
      }

      public CharSequence getConfirmLabel() {
         return this.mConfirmLabel;
      }

      public CharSequence getInProgressLabel() {
         return this.mInProgressLabel;
      }

      public boolean isAvailableOffline() {
         return (1 & this.mFlags) != 0;
      }

      public NotificationCompat.WearableExtender setAvailableOffline(boolean var1) {
         this.setFlag(1, var1);
         return this;
      }

      public NotificationCompat.WearableExtender setCancelLabel(CharSequence var1) {
         this.mCancelLabel = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setConfirmLabel(CharSequence var1) {
         this.mConfirmLabel = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setInProgressLabel(CharSequence var1) {
         this.mInProgressLabel = var1;
         return this;
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
         this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.BigPictureStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(var1);
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
         this.mBigText = NotificationCompat.Builder.limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.BigTextStyle setBigContentTitle(CharSequence var1) {
         this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.BigTextStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(var1);
         this.mSummaryTextSet = true;
         return this;
      }
   }

   public static class Builder {
      private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
      public ArrayList<NotificationCompat.Action> mActions = new ArrayList();
      String mCategory;
      int mColor = 0;
      public CharSequence mContentInfo;
      PendingIntent mContentIntent;
      public CharSequence mContentText;
      public CharSequence mContentTitle;
      public Context mContext;
      Bundle mExtras;
      PendingIntent mFullScreenIntent;
      String mGroupKey;
      boolean mGroupSummary;
      public Bitmap mLargeIcon;
      boolean mLocalOnly = false;
      public Notification mNotification = new Notification();
      public int mNumber;
      public ArrayList<String> mPeople;
      int mPriority;
      int mProgress;
      boolean mProgressIndeterminate;
      int mProgressMax;
      Notification mPublicVersion;
      boolean mShowWhen = true;
      String mSortKey;
      public NotificationCompat.Style mStyle;
      public CharSequence mSubText;
      RemoteViews mTickerView;
      public boolean mUseChronometer;
      int mVisibility = 0;

      public Builder(Context var1) {
         this.mContext = var1;
         this.mNotification.when = System.currentTimeMillis();
         this.mNotification.audioStreamType = -1;
         this.mPriority = 0;
         this.mPeople = new ArrayList();
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

      public NotificationCompat.Builder addAction(int var1, CharSequence var2, PendingIntent var3) {
         this.mActions.add(new NotificationCompat.Action(var1, var2, var3));
         return this;
      }

      public NotificationCompat.Builder addAction(NotificationCompat.Action var1) {
         this.mActions.add(var1);
         return this;
      }

      public NotificationCompat.Builder addExtras(Bundle var1) {
         if(var1 != null) {
            if(this.mExtras != null) {
               this.mExtras.putAll(var1);
               return this;
            }

            this.mExtras = new Bundle(var1);
         }

         return this;
      }

      public NotificationCompat.Builder addPerson(String var1) {
         this.mPeople.add(var1);
         return this;
      }

      public Notification build() {
         return NotificationCompat.IMPL.build(this, this.getExtender());
      }

      public NotificationCompat.Builder extend(NotificationCompat.Extender var1) {
         var1.extend(this);
         return this;
      }

      protected NotificationCompat.BuilderExtender getExtender() {
         return new NotificationCompat.BuilderExtender();
      }

      public Bundle getExtras() {
         if(this.mExtras == null) {
            this.mExtras = new Bundle();
         }

         return this.mExtras;
      }

      @Deprecated
      public Notification getNotification() {
         return this.build();
      }

      public NotificationCompat.Builder setAutoCancel(boolean var1) {
         this.setFlag(16, var1);
         return this;
      }

      public NotificationCompat.Builder setCategory(String var1) {
         this.mCategory = var1;
         return this;
      }

      public NotificationCompat.Builder setColor(@ColorInt int var1) {
         this.mColor = var1;
         return this;
      }

      public NotificationCompat.Builder setContent(RemoteViews var1) {
         this.mNotification.contentView = var1;
         return this;
      }

      public NotificationCompat.Builder setContentInfo(CharSequence var1) {
         this.mContentInfo = limitCharSequenceLength(var1);
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

      public NotificationCompat.Builder setExtras(Bundle var1) {
         this.mExtras = var1;
         return this;
      }

      public NotificationCompat.Builder setFullScreenIntent(PendingIntent var1, boolean var2) {
         this.mFullScreenIntent = var1;
         this.setFlag(128, var2);
         return this;
      }

      public NotificationCompat.Builder setGroup(String var1) {
         this.mGroupKey = var1;
         return this;
      }

      public NotificationCompat.Builder setGroupSummary(boolean var1) {
         this.mGroupSummary = var1;
         return this;
      }

      public NotificationCompat.Builder setLargeIcon(Bitmap var1) {
         this.mLargeIcon = var1;
         return this;
      }

      public NotificationCompat.Builder setLights(@ColorInt int var1, int var2, int var3) {
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

      public NotificationCompat.Builder setLocalOnly(boolean var1) {
         this.mLocalOnly = var1;
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

      public NotificationCompat.Builder setPublicVersion(Notification var1) {
         this.mPublicVersion = var1;
         return this;
      }

      public NotificationCompat.Builder setShowWhen(boolean var1) {
         this.mShowWhen = var1;
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

      public NotificationCompat.Builder setSortKey(String var1) {
         this.mSortKey = var1;
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
         this.mSubText = limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.Builder setTicker(CharSequence var1) {
         this.mNotification.tickerText = limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.Builder setTicker(CharSequence var1, RemoteViews var2) {
         this.mNotification.tickerText = limitCharSequenceLength(var1);
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

      public NotificationCompat.Builder setVisibility(int var1) {
         this.mVisibility = var1;
         return this;
      }

      public NotificationCompat.Builder setWhen(long var1) {
         this.mNotification.when = var1;
         return this;
      }
   }

   protected static class BuilderExtender {
      public Notification build(NotificationCompat.Builder var1, NotificationBuilderWithBuilderAccessor var2) {
         return var2.build();
      }
   }

   public static final class CarExtender implements NotificationCompat.Extender {
      private static final String EXTRA_CAR_EXTENDER = "android.car.EXTENSIONS";
      private static final String EXTRA_COLOR = "app_color";
      private static final String EXTRA_CONVERSATION = "car_conversation";
      private static final String EXTRA_LARGE_ICON = "large_icon";
      private static final String TAG = "CarExtender";
      private int mColor = 0;
      private Bitmap mLargeIcon;
      private NotificationCompat.UnreadConversation mUnreadConversation;

      public CarExtender() {
      }

      public CarExtender(Notification var1) {
         if(VERSION.SDK_INT >= 21) {
            Bundle var2;
            if(NotificationCompat.getExtras(var1) == null) {
               var2 = null;
            } else {
               var2 = NotificationCompat.getExtras(var1).getBundle("android.car.EXTENSIONS");
            }

            if(var2 != null) {
               this.mLargeIcon = (Bitmap)var2.getParcelable("large_icon");
               this.mColor = var2.getInt("app_color", 0);
               Bundle var3 = var2.getBundle("car_conversation");
               this.mUnreadConversation = (NotificationCompat.UnreadConversation)NotificationCompat.IMPL.getUnreadConversationFromBundle(var3, NotificationCompat.UnreadConversation.FACTORY, RemoteInput.FACTORY);
               return;
            }
         }

      }

      public NotificationCompat.Builder extend(NotificationCompat.Builder var1) {
         if(VERSION.SDK_INT < 21) {
            return var1;
         } else {
            Bundle var2 = new Bundle();
            if(this.mLargeIcon != null) {
               var2.putParcelable("large_icon", this.mLargeIcon);
            }

            if(this.mColor != 0) {
               var2.putInt("app_color", this.mColor);
            }

            if(this.mUnreadConversation != null) {
               var2.putBundle("car_conversation", NotificationCompat.IMPL.getBundleForUnreadConversation(this.mUnreadConversation));
            }

            var1.getExtras().putBundle("android.car.EXTENSIONS", var2);
            return var1;
         }
      }

      @ColorInt
      public int getColor() {
         return this.mColor;
      }

      public Bitmap getLargeIcon() {
         return this.mLargeIcon;
      }

      public NotificationCompat.UnreadConversation getUnreadConversation() {
         return this.mUnreadConversation;
      }

      public NotificationCompat.CarExtender setColor(@ColorInt int var1) {
         this.mColor = var1;
         return this;
      }

      public NotificationCompat.CarExtender setLargeIcon(Bitmap var1) {
         this.mLargeIcon = var1;
         return this;
      }

      public NotificationCompat.CarExtender setUnreadConversation(NotificationCompat.UnreadConversation var1) {
         this.mUnreadConversation = var1;
         return this;
      }
   }

   public static class UnreadConversation extends NotificationCompatBase.UnreadConversation {
      static final NotificationCompatBase.Factory FACTORY = new NotificationCompatBase.Factory() {
         public NotificationCompat.UnreadConversation build(String[] var1, RemoteInputCompatBase.RemoteInput var2, PendingIntent var3, PendingIntent var4, String[] var5, long var6) {
            return new NotificationCompat.UnreadConversation(var1, (RemoteInput)var2, var3, var4, var5, var6);
         }
      };
      private final long mLatestTimestamp;
      private final String[] mMessages;
      private final String[] mParticipants;
      private final PendingIntent mReadPendingIntent;
      private final RemoteInput mRemoteInput;
      private final PendingIntent mReplyPendingIntent;

      UnreadConversation(String[] var1, RemoteInput var2, PendingIntent var3, PendingIntent var4, String[] var5, long var6) {
         this.mMessages = var1;
         this.mRemoteInput = var2;
         this.mReadPendingIntent = var4;
         this.mReplyPendingIntent = var3;
         this.mParticipants = var5;
         this.mLatestTimestamp = var6;
      }

      public long getLatestTimestamp() {
         return this.mLatestTimestamp;
      }

      public String[] getMessages() {
         return this.mMessages;
      }

      public String getParticipant() {
         return this.mParticipants.length > 0?this.mParticipants[0]:null;
      }

      public String[] getParticipants() {
         return this.mParticipants;
      }

      public PendingIntent getReadPendingIntent() {
         return this.mReadPendingIntent;
      }

      public RemoteInput getRemoteInput() {
         return this.mRemoteInput;
      }

      public PendingIntent getReplyPendingIntent() {
         return this.mReplyPendingIntent;
      }
   }

   public static class Builder {
      private long mLatestTimestamp;
      private final List<String> mMessages = new ArrayList();
      private final String mParticipant;
      private PendingIntent mReadPendingIntent;
      private RemoteInput mRemoteInput;
      private PendingIntent mReplyPendingIntent;

      public Builder(String var1) {
         this.mParticipant = var1;
      }

      public NotificationCompat.Builder addMessage(String var1) {
         this.mMessages.add(var1);
         return this;
      }

      public NotificationCompat.UnreadConversation build() {
         String[] var1 = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
         String[] var2 = new String[]{this.mParticipant};
         return new NotificationCompat.UnreadConversation(var1, this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, var2, this.mLatestTimestamp);
      }

      public NotificationCompat.Builder setLatestTimestamp(long var1) {
         this.mLatestTimestamp = var1;
         return this;
      }

      public NotificationCompat.Builder setReadPendingIntent(PendingIntent var1) {
         this.mReadPendingIntent = var1;
         return this;
      }

      public NotificationCompat.Builder setReplyAction(PendingIntent var1, RemoteInput var2) {
         this.mRemoteInput = var2;
         this.mReplyPendingIntent = var1;
         return this;
      }
   }

   public interface Extender {
      NotificationCompat.Builder extend(NotificationCompat.Builder var1);
   }

   public static class InboxStyle extends NotificationCompat.Style {
      ArrayList<CharSequence> mTexts = new ArrayList();

      public InboxStyle() {
      }

      public InboxStyle(NotificationCompat.Builder var1) {
         this.setBuilder(var1);
      }

      public NotificationCompat.InboxStyle addLine(CharSequence var1) {
         this.mTexts.add(NotificationCompat.Builder.limitCharSequenceLength(var1));
         return this;
      }

      public NotificationCompat.InboxStyle setBigContentTitle(CharSequence var1) {
         this.mBigContentTitle = NotificationCompat.Builder.limitCharSequenceLength(var1);
         return this;
      }

      public NotificationCompat.InboxStyle setSummaryText(CharSequence var1) {
         this.mSummaryText = NotificationCompat.Builder.limitCharSequenceLength(var1);
         this.mSummaryTextSet = true;
         return this;
      }
   }

   interface NotificationCompatImpl {
      Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2);

      NotificationCompat.Action getAction(Notification var1, int var2);

      int getActionCount(Notification var1);

      NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1);

      Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation var1);

      String getCategory(Notification var1);

      Bundle getExtras(Notification var1);

      String getGroup(Notification var1);

      boolean getLocalOnly(Notification var1);

      ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] var1);

      String getSortKey(Notification var1);

      NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3);

      boolean isGroupSummary(Notification var1);
   }

   static class NotificationCompatImplApi20 extends NotificationCompat.NotificationCompatImplKitKat {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         NotificationCompatApi20.Builder var3 = new NotificationCompatApi20.Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mShowWhen, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mPeople, var1.mExtras, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
         NotificationCompat.addActionsToBuilder(var3, var1.mActions);
         NotificationCompat.addStyleToBuilderJellybean(var3, var1.mStyle);
         return var2.build(var1, var3);
      }

      public NotificationCompat.Action getAction(Notification var1, int var2) {
         return (NotificationCompat.Action)NotificationCompatApi20.getAction(var1, var2, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
      }

      public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1) {
         return (NotificationCompat.Action[])((NotificationCompat.Action[])NotificationCompatApi20.getActionsFromParcelableArrayList(var1, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY));
      }

      public String getGroup(Notification var1) {
         return NotificationCompatApi20.getGroup(var1);
      }

      public boolean getLocalOnly(Notification var1) {
         return NotificationCompatApi20.getLocalOnly(var1);
      }

      public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] var1) {
         return NotificationCompatApi20.getParcelableArrayListForActions(var1);
      }

      public String getSortKey(Notification var1) {
         return NotificationCompatApi20.getSortKey(var1);
      }

      public boolean isGroupSummary(Notification var1) {
         return NotificationCompatApi20.isGroupSummary(var1);
      }
   }

   static class NotificationCompatImplApi21 extends NotificationCompat.NotificationCompatImplApi20 {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         NotificationCompatApi21.Builder var3 = new NotificationCompatApi21.Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mShowWhen, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mCategory, var1.mPeople, var1.mExtras, var1.mColor, var1.mVisibility, var1.mPublicVersion, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
         NotificationCompat.addActionsToBuilder(var3, var1.mActions);
         NotificationCompat.addStyleToBuilderJellybean(var3, var1.mStyle);
         return var2.build(var1, var3);
      }

      public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation var1) {
         return NotificationCompatApi21.getBundleForUnreadConversation(var1);
      }

      public String getCategory(Notification var1) {
         return NotificationCompatApi21.getCategory(var1);
      }

      public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3) {
         return NotificationCompatApi21.getUnreadConversationFromBundle(var1, var2, var3);
      }
   }

   static class NotificationCompatImplBase implements NotificationCompat.NotificationCompatImpl {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         Notification var3 = NotificationCompatBase.add(var1.mNotification, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent);
         if(var1.mPriority > 0) {
            var3.flags |= 128;
         }

         return var3;
      }

      public NotificationCompat.Action getAction(Notification var1, int var2) {
         return null;
      }

      public int getActionCount(Notification var1) {
         return 0;
      }

      public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1) {
         return null;
      }

      public Bundle getBundleForUnreadConversation(NotificationCompatBase.UnreadConversation var1) {
         return null;
      }

      public String getCategory(Notification var1) {
         return null;
      }

      public Bundle getExtras(Notification var1) {
         return null;
      }

      public String getGroup(Notification var1) {
         return null;
      }

      public boolean getLocalOnly(Notification var1) {
         return false;
      }

      public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] var1) {
         return null;
      }

      public String getSortKey(Notification var1) {
         return null;
      }

      public NotificationCompatBase.UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3) {
         return null;
      }

      public boolean isGroupSummary(Notification var1) {
         return false;
      }
   }

   static class NotificationCompatImplGingerbread extends NotificationCompat.NotificationCompatImplBase {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         Notification var3 = NotificationCompatGingerbread.add(var1.mNotification, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent, var1.mFullScreenIntent);
         if(var1.mPriority > 0) {
            var3.flags |= 128;
         }

         return var3;
      }
   }

   static class NotificationCompatImplHoneycomb extends NotificationCompat.NotificationCompatImplBase {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         return NotificationCompatHoneycomb.add(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon);
      }
   }

   static class NotificationCompatImplIceCreamSandwich extends NotificationCompat.NotificationCompatImplBase {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         return var2.build(var1, new NotificationCompatIceCreamSandwich.Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate));
      }
   }

   static class NotificationCompatImplJellybean extends NotificationCompat.NotificationCompatImplBase {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         NotificationCompatJellybean.Builder var3 = new NotificationCompatJellybean.Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mExtras, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
         NotificationCompat.addActionsToBuilder(var3, var1.mActions);
         NotificationCompat.addStyleToBuilderJellybean(var3, var1.mStyle);
         return var2.build(var1, var3);
      }

      public NotificationCompat.Action getAction(Notification var1, int var2) {
         return (NotificationCompat.Action)NotificationCompatJellybean.getAction(var1, var2, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
      }

      public int getActionCount(Notification var1) {
         return NotificationCompatJellybean.getActionCount(var1);
      }

      public NotificationCompat.Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1) {
         return (NotificationCompat.Action[])((NotificationCompat.Action[])NotificationCompatJellybean.getActionsFromParcelableArrayList(var1, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY));
      }

      public Bundle getExtras(Notification var1) {
         return NotificationCompatJellybean.getExtras(var1);
      }

      public String getGroup(Notification var1) {
         return NotificationCompatJellybean.getGroup(var1);
      }

      public boolean getLocalOnly(Notification var1) {
         return NotificationCompatJellybean.getLocalOnly(var1);
      }

      public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat.Action[] var1) {
         return NotificationCompatJellybean.getParcelableArrayListForActions(var1);
      }

      public String getSortKey(Notification var1) {
         return NotificationCompatJellybean.getSortKey(var1);
      }

      public boolean isGroupSummary(Notification var1) {
         return NotificationCompatJellybean.isGroupSummary(var1);
      }
   }

   static class NotificationCompatImplKitKat extends NotificationCompat.NotificationCompatImplJellybean {
      public Notification build(NotificationCompat.Builder var1, NotificationCompat.BuilderExtender var2) {
         NotificationCompatKitKat.Builder var3 = new NotificationCompatKitKat.Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mShowWhen, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mPeople, var1.mExtras, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
         NotificationCompat.addActionsToBuilder(var3, var1.mActions);
         NotificationCompat.addStyleToBuilderJellybean(var3, var1.mStyle);
         return var2.build(var1, var3);
      }

      public NotificationCompat.Action getAction(Notification var1, int var2) {
         return (NotificationCompat.Action)NotificationCompatKitKat.getAction(var1, var2, NotificationCompat.Action.FACTORY, RemoteInput.FACTORY);
      }

      public int getActionCount(Notification var1) {
         return NotificationCompatKitKat.getActionCount(var1);
      }

      public Bundle getExtras(Notification var1) {
         return NotificationCompatKitKat.getExtras(var1);
      }

      public String getGroup(Notification var1) {
         return NotificationCompatKitKat.getGroup(var1);
      }

      public boolean getLocalOnly(Notification var1) {
         return NotificationCompatKitKat.getLocalOnly(var1);
      }

      public String getSortKey(Notification var1) {
         return NotificationCompatKitKat.getSortKey(var1);
      }

      public boolean isGroupSummary(Notification var1) {
         return NotificationCompatKitKat.isGroupSummary(var1);
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

   public static final class WearableExtender implements NotificationCompat.Extender {
      private static final int DEFAULT_CONTENT_ICON_GRAVITY = 8388613;
      private static final int DEFAULT_FLAGS = 1;
      private static final int DEFAULT_GRAVITY = 80;
      private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
      private static final int FLAG_CONTENT_INTENT_AVAILABLE_OFFLINE = 1;
      private static final int FLAG_HINT_AVOID_BACKGROUND_CLIPPING = 16;
      private static final int FLAG_HINT_HIDE_ICON = 2;
      private static final int FLAG_HINT_SHOW_BACKGROUND_ONLY = 4;
      private static final int FLAG_START_SCROLL_BOTTOM = 8;
      private static final String KEY_ACTIONS = "actions";
      private static final String KEY_BACKGROUND = "background";
      private static final String KEY_CONTENT_ACTION_INDEX = "contentActionIndex";
      private static final String KEY_CONTENT_ICON = "contentIcon";
      private static final String KEY_CONTENT_ICON_GRAVITY = "contentIconGravity";
      private static final String KEY_CUSTOM_CONTENT_HEIGHT = "customContentHeight";
      private static final String KEY_CUSTOM_SIZE_PRESET = "customSizePreset";
      private static final String KEY_DISPLAY_INTENT = "displayIntent";
      private static final String KEY_FLAGS = "flags";
      private static final String KEY_GRAVITY = "gravity";
      private static final String KEY_HINT_SCREEN_TIMEOUT = "hintScreenTimeout";
      private static final String KEY_PAGES = "pages";
      public static final int SCREEN_TIMEOUT_LONG = -1;
      public static final int SCREEN_TIMEOUT_SHORT = 0;
      public static final int SIZE_DEFAULT = 0;
      public static final int SIZE_FULL_SCREEN = 5;
      public static final int SIZE_LARGE = 4;
      public static final int SIZE_MEDIUM = 3;
      public static final int SIZE_SMALL = 2;
      public static final int SIZE_XSMALL = 1;
      public static final int UNSET_ACTION_INDEX = -1;
      private ArrayList<NotificationCompat.Action> mActions = new ArrayList();
      private Bitmap mBackground;
      private int mContentActionIndex = -1;
      private int mContentIcon;
      private int mContentIconGravity = 8388613;
      private int mCustomContentHeight;
      private int mCustomSizePreset = 0;
      private PendingIntent mDisplayIntent;
      private int mFlags = 1;
      private int mGravity = 80;
      private int mHintScreenTimeout;
      private ArrayList<Notification> mPages = new ArrayList();

      public WearableExtender() {
      }

      public WearableExtender(Notification var1) {
         Bundle var2 = NotificationCompat.getExtras(var1);
         Bundle var3;
         if(var2 != null) {
            var3 = var2.getBundle("android.wearable.EXTENSIONS");
         } else {
            var3 = null;
         }

         if(var3 != null) {
            NotificationCompat.Action[] var4 = NotificationCompat.IMPL.getActionsFromParcelableArrayList(var3.getParcelableArrayList("actions"));
            if(var4 != null) {
               Collections.addAll(this.mActions, var4);
            }

            this.mFlags = var3.getInt("flags", 1);
            this.mDisplayIntent = (PendingIntent)var3.getParcelable("displayIntent");
            Notification[] var5 = NotificationCompat.getNotificationArrayFromBundle(var3, "pages");
            if(var5 != null) {
               Collections.addAll(this.mPages, var5);
            }

            this.mBackground = (Bitmap)var3.getParcelable("background");
            this.mContentIcon = var3.getInt("contentIcon");
            this.mContentIconGravity = var3.getInt("contentIconGravity", 8388613);
            this.mContentActionIndex = var3.getInt("contentActionIndex", -1);
            this.mCustomSizePreset = var3.getInt("customSizePreset", 0);
            this.mCustomContentHeight = var3.getInt("customContentHeight");
            this.mGravity = var3.getInt("gravity", 80);
            this.mHintScreenTimeout = var3.getInt("hintScreenTimeout");
         }

      }

      private void setFlag(int var1, boolean var2) {
         if(var2) {
            this.mFlags |= var1;
         } else {
            this.mFlags &= ~var1;
         }
      }

      public NotificationCompat.WearableExtender addAction(NotificationCompat.Action var1) {
         this.mActions.add(var1);
         return this;
      }

      public NotificationCompat.WearableExtender addActions(List<NotificationCompat.Action> var1) {
         this.mActions.addAll(var1);
         return this;
      }

      public NotificationCompat.WearableExtender addPage(Notification var1) {
         this.mPages.add(var1);
         return this;
      }

      public NotificationCompat.WearableExtender addPages(List<Notification> var1) {
         this.mPages.addAll(var1);
         return this;
      }

      public NotificationCompat.WearableExtender clearActions() {
         this.mActions.clear();
         return this;
      }

      public NotificationCompat.WearableExtender clearPages() {
         this.mPages.clear();
         return this;
      }

      public NotificationCompat.WearableExtender clone() {
         NotificationCompat.WearableExtender var1 = new NotificationCompat.WearableExtender();
         var1.mActions = new ArrayList(this.mActions);
         var1.mFlags = this.mFlags;
         var1.mDisplayIntent = this.mDisplayIntent;
         var1.mPages = new ArrayList(this.mPages);
         var1.mBackground = this.mBackground;
         var1.mContentIcon = this.mContentIcon;
         var1.mContentIconGravity = this.mContentIconGravity;
         var1.mContentActionIndex = this.mContentActionIndex;
         var1.mCustomSizePreset = this.mCustomSizePreset;
         var1.mCustomContentHeight = this.mCustomContentHeight;
         var1.mGravity = this.mGravity;
         var1.mHintScreenTimeout = this.mHintScreenTimeout;
         return var1;
      }

      public NotificationCompat.Builder extend(NotificationCompat.Builder var1) {
         Bundle var2 = new Bundle();
         if(!this.mActions.isEmpty()) {
            var2.putParcelableArrayList("actions", NotificationCompat.IMPL.getParcelableArrayListForActions((NotificationCompat.Action[])this.mActions.toArray(new NotificationCompat.Action[this.mActions.size()])));
         }

         if(this.mFlags != 1) {
            var2.putInt("flags", this.mFlags);
         }

         if(this.mDisplayIntent != null) {
            var2.putParcelable("displayIntent", this.mDisplayIntent);
         }

         if(!this.mPages.isEmpty()) {
            var2.putParcelableArray("pages", (Parcelable[])this.mPages.toArray(new Notification[this.mPages.size()]));
         }

         if(this.mBackground != null) {
            var2.putParcelable("background", this.mBackground);
         }

         if(this.mContentIcon != 0) {
            var2.putInt("contentIcon", this.mContentIcon);
         }

         if(this.mContentIconGravity != 8388613) {
            var2.putInt("contentIconGravity", this.mContentIconGravity);
         }

         if(this.mContentActionIndex != -1) {
            var2.putInt("contentActionIndex", this.mContentActionIndex);
         }

         if(this.mCustomSizePreset != 0) {
            var2.putInt("customSizePreset", this.mCustomSizePreset);
         }

         if(this.mCustomContentHeight != 0) {
            var2.putInt("customContentHeight", this.mCustomContentHeight);
         }

         if(this.mGravity != 80) {
            var2.putInt("gravity", this.mGravity);
         }

         if(this.mHintScreenTimeout != 0) {
            var2.putInt("hintScreenTimeout", this.mHintScreenTimeout);
         }

         var1.getExtras().putBundle("android.wearable.EXTENSIONS", var2);
         return var1;
      }

      public List<NotificationCompat.Action> getActions() {
         return this.mActions;
      }

      public Bitmap getBackground() {
         return this.mBackground;
      }

      public int getContentAction() {
         return this.mContentActionIndex;
      }

      public int getContentIcon() {
         return this.mContentIcon;
      }

      public int getContentIconGravity() {
         return this.mContentIconGravity;
      }

      public boolean getContentIntentAvailableOffline() {
         return (1 & this.mFlags) != 0;
      }

      public int getCustomContentHeight() {
         return this.mCustomContentHeight;
      }

      public int getCustomSizePreset() {
         return this.mCustomSizePreset;
      }

      public PendingIntent getDisplayIntent() {
         return this.mDisplayIntent;
      }

      public int getGravity() {
         return this.mGravity;
      }

      public boolean getHintAvoidBackgroundClipping() {
         return (16 & this.mFlags) != 0;
      }

      public boolean getHintHideIcon() {
         return (2 & this.mFlags) != 0;
      }

      public int getHintScreenTimeout() {
         return this.mHintScreenTimeout;
      }

      public boolean getHintShowBackgroundOnly() {
         return (4 & this.mFlags) != 0;
      }

      public List<Notification> getPages() {
         return this.mPages;
      }

      public boolean getStartScrollBottom() {
         return (8 & this.mFlags) != 0;
      }

      public NotificationCompat.WearableExtender setBackground(Bitmap var1) {
         this.mBackground = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setContentAction(int var1) {
         this.mContentActionIndex = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setContentIcon(int var1) {
         this.mContentIcon = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setContentIconGravity(int var1) {
         this.mContentIconGravity = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setContentIntentAvailableOffline(boolean var1) {
         this.setFlag(1, var1);
         return this;
      }

      public NotificationCompat.WearableExtender setCustomContentHeight(int var1) {
         this.mCustomContentHeight = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setCustomSizePreset(int var1) {
         this.mCustomSizePreset = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setDisplayIntent(PendingIntent var1) {
         this.mDisplayIntent = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setGravity(int var1) {
         this.mGravity = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setHintAvoidBackgroundClipping(boolean var1) {
         this.setFlag(16, var1);
         return this;
      }

      public NotificationCompat.WearableExtender setHintHideIcon(boolean var1) {
         this.setFlag(2, var1);
         return this;
      }

      public NotificationCompat.WearableExtender setHintScreenTimeout(int var1) {
         this.mHintScreenTimeout = var1;
         return this;
      }

      public NotificationCompat.WearableExtender setHintShowBackgroundOnly(boolean var1) {
         this.setFlag(4, var1);
         return this;
      }

      public NotificationCompat.WearableExtender setStartScrollBottom(boolean var1) {
         this.setFlag(8, var1);
         return this;
      }
   }
}
