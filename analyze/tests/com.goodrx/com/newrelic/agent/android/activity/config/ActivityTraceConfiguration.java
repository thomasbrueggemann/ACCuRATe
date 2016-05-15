package com.newrelic.agent.android.activity.config;

public class ActivityTraceConfiguration {
   private int maxTotalTraceCount;

   public static ActivityTraceConfiguration defaultActivityTraceConfiguration() {
      ActivityTraceConfiguration var0 = new ActivityTraceConfiguration();
      var0.setMaxTotalTraceCount(1);
      return var0;
   }

   public int getMaxTotalTraceCount() {
      return this.maxTotalTraceCount;
   }

   public void setMaxTotalTraceCount(int var1) {
      this.maxTotalTraceCount = var1;
   }

   public String toString() {
      return "ActivityTraceConfiguration{maxTotalTraceCount=" + this.maxTotalTraceCount + '}';
   }
}
