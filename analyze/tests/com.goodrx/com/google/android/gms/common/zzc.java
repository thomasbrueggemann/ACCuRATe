package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.zze;
import com.google.android.gms.common.internal.zzn;

public class zzc {
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
   private static final zzc zzafF;

   static {
      GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
      zzafF = new zzc();
   }

   private String zzj(@Nullable Context var1, @Nullable String var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("gcore_");
      var3.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
      var3.append("-");
      if(!TextUtils.isEmpty(var2)) {
         var3.append(var2);
      }

      var3.append("-");
      if(var1 != null) {
         var3.append(var1.getPackageName());
      }

      var3.append("-");
      if(var1 != null) {
         try {
            var3.append(var1.getPackageManager().getPackageInfo(var1.getPackageName(), 0).versionCode);
         } catch (NameNotFoundException var10) {
            ;
         }
      }

      return var3.toString();
   }

   public static zzc zzoK() {
      return zzafF;
   }

   public int isGooglePlayServicesAvailable(Context var1) {
      int var2 = zze.isGooglePlayServicesAvailable(var1);
      if(zze.zzd(var1, var2)) {
         var2 = 18;
      }

      return var2;
   }

   public boolean isUserResolvableError(int var1) {
      return zze.isUserRecoverableError(var1);
   }

   @Nullable
   public Intent zza(Context var1, int var2, @Nullable String var3) {
      switch(var2) {
      case 1:
      case 2:
         return zzn.zzx("com.google.android.gms", this.zzj(var1, var3));
      case 3:
         return zzn.zzcJ("com.google.android.gms");
      case 42:
         return zzn.zzqU();
      default:
         return null;
      }
   }

   public void zzal(Context var1) {
      zze.zzal(var1);
   }

   @Deprecated
   @Nullable
   public Intent zzbu(int var1) {
      return this.zza((Context)null, var1, (String)null);
   }

   public boolean zzd(Context var1, int var2) {
      return zze.zzd(var1, var2);
   }

   public boolean zzi(Context var1, String var2) {
      return zze.zzi(var1, var2);
   }
}
