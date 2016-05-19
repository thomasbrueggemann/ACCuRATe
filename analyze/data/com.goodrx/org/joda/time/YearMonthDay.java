package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.TimeOfDay;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractPartialFieldProperty;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.ISODateTimeFormat;

@Deprecated
public final class YearMonthDay extends BasePartial implements Serializable, ReadablePartial {
   public static final int DAY_OF_MONTH = 2;
   private static final DateTimeFieldType[] FIELD_TYPES;
   public static final int MONTH_OF_YEAR = 1;
   public static final int YEAR = 0;
   private static final long serialVersionUID = 797544782896179L;

   static {
      DateTimeFieldType[] var0 = new DateTimeFieldType[]{DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
      FIELD_TYPES = var0;
   }

   public YearMonthDay() {
   }

   public YearMonthDay(int var1, int var2, int var3) {
      this(var1, var2, var3, (Chronology)null);
   }

   public YearMonthDay(int var1, int var2, int var3, Chronology var4) {
      super(new int[]{var1, var2, var3}, var4);
   }

   public YearMonthDay(long var1) {
      super(var1);
   }

   public YearMonthDay(long var1, Chronology var3) {
      super(var1, var3);
   }

   public YearMonthDay(Object var1) {
      super(var1, (Chronology)null, ISODateTimeFormat.dateOptionalTimeParser());
   }

   public YearMonthDay(Object var1, Chronology var2) {
      super(var1, DateTimeUtils.getChronology(var2), ISODateTimeFormat.dateOptionalTimeParser());
   }

   public YearMonthDay(Chronology var1) {
      super(var1);
   }

   public YearMonthDay(DateTimeZone var1) {
      super(ISOChronology.getInstance(var1));
   }

   YearMonthDay(YearMonthDay var1, Chronology var2) {
      super(var1, var2);
   }

   YearMonthDay(YearMonthDay var1, int[] var2) {
      super(var1, var2);
   }

   public static YearMonthDay fromCalendarFields(Calendar var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The calendar must not be null");
      } else {
         return new YearMonthDay(var0.get(1), 1 + var0.get(2), var0.get(5));
      }
   }

   public static YearMonthDay fromDateFields(Date var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The date must not be null");
      } else {
         return new YearMonthDay(1900 + var0.getYear(), 1 + var0.getMonth(), var0.getDate());
      }
   }

   public YearMonthDay.Property dayOfMonth() {
      return new YearMonthDay.Property(this, 2);
   }

   public int getDayOfMonth() {
      return this.getValue(2);
   }

   protected DateTimeField getField(int var1, Chronology var2) {
      switch(var1) {
      case 0:
         return var2.year();
      case 1:
         return var2.monthOfYear();
      case 2:
         return var2.dayOfMonth();
      default:
         throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }
   }

   public DateTimeFieldType getFieldType(int var1) {
      return FIELD_TYPES[var1];
   }

   public DateTimeFieldType[] getFieldTypes() {
      return (DateTimeFieldType[])((DateTimeFieldType[])FIELD_TYPES.clone());
   }

   public int getMonthOfYear() {
      return this.getValue(1);
   }

   public int getYear() {
      return this.getValue(0);
   }

   public YearMonthDay minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public YearMonthDay minusDays(int var1) {
      return this.withFieldAdded(DurationFieldType.days(), FieldUtils.safeNegate(var1));
   }

   public YearMonthDay minusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(var1));
   }

   public YearMonthDay minusYears(int var1) {
      return this.withFieldAdded(DurationFieldType.years(), FieldUtils.safeNegate(var1));
   }

   public YearMonthDay.Property monthOfYear() {
      return new YearMonthDay.Property(this, 1);
   }

   public YearMonthDay plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public YearMonthDay plusDays(int var1) {
      return this.withFieldAdded(DurationFieldType.days(), var1);
   }

   public YearMonthDay plusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), var1);
   }

   public YearMonthDay plusYears(int var1) {
      return this.withFieldAdded(DurationFieldType.years(), var1);
   }

   public YearMonthDay.Property property(DateTimeFieldType var1) {
      return new YearMonthDay.Property(this, this.indexOfSupported(var1));
   }

   public int size() {
      return 3;
   }

   public DateMidnight toDateMidnight() {
      return this.toDateMidnight((DateTimeZone)null);
   }

   public DateMidnight toDateMidnight(DateTimeZone var1) {
      Chronology var2 = this.getChronology().withZone(var1);
      return new DateMidnight(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), var2);
   }

   public DateTime toDateTime(TimeOfDay var1) {
      return this.toDateTime(var1, (DateTimeZone)null);
   }

   public DateTime toDateTime(TimeOfDay var1, DateTimeZone var2) {
      Chronology var3 = this.getChronology().withZone(var2);
      long var4 = var3.set(this, DateTimeUtils.currentTimeMillis());
      if(var1 != null) {
         var4 = var3.set(var1, var4);
      }

      return new DateTime(var4, var3);
   }

   public DateTime toDateTimeAtCurrentTime() {
      return this.toDateTimeAtCurrentTime((DateTimeZone)null);
   }

   public DateTime toDateTimeAtCurrentTime(DateTimeZone var1) {
      Chronology var2 = this.getChronology().withZone(var1);
      return new DateTime(var2.set(this, DateTimeUtils.currentTimeMillis()), var2);
   }

   public DateTime toDateTimeAtMidnight() {
      return this.toDateTimeAtMidnight((DateTimeZone)null);
   }

   public DateTime toDateTimeAtMidnight(DateTimeZone var1) {
      Chronology var2 = this.getChronology().withZone(var1);
      return new DateTime(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), 0, 0, 0, 0, var2);
   }

   public Interval toInterval() {
      return this.toInterval((DateTimeZone)null);
   }

   public Interval toInterval(DateTimeZone var1) {
      return this.toDateMidnight(DateTimeUtils.getZone(var1)).toInterval();
   }

   public LocalDate toLocalDate() {
      return new LocalDate(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), this.getChronology());
   }

   public String toString() {
      return ISODateTimeFormat.yearMonthDay().print((ReadablePartial)this);
   }

   public YearMonthDay withChronologyRetainFields(Chronology var1) {
      Chronology var2 = DateTimeUtils.getChronology(var1).withUTC();
      if(var2 == this.getChronology()) {
         return this;
      } else {
         YearMonthDay var3 = new YearMonthDay(this, var2);
         var2.validate(var3, this.getValues());
         return var3;
      }
   }

   public YearMonthDay withDayOfMonth(int var1) {
      int[] var2 = this.getValues();
      return new YearMonthDay(this, this.getChronology().dayOfMonth().set(this, 2, var2, var1));
   }

   public YearMonthDay withField(DateTimeFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == this.getValue(var3)) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new YearMonthDay(this, this.getField(var3).set(this, var3, var4, var2));
      }
   }

   public YearMonthDay withFieldAdded(DurationFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == 0) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new YearMonthDay(this, this.getField(var3).add(this, var3, var4, var2));
      }
   }

   public YearMonthDay withMonthOfYear(int var1) {
      int[] var2 = this.getValues();
      return new YearMonthDay(this, this.getChronology().monthOfYear().set(this, 1, var2, var1));
   }

   public YearMonthDay withPeriodAdded(ReadablePeriod var1, int var2) {
      if(var1 != null && var2 != 0) {
         int[] var3 = this.getValues();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            int var5 = this.indexOf(var1.getFieldType(var4));
            if(var5 >= 0) {
               var3 = this.getField(var5).add(this, var5, var3, FieldUtils.safeMultiply(var1.getValue(var4), var2));
            }
         }

         return new YearMonthDay(this, var3);
      } else {
         return this;
      }
   }

   public YearMonthDay withYear(int var1) {
      int[] var2 = this.getValues();
      return new YearMonthDay(this, this.getChronology().year().set(this, 0, var2, var1));
   }

   public YearMonthDay.Property year() {
      return new YearMonthDay.Property(this, 0);
   }

   @Deprecated
   public static class Property extends AbstractPartialFieldProperty implements Serializable {
      private static final long serialVersionUID = 5727734012190224363L;
      private final int iFieldIndex;
      private final YearMonthDay iYearMonthDay;

      Property(YearMonthDay var1, int var2) {
         this.iYearMonthDay = var1;
         this.iFieldIndex = var2;
      }

      public YearMonthDay addToCopy(int var1) {
         int[] var2 = this.iYearMonthDay.getValues();
         int[] var3 = this.getField().add(this.iYearMonthDay, this.iFieldIndex, var2, var1);
         return new YearMonthDay(this.iYearMonthDay, var3);
      }

      public YearMonthDay addWrapFieldToCopy(int var1) {
         int[] var2 = this.iYearMonthDay.getValues();
         int[] var3 = this.getField().addWrapField(this.iYearMonthDay, this.iFieldIndex, var2, var1);
         return new YearMonthDay(this.iYearMonthDay, var3);
      }

      public int get() {
         return this.iYearMonthDay.getValue(this.iFieldIndex);
      }

      public DateTimeField getField() {
         return this.iYearMonthDay.getField(this.iFieldIndex);
      }

      protected ReadablePartial getReadablePartial() {
         return this.iYearMonthDay;
      }

      public YearMonthDay getYearMonthDay() {
         return this.iYearMonthDay;
      }

      public YearMonthDay setCopy(int var1) {
         int[] var2 = this.iYearMonthDay.getValues();
         int[] var3 = this.getField().set(this.iYearMonthDay, this.iFieldIndex, var2, var1);
         return new YearMonthDay(this.iYearMonthDay, var3);
      }

      public YearMonthDay setCopy(String var1) {
         return this.setCopy(var1, (Locale)null);
      }

      public YearMonthDay setCopy(String var1, Locale var2) {
         int[] var3 = this.iYearMonthDay.getValues();
         int[] var4 = this.getField().set(this.iYearMonthDay, this.iFieldIndex, var3, var1, var2);
         return new YearMonthDay(this.iYearMonthDay, var4);
      }

      public YearMonthDay withMaximumValue() {
         return this.setCopy(this.getMaximumValue());
      }

      public YearMonthDay withMinimumValue() {
         return this.setCopy(this.getMinimumValue());
      }
   }
}
