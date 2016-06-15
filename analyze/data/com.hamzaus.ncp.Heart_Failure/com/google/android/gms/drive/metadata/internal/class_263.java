package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.g
public class class_263 extends a<Long> {
   public class_263(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Long) void
   protected void method_1826(Bundle var1, Long var2) {
      var1.putLong(this.getName(), var2.longValue());
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1827(var1, var2, var3);
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1828(var1);
   }

   // $FF: renamed from: g (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Long
   protected Long method_1827(DataHolder var1, int var2, int var3) {
      return Long.valueOf(var1.method_4554(this.getName(), var2, var3));
   }

   // $FF: renamed from: j (android.os.Bundle) java.lang.Long
   protected Long method_1828(Bundle var1) {
      return Long.valueOf(var1.getLong(this.getName()));
   }
}
