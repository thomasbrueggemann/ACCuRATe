package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.analytics.class_168;
import com.google.android.gms.analytics.class_169;
import com.google.android.gms.analytics.class_170;
import com.google.android.gms.analytics.class_837;
import com.google.android.gms.analytics.class_849;
import com.google.android.gms.analytics.class_852;
import com.google.android.gms.analytics.class_854;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.analytics.class_871;

// $FF: renamed from: com.google.android.gms.analytics.v
class class_853 extends class_852 {
   // $FF: renamed from: yT java.lang.Object
   private static final Object field_3548 = new Object();
   // $FF: renamed from: zf com.google.android.gms.analytics.v
   private static class_853 field_3549;
   private Context mContext;
   private Handler mHandler;
   // $FF: renamed from: yU com.google.android.gms.analytics.d
   private class_170 field_3550;
   // $FF: renamed from: yV com.google.android.gms.analytics.f
   private volatile class_169 field_3551;
   // $FF: renamed from: yW int
   private int field_3552 = 1800;
   // $FF: renamed from: yX boolean
   private boolean field_3553 = true;
   // $FF: renamed from: yY boolean
   private boolean field_3554;
   // $FF: renamed from: yZ java.lang.String
   private String field_3555;
   // $FF: renamed from: yt boolean
   private boolean field_3556 = false;
   // $FF: renamed from: za boolean
   private boolean field_3557 = true;
   // $FF: renamed from: zb boolean
   private boolean field_3558 = true;
   // $FF: renamed from: zc com.google.android.gms.analytics.e
   private class_168 field_3559 = new class_168() {
      // $FF: renamed from: B (boolean) void
      public void method_844(boolean var1) {
         class_853.this.method_4733(var1, class_853.this.field_3557);
      }
   };
   // $FF: renamed from: zd com.google.android.gms.analytics.u
   private class_854 field_3560;
   // $FF: renamed from: ze boolean
   private boolean field_3561 = false;

   // $FF: renamed from: eu () com.google.android.gms.analytics.v
   public static class_853 method_4728() {
      if(field_3549 == null) {
         field_3549 = new class_853();
      }

      return field_3549;
   }

   // $FF: renamed from: ev () void
   private void method_4729() {
      this.field_3560 = new class_854(this);
      this.field_3560.method_4736(this.mContext);
   }

   // $FF: renamed from: ew () void
   private void method_4730() {
      this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && class_853.field_3548.equals(var1.obj)) {
               class_849.method_4705().method_4706(true);
               class_853.this.dispatchLocalHits();
               class_849.method_4705().method_4706(false);
               if(class_853.this.field_3552 > 0 && !class_853.this.field_3561) {
                  class_853.this.mHandler.sendMessageDelayed(class_853.this.mHandler.obtainMessage(1, class_853.field_3548), (long)(1000 * class_853.this.field_3552));
               }
            }

            return true;
         }
      });
      if(this.field_3552 > 0) {
         this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, field_3548), (long)(1000 * this.field_3552));
      }

   }

   // $FF: renamed from: C (boolean) void
   void method_4722(boolean var1) {
      synchronized(this){}

      try {
         this.method_4733(this.field_3561, var1);
      } finally {
         ;
      }

   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.analytics.f) void
   void method_4732(Context param1, class_169 param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (boolean, boolean) void
   void method_4733(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dW () void
   void method_4734() {
      if(this.field_3551 == null) {
         class_863.method_4841("setForceLocalDispatch() queued. It will be called once initialization is complete.");
         this.field_3554 = true;
      } else {
         class_849.method_4705().method_4707(class_849.class_1322.field_3032);
         this.field_3551.method_846();
      }
   }

   void dispatchLocalHits() {
      synchronized(this){}

      try {
         if(this.field_3551 == null) {
            class_863.method_4841("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.field_3553 = true;
         } else {
            class_849.method_4705().method_4707(class_849.class_1322.field_2993);
            this.field_3551.dispatch();
         }
      } finally {
         ;
      }

   }

   // $FF: renamed from: ex () com.google.android.gms.analytics.d
   class_170 method_4735() {
      synchronized(this){}

      class_170 var2;
      try {
         if(this.field_3550 == null) {
            if(this.mContext == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.field_3550 = new class_871(this.field_3559, this.mContext, new class_837());
            this.field_3550.setDryRun(this.field_3556);
            if(this.field_3555 != null) {
               this.field_3550.method_851().method_854(this.field_3555);
               this.field_3555 = null;
            }
         }

         if(this.mHandler == null) {
            this.method_4730();
         }

         if(this.field_3560 == null && this.field_3558) {
            this.method_4729();
         }

         var2 = this.field_3550;
      } finally {
         ;
      }

      return var2;
   }

   // $FF: renamed from: ey () void
   void method_4723() {
      synchronized(this){}

      try {
         if(!this.field_3561 && this.field_3557 && this.field_3552 > 0) {
            this.mHandler.removeMessages(1, field_3548);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, field_3548));
         }
      } finally {
         ;
      }

   }

   void setLocalDispatchPeriod(int param1) {
      // $FF: Couldn't be decompiled
   }
}
