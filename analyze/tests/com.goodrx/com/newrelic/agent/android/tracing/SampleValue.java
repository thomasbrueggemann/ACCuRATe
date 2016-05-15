package com.newrelic.agent.android.tracing;

public class SampleValue {
   private boolean isDouble;
   private Double value = Double.valueOf(0.0D);

   public SampleValue(double var1) {
      this.setValue(var1);
   }

   public SampleValue(long var1) {
      this.setValue(var1);
   }

   public Double asDouble() {
      return this.value;
   }

   public Long asLong() {
      return Long.valueOf(this.value.longValue());
   }

   public Number getValue() {
      return (Number)(this.isDouble?this.asDouble():this.asLong());
   }

   public boolean isDouble() {
      return this.isDouble;
   }

   public void setDouble(boolean var1) {
      this.isDouble = var1;
   }

   public void setValue(double var1) {
      this.value = Double.valueOf(var1);
      this.isDouble = true;
   }

   public void setValue(long var1) {
      this.value = Double.valueOf((double)var1);
      this.isDouble = false;
   }
}
