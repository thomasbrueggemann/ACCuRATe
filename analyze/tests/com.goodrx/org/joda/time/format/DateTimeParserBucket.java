package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.format.DateTimeParser;
import org.joda.time.format.DateTimeParserInternalParser;
import org.joda.time.format.FormatUtils;
import org.joda.time.format.InternalParser;
import org.joda.time.format.DateTimeParserBucket.SavedField;
import org.joda.time.format.DateTimeParserBucket.SavedState;

public class DateTimeParserBucket {
   private final Chronology iChrono;
   private final Integer iDefaultPivotYear;
   private final int iDefaultYear;
   private final DateTimeZone iDefaultZone;
   private final Locale iLocale;
   private final long iMillis;
   private Integer iOffset;
   private Integer iPivotYear;
   private SavedField[] iSavedFields;
   private int iSavedFieldsCount;
   private boolean iSavedFieldsShared;
   private Object iSavedState;
   private DateTimeZone iZone;

   @Deprecated
   public DateTimeParserBucket(long var1, Chronology var3, Locale var4) {
      this(var1, var3, var4, (Integer)null, 2000);
   }

   @Deprecated
   public DateTimeParserBucket(long var1, Chronology var3, Locale var4, Integer var5) {
      this(var1, var3, var4, var5, 2000);
   }

   public DateTimeParserBucket(long var1, Chronology var3, Locale var4, Integer var5, int var6) {
      Chronology var7 = DateTimeUtils.getChronology(var3);
      this.iMillis = var1;
      this.iDefaultZone = var7.getZone();
      this.iChrono = var7.withUTC();
      if(var4 == null) {
         var4 = Locale.getDefault();
      }

      this.iLocale = var4;
      this.iDefaultYear = var6;
      this.iDefaultPivotYear = var5;
      this.iZone = this.iDefaultZone;
      this.iPivotYear = this.iDefaultPivotYear;
      this.iSavedFields = new SavedField[8];
   }

   // $FF: synthetic method
   static DateTimeZone access$000(DateTimeParserBucket var0) {
      return var0.iZone;
   }

   // $FF: synthetic method
   static DateTimeZone access$002(DateTimeParserBucket var0, DateTimeZone var1) {
      var0.iZone = var1;
      return var1;
   }

   // $FF: synthetic method
   static Integer access$100(DateTimeParserBucket var0) {
      return var0.iOffset;
   }

   // $FF: synthetic method
   static Integer access$102(DateTimeParserBucket var0, Integer var1) {
      var0.iOffset = var1;
      return var1;
   }

   // $FF: synthetic method
   static SavedField[] access$200(DateTimeParserBucket var0) {
      return var0.iSavedFields;
   }

   // $FF: synthetic method
   static SavedField[] access$202(DateTimeParserBucket var0, SavedField[] var1) {
      var0.iSavedFields = var1;
      return var1;
   }

   // $FF: synthetic method
   static int access$300(DateTimeParserBucket var0) {
      return var0.iSavedFieldsCount;
   }

   // $FF: synthetic method
   static int access$302(DateTimeParserBucket var0, int var1) {
      var0.iSavedFieldsCount = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean access$402(DateTimeParserBucket var0, boolean var1) {
      var0.iSavedFieldsShared = var1;
      return var1;
   }

   static int compareReverse(DurationField var0, DurationField var1) {
      return var0 != null && var0.isSupported()?(var1 != null && var1.isSupported()?-var0.compareTo(var1):1):(var1 != null && var1.isSupported()?-1:0);
   }

   private SavedField obtainSaveField() {
      SavedField[] var1 = this.iSavedFields;
      int var2 = this.iSavedFieldsCount;
      SavedField[] var4;
      if(var2 != var1.length && !this.iSavedFieldsShared) {
         var4 = var1;
      } else {
         int var3;
         if(var2 == var1.length) {
            var3 = var2 * 2;
         } else {
            var3 = var1.length;
         }

         var4 = new SavedField[var3];
         System.arraycopy(var1, 0, var4, 0, var2);
         this.iSavedFields = var4;
         this.iSavedFieldsShared = false;
      }

      this.iSavedState = null;
      SavedField var5 = var4[var2];
      SavedField var7;
      if(var5 == null) {
         SavedField var6 = new SavedField();
         var4[var2] = var6;
         var7 = var6;
      } else {
         var7 = var5;
      }

      this.iSavedFieldsCount = var2 + 1;
      return var7;
   }

   private static void sort(SavedField[] var0, int var1) {
      int var2 = 0;
      if(var1 > 10) {
         Arrays.sort(var0, 0, var1);
      } else {
         while(var2 < var1) {
            for(int var3 = var2; var3 > 0 && var0[var3 - 1].compareTo(var0[var3]) > 0; --var3) {
               SavedField var4 = var0[var3];
               var0[var3] = var0[var3 - 1];
               var0[var3 - 1] = var4;
            }

            ++var2;
         }
      }

   }

   public long computeMillis() {
      return this.computeMillis(false, (CharSequence)null);
   }

   public long computeMillis(boolean var1) {
      return this.computeMillis(var1, (CharSequence)null);
   }

   public long computeMillis(boolean param1, CharSequence param2) {
      // $FF: Couldn't be decompiled
   }

   public long computeMillis(boolean var1, String var2) {
      return this.computeMillis(var1, (CharSequence)var2);
   }

   long doParseMillis(InternalParser var1, CharSequence var2) {
      int var3 = var1.parseInto(this, var2, 0);
      if(var3 >= 0) {
         if(var3 >= var2.length()) {
            return this.computeMillis(true, var2);
         }
      } else {
         var3 = ~var3;
      }

      throw new IllegalArgumentException(FormatUtils.createErrorMessage(var2.toString(), var3));
   }

   public Chronology getChronology() {
      return this.iChrono;
   }

   public Locale getLocale() {
      return this.iLocale;
   }

   @Deprecated
   public int getOffset() {
      return this.iOffset != null?this.iOffset.intValue():0;
   }

   public Integer getOffsetInteger() {
      return this.iOffset;
   }

   public Integer getPivotYear() {
      return this.iPivotYear;
   }

   public DateTimeZone getZone() {
      return this.iZone;
   }

   public long parseMillis(DateTimeParser var1, CharSequence var2) {
      this.reset();
      return this.doParseMillis(DateTimeParserInternalParser.of(var1), var2);
   }

   public void reset() {
      this.iZone = this.iDefaultZone;
      this.iOffset = null;
      this.iPivotYear = this.iDefaultPivotYear;
      this.iSavedFieldsCount = 0;
      this.iSavedFieldsShared = false;
      this.iSavedState = null;
   }

   public boolean restoreState(Object var1) {
      if(var1 instanceof SavedState && ((SavedState)var1).restoreState(this)) {
         this.iSavedState = var1;
         return true;
      } else {
         return false;
      }
   }

   public void saveField(DateTimeField var1, int var2) {
      this.obtainSaveField().init(var1, var2);
   }

   public void saveField(DateTimeFieldType var1, int var2) {
      this.obtainSaveField().init(var1.getField(this.iChrono), var2);
   }

   public void saveField(DateTimeFieldType var1, String var2, Locale var3) {
      this.obtainSaveField().init(var1.getField(this.iChrono), var2, var3);
   }

   public Object saveState() {
      if(this.iSavedState == null) {
         this.iSavedState = new SavedState(this);
      }

      return this.iSavedState;
   }

   @Deprecated
   public void setOffset(int var1) {
      this.iSavedState = null;
      this.iOffset = Integer.valueOf(var1);
   }

   public void setOffset(Integer var1) {
      this.iSavedState = null;
      this.iOffset = var1;
   }

   @Deprecated
   public void setPivotYear(Integer var1) {
      this.iPivotYear = var1;
   }

   public void setZone(DateTimeZone var1) {
      this.iSavedState = null;
      this.iZone = var1;
   }
}
