package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.common.a
public class class_861 implements ServiceConnection {
   // $FF: renamed from: Is boolean
   boolean field_3657 = false;
   // $FF: renamed from: It java.util.concurrent.BlockingQueue
   private final BlockingQueue<IBinder> field_3658 = new LinkedBlockingQueue();

   // $FF: renamed from: gs () android.os.IBinder
   public IBinder method_4824() throws InterruptedException {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
      } else if(this.field_3657) {
         throw new IllegalStateException();
      } else {
         this.field_3657 = true;
         return (IBinder)this.field_3658.take();
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      this.field_3658.add(var2);
   }

   public void onServiceDisconnected(ComponentName var1) {
   }
}
