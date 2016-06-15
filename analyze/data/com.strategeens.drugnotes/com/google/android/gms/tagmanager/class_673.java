package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.class_610;
import com.google.android.gms.tagmanager.class_645;
import com.google.android.gms.tagmanager.class_95;
import com.google.android.gms.tagmanager.k;

// $FF: renamed from: com.google.android.gms.tagmanager.l
class class_673<K, V> {
   final class_673.class_1689<K, V> aqk = new class_673.class_1689() {
      public int sizeOf(K var1, V var2) {
         return 1;
      }
   };

   // $FF: renamed from: a (int, com.google.android.gms.tagmanager.l$a) com.google.android.gms.tagmanager.k
   public k<K, V> method_3825(int var1, class_673.class_1689<K, V> var2) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         return (class_95)(this.method_3826() < 12?new class_645(var1, var2):new class_610(var1, var2));
      }
   }

   // $FF: renamed from: pg () int
   int method_3826() {
      return VERSION.SDK_INT;
   }

   public interface class_1689<K, V> {
      int sizeOf(K var1, V var2);
   }
}
