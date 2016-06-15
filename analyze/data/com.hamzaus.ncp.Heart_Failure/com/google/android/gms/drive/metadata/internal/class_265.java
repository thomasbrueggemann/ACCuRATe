package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.l
public class class_265 extends a<String> {
   public class_265(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.String) void
   protected void method_1832(Bundle var1, String var2) {
      var1.putString(this.getName(), var2);
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1833(var1, var2, var3);
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1834(var1);
   }

   // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder, int, int) java.lang.String
   protected String method_1833(DataHolder var1, int var2, int var3) {
      return var1.method_4560(this.getName(), var2, var3);
   }

   // $FF: renamed from: m (android.os.Bundle) java.lang.String
   protected String method_1834(Bundle var1) {
      return var1.getString(this.getName());
   }
}
