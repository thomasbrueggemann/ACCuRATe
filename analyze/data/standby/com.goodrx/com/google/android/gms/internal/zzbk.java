package com.google.android.gms.internal;

import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.PriorityQueue;

@zzhb
public class zzbk {
   static long zza(int var0, int var1, long var2, long var4, long var6) {
      long var8 = var4 * ((2147483647L + (long)var0) % 1073807359L) % 1073807359L;
      return (var6 * ((var2 + 1073807359L - var8) % 1073807359L) % 1073807359L + (2147483647L + (long)var1) % 1073807359L) % 1073807359L;
   }

   static long zza(long var0, int var2) {
      if(var2 == 0) {
         var0 = 1L;
      } else if(var2 != 1) {
         if(var2 % 2 == 0) {
            return zza(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L;
         }

         return var0 * (zza(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L) % 1073807359L;
      }

      return var0;
   }

   static String zza(String[] var0, int var1, int var2) {
      if(var0.length < var1 + var2) {
         zzin.e("Unable to construct shingle");
         return "";
      } else {
         StringBuffer var3 = new StringBuffer();

         for(int var4 = var1; var4 < -1 + var1 + var2; ++var4) {
            var3.append(var0[var4]);
            var3.append(' ');
         }

         var3.append(var0[-1 + var1 + var2]);
         return var3.toString();
      }
   }

   static void zza(int var0, long var1, String var3, int var4, PriorityQueue<zzbk.zza> var5) {
      zzbk.zza var6 = new zzbk.zza(var1, var3, var4);
      if((var5.size() != var0 || ((zzbk.zza)var5.peek()).value <= var6.value) && !var5.contains(var6)) {
         var5.add(var6);
         if(var5.size() > var0) {
            var5.poll();
            return;
         }
      }

   }

   public static void zza(String[] var0, int var1, int var2, PriorityQueue<zzbk.zza> var3) {
      if(var0.length < var2) {
         zza(var1, zzb(var0, 0, var0.length), zza(var0, 0, var0.length), var0.length, var3);
      } else {
         long var4 = zzb(var0, 0, var2);
         zza(var1, var4, zza(var0, 0, var2), var2, var3);
         long var6 = zza(16785407L, var2 - 1);

         long var9;
         for(int var8 = 1; var8 < 1 + (var0.length - var2); var4 = var9) {
            var9 = zza(zzbi.zzx(var0[var8 - 1]), zzbi.zzx(var0[-1 + var8 + var2]), var4, var6, 16785407L);
            zza(var1, var9, zza(var0, var8, var2), var0.length, var3);
            ++var8;
         }
      }

   }

   private static long zzb(String[] var0, int var1, int var2) {
      long var3 = (2147483647L + (long)zzbi.zzx(var0[var1])) % 1073807359L;

      for(int var5 = var1 + 1; var5 < var1 + var2; ++var5) {
         var3 = (var3 * 16785407L % 1073807359L + (2147483647L + (long)zzbi.zzx(var0[var5])) % 1073807359L) % 1073807359L;
      }

      return var3;
   }

   public static class zza {
      final long value;
      final String zztx;
      final int zzty;

      zza(long var1, String var3, int var4) {
         this.value = var1;
         this.zztx = var3;
         this.zzty = var4;
      }

      public boolean equals(Object var1) {
         return var1 != null && var1 instanceof zzbk.zza?((zzbk.zza)var1).value == this.value && ((zzbk.zza)var1).zzty == this.zzty:false;
      }

      public int hashCode() {
         return (int)this.value;
      }
   }
}
