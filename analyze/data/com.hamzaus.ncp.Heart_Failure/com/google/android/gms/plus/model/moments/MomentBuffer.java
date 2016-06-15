package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.class_210;
import com.google.android.gms.plus.model.moments.Moment;

public final class MomentBuffer extends DataBuffer<Moment> {
   public MomentBuffer(DataHolder var1) {
      super(var1);
   }

   public Moment get(int var1) {
      return new class_210(this.DD, var1);
   }
}
