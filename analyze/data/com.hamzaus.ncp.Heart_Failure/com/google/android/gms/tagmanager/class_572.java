package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_511;
import com.google.android.gms.tagmanager.class_545;
import com.google.android.gms.tagmanager.class_88;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.l
class class_572<K, V> {
   final class_572.class_1292<K, V> aeo = new class_572.class_1292() {
      public int sizeOf(K var1, V var2) {
         return 1;
      }
   };

   // $FF: renamed from: a (int, com.google.android.gms.tagmanager.l$a) com.google.android.gms.tagmanager.k
   public k<K, V> method_3193(int var1, class_572.class_1292<K, V> var2) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         return (class_88)(this.method_3194() < 12?new class_545(var1, var2):new class_511(var1, var2));
      }
   }

   // $FF: renamed from: le () int
   int method_3194() {
      return VERSION.SDK_INT;
   }

   public interface class_1292<K, V> {
      int sizeOf(K var1, V var2);
   }
}
