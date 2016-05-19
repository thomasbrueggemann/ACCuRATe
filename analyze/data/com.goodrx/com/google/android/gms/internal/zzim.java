package com.google.android.gms.internal;

import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zziq;
import java.util.concurrent.Future;

@zzhb
public abstract class zzim {
   private volatile Thread zzLM;
   private boolean zzLN = false;
   private final Runnable zzx = new Runnable() {
      public final void run() {
         zzim.this.zzLM = Thread.currentThread();
         zzim.this.zzbr();
      }
   };

   public abstract void zzbr();

   public final Future zzhn() {
      return this.zzLN?zziq.zza(1, this.zzx):zziq.zza(this.zzx);
   }
}
