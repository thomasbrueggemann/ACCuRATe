package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

// $FF: renamed from: com.google.android.gms.analytics.l
class class_647 implements Logger {
   // $FF: renamed from: tK int
   private int field_3396 = 1;

   // $FF: renamed from: L (java.lang.String) java.lang.String
   private String method_3704(String var1) {
      return Thread.currentThread().toString() + ": " + var1;
   }

   public void error(Exception var1) {
      if(this.field_3396 <= 3) {
         Log.e("GAV4", (String)null, var1);
      }

   }

   public void error(String var1) {
      if(this.field_3396 <= 3) {
         Log.e("GAV4", this.method_3704(var1));
      }

   }

   public int getLogLevel() {
      return this.field_3396;
   }

   public void info(String var1) {
      if(this.field_3396 <= 1) {
         Log.i("GAV4", this.method_3704(var1));
      }

   }

   public void setLogLevel(int var1) {
      this.field_3396 = var1;
   }

   public void verbose(String var1) {
      if(this.field_3396 <= 0) {
         Log.v("GAV4", this.method_3704(var1));
      }

   }

   public void warn(String var1) {
      if(this.field_3396 <= 2) {
         Log.w("GAV4", this.method_3704(var1));
      }

   }
}
