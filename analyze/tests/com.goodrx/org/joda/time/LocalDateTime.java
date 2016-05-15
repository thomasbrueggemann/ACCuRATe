package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.LocalDateTime.Property;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalDateTime extends BaseLocal implements Serializable, ReadablePartial {
   private static final int DAY_OF_MONTH = 2;
   private static final int MILLIS_OF_DAY = 3;
   private static final int MONTH_OF_YEAR = 1;
   private static final int YEAR = 0;
   private static final long serialVersionUID = -268716875315837168L;
   private final Chronology iChronology;
   private final long iLocalMillis;

   public LocalDateTime() {
      this(DateTimeUtils.currentTimeMillis(), (Chronology)ISOChronology.getInstance());
   }

   public LocalDateTime(int var1, int var2, int var3, int var4, int var5) {
      this(var1, var2, var3, var4, var5, 0, 0, ISOChronology.getInstanceUTC());
   }

   public LocalDateTime(int var1, int var2, int var3, int var4, int var5, int var6) {
      this(var1, var2, var3, var4, var5, var6, 0, ISOChronology.getInstanceUTC());
   }

   public LocalDateTime(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this(var1, var2, var3, var4, var5, var6, var7, ISOChronology.getInstanceUTC());
   }

   public LocalDateTime(int var1, int var2, int var3, int var4, int var5, int var6, int var7, Chronology var8) {
      Chronology var9 = DateTimeUtils.getChronology(var8).withUTC();
      long var10 = var9.getDateTimeMillis(var1, var2, var3, var4, var5, var6, var7);
      this.iChronology = var9;
      this.iLocalMillis = var10;
   }

   public LocalDateTime(long var1) {
      this(var1, (Chronology)ISOChronology.getInstance());
   }

   public LocalDateTime(long var1, Chronology var3) {
      Chronology var4 = DateTimeUtils.getChronology(var3);
      this.iLocalMillis = var4.getZone().getMillisKeepLocal(DateTimeZone.UTC, var1);
      this.iChronology = var4.withUTC();
   }

   public LocalDateTime(long var1, DateTimeZone var3) {
      this(var1, (Chronology)ISOChronology.getInstance(var3));
   }

   public LocalDateTime(Object var1) {
      this(var1, (Chronology)null);
   }

   public LocalDateTime(Object var1, Chronology var2) {
      PartialConverter var3 = ConverterManager.getInstance().getPartialConverter(var1);
      Chronology var4 = DateTimeUtils.getChronology(var3.getChronology(var1, var2));
      this.iChronology = var4.withUTC();
      int[] var5 = var3.getPartialValues(this, var1, var4, ISODateTimeFormat.localDateOptionalTimeParser());
      this.iLocalMillis = this.iChronology.getDateTimeMillis(var5[0], var5[1], var5[2], var5[3]);
   }

   public LocalDateTime(Object var1, DateTimeZone var2) {
      PartialConverter var3 = ConverterManager.getInstance().getPartialConverter(var1);
      Chronology var4 = DateTimeUtils.getChronology(var3.getChronology(var1, var2));
      this.iChronology = var4.withUTC();
      int[] var5 = var3.getPartialValues(this, var1, var4, ISODateTimeFormat.localDateOptionalTimeParser());
      this.iLocalMillis = this.iChronology.getDateTimeMillis(var5[0], var5[1], var5[2], var5[3]);
   }

   public LocalDateTime(Chronology var1) {
      this(DateTimeUtils.currentTimeMillis(), var1);
   }

   public LocalDateTime(DateTimeZone var1) {
      this(DateTimeUtils.currentTimeMillis(), (Chronology)ISOChronology.getInstance(var1));
   }

   private Date correctDstTransition(Date var1, TimeZone var2) {
      Calendar var3 = Calendar.getInstance(var2);
      var3.setTime(var1);
      LocalDateTime var4 = fromCalendarFields(var3);
      Calendar var5;
      if(!var4.isBefore(this)) {
         if(var4.equals(this)) {
            var5 = Calendar.getInstance(var2);
            var5.setTimeInMillis(var3.getTimeInMillis() - (long)var2.getDSTSavings());
            if(fromCalendarFields(var5).equals(this)) {
               return var5.getTime();
            }
         }

         var5 = var3;
      } else {
         while(var4.isBefore(this)) {
            var3.setTimeInMillis(60000L + var3.getTimeInMillis());
            var4 = fromCalendarFields(var3);
         }

         while(true) {
            if(var4.isBefore(this)) {
               var3.setTimeInMillis(1000L + var3.getTimeInMillis());
               var5 = var3;
               break;
            }

            var3.setTimeInMillis(var3.getTimeInMillis() - 1000L);
            var4 = fromCalendarFields(var3);
         }
      }

      return var5.getTime();
   }

   public static LocalDateTime fromCalendarFields(Calendar var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The calendar must not be null");
      } else {
         int var1 = var0.get(0);
         int var2 = var0.get(1);
         if(var1 != 1) {
            var2 = 1 - var2;
         }

         return new LocalDateTime(var2, 1 + var0.get(2), var0.get(5), var0.get(11), var0.get(12), var0.get(13), var0.get(14));
      }
   }

   public static LocalDateTime fromDateFields(Date var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The date must not be null");
      } else if(var0.getTime() < 0L) {
         GregorianCalendar var1 = new GregorianCalendar();
         var1.setTime(var0);
         return fromCalendarFields(var1);
      } else {
         return new LocalDateTime(1900 + var0.getYear(), 1 + var0.getMonth(), var0.getDate(), var0.getHours(), var0.getMinutes(), var0.getSeconds(), (1000 + (int)(var0.getTime() % 1000L)) % 1000);
      }
   }

   public static LocalDateTime now() {
      return new LocalDateTime();
   }

   public static LocalDateTime now(Chronology var0) {
      if(var0 == null) {
         throw new NullPointerException("Chronology must not be null");
      } else {
         return new LocalDateTime(var0);
      }
   }

   public static LocalDateTime now(DateTimeZone var0) {
      if(var0 == null) {
         throw new NullPointerException("Zone must not be null");
      } else {
         return new LocalDateTime(var0);
      }
   }

   @FromString
   public static LocalDateTime parse(String var0) {
      return parse(var0, ISODateTimeFormat.localDateOptionalTimeParser());
   }

   public static LocalDateTime parse(String var0, DateTimeFormatter var1) {
      return var1.parseLocalDateTime(var0);
   }

   private Object readResolve() {
      if(this.iChronology == null) {
         this = new LocalDateTime(this.iLocalMillis, ISOChronology.getInstanceUTC());
      } else if(!DateTimeZone.UTC.equals(this.iChronology.getZone())) {
         return new LocalDateTime(this.iLocalMillis, this.iChronology.withUTC());
      }

      return this;
   }

   public Property centuryOfEra() {
      return new Property(this, this.getChronology().centuryOfEra());
   }

   public int compareTo(ReadablePartial var1) {
      if(this == var1) {
         return 0;
      } else {
         if(var1 instanceof LocalDateTime) {
            LocalDateTime var2 = (LocalDateTime)var1;
            if(this.iChronology.equals(var2.iChronology)) {
               byte var3;
               if(this.iLocalMillis < var2.iLocalMillis) {
                  var3 = -1;
               } else if(this.iLocalMillis == var2.iLocalMillis) {
                  var3 = 0;
               } else {
                  var3 = 1;
               }

               return var3;
            }
         }

         return super.compareTo(var1);
      }
   }

   public Property dayOfMonth() {
      return new Property(this, this.getChronology().dayOfMonth());
   }

   public Property dayOfWeek() {
      return new Property(this, this.getChronology().dayOfWeek());
   }

   public Property dayOfYear() {
      return new Property(this, this.getChronology().dayOfYear());
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else {
         if(var1 instanceof LocalDateTime) {
            LocalDateTime var2 = (LocalDateTime)var1;
            if(this.iChronology.equals(var2.iChronology)) {
               boolean var3;
               if(this.iLocalMillis == var2.iLocalMillis) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               return var3;
            }
         }

         return super.equals(var1);
      }
   }

   public Property era() {
      return new Property(this, this.getChronology().era());
   }

   public int get(DateTimeFieldType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else {
         return var1.getField(this.getChronology()).get(this.getLocalMillis());
      }
   }

   public int getCenturyOfEra() {
      return this.getChronology().centuryOfEra().get(this.getLocalMillis());
   }

   public Chronology getChronology() {
      return this.iChronology;
   }

   public int getDayOfMonth() {
      return this.getChronology().dayOfMonth().get(this.getLocalMillis());
   }

   public int getDayOfWeek() {
      return this.getChronology().dayOfWeek().get(this.getLocalMillis());
   }

   public int getDayOfYear() {
      return this.getChronology().dayOfYear().get(this.getLocalMillis());
   }

   public int getEra() {
      return this.getChronology().era().get(this.getLocalMillis());
   }

   protected DateTimeField getField(int var1, Chronology var2) {
      switch(var1) {
      case 0:
         return var2.year();
      case 1:
         return var2.monthOfYear();
      case 2:
         return var2.dayOfMonth();
      case 3:
         return var2.millisOfDay();
      default:
         throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }
   }

   public int getHourOfDay() {
      return this.getChronology().hourOfDay().get(this.getLocalMillis());
   }

   protected long getLocalMillis() {
      return this.iLocalMillis;
   }

   public int getMillisOfDay() {
      return this.getChronology().millisOfDay().get(this.getLocalMillis());
   }

   public int getMillisOfSecond() {
      return this.getChronology().millisOfSecond().get(this.getLocalMillis());
   }

   public int getMinuteOfHour() {
      return this.getChronology().minuteOfHour().get(this.getLocalMillis());
   }

   public int getMonthOfYear() {
      return this.getChronology().monthOfYear().get(this.getLocalMillis());
   }

   public int getSecondOfMinute() {
      return this.getChronology().secondOfMinute().get(this.getLocalMillis());
   }

   public int getValue(int var1) {
      switch(var1) {
      case 0:
         return this.getChronology().year().get(this.getLocalMillis());
      case 1:
         return this.getChronology().monthOfYear().get(this.getLocalMillis());
      case 2:
         return this.getChronology().dayOfMonth().get(this.getLocalMillis());
      case 3:
         return this.getChronology().millisOfDay().get(this.getLocalMillis());
      default:
         throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }
   }

   public int getWeekOfWeekyear() {
      return this.getChronology().weekOfWeekyear().get(this.getLocalMillis());
   }

   public int getWeekyear() {
      return this.getChronology().weekyear().get(this.getLocalMillis());
   }

   public int getYear() {
      return this.getChronology().year().get(this.getLocalMillis());
   }

   public int getYearOfCentury() {
      return this.getChronology().yearOfCentury().get(this.getLocalMillis());
   }

   public int getYearOfEra() {
      return this.getChronology().yearOfEra().get(this.getLocalMillis());
   }

   public Property hourOfDay() {
      return new Property(this, this.getChronology().hourOfDay());
   }

   public boolean isSupported(DateTimeFieldType var1) {
      return var1 == null?false:var1.getField(this.getChronology()).isSupported();
   }

   public boolean isSupported(DurationFieldType var1) {
      return var1 == null?false:var1.getField(this.getChronology()).isSupported();
   }

   public Property millisOfDay() {
      return new Property(this, this.getChronology().millisOfDay());
   }

   public Property millisOfSecond() {
      return new Property(this, this.getChronology().millisOfSecond());
   }

   public LocalDateTime minus(ReadableDuration var1) {
      return this.withDurationAdded(var1, -1);
   }

   public LocalDateTime minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public LocalDateTime minusDays(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().days().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusHours(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().hours().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusMillis(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().millis().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusMinutes(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().minutes().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusMonths(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().months().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusSeconds(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().seconds().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusWeeks(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().weeks().subtract(this.getLocalMillis(), var1));
   }

   public LocalDateTime minusYears(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().years().subtract(this.getLocalMillis(), var1));
   }

   public Property minuteOfHour() {
      return new Property(this, this.getChronology().minuteOfHour());
   }

   public Property monthOfYear() {
      return new Property(this, this.getChronology().monthOfYear());
   }

   public LocalDateTime plus(ReadableDuration var1) {
      return this.withDurationAdded(var1, 1);
   }

   public LocalDateTime plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public LocalDateTime plusDays(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().days().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusHours(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().hours().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusMillis(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().millis().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusMinutes(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().minutes().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusMonths(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().months().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusSeconds(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().seconds().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusWeeks(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().weeks().add(this.getLocalMillis(), var1));
   }

   public LocalDateTime plusYears(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().years().add(this.getLocalMillis(), var1));
   }

   public Property property(DateTimeFieldType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else if(!this.isSupported(var1)) {
         throw new IllegalArgumentException("Field \'" + var1 + "\' is not supported");
      } else {
         return new Property(this, var1.getField(this.getChronology()));
      }
   }

   public Property secondOfMinute() {
      return new Property(this, this.getChronology().secondOfMinute());
   }

   public int size() {
      return 4;
   }

   public Date toDate() {
      int var1 = this.getDayOfMonth();
      Date var2 = new Date(-1900 + this.getYear(), -1 + this.getMonthOfYear(), var1, this.getHourOfDay(), this.getMinuteOfHour(), this.getSecondOfMinute());
      var2.setTime(var2.getTime() + (long)this.getMillisOfSecond());
      return this.correctDstTransition(var2, TimeZone.getDefault());
   }

   public Date toDate(TimeZone var1) {
      Calendar var2 = Calendar.getInstance(var1);
      var2.clear();
      var2.set(this.getYear(), -1 + this.getMonthOfYear(), this.getDayOfMonth(), this.getHourOfDay(), this.getMinuteOfHour(), this.getSecondOfMinute());
      Date var3 = var2.getTime();
      var3.setTime(var3.getTime() + (long)this.getMillisOfSecond());
      return this.correctDstTransition(var3, var1);
   }

   public DateTime toDateTime() {
      return this.toDateTime((DateTimeZone)null);
   }

   public DateTime toDateTime(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      Chronology var3 = this.iChronology.withZone(var2);
      return new DateTime(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), this.getHourOfDay(), this.getMinuteOfHour(), this.getSecondOfMinute(), this.getMillisOfSecond(), var3);
   }

   public LocalDate toLocalDate() {
      return new LocalDate(this.getLocalMillis(), this.getChronology());
   }

   public LocalTime toLocalTime() {
      return new LocalTime(this.getLocalMillis(), this.getChronology());
   }

   @ToString
   public String toString() {
      return ISODateTimeFormat.dateTime().print((ReadablePartial)this);
   }

   public String toString(String var1) {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).print((ReadablePartial)this);
   }

   public String toString(String var1, Locale var2) throws IllegalArgumentException {
      return var1 == null?this.toString():DateTimeFormat.forPattern(var1).withLocale(var2).print((ReadablePartial)this);
   }

   public Property weekOfWeekyear() {
      return new Property(this, this.getChronology().weekOfWeekyear());
   }

   public Property weekyear() {
      return new Property(this, this.getChronology().weekyear());
   }

   public LocalDateTime withCenturyOfEra(int var1) {
      return this.withLocalMillis(this.getChronology().centuryOfEra().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withDate(int var1, int var2, int var3) {
      Chronology var4 = this.getChronology();
      long var5 = this.getLocalMillis();
      long var7 = var4.year().set(var5, var1);
      long var9 = var4.monthOfYear().set(var7, var2);
      return this.withLocalMillis(var4.dayOfMonth().set(var9, var3));
   }

   public LocalDateTime withDayOfMonth(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfMonth().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withDayOfWeek(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfWeek().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withDayOfYear(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfYear().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withDurationAdded(ReadableDuration var1, int var2) {
      return var1 != null && var2 != 0?this.withLocalMillis(this.getChronology().add(this.getLocalMillis(), var1.getMillis(), var2)):this;
   }

   public LocalDateTime withEra(int var1) {
      return this.withLocalMillis(this.getChronology().era().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withField(DateTimeFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else {
         return this.withLocalMillis(var1.getField(this.getChronology()).set(this.getLocalMillis(), var2));
      }
   }

   public LocalDateTime withFieldAdded(DurationFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else {
         return var2 == 0?this:this.withLocalMillis(var1.getField(this.getChronology()).add(this.getLocalMillis(), var2));
      }
   }

   public LocalDateTime withFields(ReadablePartial var1) {
      return var1 == null?this:this.withLocalMillis(this.getChronology().set(var1, this.getLocalMillis()));
   }

   public LocalDateTime withHourOfDay(int var1) {
      return this.withLocalMillis(this.getChronology().hourOfDay().set(this.getLocalMillis(), var1));
   }

   LocalDateTime withLocalMillis(long var1) {
      return var1 == this.getLocalMillis()?this:new LocalDateTime(var1, this.getChronology());
   }

   public LocalDateTime withMillisOfDay(int var1) {
      return this.withLocalMillis(this.getChronology().millisOfDay().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withMillisOfSecond(int var1) {
      return this.withLocalMillis(this.getChronology().millisOfSecond().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withMinuteOfHour(int var1) {
      return this.withLocalMillis(this.getChronology().minuteOfHour().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withMonthOfYear(int var1) {
      return this.withLocalMillis(this.getChronology().monthOfYear().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withPeriodAdded(ReadablePeriod var1, int var2) {
      return var1 != null && var2 != 0?this.withLocalMillis(this.getChronology().add(var1, this.getLocalMillis(), var2)):this;
   }

   public LocalDateTime withSecondOfMinute(int var1) {
      return this.withLocalMillis(this.getChronology().secondOfMinute().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withTime(int var1, int var2, int var3, int var4) {
      Chronology var5 = this.getChronology();
      long var6 = this.getLocalMillis();
      long var8 = var5.hourOfDay().set(var6, var1);
      long var10 = var5.minuteOfHour().set(var8, var2);
      long var12 = var5.secondOfMinute().set(var10, var3);
      return this.withLocalMillis(var5.millisOfSecond().set(var12, var4));
   }

   public LocalDateTime withWeekOfWeekyear(int var1) {
      return this.withLocalMillis(this.getChronology().weekOfWeekyear().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withWeekyear(int var1) {
      return this.withLocalMillis(this.getChronology().weekyear().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withYear(int var1) {
      return this.withLocalMillis(this.getChronology().year().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withYearOfCentury(int var1) {
      return this.withLocalMillis(this.getChronology().yearOfCentury().set(this.getLocalMillis(), var1));
   }

   public LocalDateTime withYearOfEra(int var1) {
      return this.withLocalMillis(this.getChronology().yearOfEra().set(this.getLocalMillis(), var1));
   }

   public Property year() {
      return new Property(this, this.getChronology().year());
   }

   public Property yearOfCentury() {
      return new Property(this, this.getChronology().yearOfCentury());
   }

   public Property yearOfEra() {
      return new Property(this, this.getChronology().yearOfEra());
   }
}
