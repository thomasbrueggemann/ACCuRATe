package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.c;
import com.google.android.gms.common.data.class_251;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.h
public class class_968<T> extends c<T> {
   // $FF: renamed from: Lt java.lang.Object
   private T field_4142;

   public class_968(DataBuffer<T> var1) {
      super(var1);
   }

   public T next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.KX);
      } else {
         ++this.KX;
         if(this.KX == 0) {
            this.field_4142 = this.KW.get(0);
            if(!(this.field_4142 instanceof class_251)) {
               throw new IllegalStateException("DataBuffer reference of type " + this.field_4142.getClass() + " is not movable");
            }
         } else {
            ((class_251)this.field_4142).method_1658(this.KX);
         }

         return this.field_4142;
      }
   }
}
