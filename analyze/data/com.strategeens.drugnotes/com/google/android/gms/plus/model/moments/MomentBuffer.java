package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_257;
import com.google.android.gms.plus.model.moments.Moment;

public final class MomentBuffer extends DataBuffer<Moment> {
   public MomentBuffer(DataHolder var1) {
      super(var1);
   }

   public Moment get(int var1) {
      return new class_257(this.JG, var1);
   }
}
