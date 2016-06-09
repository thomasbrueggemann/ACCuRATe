package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
   protected final DataBuffer<T> zzajb;
   protected int zzajc;

   public zzb(DataBuffer<T> var1) {
      this.zzajb = (DataBuffer)zzx.zzz(var1);
      this.zzajc = -1;
   }

   public boolean hasNext() {
      return this.zzajc < -1 + this.zzajb.getCount();
   }

   public T next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzajc);
      } else {
         DataBuffer var1 = this.zzajb;
         int var2 = 1 + this.zzajc;
         this.zzajc = var2;
         return var1.get(var2);
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
   }
}
