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

public final class Months extends BaseSingleFieldPeriod {
   public static final Months EIGHT = new Months(8);
   public static final Months ELEVEN = new Months(11);
   public static final Months FIVE = new Months(5);
   public static final Months FOUR = new Months(4);
   public static final Months MAX_VALUE = new Months(Integer.MAX_VALUE);
   public static final Months MIN_VALUE = new Months(Integer.MIN_VALUE);
   public static final Months NINE = new Months(9);
   public static final Months ONE = new Months(1);
   private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.months());
   public static final Months SEVEN = new Months(7);
   public static final Months SIX = new Months(6);
   public static final Months TEN = new Months(10);
   public static final Months THREE = new Months(3);
   public static final Months TWELVE = new Months(12);
   public static final Months TWO = new Months(2);
   public static final Months ZERO = new Months(0);
   private static final long serialVersionUID = 87525275727380867L;

   private Months(int var1) {
      super(var1);
   }

   public static Months months(int var0) {
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
      case 4:
         return FOUR;
      case 5:
         return FIVE;
      case 6:
         return SIX;
      case 7:
         return SEVEN;
      case 8:
         return EIGHT;
      case 9:
         return NINE;
      case 10:
         return TEN;
      case 11:
         return ELEVEN;
      case 12:
         return TWELVE;
      case Integer.MAX_VALUE:
         return MAX_VALUE;
      default:
         return new Months(var0);
      }
   }

   public static Months monthsBetween(ReadableInstant var0, ReadableInstant var1) {
      return months(BaseSingleFieldPeriod.between(var0, var1, DurationFieldType.months()));
   }

   public static Months monthsBetween(ReadablePartial var0, ReadablePartial var1) {
      return var0 instanceof LocalDate && var1 instanceof LocalDate?months(DateTimeUtils.getChronology(var0.getChronology()).months().getDifference(((LocalDate)var1).getLocalMillis(), ((LocalDate)var0).getLocalMillis())):months(BaseSingleFieldPeriod.between(var0, var1, ZERO));
   }

   public static Months monthsIn(ReadableInterval var0) {
      return var0 == null?ZERO:months(BaseSingleFieldPeriod.between(var0.getStart(), var0.getEnd(), DurationFieldType.months()));
   }

   @FromString
   public static Months parseMonths(String var0) {
      return var0 == null?ZERO:months(PARSER.parsePeriod(var0).getMonths());
   }

   private Object readResolve() {
      return months(this.getValue());
   }

   public Months dividedBy(int var1) {
      return var1 == 1?this:months(this.getValue() / var1);
   }

   public DurationFieldType getFieldType() {
      return DurationFieldType.months();
   }

   public int getMonths() {
      return this.getValue();
   }

   public PeriodType getPeriodType() {
      return PeriodType.months();
   }

   public boolean isGreaterThan(Months var1) {
      if(var1 == null) {
         if(this.getValue() <= 0) {
            return false;
         }
      } else if(this.getValue() <= var1.getValue()) {
         return false;
      }

      return true;
   }

   public boolean isLessThan(Months var1) {
      if(var1 == null) {
         if(this.getValue() >= 0) {
            return false;
         }
      } else if(this.getValue() >= var1.getValue()) {
         return false;
      }

      return true;
   }

   public Months minus(int var1) {
      return this.plus(FieldUtils.safeNegate(var1));
   }

   public Months minus(Months var1) {
      return var1 == null?this:this.minus(var1.getValue());
   }

   public Months multipliedBy(int var1) {
      return months(FieldUtils.safeMultiply(this.getValue(), var1));
   }

   public Months negated() {
      return months(FieldUtils.safeNegate(this.getValue()));
   }

   public Months plus(int var1) {
      return var1 == 0?this:months(FieldUtils.safeAdd(this.getValue(), var1));
   }

   public Months plus(Months var1) {
      return var1 == null?this:this.plus(var1.getValue());
   }

   @ToString
   public String toString() {
      return "P" + String.valueOf(this.getValue()) + "M";
   }
}
