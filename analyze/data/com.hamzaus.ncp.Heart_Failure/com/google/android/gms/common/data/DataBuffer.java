package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_746;
import com.google.android.gms.common.data.class_747;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {
   // $FF: renamed from: DD com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_1919;

   protected DataBuffer(DataHolder var1) {
      this.field_1919 = var1;
      if(this.field_1919 != null) {
         this.field_1919.method_4559(this);
      }

   }

   @Deprecated
   public final void close() {
      this.release();
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: eP () android.os.Bundle
   public Bundle method_2615() {
      return this.field_1919.method_4563();
   }

   public abstract T get(int var1);

   public int getCount() {
      return this.field_1919 == null?0:this.field_1919.getCount();
   }

   @Deprecated
   public boolean isClosed() {
      return this.field_1919 == null?true:this.field_1919.isClosed();
   }

   public Iterator<T> iterator() {
      return new class_746(this);
   }

   public void release() {
      if(this.field_1919 != null) {
         this.field_1919.close();
      }

   }

   public Iterator<T> singleRefIterator() {
      return new class_747(this);
   }
}
