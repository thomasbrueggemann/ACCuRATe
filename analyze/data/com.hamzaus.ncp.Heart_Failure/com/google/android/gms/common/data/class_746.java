package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.class_347;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.c
public class class_746<T> implements Iterator<T> {
   // $FF: renamed from: Ex com.google.android.gms.common.data.DataBuffer
   protected final DataBuffer<T> field_4037;
   // $FF: renamed from: Ey int
   protected int field_4038;

   public class_746(DataBuffer<T> var1) {
      this.field_4037 = (DataBuffer)class_347.method_2170(var1);
      this.field_4038 = -1;
   }

   public boolean hasNext() {
      return this.field_4038 < -1 + this.field_4037.getCount();
   }

   public T next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.field_4038);
      } else {
         DataBuffer var1 = this.field_4037;
         int var2 = 1 + this.field_4038;
         this.field_4038 = var2;
         return var1.get(var2);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
   }
}
