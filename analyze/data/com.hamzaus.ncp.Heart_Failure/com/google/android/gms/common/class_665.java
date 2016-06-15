package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.common.a
public class class_665 implements ServiceConnection {
   // $FF: renamed from: CN boolean
   boolean field_3509 = false;
   // $FF: renamed from: CO java.util.concurrent.BlockingQueue
   private final BlockingQueue<IBinder> field_3510 = new LinkedBlockingQueue();

   // $FF: renamed from: er () android.os.IBinder
   public IBinder method_3853() throws InterruptedException {
      if(this.field_3509) {
         throw new IllegalStateException();
      } else {
         this.field_3509 = true;
         return (IBinder)this.field_3510.take();
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      try {
         this.field_3510.put(var2);
      } catch (InterruptedException var4) {
         ;
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
   }
}
