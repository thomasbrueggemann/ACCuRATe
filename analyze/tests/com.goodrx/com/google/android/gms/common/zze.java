package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzf;
import com.google.android.gms.internal.zzne;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class zze {
   @Deprecated
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzoM();
   public static boolean zzafL = false;
   public static boolean zzafM = false;
   static int zzafN = -1;
   private static String zzafO = null;
   private static Integer zzafP = null;
   static final AtomicBoolean zzafQ = new AtomicBoolean();
   private static final AtomicBoolean zzafR = new AtomicBoolean();
   private static final Object zzqy = new Object();

   @Deprecated
   public static String getErrorString(int var0) {
      return ConnectionResult.getStatusString(var0);
   }

   public static Context getRemoteContext(Context var0) {
      try {
         Context var2 = var0.createPackageContext("com.google.android.gms", 3);
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   public static Resources getRemoteResource(Context var0) {
      try {
         Resources var2 = var0.getPackageManager().getResourcesForApplication("com.google.android.gms");
         return var2;
      } catch (NameNotFoundException var3) {
         return null;
      }
   }

   @Deprecated
   public static int isGooglePlayServicesAvailable(Context param0) {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public static boolean isUserRecoverableError(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 9:
         return true;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      default:
         return false;
      }
   }

   @Deprecated
   public static int zzaj(Context var0) {
      PackageInfo var3;
      try {
         var3 = var0.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      } catch (NameNotFoundException var4) {
         Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
         return 0;
      }

      return var3.versionCode;
   }

   @Deprecated
   public static void zzal(Context var0) {
      if(!zzafQ.getAndSet(true)) {
         try {
            ((NotificationManager)var0.getSystemService("notification")).cancel(10436);
         } catch (SecurityException var2) {
            ;
         }
      }
   }

   private static void zzan(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static String zzao(Context var0) {
      String var1 = var0.getApplicationInfo().name;
      if(TextUtils.isEmpty(var1)) {
         var1 = var0.getPackageName();
         PackageManager var2 = var0.getApplicationContext().getPackageManager();

         ApplicationInfo var4;
         label17: {
            ApplicationInfo var5;
            try {
               var5 = var2.getApplicationInfo(var0.getPackageName(), 0);
            } catch (NameNotFoundException var6) {
               var4 = null;
               break label17;
            }

            var4 = var5;
         }

         if(var4 != null) {
            var1 = var2.getApplicationLabel(var4).toString();
         }
      }

      return var1;
   }

   @TargetApi(18)
   public static boolean zzaq(Context var0) {
      if(zzne.zzsj()) {
         Bundle var1 = ((UserManager)var0.getSystemService("user")).getApplicationRestrictions(var0.getPackageName());
         if(var1 != null && "true".equals(var1.getString("restricted_profile"))) {
            return true;
         }
      }

      return false;
   }

   @TargetApi(19)
   public static boolean zzb(Context var0, int var1, String var2) {
      boolean var4;
      if(zzne.zzsk()) {
         AppOpsManager var7 = (AppOpsManager)var0.getSystemService("appops");

         try {
            var7.checkPackage(var1, var2);
         } catch (SecurityException var9) {
            return false;
         }

         var4 = true;
      } else {
         String[] var3 = var0.getPackageManager().getPackagesForUid(var1);
         var4 = false;
         if(var2 != null) {
            var4 = false;
            if(var3 != null) {
               int var5 = 0;

               while(true) {
                  int var6 = var3.length;
                  var4 = false;
                  if(var5 >= var6) {
                     break;
                  }

                  if(var2.equals(var3[var5])) {
                     return true;
                  }

                  ++var5;
               }
            }
         }
      }

      return var4;
   }

   public static boolean zzb(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public static Intent zzbv(int var0) {
      return zzc.zzoK().zza((Context)null, var0, (String)null);
   }

   public static boolean zzc(PackageManager var0) {
      return zzb(var0) || !zzoN();
   }

   @Deprecated
   public static boolean zzd(Context var0, int var1) {
      return var1 == 18?true:(var1 == 1?zzi(var0, "com.google.android.gms"):false);
   }

   public static boolean zzf(Context var0, int var1) {
      if(zzb(var0, var1, "com.google.android.gms")) {
         PackageManager var2 = var0.getPackageManager();

         PackageInfo var5;
         try {
            var5 = var2.getPackageInfo("com.google.android.gms", 64);
         } catch (NameNotFoundException var6) {
            if(!Log.isLoggable("GooglePlayServicesUtil", 3)) {
               return false;
            }

            Log.d("GooglePlayServicesUtil", "Package manager can\'t find google play services package, defaulting to false");
            return false;
         }

         return zzf.zzoO().zza(var0.getPackageManager(), var5);
      } else {
         return false;
      }
   }

   @TargetApi(21)
   static boolean zzi(Context var0, String var1) {
      if(zzne.zzsm()) {
         Iterator var5 = var0.getPackageManager().getPackageInstaller().getAllSessions().iterator();

         while(var5.hasNext()) {
            if(var1.equals(((SessionInfo)var5.next()).getAppPackageName())) {
               return true;
            }
         }
      }

      if(zzaq(var0)) {
         return false;
      } else {
         PackageManager var2 = var0.getPackageManager();

         try {
            boolean var4 = var2.getApplicationInfo(var1, 8192).enabled;
            return var4;
         } catch (NameNotFoundException var6) {
            return false;
         }
      }
   }

   private static int zzoM() {
      return 8487000;
   }

   public static boolean zzoN() {
      return zzafL?zzafM:"user".equals(Build.TYPE);
   }
}
