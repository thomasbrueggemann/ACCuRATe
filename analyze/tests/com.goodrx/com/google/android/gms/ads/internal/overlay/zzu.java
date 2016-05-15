package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzir;

@zzhb
class zzu implements Runnable {
   private boolean mCancelled = false;
   private zzk zzFo;

   zzu(zzk var1) {
      this.zzFo = var1;
   }

   public void cancel() {
      this.mCancelled = true;
      zzir.zzMc.removeCallbacks(this);
   }

   public void run() {
      if(!this.mCancelled) {
         this.zzFo.zzfF();
         this.zzfQ();
      }

   }

   public void zzfQ() {
      zzir.zzMc.postDelayed(this, 250L);
   }
}
