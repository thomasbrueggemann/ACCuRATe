package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;

public class Event extends HarvestableArray {
   private long eventName;
   private Map<String, String> params = new HashMap();
   private long timestamp;

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(new JsonPrimitive(Long.valueOf(this.timestamp)));
      var1.add(new JsonPrimitive(Long.valueOf(this.eventName)));
      var1.add((new Gson()).toJsonTree(this.params, GSON_STRING_MAP_TYPE));
      return var1;
   }

   public long getEventName() {
      return this.eventName;
   }

   public Map<String, String> getParams() {
      return this.params;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public void setEventName(long var1) {
      this.eventName = var1;
   }

   public void setParams(Map<String, String> var1) {
      this.params = var1;
   }

   public void setTimestamp(long var1) {
      this.timestamp = var1;
   }
}
