package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {
   private final String value;

   public LazilyParsedNumber(String var1) {
      this.value = var1;
   }

   public double doubleValue() {
      return Double.parseDouble(this.value);
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(this == var1) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof LazilyParsedNumber;
         var3 = false;
         if(var2) {
            LazilyParsedNumber var4 = (LazilyParsedNumber)var1;
            if(this.value != var4.value) {
               boolean var5 = this.value.equals(var4.value);
               var3 = false;
               if(!var5) {
                  return var3;
               }
            }

            return true;
         }
      }

      return var3;
   }

   public float floatValue() {
      return Float.parseFloat(this.value);
   }

   public int hashCode() {
      return this.value.hashCode();
   }

   public int intValue() {
      try {
         int var5 = Integer.parseInt(this.value);
         return var5;
      } catch (NumberFormatException var7) {
         long var3;
         try {
            var3 = Long.parseLong(this.value);
         } catch (NumberFormatException var6) {
            return (new BigDecimal(this.value)).intValue();
         }

         return (int)var3;
      }
   }

   public long longValue() {
      try {
         long var2 = Long.parseLong(this.value);
         return var2;
      } catch (NumberFormatException var4) {
         return (new BigDecimal(this.value)).longValue();
      }
   }

   public String toString() {
      return this.value;
   }
}
