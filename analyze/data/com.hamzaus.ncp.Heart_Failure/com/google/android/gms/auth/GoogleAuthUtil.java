package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.UserRecoverableNotifiedException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_665;
import com.google.android.gms.internal.class_337;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_64;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil {
   public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
   public static final String KEY_ANDROID_PACKAGE_NAME;
   public static final String KEY_CALLER_UID;
   public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
   @Deprecated
   public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
   public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
   // $FF: renamed from: yR android.content.ComponentName
   private static final ComponentName field_4237;
   // $FF: renamed from: yS android.content.ComponentName
   private static final ComponentName field_4238;
   // $FF: renamed from: yT android.content.Intent
   private static final Intent field_4239;
   // $FF: renamed from: yU android.content.Intent
   private static final Intent field_4240;

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
      field_4237 = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      field_4238 = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      field_4239 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_4237);
      field_4240 = (new Intent()).setPackage("com.google.android.gms").setComponent(field_4238);
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, android.os.Bundle) java.lang.String
   private static String method_4485(Context var0, String var1, String var2, Bundle var3) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      if(var3 == null) {
         var3 = new Bundle();
      }

      try {
         String var9 = getToken(var0, var1, var2, var3);
         return var9;
      } catch (GooglePlayServicesAvailabilityException var10) {
         int var6 = var10.getConnectionStatusCode();
         if(method_4488(var0, var6)) {
            GoogleAuthUtil.class_1314 var7 = new GoogleAuthUtil.class_1314(var0.getApplicationContext());
            var7.sendMessageDelayed(var7.obtainMessage(1), 30000L);
         } else {
            GooglePlayServicesUtil.showErrorNotification(var6, var0);
         }

         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      } catch (UserRecoverableAuthException var11) {
         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      }
   }

   // $FF: renamed from: ac (java.lang.String) boolean
   private static boolean method_4486(String var0) {
      return "NetworkError".equals(var0) || "ServiceUnavailable".equals(var0) || "Timeout".equals(var0);
   }

   // $FF: renamed from: ad (java.lang.String) boolean
   private static boolean method_4487(String var0) {
      return "BadAuthentication".equals(var0) || "CaptchaRequired".equals(var0) || "DeviceManagementRequiredOrSyncDisabled".equals(var0) || "NeedPermission".equals(var0) || "NeedsBrowser".equals(var0) || "UserCancel".equals(var0) || "AppDownloadRequired".equals(var0);
   }

   // $FF: renamed from: b (android.content.Context, int) boolean
   private static boolean method_4488(Context var0, int var1) {
      if(var1 == 1) {
         PackageManager var2 = var0.getPackageManager();

         boolean var4;
         try {
            var4 = var2.getApplicationInfo("com.google.android.gms", 8192).enabled;
         } catch (NameNotFoundException var5) {
            return false;
         }

         if(var4) {
            return true;
         }
      }

      return false;
   }

   public static void clearToken(Context var0, String var1) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
      Context var2 = var0.getApplicationContext();
      class_347.method_2165("Calling this from your main thread can lead to deadlock");
      method_4490(var2);
      Bundle var3 = new Bundle();
      String var4 = var0.getApplicationInfo().packageName;
      var3.putString("clientPackageName", var4);
      if(!var3.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
         var3.putString(KEY_ANDROID_PACKAGE_NAME, var4);
      }

      class_665 var5 = new class_665();
      if(!var2.bindService(field_4239, var5, 1)) {
         throw new IOException("Could not bind to service with the given context.");
      } else {
         try {
            Bundle var10 = class_64.class_1030.method_4491(var5.method_3853()).method_336(var1, var3);
            String var11 = var10.getString(class_337.field_1377);
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

   // $FF: renamed from: g (android.content.Intent) void
   private static void method_4489(Intent var0) {
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
      return method_4485(var0, var1, var2, var3);
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, Intent var4) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      method_4489(var4);
      if(var3 == null) {
         var3 = new Bundle();
      }

      var3.putParcelable("callback_intent", var4);
      var3.putBoolean("handle_notification", true);
      return method_4485(var0, var1, var2, var3);
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
         return method_4485(var0, var1, var2, var3);
      }
   }

   @Deprecated
   public static void invalidateToken(Context var0, String var1) {
      AccountManager.get(var0).invalidateAuthToken("com.google", var1);
   }

   // $FF: renamed from: w (android.content.Context) void
   private static void method_4490(Context var0) throws GoogleAuthException {
      try {
         GooglePlayServicesUtil.method_3846(var0);
      } catch (GooglePlayServicesRepairableException var3) {
         throw new GooglePlayServicesAvailabilityException(var3.getConnectionStatusCode(), var3.getMessage(), var3.getIntent());
      } catch (GooglePlayServicesNotAvailableException var4) {
         throw new GoogleAuthException(var4.getMessage());
      }
   }

   private static class class_1314 extends Handler {
      // $FF: renamed from: lx android.content.Context
      private final Context field_3889;

      class_1314(Context var1) {
         Looper var2;
         if(Looper.myLooper() == null) {
            var2 = Looper.getMainLooper();
         } else {
            var2 = Looper.myLooper();
         }

         super(var2);
         this.field_3889 = var1;
      }

      public void handleMessage(Message var1) {
         if(var1.what == 1) {
            int var3 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.field_3889);
            if(GooglePlayServicesUtil.isUserRecoverableError(var3)) {
               GooglePlayServicesUtil.showErrorNotification(var3, this.field_3889);
            }

         } else {
            Log.wtf("GoogleAuthUtil", "Don\'t know how to handle this message: " + var1.what);
         }
      }
   }
}
