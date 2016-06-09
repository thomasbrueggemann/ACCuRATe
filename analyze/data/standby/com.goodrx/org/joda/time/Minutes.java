package org.joda.time;

import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.DateTimeUtils;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.Hours;
import org.joda.time.LocalTime;
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

public final class Minutes extends BaseSingleFieldPeriod {
   public static final Minutes MAX_VALUE = new Minutes(Integer.MAX_VALUE);
   public static final Minutes MIN_VALUE = new Minutes(Integer.MIN_VALUE);
   public static final Minutes ONE = new Minutes(1);
   private static final PeriodFormatter PARSER = ISOPeriodFormat.standard().withParseType(PeriodType.minutes());
   public static final Minutes THREE = new Minutes(3);
   public static final Minutes TWO = new Minutes(2);
   public static final Minutes ZERO = new Minutes(0);
   private static final long serialVersionUID = 87525275727380863L;

   private Minutes(int var1) {
      super(var1);
   }

   public static Minutes minutes(int var0) {
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
         return new Minutes(var0);
      }
   }

   public static Minutes minutesBetween(ReadableInstant var0, ReadableInstant var1) {
      return minutes(BaseSingleFieldPeriod.between(var0, var1, DurationFieldType.minutes()));
   }

   public static Minutes minutesBetween(ReadablePartial var0, ReadablePartial var1) {
      return var0 instanceof LocalTime && var1 instanceof LocalTime?minutes(DateTimeUtils.getChronology(var0.getChronology()).minutes().getDifference(((LocalTime)var1).getLocalMillis(), ((LocalTime)var0).getLocalMillis())):minutes(BaseSingleFieldPeriod.between(var0, var1, ZERO));
   }

   public static Minutes minutesIn(ReadableInterval var0) {
      return var0 == null?ZERO:minutes(BaseSingleFieldPeriod.between(var0.getStart(), var0.getEnd(), DurationFieldType.minutes()));
   }

   @FromString
   public static Minutes parseMinutes(String var0) {
      return var0 == null?ZERO:minutes(PARSER.parsePeriod(var0).getMinutes());
   }

   private Object readResolve() {
      return minutes(this.getValue());
   }

   public static Minutes standardMinutesIn(ReadablePeriod var0) {
      return minutes(BaseSingleFieldPeriod.standardPeriodIn(var0, 60000L));
   }

   public Minutes dividedBy(int var1) {
      return var1 == 1?this:minutes(this.getValue() / var1);
   }

   public DurationFieldType getFieldType() {
      return DurationFieldType.minutes();
   }

   public int getMinutes() {
      return this.getValue();
   }

   public PeriodType getPeriodType() {
      return PeriodType.minutes();
   }

   public boolean isGreaterThan(Minutes var1) {
      if(var1 == null) {
         if(this.getValue() <= 0) {
            return false;
         }
      } else if(this.getValue() <= var1.getValue()) {
         return false;
      }

      return true;
   }

   public boolean isLessThan(Minutes var1) {
      if(var1 == null) {
         if(this.getValue() >= 0) {
            return false;
         }
      } else if(this.getValue() >= var1.getValue()) {
         return false;
      }

      return true;
   }

   public Minutes minus(int var1) {
      return this.plus(FieldUtils.safeNegate(var1));
   }

   public Minutes minus(Minutes var1) {
      return var1 == null?this:this.minus(var1.getValue());
   }

   public Minutes multipliedBy(int var1) {
      return minutes(FieldUtils.safeMultiply(this.getValue(), var1));
   }

   public Minutes negated() {
      return minutes(FieldUtils.safeNegate(this.getValue()));
   }

   public Minutes plus(int var1) {
      return var1 == 0?this:minutes(FieldUtils.safeAdd(this.getValue(), var1));
   }

   public Minutes plus(Minutes var1) {
      return var1 == null?this:this.plus(var1.getValue());
   }

   public Days toStandardDays() {
      return Days.days(this.getValue() / 1440);
   }

   public Duration toStandardDuration() {
      return new Duration(60000L * (long)this.getValue());
   }

   public Hours toStandardHours() {
      return Hours.hours(this.getValue() / 60);
   }

   public Seconds toStandardSeconds() {
      return Seconds.seconds(FieldUtils.safeMultiply(this.getValue(), 60));
   }

   public Weeks toStandardWeeks() {
      return Weeks.weeks(this.getValue() / 10080);
   }

   @ToString
   public String toString() {
      return "PT" + String.valueOf(this.getValue()) + "M";
   }
}
