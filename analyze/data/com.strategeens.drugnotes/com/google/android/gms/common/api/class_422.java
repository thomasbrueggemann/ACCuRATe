package com.google.android.gms.common.api;

import com.google.android.gms.common.api.class_1033;
import com.google.android.gms.common.data.DataHolder;

// $FF: renamed from: com.google.android.gms.common.api.a
public abstract class class_422<L> implements class_1033.class_1137<L> {
   // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
   private final DataHolder field_1324;

   protected class_422(DataHolder var1) {
      this.field_1324 = var1;
   }

   // $FF: renamed from: a (java.lang.Object, com.google.android.gms.common.data.DataHolder) void
   protected abstract void method_2784(L var1, DataHolder var2);

   // $FF: renamed from: c (java.lang.Object) void
   public final void method_199(L var1) {
      this.method_2784(var1, this.field_1324);
   }

   // $FF: renamed from: gG () void
   public void method_200() {
      if(this.field_1324 != null) {
         this.field_1324.close();
      }

   }
}
