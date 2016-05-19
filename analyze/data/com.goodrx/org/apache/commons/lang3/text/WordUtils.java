package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;

public class WordUtils {
   public static String capitalize(String var0) {
      return capitalize(var0, (char[])null);
   }

   public static String capitalize(String var0, char... var1) {
      int var2;
      if(var1 == null) {
         var2 = -1;
      } else {
         var2 = var1.length;
      }

      if(!StringUtils.isEmpty(var0) && var2 != 0) {
         char[] var3 = var0.toCharArray();
         boolean var4 = true;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            char var6 = var3[var5];
            if(isDelimiter(var6, var1)) {
               var4 = true;
            } else if(var4) {
               var3[var5] = Character.toTitleCase(var6);
               var4 = false;
            }
         }

         return new String(var3);
      } else {
         return var0;
      }
   }

   private static boolean isDelimiter(char var0, char[] var1) {
      if(var1 == null) {
         return Character.isWhitespace(var0);
      } else {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            if(var0 == var1[var3]) {
               return true;
            }
         }

         return false;
      }
   }
}
