package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.zzae;

public final class zzc {
   public static String zzT(int var0) {
      return zzb("&cd", var0);
   }

   public static String zzU(int var0) {
      return zzb("cd", var0);
   }

   public static String zzW(int var0) {
      return zzb("cm", var0);
   }

   public static String zzX(int var0) {
      return zzb("&pr", var0);
   }

   public static String zzY(int var0) {
      return zzb("pr", var0);
   }

   public static String zzZ(int var0) {
      return zzb("&promo", var0);
   }

   public static String zzaa(int var0) {
      return zzb("promo", var0);
   }

   public static String zzab(int var0) {
      return zzb("pi", var0);
   }

   public static String zzac(int var0) {
      return zzb("&il", var0);
   }

   public static String zzad(int var0) {
      return zzb("il", var0);
   }

   public static String zzae(int var0) {
      return zzb("cd", var0);
   }

   public static String zzaf(int var0) {
      return zzb("cm", var0);
   }

   private static String zzb(String var0, int var1) {
      if(var1 < 1) {
         zzae.zzf("index out of range for prefix", var0);
         return "";
      } else {
         return var0 + var1;
      }
   }
}
