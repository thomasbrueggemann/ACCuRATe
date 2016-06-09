package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzb;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
   protected final DataHolder zzahi;

   protected AbstractDataBuffer(DataHolder var1) {
      this.zzahi = var1;
      if(this.zzahi != null) {
         this.zzahi.zzu(this);
      }

   }

   public int getCount() {
      return this.zzahi == null?0:this.zzahi.getCount();
   }

   public Iterator<T> iterator() {
      return new zzb(this);
   }

   public void release() {
      if(this.zzahi != null) {
         this.zzahi.close();
      }

   }
}
