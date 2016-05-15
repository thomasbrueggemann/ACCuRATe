package com.google.android.gms.internal;

import com.google.android.gms.internal.zzi;

public class zzr extends Exception {
   private long zzC;
   public final zzi zzaj;

   public zzr() {
      this.zzaj = null;
   }

   public zzr(zzi var1) {
      this.zzaj = var1;
   }

   public zzr(Throwable var1) {
      super(var1);
      this.zzaj = null;
   }

   void zza(long var1) {
      this.zzC = var1;
   }
}
