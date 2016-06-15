package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.internal.class_255;

public class DataEventBuffer extends g<DataEvent> implements Result {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_1604;

   public DataEventBuffer(DataHolder var1) {
      super(var1);
      this.field_1604 = new Status(var1.getStatusCode());
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2987(int var1, int var2) {
      return this.method_2996(var1, var2);
   }

   public Status getStatus() {
      return this.field_1604;
   }

   // $FF: renamed from: ha () java.lang.String
   protected String method_2988() {
      return "path";
   }

   // $FF: renamed from: q (int, int) com.google.android.gms.wearable.DataEvent
   protected DataEvent method_2996(int var1, int var2) {
      return new class_255(this.JG, var1, var2);
   }
}
