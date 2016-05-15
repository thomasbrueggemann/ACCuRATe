package com.google.android.gms.fitness.data;

import java.util.List;

public class zzt {
   public static <T> int zza(T var0, List<T> var1) {
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
