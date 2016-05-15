package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzmq;

public final class zzmt implements zzmq {
   private static zzmt zzaoa;

   public static zzmq zzsc() {
      synchronized(zzmt.class){}

      zzmt var1;
      try {
         if(zzaoa == null) {
            zzaoa = new zzmt();
         }

         var1 = zzaoa;
      } finally {
         ;
      }

      return var1;
   }

   public long currentTimeMillis() {
      return System.currentTimeMillis();
   }

   public long elapsedRealtime() {
      return SystemClock.elapsedRealtime();
   }
}
