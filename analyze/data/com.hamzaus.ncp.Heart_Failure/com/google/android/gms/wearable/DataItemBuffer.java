package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_207;

public class DataItemBuffer extends g<DataItem> implements Result {
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   private final Status field_1928;

   public DataItemBuffer(DataHolder var1) {
      super(var1);
      this.field_1928 = new Status(var1.getStatusCode());
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2632(var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "path";
   }

   public Status getStatus() {
      return this.field_1928;
   }

   // $FF: renamed from: n (int, int) com.google.android.gms.wearable.DataItem
   protected DataItem method_2632(int var1, int var2) {
      return new class_207(this.DD, var1, var2);
   }
}
