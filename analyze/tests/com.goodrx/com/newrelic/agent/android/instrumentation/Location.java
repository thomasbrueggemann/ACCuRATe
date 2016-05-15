package com.newrelic.agent.android.instrumentation;

public class Location {
   private final String countryCode;
   private final String region;

   public Location(String var1, String var2) {
      if(var1 != null && var2 != null) {
         this.countryCode = var1;
         this.region = var2;
      } else {
         throw new IllegalArgumentException("Country code and region must not be null.");
      }
   }

   public String getCountryCode() {
      return this.countryCode;
   }

   public String getRegion() {
      return this.region;
   }
}
