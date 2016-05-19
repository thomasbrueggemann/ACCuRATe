package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzmm;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzmr {
   public static <T> Set<T> zzA(T var0) {
      return Collections.singleton(var0);
   }

   public static <K, V> Map<K, V> zza(K var0, V var1, K var2, V var3, K var4, V var5, K var6, V var7, K var8, V var9, K var10, V var11) {
      ArrayMap var12 = new ArrayMap(6);
      var12.put(var0, var1);
      var12.put(var2, var3);
      var12.put(var4, var5);
      var12.put(var6, var7);
      var12.put(var8, var9);
      var12.put(var10, var11);
      return Collections.unmodifiableMap(var12);
   }

   public static <T> Set<T> zza(T var0, T var1, T var2) {
      zzmm var3 = new zzmm(3);
      var3.add(var0);
      var3.add(var1);
      var3.add(var2);
      return Collections.unmodifiableSet(var3);
   }

   public static <T> Set<T> zza(T var0, T var1, T var2, T var3) {
      zzmm var4 = new zzmm(4);
      var4.add(var0);
      var4.add(var1);
      var4.add(var2);
      var4.add(var3);
      return Collections.unmodifiableSet(var4);
   }

   public static <T> Set<T> zzc(T... var0) {
      switch(var0.length) {
      case 0:
         return zzsb();
      case 1:
         return zzA(var0[0]);
      case 2:
         return zzd(var0[0], var0[1]);
      case 3:
         return zza(var0[0], var0[1], var0[2]);
      case 4:
         return zza(var0[0], var0[1], var0[2], var0[3]);
      default:
         Object var1;
         if(var0.length <= 32) {
            var1 = new zzmm(Arrays.asList(var0));
         } else {
            var1 = new HashSet(Arrays.asList(var0));
         }

         return Collections.unmodifiableSet((Set)var1);
      }
   }

   public static <T> Set<T> zzd(T var0, T var1) {
      zzmm var2 = new zzmm(2);
      var2.add(var0);
      var2.add(var1);
      return Collections.unmodifiableSet(var2);
   }

   public static <T> Set<T> zzsb() {
      return Collections.emptySet();
   }
}
