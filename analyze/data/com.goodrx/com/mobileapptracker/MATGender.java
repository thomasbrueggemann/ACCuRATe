package com.mobileapptracker;

import java.util.Locale;

public enum MATGender {
   FEMALE,
   MALE,
   UNKNOWN;

   static {
      MATGender[] var0 = new MATGender[]{MALE, FEMALE, UNKNOWN};
   }

   public static MATGender forValue(String var0) {
      return valueOf(var0.toUpperCase(Locale.ENGLISH));
   }

   public String value() {
      return this.name();
   }
}
