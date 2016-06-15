package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.f
public class class_535 extends a<Integer> {
   public class_535(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Integer) void
   protected void method_3283(Bundle var1, Integer var2) {
      var1.putInt(this.getName(), var2.intValue());
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3284(var1, var2, var3);
   }

   // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Integer
   protected Integer method_3284(DataHolder var1, int var2, int var3) {
      return Integer.valueOf(var1.method_5830(this.getName(), var2, var3));
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3285(var1);
   }

   // $FF: renamed from: l (android.os.Bundle) java.lang.Integer
   protected Integer method_3285(Bundle var1) {
      return Integer.valueOf(var1.getInt(this.getName()));
   }
}
