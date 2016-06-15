package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.tagmanager.class_514;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_522;
import com.google.android.gms.tagmanager.class_542;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_75;

// $FF: renamed from: com.google.android.gms.tagmanager.cx
class class_543 extends class_542 {
   private static class_543 ahR;
   // $FF: renamed from: tQ java.lang.Object
   private static final Object field_2906 = new Object();
   private Context ahH;
   private class_72 ahI;
   private volatile class_75 ahJ;
   private int ahK = 1800000;
   private boolean ahL = true;
   private boolean ahM = false;
   private boolean ahN = true;
   private class_73 ahO = new class_73() {
      // $FF: renamed from: s (boolean) void
      public void method_369(boolean var1) {
         class_543.this.method_3080(var1, class_543.this.connected);
      }
   };
   private class_514 ahP;
   private boolean ahQ = false;
   private boolean connected = true;
   private Handler handler;

   // $FF: renamed from: cA () void
   private void method_3073() {
      this.ahP = new class_514(this);
      this.ahP.method_2915(this.ahH);
   }

   // $FF: renamed from: cB () void
   private void method_3074() {
      this.handler = new Handler(this.ahH.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && class_543.field_2906.equals(var1.obj)) {
               class_543.this.method_3081();
               if(class_543.this.ahK > 0 && !class_543.this.ahQ) {
                  class_543.this.handler.sendMessageDelayed(class_543.this.handler.obtainMessage(1, class_543.field_2906), (long)class_543.this.ahK);
               }
            }

            return true;
         }
      });
      if(this.ahK > 0) {
         this.handler.sendMessageDelayed(this.handler.obtainMessage(1, field_2906), (long)this.ahK);
      }

   }

   // $FF: renamed from: mL () com.google.android.gms.tagmanager.cx
   public static class_543 method_3078() {
      if(ahR == null) {
         ahR = new class_543();
      }

      return ahR;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.ar) void
   void method_3079(Context param1, class_75 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (boolean, boolean) void
   void method_3080(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cD () void
   void method_3068() {
      synchronized(this){}

      try {
         if(!this.ahQ && this.connected && this.ahK > 0) {
            this.handler.removeMessages(1, field_2906);
            this.handler.sendMessage(this.handler.obtainMessage(1, field_2906));
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cl () void
   public void method_3081() {
      synchronized(this){}

      try {
         if(!this.ahM) {
            class_515.method_2918("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.ahL = true;
         } else {
            this.ahJ.method_371(new Runnable() {
               public void run() {
                  class_543.this.ahI.method_366();
               }
            });
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: mM () com.google.android.gms.tagmanager.at
   class_72 method_3082() {
      synchronized(this){}

      class_72 var2;
      try {
         if(this.ahI == null) {
            if(this.ahH == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.ahI = new class_522(this.ahO, this.ahH);
         }

         if(this.handler == null) {
            this.method_3074();
         }

         this.ahM = true;
         if(this.ahL) {
            this.method_3081();
            this.ahL = false;
         }

         if(this.ahP == null && this.ahN) {
            this.method_3073();
         }

         var2 = this.ahI;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: t (boolean) void
   void method_3069(boolean var1) {
      synchronized(this){}

      try {
         this.method_3080(this.ahQ, var1);
      } finally {
         ;
      }

   }
}
