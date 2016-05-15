package com.newrelic.agent.android.metric;

public enum MetricUnit {
   BYTES("bytes"),
   BYTES_PER_SECOND("bytes/second"),
   OPERATIONS("op"),
   PERCENT("%"),
   SECONDS("sec");

   private String label;

   static {
      MetricUnit[] var0 = new MetricUnit[]{PERCENT, BYTES, SECONDS, BYTES_PER_SECOND, OPERATIONS};
   }

   private MetricUnit(String var3) {
      this.label = var3;
   }

   public String getLabel() {
      return this.label;
   }

   public void setLabel(String var1) {
      this.label = var1;
   }
}
