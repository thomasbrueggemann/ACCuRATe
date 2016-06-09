package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzb {
   // $FF: renamed from: e (java.lang.String) void
   public static void method_32(String var0) {
      if(zzQ(6)) {
         Log.e("Ads", var0);
      }

   }

   public static boolean zzQ(int var0) {
      return var0 >= 5 || Log.isLoggable("Ads", var0);
   }

   public static void zza(String var0, Throwable var1) {
      if(zzQ(3)) {
         Log.d("Ads", var0, var1);
      }

   }

   public static void zzaI(String var0) {
      if(zzQ(3)) {
         Log.d("Ads", var0);
      }

   }

   public static void zzaJ(String var0) {
      if(zzQ(4)) {
         Log.i("Ads", var0);
      }

   }

   public static void zzaK(String var0) {
      if(zzQ(5)) {
         Log.w("Ads", var0);
      }

   }

   public static void zzb(String var0, Throwable var1) {
      if(zzQ(6)) {
         Log.e("Ads", var0, var1);
      }

   }

   public static void zzd(String var0, Throwable var1) {
      if(zzQ(5)) {
         Log.w("Ads", var0, var1);
      }

   }
}
