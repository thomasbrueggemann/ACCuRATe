package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzmq;

class zzaj {
   private long zzCv;
   private final zzmq zzqW;

   public zzaj(zzmq var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzqW = var1;
   }

   public zzaj(zzmq var1, long var2) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzqW = var1;
      this.zzCv = var2;
   }

   public void clear() {
      this.zzCv = 0L;
   }

   public void start() {
      this.zzCv = this.zzqW.elapsedRealtime();
   }

   public boolean zzv(long var1) {
      return this.zzCv == 0L || this.zzqW.elapsedRealtime() - this.zzCv > var1;
   }
}
