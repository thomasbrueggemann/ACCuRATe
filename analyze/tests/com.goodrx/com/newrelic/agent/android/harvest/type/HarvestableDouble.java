package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.HarvestableValue;
import com.newrelic.com.google.gson.JsonPrimitive;

public class HarvestableDouble extends HarvestableValue {
   private double value;

   public HarvestableDouble() {
   }

   public HarvestableDouble(double var1) {
      this();
      this.value = var1;
   }

   public JsonPrimitive asJsonPrimitive() {
      return new JsonPrimitive(Double.valueOf(this.value));
   }
}
