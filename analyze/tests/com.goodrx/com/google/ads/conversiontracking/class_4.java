package com.google.ads.conversiontracking;

import android.content.Context;
import android.util.Log;
import com.google.ads.conversiontracking.GoogleConversionReporter;
import com.google.ads.conversiontracking.class_79;

// $FF: renamed from: com.google.ads.conversiontracking.b
public class class_4 extends GoogleConversionReporter {
   // $FF: renamed from: a android.content.Context
   private Context field_5;

   public class_4(Context var1) {
      this.field_5 = var1;
   }

   // $FF: renamed from: a (java.lang.String, long) void
   public void method_31(String var1, long var2) {
      try {
         this.a(this.field_5, (new class_79.class_95()).method_55(var1).method_56(true).method_57().method_52(var2), false, true, true);
      } catch (Exception var5) {
         Log.e("GoogleConversionReporter", "Error sending ping", var5);
      }
   }
}
