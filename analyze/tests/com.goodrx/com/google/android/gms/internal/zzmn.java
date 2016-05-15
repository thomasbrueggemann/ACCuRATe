package com.google.android.gms.internal;

import java.util.ArrayList;

public final class zzmn {
   public static <T> int zza(T[] var0, T var1) {
      int var2 = 0;
      int var3;
      if(var0 != null) {
         var3 = var0.length;
      } else {
         var3 = 0;
         var2 = 0;
      }

      while(var2 < var3) {
         if(com.google.android.gms.common.internal.zzw.equal(var0[var2], var1)) {
            return var2;
         }

         ++var2;
      }

      return -1;
   }

   public static void zza(StringBuilder var0, double[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Double.toString(var1[var3]));
      }

   }

   public static void zza(StringBuilder var0, float[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Float.toString(var1[var3]));
      }

   }

   public static void zza(StringBuilder var0, int[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Integer.toString(var1[var3]));
      }

   }

   public static void zza(StringBuilder var0, long[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Long.toString(var1[var3]));
      }

   }

   public static <T> void zza(StringBuilder var0, T[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(var1[var3].toString());
      }

   }

   public static void zza(StringBuilder var0, String[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append("\"").append(var1[var3]).append("\"");
      }

   }

   public static void zza(StringBuilder var0, boolean[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         if(var3 != 0) {
            var0.append(",");
         }

         var0.append(Boolean.toString(var1[var3]));
      }

   }

   public static <T> ArrayList<T> zzb(T[] var0) {
      int var1 = var0.length;
      ArrayList var2 = new ArrayList(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.add(var0[var3]);
      }

      return var2;
   }

   public static <T> boolean zzb(T[] var0, T var1) {
      return zza(var0, var1) >= 0;
   }

   public static <T> ArrayList<T> zzsa() {
      return new ArrayList();
   }
}
