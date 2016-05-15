package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadWritableInstant;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserBucket;
import org.joda.time.format.DateTimeParserInternalParser;
import org.joda.time.format.DateTimePrinter;
import org.joda.time.format.DateTimePrinterInternalPrinter;
import org.joda.time.format.FormatUtils;
import org.joda.time.format.InternalParser;
import org.joda.time.format.InternalParserDateTimeParser;
import org.joda.time.format.InternalPrinter;
import org.joda.time.format.InternalPrinterDateTimePrinter;

public class DateTimeFormatter {
   private final Chronology iChrono;
   private final int iDefaultYear;
   private final Locale iLocale;
   private final boolean iOffsetParsed;
   private final InternalParser iParser;
   private final Integer iPivotYear;
   private final InternalPrinter iPrinter;
   private final DateTimeZone iZone;

   public DateTimeFormatter(DateTimePrinter var1, DateTimeParser var2) {
      this(DateTimePrinterInternalPrinter.of(var1), DateTimeParserInternalParser.of(var2));
   }

   DateTimeFormatter(InternalPrinter var1, InternalParser var2) {
      this.iPrinter = var1;
      this.iParser = var2;
      this.iLocale = null;
      this.iOffsetParsed = false;
      this.iChrono = null;
      this.iZone = null;
      this.iPivotYear = null;
      this.iDefaultYear = 2000;
   }

   private DateTimeFormatter(InternalPrinter var1, InternalParser var2, Locale var3, boolean var4, Chronology var5, DateTimeZone var6, Integer var7, int var8) {
      this.iPrinter = var1;
      this.iParser = var2;
      this.iLocale = var3;
      this.iOffsetParsed = var4;
      this.iChrono = var5;
      this.iZone = var6;
      this.iPivotYear = var7;
      this.iDefaultYear = var8;
   }

   private void printTo(Appendable var1, long var2, Chronology var4) throws IOException {
      InternalPrinter var5 = this.requirePrinter();
      Chronology var6 = this.selectChronology(var4);
      DateTimeZone var7 = var6.getZone();
      int var8 = var7.getOffset(var2);
      long var9 = var2 + (long)var8;
      if((var2 ^ var9) < 0L && (var2 ^ (long)var8) >= 0L) {
         var7 = DateTimeZone.UTC;
         var8 = 0;
         var9 = var2;
      }

      var5.printTo(var1, var9, var6.withUTC(), var8, var7, this.iLocale);
   }

   private InternalParser requireParser() {
      InternalParser var1 = this.iParser;
      if(var1 == null) {
         throw new UnsupportedOperationException("Parsing not supported");
      } else {
         return var1;
      }
   }

   private InternalPrinter requirePrinter() {
      InternalPrinter var1 = this.iPrinter;
      if(var1 == null) {
         throw new UnsupportedOperationException("Printing not supported");
      } else {
         return var1;
      }
   }

   private Chronology selectChronology(Chronology var1) {
      Chronology var2 = DateTimeUtils.getChronology(var1);
      if(this.iChrono != null) {
         var2 = this.iChrono;
      }

      if(this.iZone != null) {
         var2 = var2.withZone(this.iZone);
      }

      return var2;
   }

   @Deprecated
   public Chronology getChronolgy() {
      return this.iChrono;
   }

   public Chronology getChronology() {
      return this.iChrono;
   }

   public int getDefaultYear() {
      return this.iDefaultYear;
   }

   public Locale getLocale() {
      return this.iLocale;
   }

   public DateTimeParser getParser() {
      return InternalParserDateTimeParser.of(this.iParser);
   }

   InternalParser getParser0() {
      return this.iParser;
   }

   public Integer getPivotYear() {
      return this.iPivotYear;
   }

   public DateTimePrinter getPrinter() {
      return InternalPrinterDateTimePrinter.of(this.iPrinter);
   }

   InternalPrinter getPrinter0() {
      return this.iPrinter;
   }

   public DateTimeZone getZone() {
      return this.iZone;
   }

   public boolean isOffsetParsed() {
      return this.iOffsetParsed;
   }

   public boolean isParser() {
      return this.iParser != null;
   }

   public boolean isPrinter() {
      return this.iPrinter != null;
   }

   public DateTime parseDateTime(String var1) {
      InternalParser var2 = this.requireParser();
      Chronology var3 = this.selectChronology((Chronology)null);
      DateTimeParserBucket var4 = new DateTimeParserBucket(0L, var3, this.iLocale, this.iPivotYear, this.iDefaultYear);
      int var5 = var2.parseInto(var4, var1, 0);
      if(var5 >= 0) {
         if(var5 >= var1.length()) {
            long var6 = var4.computeMillis(true, var1);
            if(this.iOffsetParsed && var4.getOffsetInteger() != null) {
               var3 = var3.withZone(DateTimeZone.forOffsetMillis(var4.getOffsetInteger().intValue()));
            } else if(var4.getZone() != null) {
               var3 = var3.withZone(var4.getZone());
            }

            DateTime var8 = new DateTime(var6, var3);
            if(this.iZone != null) {
               var8 = var8.withZone(this.iZone);
            }

            return var8;
         }
      } else {
         var5 = ~var5;
      }

      throw new IllegalArgumentException(FormatUtils.createErrorMessage(var1, var5));
   }

   public int parseInto(ReadWritableInstant var1, String var2, int var3) {
      InternalParser var4 = this.requireParser();
      if(var1 == null) {
         throw new IllegalArgumentException("Instant must not be null");
      } else {
         long var5 = var1.getMillis();
         Chronology var7 = var1.getChronology();
         int var8 = DateTimeUtils.getChronology(var7).year().get(var5);
         long var9 = var5 + (long)var7.getZone().getOffset(var5);
         Chronology var11 = this.selectChronology(var7);
         DateTimeParserBucket var12 = new DateTimeParserBucket(var9, var11, this.iLocale, this.iPivotYear, var8);
         int var13 = var4.parseInto(var12, var2, var3);
         var1.setMillis(var12.computeMillis(false, var2));
         if(this.iOffsetParsed && var12.getOffsetInteger() != null) {
            var11 = var11.withZone(DateTimeZone.forOffsetMillis(var12.getOffsetInteger().intValue()));
         } else if(var12.getZone() != null) {
            var11 = var11.withZone(var12.getZone());
         }

         var1.setChronology(var11);
         if(this.iZone != null) {
            var1.setZone(this.iZone);
         }

         return var13;
      }
   }

   public LocalDate parseLocalDate(String var1) {
      return this.parseLocalDateTime(var1).toLocalDate();
   }

   public LocalDateTime parseLocalDateTime(String var1) {
      InternalParser var2 = this.requireParser();
      Chronology var3 = this.selectChronology((Chronology)null).withUTC();
      DateTimeParserBucket var4 = new DateTimeParserBucket(0L, var3, this.iLocale, this.iPivotYear, this.iDefaultYear);
      int var5 = var2.parseInto(var4, var1, 0);
      if(var5 >= 0) {
         if(var5 >= var1.length()) {
            long var6 = var4.computeMillis(true, var1);
            if(var4.getOffsetInteger() != null) {
               var3 = var3.withZone(DateTimeZone.forOffsetMillis(var4.getOffsetInteger().intValue()));
            } else if(var4.getZone() != null) {
               var3 = var3.withZone(var4.getZone());
            }

            return new LocalDateTime(var6, var3);
         }
      } else {
         var5 = ~var5;
      }

      throw new IllegalArgumentException(FormatUtils.createErrorMessage(var1, var5));
   }

   public LocalTime parseLocalTime(String var1) {
      return this.parseLocalDateTime(var1).toLocalTime();
   }

   public long parseMillis(String var1) {
      InternalParser var2 = this.requireParser();
      return (new DateTimeParserBucket(0L, this.selectChronology(this.iChrono), this.iLocale, this.iPivotYear, this.iDefaultYear)).doParseMillis(var2, var1);
   }

   public MutableDateTime parseMutableDateTime(String var1) {
      InternalParser var2 = this.requireParser();
      Chronology var3 = this.selectChronology((Chronology)null);
      DateTimeParserBucket var4 = new DateTimeParserBucket(0L, var3, this.iLocale, this.iPivotYear, this.iDefaultYear);
      int var5 = var2.parseInto(var4, var1, 0);
      if(var5 >= 0) {
         if(var5 >= var1.length()) {
            long var6 = var4.computeMillis(true, var1);
            if(this.iOffsetParsed && var4.getOffsetInteger() != null) {
               var3 = var3.withZone(DateTimeZone.forOffsetMillis(var4.getOffsetInteger().intValue()));
            } else if(var4.getZone() != null) {
               var3 = var3.withZone(var4.getZone());
            }

            MutableDateTime var8 = new MutableDateTime(var6, var3);
            if(this.iZone != null) {
               var8.setZone(this.iZone);
            }

            return var8;
         }
      } else {
         var5 = ~var5;
      }

      throw new IllegalArgumentException(FormatUtils.createErrorMessage(var1, var5));
   }

   public String print(long var1) {
      StringBuilder var3 = new StringBuilder(this.requirePrinter().estimatePrintedLength());

      try {
         this.printTo((Appendable)var3, var1);
      } catch (IOException var5) {
         ;
      }

      return var3.toString();
   }

   public String print(ReadableInstant var1) {
      StringBuilder var2 = new StringBuilder(this.requirePrinter().estimatePrintedLength());

      try {
         this.printTo((Appendable)var2, (ReadableInstant)var1);
      } catch (IOException var4) {
         ;
      }

      return var2.toString();
   }

   public String print(ReadablePartial var1) {
      StringBuilder var2 = new StringBuilder(this.requirePrinter().estimatePrintedLength());

      try {
         this.printTo((Appendable)var2, (ReadablePartial)var1);
      } catch (IOException var4) {
         ;
      }

      return var2.toString();
   }

   public void printTo(Writer var1, long var2) throws IOException {
      this.printTo((Appendable)var1, var2);
   }

   public void printTo(Writer var1, ReadableInstant var2) throws IOException {
      this.printTo((Appendable)var1, (ReadableInstant)var2);
   }

   public void printTo(Writer var1, ReadablePartial var2) throws IOException {
      this.printTo((Appendable)var1, (ReadablePartial)var2);
   }

   public void printTo(Appendable var1, long var2) throws IOException {
      this.printTo(var1, var2, (Chronology)null);
   }

   public void printTo(Appendable var1, ReadableInstant var2) throws IOException {
      this.printTo(var1, DateTimeUtils.getInstantMillis(var2), DateTimeUtils.getInstantChronology(var2));
   }

   public void printTo(Appendable var1, ReadablePartial var2) throws IOException {
      InternalPrinter var3 = this.requirePrinter();
      if(var2 == null) {
         throw new IllegalArgumentException("The partial must not be null");
      } else {
         var3.printTo(var1, var2, this.iLocale);
      }
   }

   public void printTo(StringBuffer var1, long var2) {
      try {
         this.printTo((Appendable)var1, var2);
      } catch (IOException var5) {
         ;
      }
   }

   public void printTo(StringBuffer var1, ReadableInstant var2) {
      try {
         this.printTo((Appendable)var1, (ReadableInstant)var2);
      } catch (IOException var4) {
         ;
      }
   }

   public void printTo(StringBuffer var1, ReadablePartial var2) {
      try {
         this.printTo((Appendable)var1, (ReadablePartial)var2);
      } catch (IOException var4) {
         ;
      }
   }

   public void printTo(StringBuilder var1, long var2) {
      try {
         this.printTo((Appendable)var1, var2);
      } catch (IOException var5) {
         ;
      }
   }

   public void printTo(StringBuilder var1, ReadableInstant var2) {
      try {
         this.printTo((Appendable)var1, (ReadableInstant)var2);
      } catch (IOException var4) {
         ;
      }
   }

   public void printTo(StringBuilder var1, ReadablePartial var2) {
      try {
         this.printTo((Appendable)var1, (ReadablePartial)var2);
      } catch (IOException var4) {
         ;
      }
   }

   public DateTimeFormatter withChronology(Chronology var1) {
      return this.iChrono == var1?this:new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, var1, this.iZone, this.iPivotYear, this.iDefaultYear);
   }

   public DateTimeFormatter withDefaultYear(int var1) {
      return new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, var1);
   }

   public DateTimeFormatter withLocale(Locale var1) {
      return var1 != this.getLocale() && (var1 == null || !var1.equals(this.getLocale()))?new DateTimeFormatter(this.iPrinter, this.iParser, var1, this.iOffsetParsed, this.iChrono, this.iZone, this.iPivotYear, this.iDefaultYear):this;
   }

   public DateTimeFormatter withOffsetParsed() {
      return this.iOffsetParsed?this:new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, true, this.iChrono, (DateTimeZone)null, this.iPivotYear, this.iDefaultYear);
   }

   public DateTimeFormatter withPivotYear(int var1) {
      return this.withPivotYear(Integer.valueOf(var1));
   }

   public DateTimeFormatter withPivotYear(Integer var1) {
      return this.iPivotYear != var1 && (this.iPivotYear == null || !this.iPivotYear.equals(var1))?new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, this.iOffsetParsed, this.iChrono, this.iZone, var1, this.iDefaultYear):this;
   }

   public DateTimeFormatter withZone(DateTimeZone var1) {
      return this.iZone == var1?this:new DateTimeFormatter(this.iPrinter, this.iParser, this.iLocale, false, this.iChrono, var1, this.iPivotYear, this.iDefaultYear);
   }

   public DateTimeFormatter withZoneUTC() {
      return this.withZone(DateTimeZone.UTC);
   }
}
