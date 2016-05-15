package com.parse;

import java.util.Iterator;

class ParseTextUtils {
   public static boolean equals(CharSequence var0, CharSequence var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static boolean isEmpty(CharSequence var0) {
      return var0 == null || var0.length() == 0;
   }

   static String join(CharSequence var0, Iterable var1) {
      StringBuilder var2 = new StringBuilder();
      boolean var3 = true;

      Object var5;
      for(Iterator var4 = var1.iterator(); var4.hasNext(); var2.append(var5)) {
         var5 = var4.next();
         if(var3) {
            var3 = false;
         } else {
            var2.append(var0);
         }
      }

      return var2.toString();
   }
}
