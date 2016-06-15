package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.internal.class_207;
import com.google.android.gms.wearable.internal.class_694;

// $FF: renamed from: com.google.android.gms.wearable.internal.h
public final class class_209 extends class_206 implements DataEvent {
   // $FF: renamed from: RD int
   private final int field_690;

   public class_209(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_690 = var3;
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1362();
   }

   public DataItem getDataItem() {
      return new class_207(this.DD, this.Ez, this.field_690);
   }

   public int getType() {
      return this.getInteger("event_type");
   }

   // $FF: renamed from: nk () com.google.android.gms.wearable.DataEvent
   public DataEvent method_1362() {
      return new class_694(this);
   }
}
