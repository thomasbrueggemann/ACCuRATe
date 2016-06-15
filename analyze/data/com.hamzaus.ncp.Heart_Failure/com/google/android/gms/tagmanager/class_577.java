package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.tagmanager.class_70;

// $FF: renamed from: com.google.android.gms.tagmanager.x
class class_577 implements class_70 {
   // $FF: renamed from: tK int
   private int field_3059 = 5;

   // $FF: renamed from: A (java.lang.String) void
   public void method_357(String var1) {
      if(this.field_3059 <= 6) {
         Log.e("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: B (java.lang.String) void
   public void method_358(String var1) {
      if(this.field_3059 <= 4) {
         Log.i("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: C (java.lang.String) void
   public void method_359(String var1) {
      if(this.field_3059 <= 2) {
         Log.v("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: D (java.lang.String) void
   public void method_360(String var1) {
      if(this.field_3059 <= 5) {
         Log.w("GoogleTagManager", var1);
      }

   }

   // $FF: renamed from: b (java.lang.String, java.lang.Throwable) void
   public void method_361(String var1, Throwable var2) {
      if(this.field_3059 <= 6) {
         Log.e("GoogleTagManager", var1, var2);
      }

   }

   // $FF: renamed from: c (java.lang.String, java.lang.Throwable) void
   public void method_362(String var1, Throwable var2) {
      if(this.field_3059 <= 5) {
         Log.w("GoogleTagManager", var1, var2);
      }

   }

   public void setLogLevel(int var1) {
      this.field_3059 = var1;
   }

   // $FF: renamed from: z (java.lang.String) void
   public void method_363(String var1) {
      if(this.field_3059 <= 3) {
         Log.d("GoogleTagManager", var1);
      }

   }
}
