package org.joda.time;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.Chronology;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.LocalDate.Property;
import org.joda.time.base.BaseLocal;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.PartialConverter;
import org.joda.time.field.FieldUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public final class LocalDate extends BaseLocal implements Serializable, ReadablePartial {
   private static final Set<DurationFieldType> DATE_DURATION_TYPES = new HashSet();
   private static final int DAY_OF_MONTH = 2;
   private static final int MONTH_OF_YEAR = 1;
   private static final int YEAR = 0;
   private static final long serialVersionUID = -8775358157899L;
   private final Chronology iChronology;
   private transient int iHash;
   private final long iLocalMillis;

   static {
      DATE_DURATION_TYPES.add(DurationFieldType.days());
      DATE_DURATION_TYPES.add(DurationFieldType.weeks());
      DATE_DURATION_TYPES.add(DurationFieldType.months());
      DATE_DURATION_TYPES.add(DurationFieldType.weekyears());
      DATE_DURATION_TYPES.add(DurationFieldType.years());
      DATE_DURATION_TYPES.add(DurationFieldType.centuries());
      DATE_DURATION_TYPES.add(DurationFieldType.eras());
   }

   public LocalDate() {
      this(DateTimeUtils.currentTimeMillis(), (Chronology)ISOChronology.getInstance());
   }

   public LocalDate(int var1, int var2, int var3) {
      this(var1, var2, var3, ISOChronology.getInstanceUTC());
   }

   public LocalDate(int var1, int var2, int var3, Chronology var4) {
      Chronology var5 = DateTimeUtils.getChronology(var4).withUTC();
      long var6 = var5.getDateTimeMillis(var1, var2, var3, 0);
      this.iChronology = var5;
      this.iLocalMillis = var6;
   }

   public LocalDate(long var1) {
      this(var1, (Chronology)ISOChronology.getInstance());
   }

   public LocalDate(long var1, Chronology var3) {
      Chronology var4 = DateTimeUtils.getChronology(var3);
      long var5 = var4.getZone().getMillisKeepLocal(DateTimeZone.UTC, var1);
      Chronology var7 = var4.withUTC();
      this.iLocalMillis = var7.dayOfMonth().roundFloor(var5);
      this.iChronology = var7;
   }

   public LocalDate(long var1, DateTimeZone var3) {
      this(var1, (Chronology)ISOChronology.getInstance(var3));
   }

   public LocalDate(Object var1) {
      this(var1, (Chronology)null);
   }

   public LocalDate(Object var1, Chronology var2) {
      PartialConverter var3 = ConverterManager.getInstance().getPartialConverter(var1);
      Chronology var4 = DateTimeUtils.getChronology(var3.getChronology(var1, var2));
      this.iChronology = var4.withUTC();
      int[] var5 = var3.getPartialValues(this, var1, var4, ISODateTimeFormat.localDateParser());
      this.iLocalMillis = this.iChronology.getDateTimeMillis(var5[0], var5[1], var5[2], 0);
   }

   public LocalDate(Object var1, DateTimeZone var2) {
      PartialConverter var3 = ConverterManager.getInstance().getPartialConverter(var1);
      Chronology var4 = DateTimeUtils.getChronology(var3.getChronology(var1, var2));
      this.iChronology = var4.withUTC();
      int[] var5 = var3.getPartialValues(this, var1, var4, ISODateTimeFormat.localDateParser());
      this.iLocalMillis = this.iChronology.getDateTimeMillis(var5[0], var5[1], var5[2], 0);
   }

   public LocalDate(Chronology var1) {
      this(DateTimeUtils.currentTimeMillis(), var1);
   }

   public LocalDate(DateTimeZone var1) {
      this(DateTimeUtils.currentTimeMillis(), (Chronology)ISOChronology.getInstance(var1));
   }

   public static LocalDate fromCalendarFields(Calendar var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The calendar must not be null");
      } else {
         int var1 = var0.get(0);
         int var2 = var0.get(1);
         if(var1 != 1) {
            var2 = 1 - var2;
         }

         return new LocalDate(var2, 1 + var0.get(2), var0.get(5));
      }
   }

   public static LocalDate fromDateFields(Date var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("The date must not be null");
      } else if(var0.getTime() < 0L) {
         GregorianCalendar var1 = new GregorianCalendar();
         var1.setTime(var0);
         return fromCalendarFields(var1);
      } else {
         return new LocalDate(1900 + var0.getYear(), 1 + var0.getMonth(), var0.getDate());
      }
   }

   public static LocalDate now() {
      return new LocalDate();
   }

   public static LocalDate now(Chronology var0) {
      if(var0 == null) {
         throw new NullPointerException("Chronology must not be null");
      } else {
         return new LocalDate(var0);
      }
   }

   public static LocalDate now(DateTimeZone var0) {
      if(var0 == null) {
         throw new NullPointerException("Zone must not be null");
      } else {
         return new LocalDate(var0);
      }
   }

   @FromString
   public static LocalDate parse(String var0) {
      return parse(var0, ISODateTimeFormat.localDateParser());
   }

   public static LocalDate parse(String var0, DateTimeFormatter var1) {
      return var1.parseLocalDate(var0);
   }

   private Object readResolve() {
      if(this.iChronology == null) {
         this = new LocalDate(this.iLocalMillis, ISOChronology.getInstanceUTC());
      } else if(!DateTimeZone.UTC.equals(this.iChronology.getZone())) {
         return new LocalDate(this.iLocalMillis, this.iChronology.withUTC());
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
         if(var1 instanceof LocalDate) {
            LocalDate var2 = (LocalDate)var1;
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
         if(var1 instanceof LocalDate) {
            LocalDate var2 = (LocalDate)var1;
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
      } else if(!this.isSupported(var1)) {
         throw new IllegalArgumentException("Field \'" + var1 + "\' is not supported");
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
      default:
         throw new IndexOutOfBoundsException("Invalid index: " + var1);
      }
   }

   protected long getLocalMillis() {
      return this.iLocalMillis;
   }

   public int getMonthOfYear() {
      return this.getChronology().monthOfYear().get(this.getLocalMillis());
   }

   public int getValue(int var1) {
      switch(var1) {
      case 0:
         return this.getChronology().year().get(this.getLocalMillis());
      case 1:
         return this.getChronology().monthOfYear().get(this.getLocalMillis());
      case 2:
         return this.getChronology().dayOfMonth().get(this.getLocalMillis());
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

   public int hashCode() {
      int var1 = this.iHash;
      if(var1 == 0) {
         var1 = super.hashCode();
         this.iHash = var1;
      }

      return var1;
   }

   public boolean isSupported(DateTimeFieldType var1) {
      if(var1 != null) {
         DurationFieldType var2 = var1.getDurationType();
         if(DATE_DURATION_TYPES.contains(var2) || var2.getField(this.getChronology()).getUnitMillis() >= this.getChronology().days().getUnitMillis()) {
            return var1.getField(this.getChronology()).isSupported();
         }
      }

      return false;
   }

   public boolean isSupported(DurationFieldType var1) {
      if(var1 != null) {
         DurationField var2 = var1.getField(this.getChronology());
         if(DATE_DURATION_TYPES.contains(var1) || var2.getUnitMillis() >= this.getChronology().days().getUnitMillis()) {
            return var2.isSupported();
         }
      }

      return false;
   }

   public LocalDate minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public LocalDate minusDays(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().days().subtract(this.getLocalMillis(), var1));
   }

   public LocalDate minusMonths(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().months().subtract(this.getLocalMillis(), var1));
   }

   public LocalDate minusWeeks(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().weeks().subtract(this.getLocalMillis(), var1));
   }

   public LocalDate minusYears(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().years().subtract(this.getLocalMillis(), var1));
   }

   public Property monthOfYear() {
      return new Property(this, this.getChronology().monthOfYear());
   }

   public LocalDate plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public LocalDate plusDays(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().days().add(this.getLocalMillis(), var1));
   }

   public LocalDate plusMonths(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().months().add(this.getLocalMillis(), var1));
   }

   public LocalDate plusWeeks(int var1) {
      return var1 == 0?this:this.withLocalMillis(this.getChronology().weeks().add(this.getLocalMillis(), var1));
   }

   public LocalDate plusYears(int var1) {
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

   public int size() {
      return 3;
   }

   public Date toDate() {
      int var1 = this.getDayOfMonth();
      Date var2 = new Date(-1900 + this.getYear(), -1 + this.getMonthOfYear(), var1);
      LocalDate var3 = fromDateFields(var2);
      Date var4;
      if(!var3.isBefore(this)) {
         if(var3.equals(this)) {
            var4 = new Date(var2.getTime() - (long)TimeZone.getDefault().getDSTSavings());
            if(var4.getDate() == var1) {
               return var4;
            }
         }

         return var2;
      } else {
         while(!var3.equals(this)) {
            var2.setTime(3600000L + var2.getTime());
            var3 = fromDateFields(var2);
         }

         while(var2.getDate() == var1) {
            var2.setTime(var2.getTime() - 1000L);
         }

         var2.setTime(1000L + var2.getTime());
         var4 = var2;
         return var4;
      }
   }

   @Deprecated
   public DateMidnight toDateMidnight() {
      return this.toDateMidnight((DateTimeZone)null);
   }

   @Deprecated
   public DateMidnight toDateMidnight(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      Chronology var3 = this.getChronology().withZone(var2);
      return new DateMidnight(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), var3);
   }

   public DateTime toDateTime(LocalTime var1) {
      return this.toDateTime(var1, (DateTimeZone)null);
   }

   public DateTime toDateTime(LocalTime var1, DateTimeZone var2) {
      if(var1 == null) {
         return this.toDateTimeAtCurrentTime(var2);
      } else if(this.getChronology() != var1.getChronology()) {
         throw new IllegalArgumentException("The chronology of the time does not match");
      } else {
         Chronology var3 = this.getChronology().withZone(var2);
         return new DateTime(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), var1.getHourOfDay(), var1.getMinuteOfHour(), var1.getSecondOfMinute(), var1.getMillisOfSecond(), var3);
      }
   }

   public DateTime toDateTimeAtCurrentTime() {
      return this.toDateTimeAtCurrentTime((DateTimeZone)null);
   }

   public DateTime toDateTimeAtCurrentTime(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      Chronology var3 = this.getChronology().withZone(var2);
      return new DateTime(var3.set(this, DateTimeUtils.currentTimeMillis()), var3);
   }

   @Deprecated
   public DateTime toDateTimeAtMidnight() {
      return this.toDateTimeAtMidnight((DateTimeZone)null);
   }

   @Deprecated
   public DateTime toDateTimeAtMidnight(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      Chronology var3 = this.getChronology().withZone(var2);
      return new DateTime(this.getYear(), this.getMonthOfYear(), this.getDayOfMonth(), 0, 0, 0, 0, var3);
   }

   public DateTime toDateTimeAtStartOfDay() {
      return this.toDateTimeAtStartOfDay((DateTimeZone)null);
   }

   public DateTime toDateTimeAtStartOfDay(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      Chronology var3 = this.getChronology().withZone(var2);
      long var4 = var2.convertLocalToUTC(21600000L + this.getLocalMillis(), false);
      return new DateTime(var3.dayOfMonth().roundFloor(var4), var3);
   }

   public Interval toInterval() {
      return this.toInterval((DateTimeZone)null);
   }

   public Interval toInterval(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      return new Interval(this.toDateTimeAtStartOfDay(var2), this.plusDays(1).toDateTimeAtStartOfDay(var2));
   }

   public LocalDateTime toLocalDateTime(LocalTime var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("The time must not be null");
      } else if(this.getChronology() != var1.getChronology()) {
         throw new IllegalArgumentException("The chronology of the time does not match");
      } else {
         return new LocalDateTime(this.getLocalMillis() + var1.getLocalMillis(), this.getChronology());
      }
   }

   @ToString
   public String toString() {
      return ISODateTimeFormat.date().print((ReadablePartial)this);
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

   public LocalDate withCenturyOfEra(int var1) {
      return this.withLocalMillis(this.getChronology().centuryOfEra().set(this.getLocalMillis(), var1));
   }

   public LocalDate withDayOfMonth(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfMonth().set(this.getLocalMillis(), var1));
   }

   public LocalDate withDayOfWeek(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfWeek().set(this.getLocalMillis(), var1));
   }

   public LocalDate withDayOfYear(int var1) {
      return this.withLocalMillis(this.getChronology().dayOfYear().set(this.getLocalMillis(), var1));
   }

   public LocalDate withEra(int var1) {
      return this.withLocalMillis(this.getChronology().era().set(this.getLocalMillis(), var1));
   }

   public LocalDate withField(DateTimeFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else if(!this.isSupported(var1)) {
         throw new IllegalArgumentException("Field \'" + var1 + "\' is not supported");
      } else {
         return this.withLocalMillis(var1.getField(this.getChronology()).set(this.getLocalMillis(), var2));
      }
   }

   public LocalDate withFieldAdded(DurationFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else if(!this.isSupported(var1)) {
         throw new IllegalArgumentException("Field \'" + var1 + "\' is not supported");
      } else {
         return var2 == 0?this:this.withLocalMillis(var1.getField(this.getChronology()).add(this.getLocalMillis(), var2));
      }
   }

   public LocalDate withFields(ReadablePartial var1) {
      return var1 == null?this:this.withLocalMillis(this.getChronology().set(var1, this.getLocalMillis()));
   }

   LocalDate withLocalMillis(long var1) {
      long var3 = this.iChronology.dayOfMonth().roundFloor(var1);
      return var3 == this.getLocalMillis()?this:new LocalDate(var3, this.getChronology());
   }

   public LocalDate withMonthOfYear(int var1) {
      return this.withLocalMillis(this.getChronology().monthOfYear().set(this.getLocalMillis(), var1));
   }

   public LocalDate withPeriodAdded(ReadablePeriod var1, int var2) {
      if(var1 != null && var2 != 0) {
         long var3 = this.getLocalMillis();
         Chronology var5 = this.getChronology();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            long var7 = (long)FieldUtils.safeMultiply(var1.getValue(var6), var2);
            DurationFieldType var9 = var1.getFieldType(var6);
            if(this.isSupported(var9)) {
               var3 = var9.getField(var5).add(var3, var7);
            }
         }

         return this.withLocalMillis(var3);
      } else {
         return this;
      }
   }

   public LocalDate withWeekOfWeekyear(int var1) {
      return this.withLocalMillis(this.getChronology().weekOfWeekyear().set(this.getLocalMillis(), var1));
   }

   public LocalDate withWeekyear(int var1) {
      return this.withLocalMillis(this.getChronology().weekyear().set(this.getLocalMillis(), var1));
   }

   public LocalDate withYear(int var1) {
      return this.withLocalMillis(this.getChronology().year().set(this.getLocalMillis(), var1));
   }

   public LocalDate withYearOfCentury(int var1) {
      return this.withLocalMillis(this.getChronology().yearOfCentury().set(this.getLocalMillis(), var1));
   }

   public LocalDate withYearOfEra(int var1) {
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
