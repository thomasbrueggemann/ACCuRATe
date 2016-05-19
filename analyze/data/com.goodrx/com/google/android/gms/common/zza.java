package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class zza implements ServiceConnection {
   private final BlockingQueue<IBinder> zzafA = new LinkedBlockingQueue();
   boolean zzafz = false;

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      this.zzafA.add(var2);
   }

   public void onServiceDisconnected(ComponentName var1) {
   }

   public IBinder zzoJ() throws InterruptedException {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
      } else if(this.zzafz) {
         throw new IllegalStateException();
      } else {
         this.zzafz = true;
         return (IBinder)this.zzafA.take();
      }
   }
}
