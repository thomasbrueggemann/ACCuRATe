package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

// $FF: renamed from: com.google.android.gms.wearable.internal.g
public class class_906 implements DataEvent {
   // $FF: renamed from: Gt int
   private int field_3830;
   private DataItem axE;

   public class_906(DataEvent var1) {
      this.field_3830 = var1.getType();
      this.axE = (DataItem)var1.getDataItem().freeze();
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5055();
   }

   public DataItem getDataItem() {
      return this.axE;
   }

   public int getType() {
      return this.field_3830;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: rn () com.google.android.gms.wearable.DataEvent
   public DataEvent method_5055() {
      return this;
   }
}
