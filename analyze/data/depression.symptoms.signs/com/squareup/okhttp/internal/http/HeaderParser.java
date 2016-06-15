package com.squareup.okhttp.internal.http;

final class HeaderParser {
   public static void parseCacheControl(String var0, HeaderParser.CacheControlHandler var1) {
      int var2 = 0;

      while(true) {
         while(var2 < var0.length()) {
            int var4 = skipUntil(var0, var2, "=,;");
            String var5 = var0.substring(var2, var4).trim();
            if(var4 != var0.length() && var0.charAt(var4) != 44 && var0.charAt(var4) != 59) {
               int var6 = skipWhitespace(var0, var4 + 1);
               String var7;
               if(var6 < var0.length() && var0.charAt(var6) == 34) {
                  int var8 = var6 + 1;
                  int var9 = skipUntil(var0, var8, "\"");
                  var7 = var0.substring(var8, var9);
                  var2 = var9 + 1;
               } else {
                  var2 = skipUntil(var0, var6, ",;");
                  var7 = var0.substring(var6, var2).trim();
               }

               var1.handle(var5, var7);
            } else {
               var2 = var4 + 1;
               var1.handle(var5, (String)null);
            }
         }

         return;
      }
   }

   public static int parseSeconds(String var0) {
      long var2;
      try {
         var2 = Long.parseLong(var0);
      } catch (NumberFormatException var4) {
         return -1;
      }

      return var2 > 2147483647L?Integer.MAX_VALUE:(var2 < 0L?0:(int)var2);
   }

   public static int skipUntil(String var0, int var1, String var2) {
      while(var1 < var0.length() && var2.indexOf(var0.charAt(var1)) == -1) {
         ++var1;
      }

      return var1;
   }

   public static int skipWhitespace(String var0, int var1) {
      while(var1 < var0.length()) {
         char var2 = var0.charAt(var1);
         if(var2 != 32 && var2 != 9) {
            break;
         }

         ++var1;
      }

      return var1;
   }

   public interface CacheControlHandler {
      void handle(String var1, String var2);
   }
}
