package com.criteo.events;

import com.criteo.events.CRTOLog;
import java.util.GregorianCalendar;

class ExtraData {
   private GregorianCalendar dateValue;
   private float floatValue;
   private int intValue;
   private String stringValue;
   private ExtraData.ExtraDataType valueType;

   public GregorianCalendar getDateValue() {
      if(this.valueType != ExtraData.ExtraDataType.Date) {
         Object[] var1 = new Object[]{this.valueType};
         CRTOLog.method_473(String.format("Attempt to retrieve Date value from %s ExtraData instance", var1));
         return null;
      } else {
         return this.dateValue;
      }
   }

   public float getFloatValue() {
      if(this.valueType != ExtraData.ExtraDataType.Float) {
         Object[] var1 = new Object[]{this.valueType};
         CRTOLog.method_473(String.format("Attempt to retrieve float value from %s ExtraData instance", var1));
         return 0.0F;
      } else {
         return this.floatValue;
      }
   }

   public int getIntValue() {
      if(this.valueType != ExtraData.ExtraDataType.Int) {
         Object[] var1 = new Object[]{this.valueType};
         CRTOLog.method_473(String.format("Attempt to retrieve int value from %s ExtraData instance", var1));
         return 0;
      } else {
         return this.intValue;
      }
   }

   public String getStringValue() {
      if(this.valueType != ExtraData.ExtraDataType.String) {
         Object[] var1 = new Object[]{this.valueType};
         CRTOLog.method_473(String.format("Attempt to retrieve String value from %s ExtraData instance", var1));
         return null;
      } else {
         return this.stringValue;
      }
   }

   ExtraData.ExtraDataType getType() {
      return this.valueType;
   }

   Object getValue() {
      switch(null.$SwitchMap$com$criteo$events$ExtraData$ExtraDataType[this.valueType.ordinal()]) {
      case 1:
         return Float.valueOf(this.getFloatValue());
      case 2:
         return Integer.valueOf(this.getIntValue());
      case 3:
         return this.getDateValue();
      case 4:
         return this.getStringValue();
      default:
         return null;
      }
   }

   static enum ExtraDataType {
      Date,
      Float,
      Int,
      String;

      static {
         ExtraData.ExtraDataType[] var0 = new ExtraData.ExtraDataType[]{Float, Date, Int, String};
      }
   }
}
