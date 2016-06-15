package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_643;
import com.google.android.gms.tagmanager.class_77;
import com.google.android.gms.tagmanager.class_80;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.tagmanager.as
class class_614 extends Thread implements class_80 {
   private static class_614 ary;
   private final LinkedBlockingQueue<Runnable> arx = new LinkedBlockingQueue();
   private volatile class_77 arz;
   private volatile boolean mClosed = false;
   private final Context mContext;
   // $FF: renamed from: zK boolean
   private volatile boolean field_2717 = false;

   private class_614(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.start();
   }

   // $FF: renamed from: Z (android.content.Context) com.google.android.gms.tagmanager.as
   static class_614 method_3498(Context var0) {
      if(ary == null) {
         ary = new class_614(var0);
      }

      return ary;
   }

   // $FF: renamed from: g (java.lang.Throwable) java.lang.String
   private String method_3502(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   // $FF: renamed from: b (java.lang.Runnable) void
   public void method_412(Runnable var1) {
      this.arx.add(var1);
   }

   // $FF: renamed from: b (java.lang.String, long) void
   void method_3503(final String var1, final long var2) {
      this.method_412(new Runnable() {
         public void run() {
            if(class_614.this.arz == null) {
               class_643 var1x = class_643.method_3665();
               var1x.method_3666(class_614.this.mContext, class_614.this);
               class_614.this.arz = var1x.method_3668();
            }

            class_614.this.arz.method_408(var2, var1);
         }
      });
   }

   // $FF: renamed from: cE (java.lang.String) void
   public void method_413(String var1) {
      this.method_3503(var1, System.currentTimeMillis());
   }

   public void run() {
      while(!this.mClosed) {
         try {
            try {
               Runnable var3 = (Runnable)this.arx.take();
               if(!this.field_2717) {
                  var3.run();
               }
            } catch (InterruptedException var4) {
               class_613.method_3492(var4.toString());
            }
         } catch (Throwable var5) {
            class_613.method_3491("Error on Google TagManager Thread: " + this.method_3502(var5));
            class_613.method_3491("Google TagManager is shutting down.");
            this.field_2717 = true;
         }
      }

   }
}
