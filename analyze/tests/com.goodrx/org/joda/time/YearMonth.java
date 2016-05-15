package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.YearMonth.Property;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class YearMonth extends BasePartial implements Serializable, ReadablePartial {
   private static final DateTimeFieldType[] FIELD_TYPES;
   public static final int MONTH_OF_YEAR = 1;
   public static final int YEAR = 0;
   private static final long serialVersionUID = 797544782896179L;

   static {
      DateTimeFieldType[] var0 = new DateTimeFieldType[]{DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
      FIELD_TYPES = var0;
   }

   public YearMonth() {
   }

   public YearMonth(int var1, int var2) {
      this(var1, var2, (Chronology)null);
   }

   public YearMonth(int var1, int var2, Chronology var3) {
      super(new int[]{var1, var2}, var3);
   }

   public YearMonth(long var1) {
      super(var1);
   }

   public YearMonth(long var1, Chronology var3) {
      super(var1, var3);
   }

   public YearMonth(Object var1) {
      super(var1, (Chronology)null, ISODateTimeFormat.localDateParser());
   }

   public YearMonth(Object var1, Chronology var2) {
      super(var1, DateTimeUtils.getChronology(var2), ISODateTimeFormat.localDateParser());
   }

   public YearMonth(Chronology var1) {
      super(var1);
   }

   public YearMonth(DateTimeZone var1) {
      super(ISOChronology.getInstance(var1));
   }

   YearMonth(YearMonth var1, Chronology var2) {
      super(var1, var2);
   }

   YearMonth(YearMonth var1, int[] var2) {
      super(var1, var2);
   }

   public static YearMonth fromCalendarFields(Calendar var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The calendar must not be null");
      } else {
         return new YearMonth(var0.get(1), 1 + var0.get(2));
      }
   }

   public static YearMonth fromDateFields(Date var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The date must not be null");
      } else {
         return new YearMonth(1900 + var0.getYear(), 1 + var0.getMonth());
      }
   }

   public static YearMonth now() {
      return new YearMonth();
   }

   public static YearMonth now(Chronology var0) {
      if(var0 == null) {
         throw new NullPointerException("Chronology must not be null");
      } else {
         return new YearMonth(var0);
      }
   }

   public static YearMonth now(DateTimeZone var0) {
      if(var0 == null) {
         throw new NullPointerException("Zone must not be null");
      } else {
         return new YearMonth(var0);
      }
   }

   @FromString
   public static YearMonth parse(String var0) {
      return parse(var0, ISODateTimeFormat.localDateParser());
   }

   public static YearMonth parse(String var0, DateTimeFormatter var1) {
      LocalDate var2 = var1.parseLocalDate(var0);
      return new YearMonth(var2.getYear(), var2.getMonthOfYear());
   }

   private Object readResolve() {
      if(!DateTimeZone.UTC.equals(this.getChronology().getZone())) {
         this = new YearMonth(this, this.getChronology().withUTC());
      }

      return this;
   }

   protected DateTimeField getField(int var1, Chronology var2) {
      switch(var1) {
      case 0:
         return var2.year();
      case 1:
         return var2.monthOfYear();
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

   public YearMonth minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public YearMonth minusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(var1));
   }

   public YearMonth minusYears(int var1) {
      return this.withFieldAdded(DurationFieldType.years(), FieldUtils.safeNegate(var1));
   }

   public Property monthOfYear() {
      return new Property(this, 1);
   }

   public YearMonth plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public YearMonth plusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), var1);
   }

   public YearMonth plusYears(int var1) {
      return this.withFieldAdded(DurationFieldType.years(), var1);
   }

   public Property property(DateTimeFieldType var1) {
      return new Property(this, this.indexOfSupported(var1));
   }

   public int size() {
      return 2;
   }

   public Interval toInterval() {
      return this.toInterval((DateTimeZone)null);
   }

   public Interval toInterval(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      return new Interval(this.toLocalDate(1).toDateTimeAtStartOfDay(var2), this.plusMonths(1).toLocalDate(1).toDateTimeAtStartOfDay(var2));
   }

   public LocalDate toLocalDate(int var1) {
      return new LocalDate(this.getYear(), this.getMonthOfYear(), var1, this.getChronology());
   }

   @ToString
   public String toString() {
      return ISODateTimeFormat.yearMonth().print((ReadablePartial)this);
   }

   public String toString(String var1) {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).print((ReadablePartial)this);
   }

   public String toString(String var1, Locale var2) throws IllegalArgumentException {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).withLocale(var2).print((ReadablePartial)this);
   }

   public YearMonth withChronologyRetainFields(Chronology var1) {
      Chronology var2 = DateTimeUtils.getChronology(var1).withUTC();
      if(var2 == this.getChronology()) {
         return this;
      } else {
         YearMonth var3 = new YearMonth(this, var2);
         var2.validate(var3, this.getValues());
         return var3;
      }
   }

   public YearMonth withField(DateTimeFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == this.getValue(var3)) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new YearMonth(this, this.getField(var3).set(this, var3, var4, var2));
      }
   }

   public YearMonth withFieldAdded(DurationFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == 0) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new YearMonth(this, this.getField(var3).add(this, var3, var4, var2));
      }
   }

   public YearMonth withMonthOfYear(int var1) {
      int[] var2 = this.getValues();
      return new YearMonth(this, this.getChronology().monthOfYear().set(this, 1, var2, var1));
   }

   public YearMonth withPeriodAdded(ReadablePeriod var1, int var2) {
      if(var1 != null && var2 != 0) {
         int[] var3 = this.getValues();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            int var5 = this.indexOf(var1.getFieldType(var4));
            if(var5 >= 0) {
               var3 = this.getField(var5).add(this, var5, var3, FieldUtils.safeMultiply(var1.getValue(var4), var2));
            }
         }

         return new YearMonth(this, var3);
      } else {
         return this;
      }
   }

   public YearMonth withYear(int var1) {
      int[] var2 = this.getValues();
      return new YearMonth(this, this.getChronology().year().set(this, 0, var2, var1));
   }

   public Property year() {
      return new Property(this, 0);
   }
}
