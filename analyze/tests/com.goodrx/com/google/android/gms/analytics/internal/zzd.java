package com.google.android.gms.analytics.internal;

import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zzf;

public abstract class zzd extends zzc {
   private boolean zzQk;
   private boolean zzQl;

   protected zzd(zzf var1) {
      super(var1);
   }

   public boolean isInitialized() {
      return this.zzQk && !this.zzQl;
   }

   public void zza() {
      this.zziJ();
      this.zzQk = true;
   }

   protected abstract void zziJ();

   protected void zzjv() {
      if(!this.isInitialized()) {
         throw new IllegalStateException("Not initialized");
      }
   }
}
