package com.goodrx.utils;

public class ArrayUtils extends org.apache.commons.lang3.ArrayUtils {
   public static <T> void swapInPlace(T[] var0, int var1, int var2) {
      Object var3 = var0[var1];
      var0[var1] = var0[var2];
      var0[var2] = var3;
   }
}
