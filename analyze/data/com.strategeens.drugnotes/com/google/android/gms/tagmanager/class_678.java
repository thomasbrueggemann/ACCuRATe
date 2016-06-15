package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.tagmanager.class_75;

// $FF: renamed from: com.google.android.gms.tagmanager.x
class class_678 implements class_75 {
   // $FF: renamed from: yM int
   private int field_2925 = 5;

   // $FF: renamed from: S (java.lang.String) void
   public void method_399(String var1) {
      if(this.field_2925 <= 3) {
         Log.d("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: T (java.lang.String) void
   public void method_400(String var1) {
      if(this.field_2925 <= 6) {
         Log.e("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: U (java.lang.String) void
   public void method_401(String var1) {
      if(this.field_2925 <= 4) {
         Log.i("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: V (java.lang.String) void
   public void method_402(String var1) {
      if(this.field_2925 <= 2) {
         Log.v("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: W (java.lang.String) void
   public void method_403(String var1) {
      if(this.field_2925 <= 5) {
         Log.w("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
   public void method_404(String var1, Throwable var2) {
      if(this.field_2925 <= 6) {
         Log.e("GoogleTagManager", var1, var2);
      }

   }

   // $FF: renamed from: d (java.lang.String, java.lang.Throwable) void
   public void method_405(String var1, Throwable var2) {
      if(this.field_2925 <= 5) {
         Log.w("GoogleTagManager", var1, var2);
      }

   }

   public void setLogLevel(int var1) {
      this.field_2925 = var1;
   }
}
