package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_253;

public class DataItemBuffer extends g<DataItem> implements Result {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_1603;

   public DataItemBuffer(DataHolder var1) {
      super(var1);
      this.field_1603 = new Status(var1.getStatusCode());
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2993(var1, var2);
   }

   public Status getStatus() {
      return this.field_1603;
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "path";
   }

   // $FF: renamed from: r (int, int) com.google.android.gms.wearable.DataItem
   protected DataItem method_2993(int var1, int var2) {
      return new class_253(this.JG, var1, var2);
   }
}
