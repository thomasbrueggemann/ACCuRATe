package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import com.facebook.imagepipeline.memory.Bucket;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class OOMSoftReferenceBucket<V> extends Bucket<V> {
   private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList();

   public OOMSoftReferenceBucket(int var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   void addToFreeList(V var1) {
      OOMSoftReference var2 = (OOMSoftReference)this.mSpareReferences.poll();
      if(var2 == null) {
         var2 = new OOMSoftReference();
      }

      var2.set(var1);
      this.mFreeList.add(var2);
   }

   public V pop() {
      OOMSoftReference var1 = (OOMSoftReference)this.mFreeList.poll();
      Object var2 = var1.get();
      var1.clear();
      this.mSpareReferences.add(var1);
      return var2;
   }
}
