package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;

abstract class zzz extends zzy {
   private boolean zzQk;
   private boolean zzQl;
   private boolean zzaYC;

   zzz(zzw var1) {
      super(var1);
      this.zzaTV.zzb(this);
   }

   boolean isInitialized() {
      return this.zzQk && !this.zzQl;
   }

   boolean zzDi() {
      return this.zzaYC;
   }

   public final void zza() {
      if(this.zzQk) {
         throw new IllegalStateException("Can\'t initialize twice");
      } else {
         this.zziJ();
         this.zzaTV.zzDg();
         this.zzQk = true;
      }
   }

   protected abstract void zziJ();

   protected void zzjv() {
      if(!this.isInitialized()) {
         throw new IllegalStateException("Not initialized");
      }
   }
}
