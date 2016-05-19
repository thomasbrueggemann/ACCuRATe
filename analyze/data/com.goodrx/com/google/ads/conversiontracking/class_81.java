package com.google.ads.conversiontracking;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.ads.conversiontracking.n
public class class_81 implements ServiceConnection {
   // $FF: renamed from: a boolean
   boolean field_588 = false;
   // $FF: renamed from: b java.util.concurrent.BlockingQueue
   private final BlockingQueue<IBinder> field_589 = new LinkedBlockingQueue();

   // $FF: renamed from: a () android.os.IBinder
   public IBinder method_549() throws InterruptedException {
      if(this.field_588) {
         throw new IllegalStateException();
      } else {
         this.field_588 = true;
         return (IBinder)this.field_589.take();
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      try {
         this.field_589.put(var2);
      } catch (InterruptedException var4) {
         ;
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
   }
}
