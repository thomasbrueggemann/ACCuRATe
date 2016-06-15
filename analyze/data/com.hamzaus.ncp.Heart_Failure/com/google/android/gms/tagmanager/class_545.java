package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.class_572;
import com.google.android.gms.tagmanager.k;
import java.util.HashMap;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cz
class class_545<K, V> implements k<K, V> {
   private final Map<K, V> ahU = new HashMap();
   private final int ahV;
   private final class_572.class_1292<K, V> ahW;
   private int ahX;

   class_545(int var1, class_572.class_1292<K, V> var2) {
      this.ahV = var1;
      this.ahW = var2;
   }

   // $FF: renamed from: e (java.lang.Object, java.lang.Object) void
   public void method_401(K param1, V param2) {
      // $FF: Couldn't be decompiled
   }

   public V get(K var1) {
      synchronized(this){}

      Object var3;
      try {
         var3 = this.ahU.get(var1);
      } finally {
         ;
      }

      return var3;
   }
}
