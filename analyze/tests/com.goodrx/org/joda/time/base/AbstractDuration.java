package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.ReadableDuration;
import org.joda.time.format.FormatUtils;

public abstract class AbstractDuration implements ReadableDuration {
   public int compareTo(ReadableDuration var1) {
      long var2 = this.getMillis();
      long var4 = var1.getMillis();
      return var2 < var4?-1:(var2 > var4?1:0);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ReadableDuration)) {
            return false;
         }

         ReadableDuration var2 = (ReadableDuration)var1;
         if(this.getMillis() != var2.getMillis()) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      long var1 = this.getMillis();
      return (int)(var1 ^ var1 >>> 32);
   }

   public boolean isEqual(ReadableDuration var1) {
      if(var1 == null) {
         var1 = Duration.ZERO;
      }

      return this.compareTo((ReadableDuration)var1) == 0;
   }

   public boolean isLongerThan(ReadableDuration var1) {
      if(var1 == null) {
         var1 = Duration.ZERO;
      }

      return this.compareTo((ReadableDuration)var1) > 0;
   }

   public boolean isShorterThan(ReadableDuration var1) {
      if(var1 == null) {
         var1 = Duration.ZERO;
      }

      return this.compareTo((ReadableDuration)var1) < 0;
   }

   public Duration toDuration() {
      return new Duration(this.getMillis());
   }

   public Period toPeriod() {
      return new Period(this.getMillis());
   }

   @ToString
   public String toString() {
      long var1 = this.getMillis();
      StringBuffer var3 = new StringBuffer();
      var3.append("PT");
      boolean var5;
      if(var1 < 0L) {
         var5 = true;
      } else {
         var5 = false;
      }

      FormatUtils.appendUnpaddedInteger(var3, var1);

      while(true) {
         int var6 = var3.length();
         byte var7;
         if(var5) {
            var7 = 7;
         } else {
            var7 = 6;
         }

         if(var6 >= var7) {
            if(1000L * (var1 / 1000L) == var1) {
               var3.setLength(-3 + var3.length());
            } else {
               var3.insert(-3 + var3.length(), ".");
            }

            var3.append('S');
            return var3.toString();
         }

         byte var10;
         if(var5) {
            var10 = 3;
         } else {
            var10 = 2;
         }

         var3.insert(var10, "0");
      }
   }
}
