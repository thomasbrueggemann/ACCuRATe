package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.DateTimeUtils;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadableInterval;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public final class Hours extends BaseSingleFieldPeriod {
   public static final Hours EIGHT = new Hours(8);
   public static final Hours FIVE = new Hours(5);
   public static final Hours FOUR = new Hours(4);
   public static final Hours MAX_VALUE = new Hours(Integer.MAX_VALUE);
   public static final Hours MIN_VALUE = new Hours(Integer.MIN_VALUE);
   public static final Hours ONE = new Hours(1);
   private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.hours());
   public static final Hours SEVEN = new Hours(7);
   public static final Hours SIX = new Hours(6);
   public static final Hours THREE = new Hours(3);
   public static final Hours TWO = new Hours(2);
   public static final Hours ZERO = new Hours(0);
   private static final long serialVersionUID = 87525275727380864L;

   private Hours(int var1) {
      super(var1);
   }

   public static Hours hours(int var0) {
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
      case Integer.MAX_VALUE:
         return MAX_VALUE;
      default:
         return new Hours(var0);
      }
   }

   public static Hours hoursBetween(ReadableInstant var0, ReadableInstant var1) {
      return hours(BaseSingleFieldPeriod.between(var0, var1, DurationFieldType.hours()));
   }

   public static Hours hoursBetween(ReadablePartial var0, ReadablePartial var1) {
      return var0 instanceof LocalTime && var1 instanceof LocalTime?hours(DateTimeUtils.getChronology(var0.getChronology()).hours().getDifference(((LocalTime)var1).getLocalMillis(), ((LocalTime)var0).getLocalMillis())):hours(BaseSingleFieldPeriod.between(var0, var1, ZERO));
   }

   public static Hours hoursIn(ReadableInterval var0) {
      return var0 == null?ZERO:hours(BaseSingleFieldPeriod.between(var0.getStart(), var0.getEnd(), DurationFieldType.hours()));
   }

   @FromString
   public static Hours parseHours(String var0) {
      return var0 == null?ZERO:hours(PARSER.parsePeriod(var0).getHours());
   }

   private Object readResolve() {
      return hours(this.getValue());
   }

   public static Hours standardHoursIn(ReadablePeriod var0) {
      return hours(BaseSingleFieldPeriod.standardPeriodIn(var0, 3600000L));
   }

   public Hours dividedBy(int var1) {
      return var1 == 1?this:hours(this.getValue() / var1);
   }

   public DurationFieldType getFieldType() {
      return DurationFieldType.hours();
   }

   public int getHours() {
      return this.getValue();
   }

   public PeriodType getPeriodType() {
      return PeriodType.hours();
   }

   public boolean isGreaterThan(Hours var1) {
      if(var1 == null) {
         if(this.getValue() <= 0) {
            return false;
         }
      } else if(this.getValue() <= var1.getValue()) {
         return false;
      }

      return true;
   }

   public boolean isLessThan(Hours var1) {
      if(var1 == null) {
         if(this.getValue() >= 0) {
            return false;
         }
      } else if(this.getValue() >= var1.getValue()) {
         return false;
      }

      return true;
   }

   public Hours minus(int var1) {
      return this.plus(FieldUtils.safeNegate(var1));
   }

   public Hours minus(Hours var1) {
      return var1 == null?this:this.minus(var1.getValue());
   }

   public Hours multipliedBy(int var1) {
      return hours(FieldUtils.safeMultiply(this.getValue(), var1));
   }

   public Hours negated() {
      return hours(FieldUtils.safeNegate(this.getValue()));
   }

   public Hours plus(int var1) {
      return var1 == 0?this:hours(FieldUtils.safeAdd(this.getValue(), var1));
   }

   public Hours plus(Hours var1) {
      return var1 == null?this:this.plus(var1.getValue());
   }

   public Days toStandardDays() {
      return Days.days(this.getValue() / 24);
   }

   public Duration toStandardDuration() {
      return new Duration(3600000L * (long)this.getValue());
   }

   public Minutes toStandardMinutes() {
      return Minutes.minutes(FieldUtils.safeMultiply(this.getValue(), 60));
   }

   public Seconds toStandardSeconds() {
      return Seconds.seconds(FieldUtils.safeMultiply(this.getValue(), 3600));
   }

   public Weeks toStandardWeeks() {
      return Weeks.weeks(this.getValue() / 168);
   }

   @ToString
   public String toString() {
      return "PT" + String.valueOf(this.getValue()) + "H";
   }
}
