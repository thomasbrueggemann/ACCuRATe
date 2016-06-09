package com.loopj.android.http;

class Utils {
   public static void asserts(boolean var0, String var1) {
      if(!var0) {
         throw new AssertionError(var1);
      }
   }

   public static <T> T notNull(T var0, String var1) {
      if(var0 == null) {
         throw new IllegalArgumentException(var1 + " should not be null!");
      } else {
         return var0;
      }
   }
}
