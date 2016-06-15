package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.class_335;
import java.util.Iterator;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.c
public class class_967<T> implements Iterator<T> {
   // $FF: renamed from: KW com.google.android.gms.common.data.DataBuffer
   protected final DataBuffer<T> field_4140;
   // $FF: renamed from: KX int
   protected int field_4141;

   public class_967(DataBuffer<T> var1) {
      this.field_4140 = (DataBuffer)class_335.method_2311(var1);
      this.field_4141 = -1;
   }

   public boolean hasNext() {
      return this.field_4141 < -1 + this.field_4140.getCount();
   }

   public T next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.field_4141);
      } else {
         DataBuffer var1 = this.field_4140;
         int var2 = 1 + this.field_4141;
         this.field_4141 = var2;
         return var1.get(var2);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
   }
}
