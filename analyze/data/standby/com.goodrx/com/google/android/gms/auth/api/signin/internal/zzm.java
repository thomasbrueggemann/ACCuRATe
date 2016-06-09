package com.google.android.gms.auth.api.signin.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class zzm {
   private static final WeakHashMap<String, zzm> zzXE = new WeakHashMap();
   private static final Lock zzXF = new ReentrantLock();
   private final Lock zzXG = new ReentrantLock();
   private final Map<String, zzm.zza> zzXH;

   private zzm(Map<String, zzm.zza> var1) {
      this.zzXH = var1;
   }

   public static zzm zzbN(String param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean zza(Set<String> var1, zzm.zza var2) {
      zzx.zzz(var1);
      zzx.zzz(var2);
      if(var1.size() != 0 && !var2.zzb()) {
         ArrayList var5 = new ArrayList(var1);
         Collections.sort(var5);
         this.zzXG.lock();

         try {
            String var7 = TextUtils.join(" ", var5);
            this.zzXH.put(var7, var2);
         } finally {
            this.zzXG.unlock();
         }

         return true;
      } else {
         return false;
      }
   }

   public static class zza {
      private final String zzXI;
      private final long zzXJ;
      private final zzmq zzqW;

      public zza(String var1, long var2) {
         this(var1, var2, zzmt.zzsc());
      }

      private zza(String var1, long var2, zzmq var4) {
         this.zzXI = zzx.zzcM(var1);
         boolean var5;
         if(var2 > 0L) {
            var5 = true;
         } else {
            var5 = false;
         }

         zzx.zzac(var5);
         this.zzXJ = var2;
         this.zzqW = (zzmq)zzx.zzz(var4);
      }

      public boolean zzb() {
         return this.zzqW.currentTimeMillis() / 1000L >= this.zzXJ - 300L;
      }
   }

   static class zzb<K, V> extends LinkedHashMap<K, V> {
      private final int zzav;

      public zzb(int var1) {
         this.zzav = var1;
      }

      protected boolean removeEldestEntry(Entry<K, V> var1) {
         return this.size() > this.zzav;
      }
   }
}
