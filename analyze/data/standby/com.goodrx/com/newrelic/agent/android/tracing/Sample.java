package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.tracing.SampleValue;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;

public class Sample extends HarvestableArray {
   private SampleValue sampleValue;
   private long timestamp;
   private Sample.SampleType type;

   public Sample(long var1) {
      this.setTimestamp(var1);
   }

   public Sample(long var1, SampleValue var3) {
      this.setTimestamp(var1);
      this.setSampleValue(var3);
   }

   public Sample(Sample.SampleType var1) {
      this.setSampleType(var1);
      this.setTimestamp(System.currentTimeMillis());
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.timestamp)));
      var1.add(SafeJsonPrimitive.factory(this.sampleValue.getValue()));
      return var1;
   }

   public Sample.SampleType getSampleType() {
      return this.type;
   }

   public SampleValue getSampleValue() {
      return this.sampleValue;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public Number getValue() {
      return this.sampleValue.getValue();
   }

   public void setSampleType(Sample.SampleType var1) {
      this.type = var1;
   }

   public void setSampleValue(double var1) {
      this.sampleValue = new SampleValue(var1);
   }

   public void setSampleValue(long var1) {
      this.sampleValue = new SampleValue(var1);
   }

   public void setSampleValue(SampleValue var1) {
      this.sampleValue = var1;
   }

   public void setTimestamp(long var1) {
      this.timestamp = var1;
   }

   public static enum SampleType {
      CPU,
      MEMORY;

      static {
         Sample.SampleType[] var0 = new Sample.SampleType[]{MEMORY, CPU};
      }
   }
}
