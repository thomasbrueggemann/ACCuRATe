package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.internal.class_209;

public class DataEventBuffer extends g<DataEvent> implements Result {
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   private final Status field_1929;

   public DataEventBuffer(DataHolder var1) {
      super(var1);
      this.field_1929 = new Status(var1.getStatusCode());
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   // $FF: synthetic method
   protected Object method_2626(int var1, int var2) {
      return this.method_2635(var1, var2);
   }

   // $FF: renamed from: eU () java.lang.String
   protected String method_2627() {
      return "path";
   }

   public Status getStatus() {
      return this.field_1929;
   }

   // $FF: renamed from: m (int, int) com.google.android.gms.wearable.DataEvent
   protected DataEvent method_2635(int var1, int var2) {
      return new class_209(this.DD, var1, var2);
   }
}
