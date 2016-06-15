package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.analytics.class_133;
import com.google.android.gms.analytics.class_134;
import com.google.android.gms.analytics.class_135;
import com.google.android.gms.analytics.class_648;
import com.google.android.gms.analytics.class_649;
import com.google.android.gms.analytics.class_660;
import com.google.android.gms.analytics.class_668;
import com.google.android.gms.analytics.class_669;

// $FF: renamed from: com.google.android.gms.analytics.r
class class_650 extends class_649 {
   // $FF: renamed from: tQ java.lang.Object
   private static final Object field_3399 = new Object();
   // $FF: renamed from: uc com.google.android.gms.analytics.r
   private static class_650 field_3400;
   private Context mContext;
   private Handler mHandler;
   // $FF: renamed from: tR com.google.android.gms.analytics.d
   private class_135 field_3401;
   // $FF: renamed from: tS com.google.android.gms.analytics.f
   private volatile class_134 field_3402;
   // $FF: renamed from: tT int
   private int field_3403 = 1800;
   // $FF: renamed from: tU boolean
   private boolean field_3404 = true;
   // $FF: renamed from: tV boolean
   private boolean field_3405;
   // $FF: renamed from: tW java.lang.String
   private String field_3406;
   // $FF: renamed from: tX boolean
   private boolean field_3407 = true;
   // $FF: renamed from: tY boolean
   private boolean field_3408 = true;
   // $FF: renamed from: tZ com.google.android.gms.analytics.e
   private class_133 field_3409 = new class_133() {
      // $FF: renamed from: s (boolean) void
      public void method_698(boolean var1) {
         class_650.this.method_3718(var1, class_650.this.field_3407);
      }
   };
   // $FF: renamed from: ua com.google.android.gms.analytics.q
   private class_648 field_3410;
   // $FF: renamed from: ub boolean
   private boolean field_3411 = false;

   // $FF: renamed from: cA () void
   private void method_3712() {
      this.field_3410 = new class_648(this);
      this.field_3410.method_3706(this.mContext);
   }

   // $FF: renamed from: cB () void
   private void method_3713() {
      this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && class_650.field_3399.equals(var1.obj)) {
               class_660.method_3794().method_3798(true);
               class_650.this.dispatchLocalHits();
               class_660.method_3794().method_3798(false);
               if(class_650.this.field_3403 > 0 && !class_650.this.field_3411) {
                  class_650.this.mHandler.sendMessageDelayed(class_650.this.mHandler.obtainMessage(1, class_650.field_3399), (long)(1000 * class_650.this.field_3403));
               }
            }

            return true;
         }
      });
      if(this.field_3403 > 0) {
         this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, field_3399), (long)(1000 * this.field_3403));
      }

   }

   // $FF: renamed from: cz () com.google.android.gms.analytics.r
   public static class_650 method_3715() {
      if(field_3400 == null) {
         field_3400 = new class_650();
      }

      return field_3400;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.analytics.f) void
   void method_3717(Context param1, class_134 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (boolean, boolean) void
   void method_3718(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cC () com.google.android.gms.analytics.d
   class_135 method_3719() {
      synchronized(this){}

      class_135 var2;
      try {
         if(this.field_3401 == null) {
            if(this.mContext == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.field_3401 = new class_668(this.field_3409, this.mContext);
            if(this.field_3406 != null) {
               this.field_3401.method_706().method_708(this.field_3406);
               this.field_3406 = null;
            }
         }

         if(this.mHandler == null) {
            this.method_3713();
         }

         if(this.field_3410 == null && this.field_3408) {
            this.method_3712();
         }

         var2 = this.field_3401;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: cD () void
   void method_3707() {
      synchronized(this){}

      try {
         if(!this.field_3411 && this.field_3407 && this.field_3403 > 0) {
            this.mHandler.removeMessages(1, field_3399);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, field_3399));
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: cn () void
   void method_3720() {
      if(this.field_3402 == null) {
         class_669.method_3890("setForceLocalDispatch() queued. It will be called once initialization is complete.");
         this.field_3405 = true;
      } else {
         class_660.method_3794().method_3795(class_660.class_1313.field_3785);
         this.field_3402.method_701();
      }
   }

   void dispatchLocalHits() {
      synchronized(this){}

      try {
         if(this.field_3402 == null) {
            class_669.method_3890("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.field_3404 = true;
         } else {
            class_660.method_3794().method_3795(class_660.class_1313.field_3772);
            this.field_3402.method_700();
         }
      } finally {
         ;
      }

   }

   void setLocalDispatchPeriod(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: t (boolean) void
   void method_3708(boolean var1) {
      synchronized(this){}

      try {
         this.method_3718(this.field_3411, var1);
      } finally {
         ;
      }

   }
}
