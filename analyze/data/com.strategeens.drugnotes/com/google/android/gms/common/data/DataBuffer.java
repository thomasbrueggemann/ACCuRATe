package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_967;
import com.google.android.gms.common.data.class_968;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {
   // $FF: renamed from: JG com.google.android.gms.common.data.DataHolder
   protected final DataHolder field_1596;

   protected DataBuffer(DataHolder var1) {
      this.field_1596 = var1;
      if(this.field_1596 != null) {
         this.field_1596.method_5834(this);
      }

   }

   @Deprecated
   public final void close() {
      this.release();
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: gV () android.os.Bundle
   public Bundle method_2975() {
      return this.field_1596.method_5837();
   }

   public abstract T get(int var1);

   public int getCount() {
      return this.field_1596 == null?0:this.field_1596.getCount();
   }

   @Deprecated
   public boolean isClosed() {
      return this.field_1596 == null?true:this.field_1596.isClosed();
   }

   public Iterator<T> iterator() {
      return new class_967(this);
   }

   public void release() {
      if(this.field_1596 != null) {
         this.field_1596.close();
      }

   }

   public Iterator<T> singleRefIterator() {
      return new class_968(this);
   }
}
