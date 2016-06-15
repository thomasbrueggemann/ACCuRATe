package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.l
public class class_538 extends a<String> {
   public class_538(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.String) void
   protected void method_3292(Bundle var1, String var2) {
      var1.putString(this.getName(), var2);
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3293(var1, var2, var3);
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3294(var1);
   }

   // $FF: renamed from: i (com.google.android.gms.common.data.DataHolder, int, int) java.lang.String
   protected String method_3293(DataHolder var1, int var2, int var3) {
      return var1.method_5831(this.getName(), var2, var3);
   }

   // $FF: renamed from: p (android.os.Bundle) java.lang.String
   protected String method_3294(Bundle var1) {
      return var1.getString(this.getName());
   }
}
