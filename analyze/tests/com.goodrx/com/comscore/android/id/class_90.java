package com.comscore.android.id;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.comscore.android.id.class_88;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.comscore.android.id.b
final class class_90 implements ServiceConnection {
   // $FF: renamed from: a boolean
   boolean field_614;
   // $FF: renamed from: b java.util.concurrent.LinkedBlockingQueue
   private final LinkedBlockingQueue<IBinder> field_615;

   private class_90() {
      this.field_614 = false;
      this.field_615 = new LinkedBlockingQueue(1);
   }

   // $FF: synthetic method
   class_90(class_88 var1) {
      this();
   }

   public IBinder getBinder() {
      if(this.field_614) {
         throw new IllegalStateException();
      } else {
         this.field_614 = true;
         return (IBinder)this.field_615.take();
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      try {
         this.field_615.put(var2);
      } catch (InterruptedException var4) {
         ;
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
   }
}
