package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.TimeZone;

public class ISO8601Utils {
   private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

   private static boolean checkOffset(String var0, int var1, char var2) {
      return var1 < var0.length() && var0.charAt(var1) == var2;
   }

   private static int indexOfNonDigit(String var0, int var1) {
      for(int var2 = var1; var2 < var0.length(); ++var2) {
         char var3 = var0.charAt(var2);
         if(var3 < 48 || var3 > 57) {
            return var2;
         }
      }

      return var0.length();
   }

   public static Date parse(String param0, ParsePosition param1) throws ParseException {
      // $FF: Couldn't be decompiled
   }

   private static int parseInt(String var0, int var1, int var2) throws NumberFormatException {
      if(var1 >= 0 && var2 <= var0.length() && var1 <= var2) {
         int var3;
         int var4;
         if(var1 < var2) {
            var3 = var1 + 1;
            int var7 = Character.digit(var0.charAt(var1), 10);
            if(var7 < 0) {
               throw new NumberFormatException("Invalid number: " + var0.substring(var1, var2));
            }

            var4 = -var7;
         } else {
            var3 = var1;
            var4 = 0;
         }

         while(var3 < var2) {
            int var5 = var3 + 1;
            int var6 = Character.digit(var0.charAt(var3), 10);
            if(var6 < 0) {
               throw new NumberFormatException("Invalid number: " + var0.substring(var1, var2));
            }

            var4 = var4 * 10 - var6;
            var3 = var5;
         }

         return -var4;
      } else {
         throw new NumberFormatException(var0);
      }
   }
}
