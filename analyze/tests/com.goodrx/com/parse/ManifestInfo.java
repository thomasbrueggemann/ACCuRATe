package com.parse;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.parse.GcmBroadcastReceiver;
import com.parse.PLog;
import com.parse.Parse;
import com.parse.ParseBroadcastReceiver;
import com.parse.PushService;
import com.parse.PushType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class ManifestInfo {
   private static final int NUMBER_OF_PUSH_INTENTS = 3;
   private static final String TAG = "com.parse.ManifestInfo";
   private static String displayName = null;
   private static int iconId = 0;
   private static long lastModified = -1L;
   private static final Object lock = new Object();
   private static PushType pushType;
   static int versionCode = -1;
   static String versionName = null;

   private static boolean checkReceiver(Class<? extends BroadcastReceiver> var0, String var1, Intent[] var2) {
      ActivityInfo var3 = getReceiverInfo(var0);
      if(var3 != null && (var1 == null || var1.equals(var3.permission))) {
         int var4 = var2.length;
         int var5 = 0;

         while(true) {
            if(var5 >= var4) {
               return true;
            }

            Intent var6 = var2[var5];
            List var7 = getPackageManager().queryBroadcastReceivers(var6, 0);
            if(var7.isEmpty() || !checkResolveInfo(var0, var7)) {
               break;
            }

            ++var5;
         }
      }

      return false;
   }

   private static boolean checkResolveInfo(Class<? extends BroadcastReceiver> var0, List<ResolveInfo> var1) {
      Iterator var2 = var1.iterator();

      ResolveInfo var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (ResolveInfo)var2.next();
      } while(var3.activityInfo == null || !var0.getCanonicalName().equals(var3.activityInfo.name));

      return true;
   }

   private static ManifestInfo.ManifestCheckResult gcmSupportLevel() {
      Context var0 = getContext();
      if(getServiceInfo(PushService.class) == null) {
         return ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
      } else {
         String[] var1 = new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK", "com.google.android.c2dm.permission.RECEIVE", var0.getPackageName() + ".permission.C2D_MESSAGE"};
         if(!hasRequestedPermissions(var0, var1)) {
            return ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
         } else {
            String var2 = var0.getPackageName();
            Intent[] var3 = new Intent[]{(new Intent("com.google.android.c2dm.intent.RECEIVE")).setPackage(var2).addCategory(var2), (new Intent("com.google.android.c2dm.intent.REGISTRATION")).setPackage(var2).addCategory(var2)};
            return !checkReceiver(GcmBroadcastReceiver.class, "com.google.android.c2dm.permission.SEND", var3)?ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS:(!hasGrantedPermissions(var0, new String[]{"android.permission.VIBRATE"})?ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS:ManifestInfo.ManifestCheckResult.HAS_ALL_DECLARATIONS);
         }
      }
   }

   private static ApplicationInfo getApplicationInfo(Context var0, int var1) {
      try {
         ApplicationInfo var3 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), var1);
         return var3;
      } catch (NameNotFoundException var4) {
         return null;
      }
   }

   public static Bundle getApplicationMetadata(Context var0) {
      ApplicationInfo var1 = getApplicationInfo(var0, 128);
      return var1 != null?var1.metaData:null;
   }

   private static Context getContext() {
      return Parse.getApplicationContext();
   }

   public static String getDisplayName(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private static String getGcmManifestMessage() {
      String var0 = getContext().getPackageName();
      String var1 = var0 + ".permission.C2D_MESSAGE";
      return "make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n<uses-permission android:name=\"android.permission.GET_ACCOUNTS\" />\n<uses-permission android:name=\"com.google.android.c2dm.permission.RECEIVE\" />\n<permission android:name=\"" + var1 + "\" " + "android:protectionLevel=\"signature\" />\n" + "<uses-permission android:name=\"" + var1 + "\" />\n" + "\n" + "Also, please make sure that these services and broadcast receivers are declared as " + "children of the <application> element:\n" + "\n" + "<service android:name=\"com.parse.PushService\" />\n" + "<receiver android:name=\"com.parse.GcmBroadcastReceiver\" " + "android:permission=\"com.google.android.c2dm.permission.SEND\">\n" + "  <intent-filter>\n" + "    <action android:name=\"com.google.android.c2dm.intent.RECEIVE\" />\n" + "    <action android:name=\"com.google.android.c2dm.intent.REGISTRATION\" />\n" + "    <category android:name=\"" + var0 + "\" />\n" + "  </intent-filter>\n" + "</receiver>\n" + "<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"" + " android:exported=false>\n" + "  <intent-filter>\n" + "    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n" + "    <action android:name=\"com.parse.push.intent.OPEN\" />\n" + "    <action android:name=\"com.parse.push.intent.DELETE\" />\n" + "  </intent-filter>\n" + "</receiver>";
   }

   public static int getIconId() {
      // $FF: Couldn't be decompiled
   }

   static List<ResolveInfo> getIntentReceivers(String... var0) {
      Context var1 = getContext();
      String var2 = var1.getPackageName();
      ArrayList var3 = new ArrayList();
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var8 = var0[var5];
         var3.addAll(var1.getPackageManager().queryBroadcastReceivers(new Intent(var8), 32));
      }

      for(int var6 = -1 + var3.size(); var6 >= 0; --var6) {
         if(!((ResolveInfo)var3.get(var6)).activityInfo.packageName.equals(var2)) {
            var3.remove(var6);
         }
      }

      return var3;
   }

   public static long getLastModified() {
      // $FF: Couldn't be decompiled
   }

   public static String getNonePushTypeLogMessage() {
      return "Push is not configured for this app because the app manifest is missing required declarations. Please add the following declarations to your app manifest to use GCM for push: " + getGcmManifestMessage();
   }

   private static PackageInfo getPackageInfo(String var0) {
      try {
         PackageInfo var2 = getPackageManager().getPackageInfo(var0, 0);
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   private static PackageManager getPackageManager() {
      return getContext().getPackageManager();
   }

   private static String getPpnsManifestMessage() {
      return "make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.RECEIVE_BOOT_COMPLETED\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n\nAlso, please make sure that these services and broadcast receivers are declared as children of the <application> element:\n\n<service android:name=\"com.parse.PushService\" />\n<receiver android:name=\"com.parse.ParseBroadcastReceiver\">\n  <intent-filter>\n    <action android:name=\"android.intent.action.BOOT_COMPLETED\" />\n    <action android:name=\"android.intent.action.USER_PRESENT\" />\n  </intent-filter>\n</receiver>\n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\" android:exported=false>\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>";
   }

   public static PushType getPushType() {
      // $FF: Couldn't be decompiled
   }

   private static ActivityInfo getReceiverInfo(Class<? extends BroadcastReceiver> var0) {
      try {
         ActivityInfo var2 = getPackageManager().getReceiverInfo(new ComponentName(getContext(), var0), 0);
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   private static ServiceInfo getServiceInfo(Class<? extends Service> var0) {
      try {
         ServiceInfo var2 = getPackageManager().getServiceInfo(new ComponentName(getContext(), var0), 0);
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   public static int getVersionCode() {
      // $FF: Couldn't be decompiled
   }

   public static String getVersionName() {
      // $FF: Couldn't be decompiled
   }

   private static boolean hasAnyGcmSpecificDeclaration() {
      Context var0 = getContext();
      boolean var1;
      if(!hasRequestedPermissions(var0, new String[]{"com.google.android.c2dm.permission.RECEIVE"})) {
         String[] var2 = new String[]{var0.getPackageName() + ".permission.C2D_MESSAGE"};
         if(!hasRequestedPermissions(var0, var2)) {
            ActivityInfo var3 = getReceiverInfo(GcmBroadcastReceiver.class);
            var1 = false;
            if(var3 == null) {
               return var1;
            }
         }
      }

      var1 = true;
      return var1;
   }

   private static boolean hasGrantedPermissions(Context var0, String... var1) {
      String var2 = var0.getPackageName();
      PackageManager var3 = var0.getPackageManager();
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         if(var3.checkPermission(var1[var5], var2) != 0) {
            return false;
         }
      }

      return true;
   }

   static boolean hasIntentReceiver(String var0) {
      return !getIntentReceivers(new String[]{var0}).isEmpty();
   }

   private static boolean hasRequestedPermissions(Context var0, String... var1) {
      String var2 = var0.getPackageName();

      try {
         PackageInfo var4 = var0.getPackageManager().getPackageInfo(var2, 4096);
         if(var4.requestedPermissions == null) {
            return false;
         } else {
            boolean var5 = Arrays.asList(var4.requestedPermissions).containsAll(Arrays.asList(var1));
            return var5;
         }
      } catch (NameNotFoundException var6) {
         PLog.method_362("com.parse.ManifestInfo", "Couldn\'t find info about own package", var6);
         return false;
      }
   }

   private static boolean isGooglePlayServicesAvailable() {
      return VERSION.SDK_INT >= 8 && getPackageInfo("com.google.android.gsf") != null;
   }

   private static ManifestInfo.ManifestCheckResult ppnsSupportLevel() {
      Context var0 = getContext();
      if(getServiceInfo(PushService.class) == null) {
         return ManifestInfo.ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
      } else if(!hasGrantedPermissions(var0, new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.VIBRATE", "android.permission.WAKE_LOCK", "android.permission.RECEIVE_BOOT_COMPLETED"})) {
         return ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
      } else {
         String var1 = var0.getPackageName();
         Intent[] var2 = new Intent[]{(new Intent("android.intent.action.BOOT_COMPLETED")).setPackage(var1), (new Intent("android.intent.action.USER_PRESENT")).setPackage(var1)};
         return !checkReceiver(ParseBroadcastReceiver.class, (String)null, var2)?ManifestInfo.ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS:ManifestInfo.ManifestCheckResult.HAS_ALL_DECLARATIONS;
      }
   }

   static void setPushType(PushType param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean usesPushBroadcastReceivers() {
      boolean var0 = hasIntentReceiver("com.parse.push.intent.RECEIVE");
      int var1 = 0;
      if(var0) {
         var1 = 0 + 1;
      }

      if(hasIntentReceiver("com.parse.push.intent.OPEN")) {
         ++var1;
      }

      if(hasIntentReceiver("com.parse.push.intent.DELETE")) {
         ++var1;
      }

      if(var1 != 0 && var1 != 3) {
         throw new SecurityException("The Parse Push BroadcastReceiver must implement a filter for all of com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, and com.parse.push.intent.DELETE");
      } else {
         return var1 == 3;
      }
   }

   static enum ManifestCheckResult {
      HAS_ALL_DECLARATIONS,
      MISSING_OPTIONAL_DECLARATIONS,
      MISSING_REQUIRED_DECLARATIONS;

      static {
         ManifestInfo.ManifestCheckResult[] var0 = new ManifestInfo.ManifestCheckResult[]{HAS_ALL_DECLARATIONS, MISSING_OPTIONAL_DECLARATIONS, MISSING_REQUIRED_DECLARATIONS};
      }
   }
}
