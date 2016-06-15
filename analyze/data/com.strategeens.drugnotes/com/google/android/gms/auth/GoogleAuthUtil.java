package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.AccountChangeEvent;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.UserRecoverableNotifiedException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_861;
import com.google.android.gms.internal.class_326;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_69;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
   public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
   public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
   public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
   public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
   // $FF: renamed from: Ek android.content.ComponentName
   private static final ComponentName field_4390;
   // $FF: renamed from: El android.content.ComponentName
   private static final ComponentName field_4391;
   // $FF: renamed from: Em android.content.Intent
   private static final Intent field_4392;
   // $FF: renamed from: En android.content.Intent
   private static final Intent field_4393;
   public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
   public static final String KEY_ANDROID_PACKAGE_NAME;
   public static final String KEY_CALLER_UID;
   public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
   @Deprecated
   public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
   public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

   static {
      String var0;
      if(VERSION.SDK_INT >= 11) {
         var0 = "callerUid";
      } else {
         var0 = "callerUid";
      }

      KEY_CALLER_UID = var0;
      String var1;
      if(VERSION.SDK_INT >= 14) {
         var1 = "androidPackageName";
      } else {
         var1 = "androidPackageName";
      }

      KEY_ANDROID_PACKAGE_NAME = var1;
      field_4390 = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      field_4391 = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      field_4392 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_4390);
      field_4393 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_4391);
   }

   // $FF: renamed from: C (android.content.Context) void
   private static void method_5709(Context var0) throws GoogleAuthException {
      try {
         GooglePlayServicesUtil.method_4791(var0);
      } catch (GooglePlayServicesRepairableException var3) {
         throw new GooglePlayServicesAvailabilityException(var3.getConnectionStatusCode(), var3.getMessage(), var3.getIntent());
      } catch (GooglePlayServicesNotAvailableException var4) {
         throw new GoogleAuthException(var4.getMessage());
      }
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, android.os.Bundle) java.lang.String
   private static String method_5710(Context var0, String var1, String var2, Bundle var3) throws IOException, GoogleAuthException {
      if(var3 == null) {
         var3 = new Bundle();
      }

      try {
         String var6 = getToken(var0, var1, var2, var3);
         return var6;
      } catch (GooglePlayServicesAvailabilityException var7) {
         GooglePlayServicesUtil.showErrorNotification(var7.getConnectionStatusCode(), var0);
         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      } catch (UserRecoverableAuthException var8) {
         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      }
   }

   // $FF: renamed from: ax (java.lang.String) boolean
   private static boolean method_5711(String var0) {
      return "NetworkError".equals(var0) || "ServiceUnavailable".equals(var0) || "Timeout".equals(var0);
   }

   // $FF: renamed from: ay (java.lang.String) boolean
   private static boolean method_5712(String var0) {
      return "BadAuthentication".equals(var0) || "CaptchaRequired".equals(var0) || "DeviceManagementRequiredOrSyncDisabled".equals(var0) || "NeedPermission".equals(var0) || "NeedsBrowser".equals(var0) || "UserCancel".equals(var0) || "AppDownloadRequired".equals(var0) || class_326.field_841.method_2283().equals(var0) || class_326.field_842.method_2283().equals(var0) || class_326.field_843.method_2283().equals(var0) || class_326.field_844.method_2283().equals(var0) || class_326.field_845.method_2283().equals(var0) || class_326.field_846.method_2283().equals(var0);
   }

   public static void clearToken(Context var0, String var1) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
      Context var2 = var0.getApplicationContext();
      class_335.method_2305("Calling this from your main thread can lead to deadlock");
      method_5709(var2);
      Bundle var3 = new Bundle();
      String var4 = var0.getApplicationInfo().packageName;
      var3.putString("clientPackageName", var4);
      if(!var3.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
         var3.putString(KEY_ANDROID_PACKAGE_NAME, var4);
      }

      class_861 var5 = new class_861();
      if(!var2.bindService(field_4392, var5, 1)) {
         throw new IOException("Could not bind to service with the given context.");
      } else {
         try {
            Bundle var10 = class_69.class_1367.method_5389(var5.method_4824()).method_378(var1, var3);
            String var11 = var10.getString(class_326.field_878);
            if(!var10.getBoolean("booleanResult")) {
               throw new GoogleAuthException(var11);
            }
         } catch (RemoteException var15) {
            Log.i("GoogleAuthUtil", "GMS remote exception ", var15);
            throw new IOException("remote exception");
         } catch (InterruptedException var16) {
            throw new GoogleAuthException("Interrupted");
         } finally {
            var2.unbindService(var5);
         }

      }
   }

   public static List<AccountChangeEvent> getAccountChangeEvents(Context var0, int var1, String var2) throws GoogleAuthException, IOException {
      class_335.method_2307(var2, "accountName must be provided");
      class_335.method_2305("Calling this from your main thread can lead to deadlock");
      Context var4 = var0.getApplicationContext();
      method_5709(var4);
      class_861 var5 = new class_861();
      if(var4.bindService(field_4392, var5, 1)) {
         List var10;
         try {
            var10 = class_69.class_1367.method_5389(var5.method_4824()).method_380((new AccountChangeEventsRequest()).setAccountName(var2).setEventIndex(var1)).getEvents();
         } catch (RemoteException var14) {
            Log.i("GoogleAuthUtil", "GMS remote exception ", var14);
            throw new IOException("remote exception");
         } catch (InterruptedException var15) {
            throw new GoogleAuthException("Interrupted");
         } finally {
            var4.unbindService(var5);
         }

         return var10;
      } else {
         throw new IOException("Could not bind to service with the given context.");
      }
   }

   public static String getAccountId(Context var0, String var1) throws GoogleAuthException, IOException {
      class_335.method_2307(var1, "accountName must be provided");
      class_335.method_2305("Calling this from your main thread can lead to deadlock");
      method_5709(var0.getApplicationContext());
      return getToken(var0, var1, "^^_account_id_^^", new Bundle());
   }

   public static String getAppCert(Context var0, String var1) {
      return "spatula";
   }

   public static String getToken(Context var0, String var1, String var2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      return getToken(var0, var1, var2, new Bundle());
   }

   public static String getToken(Context param0, String param1, String param2, Bundle param3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      // $FF: Couldn't be decompiled
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      if(var3 == null) {
         var3 = new Bundle();
      }

      var3.putBoolean("handle_notification", true);
      return method_5710(var0, var1, var2, var3);
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, Intent var4) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      method_5713(var4);
      if(var3 == null) {
         var3 = new Bundle();
      }

      var3.putParcelable("callback_intent", var4);
      var3.putBoolean("handle_notification", true);
      return method_5710(var0, var1, var2, var3);
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, String var4, Bundle var5) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      if(TextUtils.isEmpty(var4)) {
         throw new IllegalArgumentException("Authority cannot be empty or null.");
      } else {
         if(var3 == null) {
            var3 = new Bundle();
         }

         if(var5 == null) {
            var5 = new Bundle();
         }

         ContentResolver.validateSyncExtrasBundle(var5);
         var3.putString("authority", var4);
         var3.putBundle("sync_extras", var5);
         var3.putBoolean("handle_notification", true);
         return method_5710(var0, var1, var2, var3);
      }
   }

   // $FF: renamed from: h (android.content.Intent) void
   private static void method_5713(Intent var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Callback cannot be null.");
      } else {
         String var1 = var0.toUri(1);

         try {
            Intent.parseUri(var1, 1);
         } catch (URISyntaxException var3) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
         }
      }
   }

   @Deprecated
   public static void invalidateToken(Context var0, String var1) {
      AccountManager.get(var0).invalidateAuthToken("com.google", var1);
   }
}
