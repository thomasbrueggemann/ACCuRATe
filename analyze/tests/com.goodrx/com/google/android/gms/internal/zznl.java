package com.google.android.gms.internal;

import android.os.Process;

class zznl implements Runnable {
   private final int mPriority;
   private final Runnable zzx;

   public zznl(Runnable var1, int var2) {
      this.zzx = var1;
      this.mPriority = var2;
   }

   public void run() {
      Process.setThreadPriority(this.mPriority);
      this.zzx.run();
   }
}
