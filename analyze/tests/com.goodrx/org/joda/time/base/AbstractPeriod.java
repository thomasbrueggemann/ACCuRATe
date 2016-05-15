package org.joda.time.base;

import org.joda.convert.ToString;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

public abstract class AbstractPeriod implements ReadablePeriod {
   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ReadablePeriod)) {
            return false;
         }

         ReadablePeriod var2 = (ReadablePeriod)var1;
         if(this.size() != var2.size()) {
            return false;
         }

         int var3 = this.size();

         for(int var4 = 0; var4 < var3; ++var4) {
            if(this.getValue(var4) != var2.getValue(var4) || this.getFieldType(var4) != var2.getFieldType(var4)) {
               return false;
            }
         }
      }

      return true;
   }

   public int get(DurationFieldType var1) {
      int var2 = this.indexOf(var1);
      return var2 == -1?0:this.getValue(var2);
   }

   public DurationFieldType getFieldType(int var1) {
      return this.getPeriodType().getFieldType(var1);
   }

   public DurationFieldType[] getFieldTypes() {
      DurationFieldType[] var1 = new DurationFieldType[this.size()];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = this.getFieldType(var2);
      }

      return var1;
   }

   public int[] getValues() {
      int[] var1 = new int[this.size()];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = this.getValue(var2);
      }

      return var1;
   }

   public int hashCode() {
      int var1 = 17;
      int var2 = 0;

      for(int var3 = this.size(); var2 < var3; ++var2) {
         var1 = 27 * (var1 * 27 + this.getValue(var2)) + this.getFieldType(var2).hashCode();
      }

      return var1;
   }

   public int indexOf(DurationFieldType var1) {
      return this.getPeriodType().indexOf(var1);
   }

   public boolean isSupported(DurationFieldType var1) {
      return this.getPeriodType().isSupported(var1);
   }

   public int size() {
      return this.getPeriodType().size();
   }

   public MutablePeriod toMutablePeriod() {
      return new MutablePeriod(this);
   }

   public Period toPeriod() {
      return new Period(this);
   }

   @ToString
   public String toString() {
      return ISOPeriodFormat.standard().print(this);
   }

   public String toString(PeriodFormatter var1) {
      return var1 == null?this.toString():var1.print(this);
   }
}
