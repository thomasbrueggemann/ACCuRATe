package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_543;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_75;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

// $FF: renamed from: com.google.android.gms.tagmanager.as
class class_516 extends Thread implements class_75 {
   private static class_516 afF;
   private final LinkedBlockingQueue<Runnable> afE = new LinkedBlockingQueue();
   private volatile class_72 afG;
   private volatile boolean mClosed = false;
   private final Context mContext;
   // $FF: renamed from: uI boolean
   private volatile boolean field_2872 = false;

   private class_516(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.start();
   }

   // $FF: renamed from: M (android.content.Context) com.google.android.gms.tagmanager.as
   static class_516 method_2924(Context var0) {
      if(afF == null) {
         afF = new class_516(var0);
      }

      return afF;
   }

   // $FF: renamed from: a (java.lang.Throwable) java.lang.String
   private String method_2927(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   // $FF: renamed from: a (java.lang.Runnable) void
   public void method_371(Runnable var1) {
      this.afE.add(var1);
   }

   // $FF: renamed from: b (java.lang.String, long) void
   void method_2929(final String var1, final long var2) {
      this.method_371(new Runnable() {
         public void run() {
            if(class_516.this.afG == null) {
               class_543 var1x = class_543.method_3078();
               var1x.method_3079(class_516.this.mContext, class_516.this);
               class_516.this.afG = var1x.method_3082();
            }

            class_516.this.afG.method_367(var2, var1);
         }
      });
   }

   // $FF: renamed from: bU (java.lang.String) void
   public void method_372(String var1) {
      this.method_2929(var1, System.currentTimeMillis());
   }

   public void run() {
      while(!this.mClosed) {
         try {
            try {
               Runnable var3 = (Runnable)this.afE.take();
               if(!this.field_2872) {
                  var3.run();
               }
            } catch (InterruptedException var4) {
               class_515.method_2917(var4.toString());
            }
         } catch (Throwable var5) {
            class_515.method_2916("Error on GAThread: " + this.method_2927(var5));
            class_515.method_2916("Google Analytics is shutting down.");
            this.field_2872 = true;
         }
      }

   }
}
