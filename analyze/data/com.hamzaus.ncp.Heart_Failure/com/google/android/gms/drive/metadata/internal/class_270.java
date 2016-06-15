package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.d;
import java.util.Date;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.d
public class class_270 extends d<Date> {
   public class_270(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.util.Date) void
   protected void method_1841(Bundle var1, Date var2) {
      var1.putLong(this.getName(), var2.getTime());
   }

   // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_1821(DataHolder var1, int var2, int var3) {
      return this.method_1842(var1, var2, var3);
   }

   // $FF: renamed from: e (com.google.android.gms.common.data.DataHolder, int, int) java.util.Date
   protected Date method_1842(DataHolder var1, int var2, int var3) {
      return new Date(var1.method_4554(this.getName(), var2, var3));
   }

   // $FF: renamed from: f (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_1822(Bundle var1) {
      return this.method_1843(var1);
   }

   // $FF: renamed from: h (android.os.Bundle) java.util.Date
   protected Date method_1843(Bundle var1) {
      return new Date(var1.getLong(this.getName()));
   }
}
