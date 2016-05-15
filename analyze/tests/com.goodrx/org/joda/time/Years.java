package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.DateTimeUtils;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.ReadablePartial;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public final class Years extends BaseSingleFieldPeriod {
   public static final Years MAX_VALUE = new Years(Integer.MAX_VALUE);
   public static final Years MIN_VALUE = new Years(Integer.MIN_VALUE);
   public static final Years ONE = new Years(1);
   private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.years());
   public static final Years THREE = new Years(3);
   public static final Years TWO = new Years(2);
   public static final Years ZERO = new Years(0);
   private static final long serialVersionUID = 87525275727380868L;

   private Years(int var1) {
      super(var1);
   }

   @FromString
   public static Years parseYears(String var0) {
      return var0 == null?ZERO:years(PARSER.parsePeriod(var0).getYears());
   }

   private Object readResolve() {
      return years(this.getValue());
   }

   public static Years years(int var0) {
      switch(var0) {
      case Integer.MIN_VALUE:
         return MIN_VALUE;
      case 0:
         return ZERO;
      case 1:
         return ONE;
      case 2:
         return TWO;
      case 3:
         return THREE;
      case Integer.MAX_VALUE:
         return MAX_VALUE;
      default:
         return new Years(var0);
      }
   }

   public static Years yearsBetween(ReadableInstant var0, ReadableInstant var1) {
      return years(BaseSingleFieldPeriod.between(var0, var1, DurationFieldType.years()));
   }

   public static Years yearsBetween(ReadablePartial var0, ReadablePartial var1) {
      return var0 instanceof LocalDate && var1 instanceof LocalDate?years(DateTimeUtils.getChronology(var0.getChronology()).years().getDifference(((LocalDate)var1).getLocalMillis(), ((LocalDate)var0).getLocalMillis())):years(BaseSingleFieldPeriod.between(var0, var1, ZERO));
   }

   public static Years yearsIn(ReadableInterval var0) {
      return var0 == null?ZERO:years(BaseSingleFieldPeriod.between(var0.getStart(), var0.getEnd(), DurationFieldType.years()));
   }

   public Years dividedBy(int var1) {
      return var1 == 1?this:years(this.getValue() / var1);
   }

   public DurationFieldType getFieldType() {
      return DurationFieldType.years();
   }

   public PeriodType getPeriodType() {
      return PeriodType.years();
   }

   public int getYears() {
      return this.getValue();
   }

   public boolean isGreaterThan(Years var1) {
      if(var1 == null) {
         if(this.getValue() <= 0) {
            return false;
         }
      } else if(this.getValue() <= var1.getValue()) {
         return false;
      }

      return true;
   }

   public boolean isLessThan(Years var1) {
      if(var1 == null) {
         if(this.getValue() >= 0) {
            return false;
         }
      } else if(this.getValue() >= var1.getValue()) {
         return false;
      }

      return true;
   }

   public Years minus(int var1) {
      return this.plus(FieldUtils.safeNegate(var1));
   }

   public Years minus(Years var1) {
      return var1 == null?this:this.minus(var1.getValue());
   }

   public Years multipliedBy(int var1) {
      return years(FieldUtils.safeMultiply(this.getValue(), var1));
   }

   public Years negated() {
      return years(FieldUtils.safeNegate(this.getValue()));
   }

   public Years plus(int var1) {
      return var1 == 0?this:years(FieldUtils.safeAdd(this.getValue(), var1));
   }

   public Years plus(Years var1) {
      return var1 == null?this:this.plus(var1.getValue());
   }

   @ToString
   public String toString() {
      return "P" + String.valueOf(this.getValue()) + "Y";
   }
}
