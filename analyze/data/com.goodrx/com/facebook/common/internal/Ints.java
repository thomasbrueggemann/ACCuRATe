package com.facebook.common.internal;

import com.facebook.common.internal.Preconditions;

public class Ints {
   public static int max(int... var0) {
      boolean var1;
      if(var0.length > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Preconditions.checkArgument(var1);
      int var2 = var0[0];

      for(int var3 = 1; var3 < var0.length; ++var3) {
         if(var0[var3] > var2) {
            var2 = var0[var3];
         }
      }

      return var2;
   }
}
