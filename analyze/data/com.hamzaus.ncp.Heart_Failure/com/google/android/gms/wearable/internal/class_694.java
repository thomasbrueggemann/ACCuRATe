package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

// $FF: renamed from: com.google.android.gms.wearable.internal.g
public class class_694 implements DataEvent {
   // $FF: renamed from: AQ int
   private int field_3694;
   private DataItem alE;

   public class_694(DataEvent var1) {
      this.field_3694 = var1.getType();
      this.alE = (DataItem)var1.getDataItem().freeze();
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4016();
   }

   public DataItem getDataItem() {
      return this.alE;
   }

   public int getType() {
      return this.field_3694;
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: nk () com.google.android.gms.wearable.DataEvent
   public DataEvent method_4016() {
      return this;
   }
}
