package org.joda.time;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.joda.time.LocalDate;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.MonthDay.Property;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;

public final class MonthDay extends BasePartial implements Serializable, ReadablePartial {
   public static final int DAY_OF_MONTH = 1;
   private static final DateTimeFieldType[] FIELD_TYPES;
   public static final int MONTH_OF_YEAR = 0;
   private static final DateTimeFormatter PARSER;
   private static final long serialVersionUID = 2954560699050434609L;

   static {
      DateTimeFieldType[] var0 = new DateTimeFieldType[]{DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
      FIELD_TYPES = var0;
      PARSER = (new DateTimeFormatterBuilder()).appendOptional(ISODateTimeFormat.localDateParser().getParser()).appendOptional(DateTimeFormat.forPattern("--MM-dd").getParser()).toFormatter();
   }

   public MonthDay() {
   }

   public MonthDay(int var1, int var2) {
      this(var1, var2, (Chronology)null);
   }

   public MonthDay(int var1, int var2, Chronology var3) {
      super(new int[]{var1, var2}, var3);
   }

   public MonthDay(long var1) {
      super(var1);
   }

   public MonthDay(long var1, Chronology var3) {
      super(var1, var3);
   }

   public MonthDay(Object var1) {
      super(var1, (Chronology)null, ISODateTimeFormat.localDateParser());
   }

   public MonthDay(Object var1, Chronology var2) {
      super(var1, DateTimeUtils.getChronology(var2), ISODateTimeFormat.localDateParser());
   }

   public MonthDay(Chronology var1) {
      super(var1);
   }

   public MonthDay(DateTimeZone var1) {
      super(ISOChronology.getInstance(var1));
   }

   MonthDay(MonthDay var1, Chronology var2) {
      super(var1, var2);
   }

   MonthDay(MonthDay var1, int[] var2) {
      super(var1, var2);
   }

   public static MonthDay fromCalendarFields(Calendar var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The calendar must not be null");
      } else {
         return new MonthDay(1 + var0.get(2), var0.get(5));
      }
   }

   public static MonthDay fromDateFields(Date var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The date must not be null");
      } else {
         return new MonthDay(1 + var0.getMonth(), var0.getDate());
      }
   }

   public static MonthDay now() {
      return new MonthDay();
   }

   public static MonthDay now(Chronology var0) {
      if(var0 == null) {
         throw new NullPointerException("Chronology must not be null");
      } else {
         return new MonthDay(var0);
      }
   }

   public static MonthDay now(DateTimeZone var0) {
      if(var0 == null) {
         throw new NullPointerException("Zone must not be null");
      } else {
         return new MonthDay(var0);
      }
   }

   @FromString
   public static MonthDay parse(String var0) {
      return parse(var0, PARSER);
   }

   public static MonthDay parse(String var0, DateTimeFormatter var1) {
      LocalDate var2 = var1.parseLocalDate(var0);
      return new MonthDay(var2.getMonthOfYear(), var2.getDayOfMonth());
   }

   private Object readResolve() {
      if(!DateTimeZone.UTC.equals(this.getChronology().getZone())) {
         this = new MonthDay(this, this.getChronology().withUTC());
      }

      return this;
   }

   public Property dayOfMonth() {
      return new Property(this, 1);
   }

   public int getDayOfMonth() {
      return this.getValue(1);
   }

   protected DateTimeField getField(int var1, Chronology var2) {
      switch(var1) {
      case 0:
         return var2.monthOfYear();
      case 1:
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
      return this.getValue(0);
   }

   public MonthDay minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public MonthDay minusDays(int var1) {
      return this.withFieldAdded(DurationFieldType.days(), FieldUtils.safeNegate(var1));
   }

   public MonthDay minusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), FieldUtils.safeNegate(var1));
   }

   public Property monthOfYear() {
      return new Property(this, 0);
   }

   public MonthDay plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public MonthDay plusDays(int var1) {
      return this.withFieldAdded(DurationFieldType.days(), var1);
   }

   public MonthDay plusMonths(int var1) {
      return this.withFieldAdded(DurationFieldType.months(), var1);
   }

   public Property property(DateTimeFieldType var1) {
      return new Property(this, this.indexOfSupported(var1));
   }

   public int size() {
      return 2;
   }

   public LocalDate toLocalDate(int var1) {
      return new LocalDate(var1, this.getMonthOfYear(), this.getDayOfMonth(), this.getChronology());
   }

   @ToString
   public String toString() {
      ArrayList var1 = new ArrayList();
      var1.add(DateTimeFieldType.monthOfYear());
      var1.add(DateTimeFieldType.dayOfMonth());
      return ISODateTimeFormat.forFields(var1, true, true).print((ReadablePartial)this);
   }

   public String toString(String var1) {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).print((ReadablePartial)this);
   }

   public String toString(String var1, Locale var2) throws IllegalArgumentException {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).withLocale(var2).print((ReadablePartial)this);
   }

   public MonthDay withChronologyRetainFields(Chronology var1) {
      Chronology var2 = DateTimeUtils.getChronology(var1).withUTC();
      if(var2 == this.getChronology()) {
         return this;
      } else {
         MonthDay var3 = new MonthDay(this, var2);
         var2.validate(var3, this.getValues());
         return var3;
      }
   }

   public MonthDay withDayOfMonth(int var1) {
      int[] var2 = this.getValues();
      return new MonthDay(this, this.getChronology().dayOfMonth().set(this, 1, var2, var1));
   }

   public MonthDay withField(DateTimeFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == this.getValue(var3)) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new MonthDay(this, this.getField(var3).set(this, var3, var4, var2));
      }
   }

   public MonthDay withFieldAdded(DurationFieldType var1, int var2) {
      int var3 = this.indexOfSupported(var1);
      if(var2 == 0) {
         return this;
      } else {
         int[] var4 = this.getValues();
         return new MonthDay(this, this.getField(var3).add(this, var3, var4, var2));
      }
   }

   public MonthDay withMonthOfYear(int var1) {
      int[] var2 = this.getValues();
      return new MonthDay(this, this.getChronology().monthOfYear().set(this, 0, var2, var1));
   }

   public MonthDay withPeriodAdded(ReadablePeriod var1, int var2) {
      if(var1 != null && var2 != 0) {
         int[] var3 = this.getValues();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            int var5 = this.indexOf(var1.getFieldType(var4));
            if(var5 >= 0) {
               var3 = this.getField(var5).add(this, var5, var3, FieldUtils.safeMultiply(var1.getValue(var4), var2));
            }
         }

         return new MonthDay(this, var3);
      } else {
         return this;
      }
   }
}
