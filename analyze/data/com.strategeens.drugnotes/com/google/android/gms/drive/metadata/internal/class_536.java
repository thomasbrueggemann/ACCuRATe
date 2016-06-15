package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.a;

// $FF: renamed from: com.google.android.gms.drive.metadata.internal.g
public class class_536 extends a<Long> {
   public class_536(String var1, int var2) {
      super(var1, var2);
   }

   // $FF: renamed from: a (android.os.Bundle, java.lang.Long) void
   protected void method_3286(Bundle var1, Long var2) {
      var1.putLong(this.getName(), var2.longValue());
   }

   // $FF: renamed from: c (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_3281(DataHolder var1, int var2, int var3) {
      return this.method_3287(var1, var2, var3);
   }

   // $FF: renamed from: h (com.google.android.gms.common.data.DataHolder, int, int) java.lang.Long
   protected Long method_3287(DataHolder var1, int var2, int var3) {
      return Long.valueOf(var1.method_5826(this.getName(), var2, var3));
   }

   // $FF: renamed from: i (android.os.Bundle) java.lang.Object
   // $FF: synthetic method
   protected Object method_3282(Bundle var1) {
      return this.method_3288(var1);
   }

   // $FF: renamed from: m (android.os.Bundle) java.lang.Long
   protected Long method_3288(Bundle var1) {
      return Long.valueOf(var1.getLong(this.getName()));
   }
}
