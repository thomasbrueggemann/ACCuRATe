package com.parse;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class WeakValueHashMap<K, V> {
   private HashMap<K, WeakReference<V>> map = new HashMap();

   public void clear() {
      this.map.clear();
   }

   public V get(K var1) {
      WeakReference var2 = (WeakReference)this.map.get(var1);
      Object var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = var2.get();
         if(var3 == null) {
            this.map.remove(var1);
            return var3;
         }
      }

      return var3;
   }

   public void put(K var1, V var2) {
      this.map.put(var1, new WeakReference(var2));
   }

   public void remove(K var1) {
      this.map.remove(var1);
   }
}
