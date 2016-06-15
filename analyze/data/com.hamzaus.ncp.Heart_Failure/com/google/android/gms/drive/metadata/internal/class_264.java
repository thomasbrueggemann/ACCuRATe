package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.b
public class class_264 extends a<Boolean> {
   public class_264(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Boolean) void
   protected void method_1829(Bundle var1, Boolean var2) {
      var1.putBoolean(this.getName(), var2.booleanValue());
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1830(var1, var2, var3);
   }

   // $FF: renamed from: d (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Boolean
   protected Boolean method_1830(DataHolder var1, int var2, int var3) {
      return Boolean.valueOf(var1.method_4561(this.getName(), var2, var3));
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1831(var1);
   }

   // $FF: renamed from: g (android.os.Bundle) java.lang.Boolean
   protected Boolean method_1831(Bundle var1) {
      return Boolean.valueOf(var1.getBoolean(this.getName()));
   }
}
