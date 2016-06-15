package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.c;
import com.google.android.gms.common.data.class_206;
import java.util.NoSuchElementException;

// $FF: renamed from: com.google.android.gms.common.data.h
public class class_747<T> extends c<T> {
   // $FF: renamed from: ET java.lang.Object
   private T field_4039;

   public class_747(DataBuffer<T> var1) {
      super(var1);
   }

   public T next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException("Cannot advance the iterator beyond " + this.Ey);
      } else {
         ++this.Ey;
         if(this.Ey == 0) {
            this.field_4039 = this.Ex.get(0);
            if(!(this.field_4039 instanceof class_206)) {
               throw new IllegalStateException("DataBuffer reference of type " + this.field_4039.getClass() + " is not movable");
            }
         } else {
            ((class_206)this.field_4039).method_1348(this.Ey);
         }

         return this.field_4039;
      }
   }
}
