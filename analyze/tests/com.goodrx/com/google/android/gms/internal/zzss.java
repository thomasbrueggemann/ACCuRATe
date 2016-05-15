package com.google.android.gms.internal;

import com.google.android.gms.internal.zzso;
import java.util.Arrays;

public final class zzss {
   public static final Object zzbut = new Object();

   public static boolean equals(int[] var0, int[] var1) {
      return var0 != null && var0.length != 0?Arrays.equals(var0, var1):var1 == null || var1.length == 0;
   }

   public static boolean equals(long[] var0, long[] var1) {
      return var0 != null && var0.length != 0?Arrays.equals(var0, var1):var1 == null || var1.length == 0;
   }

   public static boolean equals(Object[] var0, Object[] var1) {
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = var0.length;
      }

      int var3;
      if(var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.length;
      }

      int var4 = 0;
      int var5 = 0;

      boolean var9;
      while(true) {
         while(var5 < var2 && var0[var5] == null) {
            ++var5;
         }

         int var6;
         for(var6 = var4; var6 < var3 && var1[var6] == null; ++var6) {
            ;
         }

         boolean var7;
         if(var5 >= var2) {
            var7 = true;
         } else {
            var7 = false;
         }

         boolean var8;
         if(var6 >= var3) {
            var8 = true;
         } else {
            var8 = false;
         }

         if(var7 && var8) {
            var9 = true;
            break;
         }

         var9 = false;
         if(var7 != var8) {
            break;
         }

         boolean var10 = var0[var5].equals(var1[var6]);
         var9 = false;
         if(!var10) {
            break;
         }

         int var11 = var5 + 1;
         var4 = var6 + 1;
         var5 = var11;
      }

      return var9;
   }

   public static int hashCode(int[] var0) {
      return var0 != null && var0.length != 0?Arrays.hashCode(var0):0;
   }

   public static int hashCode(long[] var0) {
      return var0 != null && var0.length != 0?Arrays.hashCode(var0):0;
   }

   public static int hashCode(Object[] var0) {
      int var1 = 0;
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = var0.length;
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = var0[var3];
         if(var4 != null) {
            var1 = var1 * 31 + var4.hashCode();
         }
      }

      return var1;
   }

   public static int zza(byte[][] var0) {
      int var1 = 0;
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = var0.length;
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         byte[] var4 = var0[var3];
         if(var4 != null) {
            var1 = var1 * 31 + Arrays.hashCode(var4);
         }
      }

      return var1;
   }

   public static void zza(zzso var0, zzso var1) {
      if(var0.zzbuj != null) {
         var1.zzbuj = var0.zzbuj.zzJq();
      }

   }

   public static boolean zza(byte[][] var0, byte[][] var1) {
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = var0.length;
      }

      int var3;
      if(var1 == null) {
         var3 = 0;
      } else {
         var3 = var1.length;
      }

      int var4 = 0;
      int var5 = 0;

      boolean var9;
      while(true) {
         while(var5 < var2 && var0[var5] == null) {
            ++var5;
         }

         int var6;
         for(var6 = var4; var6 < var3 && var1[var6] == null; ++var6) {
            ;
         }

         boolean var7;
         if(var5 >= var2) {
            var7 = true;
         } else {
            var7 = false;
         }

         boolean var8;
         if(var6 >= var3) {
            var8 = true;
         } else {
            var8 = false;
         }

         if(var7 && var8) {
            var9 = true;
            break;
         }

         var9 = false;
         if(var7 != var8) {
            break;
         }

         boolean var10 = Arrays.equals(var0[var5], var1[var6]);
         var9 = false;
         if(!var10) {
            break;
         }

         int var11 = var5 + 1;
         var4 = var6 + 1;
         var5 = var11;
      }

      return var9;
   }
}
