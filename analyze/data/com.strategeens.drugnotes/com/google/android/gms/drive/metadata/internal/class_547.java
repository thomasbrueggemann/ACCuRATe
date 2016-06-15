package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.d;
import java.util.Date;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.d
public class class_547 extends d<Date> {
   public class_547(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.util.Date) void
   protected void method_3310(Bundle var1, Date var2) {
      var1.putLong(this.getName(), var2.getTime());
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3311(var1, var2, var3);
   }

   // $FF: renamed from: f (com.google.android.gms.common.data.DataHolder, int, int) java.util.Date
   protected Date method_3311(DataHolder var1, int var2, int var3) {
      return new Date(var1.method_5826(this.getName(), var2, var3));
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3312(var1);
   }

   // $FF: renamed from: k (android.os.Bundle) java.util.Date
   protected Date method_3312(Bundle var1) {
      return new Date(var1.getLong(this.getName()));
   }
}
