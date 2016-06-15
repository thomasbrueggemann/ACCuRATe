package com.google.android.gms.fitness.data;

import java.util.List;

// $FF: renamed from: com.google.android.gms.fitness.data.t
public class class_1053 {
   // $FF: renamed from: a (java.lang.Object, java.util.List) int
   public static <T> int method_5779(T var0, List<T> var1) {
      int var2;
      if(var0 == null) {
         var2 = -1;
      } else {
         var2 = var1.indexOf(var0);
         if(var2 < 0) {
            var1.add(var0);
            return -1 + var1.size();
         }
      }

      return var2;
   }
}
