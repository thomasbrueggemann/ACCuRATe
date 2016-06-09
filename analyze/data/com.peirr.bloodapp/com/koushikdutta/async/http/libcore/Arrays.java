package com.koushikdutta.async.http.libcore;

import java.lang.reflect.Array;

class Arrays {
   static <T> T[] copyOfRange(T[] var0, int var1, int var2) {
      int var3 = var0.length;
      if(var1 > var2) {
         throw new IllegalArgumentException();
      } else if(var1 >= 0 && var1 <= var3) {
         int var4 = var2 - var1;
         int var5 = Math.min(var4, var3 - var1);
         Object[] var6 = (Object[])((Object[])Array.newInstance(var0.getClass().getComponentType(), var4));
         System.arraycopy(var0, var1, var6, 0, var5);
         return var6;
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }
}
