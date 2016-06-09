package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.HarvestableValue;
import com.newrelic.com.google.gson.JsonPrimitive;

public class HarvestableLong extends HarvestableValue {
   private long value;

   public HarvestableLong() {
   }

   public HarvestableLong(long var1) {
      this();
      this.value = var1;
   }

   public JsonPrimitive asJsonPrimitive() {
      return new JsonPrimitive(Long.valueOf(this.value));
   }
}
