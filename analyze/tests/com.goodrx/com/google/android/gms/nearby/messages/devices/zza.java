package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

abstract class zza {
   private static final char[] zzbbX = "0123456789abcdef".toCharArray();
   private final byte[] zzbbY;

   protected zza(byte[] var1) {
      this.zzbbY = var1;
   }

   static String zzt(byte[] var0) {
      StringBuilder var1 = new StringBuilder(2 * var0.length);
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         byte var4 = var0[var3];
         var1.append(zzbbX[15 & var4 >> 4]).append(zzbbX[var4 & 15]);
      }

      return var1.toString();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!var1.getClass().isAssignableFrom(this.getClass())) {
         return false;
      } else {
         zza var2 = (zza)var1;
         return Arrays.equals(this.zzbbY, var2.zzbbY);
      }
   }

   byte[] getBytes() {
      return this.zzbbY;
   }

   public int hashCode() {
      return Arrays.hashCode(this.zzbbY);
   }

   public String toString() {
      return zzt(this.zzbbY);
   }

   String zzEt() {
      return zzt(this.zzbbY);
   }
}
