package com.koushikdutta.async.http.libcore;

public final class Objects {
   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static int hashCode(Object var0) {
      return var0 == null?0:var0.hashCode();
   }
}
