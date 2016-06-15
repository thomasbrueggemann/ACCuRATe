package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.tagmanager.class_611;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_620;
import com.google.android.gms.tagmanager.class_642;
import com.google.android.gms.tagmanager.class_77;
import com.google.android.gms.tagmanager.class_78;
import com.google.android.gms.tagmanager.class_80;

// $FF: renamed from: com.google.android.gms.tagmanager.cy
class class_643 extends class_642 {
   private static class_643 atJ;
   // $FF: renamed from: yT java.lang.Object
   private static final Object field_2765 = new Object();
   private class_77 atA;
   private volatile class_80 atB;
   private int atC = 1800000;
   private boolean atD = true;
   private boolean atE = false;
   private boolean atF = true;
   private class_78 atG = new class_78() {
      // $FF: renamed from: B (boolean) void
      public void method_410(boolean var1) {
         class_643.this.method_3667(var1, class_643.this.connected);
      }
   };
   private class_611 atH;
   private boolean atI = false;
   private Context atz;
   private boolean connected = true;
   private Handler handler;

   // $FF: renamed from: ev () void
   private void method_3662() {
      this.atH = new class_611(this);
      this.atH.method_3487(this.atz);
   }

   // $FF: renamed from: ew () void
   private void method_3663() {
      this.handler = new Handler(this.atz.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && class_643.field_2765.equals(var1.obj)) {
               class_643.this.dispatch();
               if(class_643.this.atC > 0 && !class_643.this.atI) {
                  class_643.this.handler.sendMessageDelayed(class_643.this.handler.obtainMessage(1, class_643.field_2765), (long)class_643.this.atC);
               }
            }

            return true;
         }
      });
      if(this.atC > 0) {
         this.handler.sendMessageDelayed(this.handler.obtainMessage(1, field_2765), (long)this.atC);
      }

   }

   // $FF: renamed from: qN () com.google.android.gms.tagmanager.cy
   public static class_643 method_3665() {
      if(atJ == null) {
         atJ = new class_643();
      }

      return atJ;
   }

   // $FF: renamed from: C (boolean) void
   void method_3655(boolean var1) {
      synchronized(this){}

      try {
         this.method_3667(this.atI, var1);
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.ar) void
   void method_3666(Context param1, class_80 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (boolean, boolean) void
   void method_3667(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      synchronized(this){}

      try {
         if(!this.atE) {
            class_613.method_3493("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.atD = true;
         } else {
            this.atB.method_412(new Runnable() {
               public void run() {
                  class_643.this.atA.dispatch();
               }
            });
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: ey () void
   void method_3656() {
      synchronized(this){}

      try {
         if(!this.atI && this.connected && this.atC > 0) {
            this.handler.removeMessages(1, field_2765);
            this.handler.sendMessage(this.handler.obtainMessage(1, field_2765));
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: qO () com.google.android.gms.tagmanager.at
   class_77 method_3668() {
      synchronized(this){}

      class_77 var2;
      try {
         if(this.atA == null) {
            if(this.atz == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.atA = new class_620(this.atG, this.atz);
         }

         if(this.handler == null) {
            this.method_3663();
         }

         this.atE = true;
         if(this.atD) {
            this.dispatch();
            this.atD = false;
         }

         if(this.atH == null && this.atF) {
            this.method_3662();
         }

         var2 = this.atA;
      } finally {
         ;
      }

      return var2;
   }
}
