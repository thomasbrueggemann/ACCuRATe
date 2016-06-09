package com.newrelic.agent.android.analytics;

public enum AnalyticsEventCategory {
   Crash,
   Custom,
   Interaction,
   Session;

   static {
      AnalyticsEventCategory[] var0 = new AnalyticsEventCategory[]{Session, Interaction, Crash, Custom};
   }

   public static AnalyticsEventCategory fromString(String var0) {
      AnalyticsEventCategory var1 = Custom;
      if(var0 != null) {
         if(var0.equalsIgnoreCase("session")) {
            var1 = Session;
         } else {
            if(var0.equalsIgnoreCase("interaction")) {
               return Interaction;
            }

            if(var0.equalsIgnoreCase("crash")) {
               return Crash;
            }
         }
      }

      return var1;
   }
}
