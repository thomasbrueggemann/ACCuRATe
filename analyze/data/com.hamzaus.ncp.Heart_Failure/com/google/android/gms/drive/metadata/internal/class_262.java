package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.f
public class class_262 extends a<Integer> {
   public class_262(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Integer) void
   protected void method_1823(Bundle var1, Integer var2) {
      var1.putInt(this.getName(), var2.intValue());
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1824(var1, var2, var3);
   }

   // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Integer
   protected Integer method_1824(DataHolder var1, int var2, int var3) {
      return Integer.valueOf(var1.method_4558(this.getName(), var2, var3));
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1825(var1);
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Integer
   protected Integer method_1825(Bundle var1) {
      return Integer.valueOf(var1.getInt(this.getName()));
   }
}
