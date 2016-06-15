package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_253;
import com.google.android.gms.wearable.internal.class_906;

// $FF: renamed from: com.google.android.gms.wearable.internal.h
public final class class_255 extends class_251 implements DataEvent {
   // $FF: renamed from: Ya int
   private final int field_532;

   public class_255(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_532 = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1669();
   }

   public DataItem getDataItem() {
      return new class_253(this.JG, this.KZ, this.field_532);
   }

   public int getType() {
      return this.getInteger("event_type");
   }

   // $FF: renamed from: rn () com.google.android.gms.wearable.DataEvent
   public DataEvent method_1669() {
      return new class_906(this);
   }
}
