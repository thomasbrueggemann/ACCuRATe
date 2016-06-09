package org.joda.time;

import java.io.Serializable;
import org.joda.convert.FromString;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadablePartial;
import org.joda.time.ReadablePeriod;
import org.joda.time.YearMonthDay;
import org.joda.time.DateMidnight.Property;
import org.joda.time.base.BaseDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

@Deprecated
public final class DateMidnight extends BaseDateTime implements Serializable, ReadableDateTime {
   private static final long serialVersionUID = 156371964018738L;

   public DateMidnight() {
   }

   public DateMidnight(int var1, int var2, int var3) {
      super(var1, var2, var3, 0, 0, 0, 0);
   }

   public DateMidnight(int var1, int var2, int var3, Chronology var4) {
      super(var1, var2, var3, 0, 0, 0, 0, (Chronology)var4);
   }

   public DateMidnight(int var1, int var2, int var3, DateTimeZone var4) {
      super(var1, var2, var3, 0, 0, 0, 0, (DateTimeZone)var4);
   }

   public DateMidnight(long var1) {
      super(var1);
   }

   public DateMidnight(long var1, Chronology var3) {
      super(var1, var3);
   }

   public DateMidnight(long var1, DateTimeZone var3) {
      super(var1, var3);
   }

   public DateMidnight(Object var1) {
      super(var1, (Chronology)null);
   }

   public DateMidnight(Object var1, Chronology var2) {
      super(var1, DateTimeUtils.getChronology(var2));
   }

   public DateMidnight(Object var1, DateTimeZone var2) {
      super(var1, var2);
   }

   public DateMidnight(Chronology var1) {
      super(var1);
   }

   public DateMidnight(DateTimeZone var1) {
      super(var1);
   }

   public static DateMidnight now() {
      return new DateMidnight();
   }

   public static DateMidnight now(Chronology var0) {
      if(var0 == null) {
         throw new NullPointerException("Chronology must not be null");
      } else {
         return new DateMidnight(var0);
      }
   }

   public static DateMidnight now(DateTimeZone var0) {
      if(var0 == null) {
         throw new NullPointerException("Zone must not be null");
      } else {
         return new DateMidnight(var0);
      }
   }

   @FromString
   public static DateMidnight parse(String var0) {
      return parse(var0, ISODateTimeFormat.dateTimeParser().withOffsetParsed());
   }

   public static DateMidnight parse(String var0, DateTimeFormatter var1) {
      return var1.parseDateTime(var0).toDateMidnight();
   }

   public Property centuryOfEra() {
      return new Property(this, this.getChronology().centuryOfEra());
   }

   protected long checkInstant(long var1, Chronology var3) {
      return var3.dayOfMonth().roundFloor(var1);
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

   public Property era() {
      return new Property(this, this.getChronology().era());
   }

   public DateMidnight minus(long var1) {
      return this.withDurationAdded(var1, -1);
   }

   public DateMidnight minus(ReadableDuration var1) {
      return this.withDurationAdded(var1, -1);
   }

   public DateMidnight minus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, -1);
   }

   public DateMidnight minusDays(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().days().subtract(this.getMillis(), var1));
   }

   public DateMidnight minusMonths(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().months().subtract(this.getMillis(), var1));
   }

   public DateMidnight minusWeeks(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().weeks().subtract(this.getMillis(), var1));
   }

   public DateMidnight minusYears(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().years().subtract(this.getMillis(), var1));
   }

   public Property monthOfYear() {
      return new Property(this, this.getChronology().monthOfYear());
   }

   public DateMidnight plus(long var1) {
      return this.withDurationAdded(var1, 1);
   }

   public DateMidnight plus(ReadableDuration var1) {
      return this.withDurationAdded(var1, 1);
   }

   public DateMidnight plus(ReadablePeriod var1) {
      return this.withPeriodAdded(var1, 1);
   }

   public DateMidnight plusDays(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().days().add(this.getMillis(), var1));
   }

   public DateMidnight plusMonths(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().months().add(this.getMillis(), var1));
   }

   public DateMidnight plusWeeks(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().weeks().add(this.getMillis(), var1));
   }

   public DateMidnight plusYears(int var1) {
      return var1 == 0?this:this.withMillis(this.getChronology().years().add(this.getMillis(), var1));
   }

   public Property property(DateTimeFieldType var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("The DateTimeFieldType must not be null");
      } else {
         DateTimeField var2 = var1.getField(this.getChronology());
         if(!var2.isSupported()) {
            throw new IllegalArgumentException("Field \'" + var1 + "\' is not supported");
         } else {
            return new Property(this, var2);
         }
      }
   }

   public Interval toInterval() {
      Chronology var1 = this.getChronology();
      long var2 = this.getMillis();
      return new Interval(var2, DurationFieldType.days().getField(var1).add(var2, 1), var1);
   }

   public LocalDate toLocalDate() {
      return new LocalDate(this.getMillis(), this.getChronology());
   }

   @Deprecated
   public YearMonthDay toYearMonthDay() {
      return new YearMonthDay(this.getMillis(), this.getChronology());
   }

   public Property weekOfWeekyear() {
      return new Property(this, this.getChronology().weekOfWeekyear());
   }

   public Property weekyear() {
      return new Property(this, this.getChronology().weekyear());
   }

   public DateMidnight withCenturyOfEra(int var1) {
      return this.withMillis(this.getChronology().centuryOfEra().set(this.getMillis(), var1));
   }

   public DateMidnight withChronology(Chronology var1) {
      return var1 == this.getChronology()?this:new DateMidnight(this.getMillis(), var1);
   }

   public DateMidnight withDayOfMonth(int var1) {
      return this.withMillis(this.getChronology().dayOfMonth().set(this.getMillis(), var1));
   }

   public DateMidnight withDayOfWeek(int var1) {
      return this.withMillis(this.getChronology().dayOfWeek().set(this.getMillis(), var1));
   }

   public DateMidnight withDayOfYear(int var1) {
      return this.withMillis(this.getChronology().dayOfYear().set(this.getMillis(), var1));
   }

   public DateMidnight withDurationAdded(long var1, int var3) {
      return var1 != 0L && var3 != 0?this.withMillis(this.getChronology().add(this.getMillis(), var1, var3)):this;
   }

   public DateMidnight withDurationAdded(ReadableDuration var1, int var2) {
      return var1 != null && var2 != 0?this.withDurationAdded(var1.getMillis(), var2):this;
   }

   public DateMidnight withEra(int var1) {
      return this.withMillis(this.getChronology().era().set(this.getMillis(), var1));
   }

   public DateMidnight withField(DateTimeFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else {
         return this.withMillis(var1.getField(this.getChronology()).set(this.getMillis(), var2));
      }
   }

   public DateMidnight withFieldAdded(DurationFieldType var1, int var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field must not be null");
      } else {
         return var2 == 0?this:this.withMillis(var1.getField(this.getChronology()).add(this.getMillis(), var2));
      }
   }

   public DateMidnight withFields(ReadablePartial var1) {
      return var1 == null?this:this.withMillis(this.getChronology().set(var1, this.getMillis()));
   }

   public DateMidnight withMillis(long var1) {
      Chronology var3 = this.getChronology();
      long var4 = this.checkInstant(var1, var3);
      return var4 == this.getMillis()?this:new DateMidnight(var4, var3);
   }

   public DateMidnight withMonthOfYear(int var1) {
      return this.withMillis(this.getChronology().monthOfYear().set(this.getMillis(), var1));
   }

   public DateMidnight withPeriodAdded(ReadablePeriod var1, int var2) {
      return var1 != null && var2 != 0?this.withMillis(this.getChronology().add(var1, this.getMillis(), var2)):this;
   }

   public DateMidnight withWeekOfWeekyear(int var1) {
      return this.withMillis(this.getChronology().weekOfWeekyear().set(this.getMillis(), var1));
   }

   public DateMidnight withWeekyear(int var1) {
      return this.withMillis(this.getChronology().weekyear().set(this.getMillis(), var1));
   }

   public DateMidnight withYear(int var1) {
      return this.withMillis(this.getChronology().year().set(this.getMillis(), var1));
   }

   public DateMidnight withYearOfCentury(int var1) {
      return this.withMillis(this.getChronology().yearOfCentury().set(this.getMillis(), var1));
   }

   public DateMidnight withYearOfEra(int var1) {
      return this.withMillis(this.getChronology().yearOfEra().set(this.getMillis(), var1));
   }

   public DateMidnight withZoneRetainFields(DateTimeZone var1) {
      DateTimeZone var2 = DateTimeUtils.getZone(var1);
      DateTimeZone var3 = DateTimeUtils.getZone(this.getZone());
      return var2 == var3?this:new DateMidnight(var3.getMillisKeepLocal(var2, this.getMillis()), this.getChronology().withZone(var2));
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
