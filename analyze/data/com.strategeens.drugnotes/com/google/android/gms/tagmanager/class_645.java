package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_673;
import com.google.android.gms.tagmanager.k;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.da
class class_645<K, V> implements k<K, V> {
   private final Map<K, V> atM = new HashMap();
   private final int atN;
   private final class_673.class_1689<K, V> atO;
   private int atP;

   class_645(int var1, class_673.class_1689<K, V> var2) {
      this.atN = var1;
      this.atO = var2;
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
   public void method_443(K param1, V param2) {
      // $FF: Couldn't be decompiled
   }

   public V get(K var1) {
      synchronized(this){}

      Object var3;
      try {
         var3 = this.atM.get(var1);
      } finally {
         ;
      }

      return var3;
   }
}
