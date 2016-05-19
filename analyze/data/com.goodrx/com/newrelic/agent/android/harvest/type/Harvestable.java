package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public interface Harvestable {
   JsonElement asJson();

   JsonArray asJsonArray();

   JsonObject asJsonObject();

   JsonPrimitive asJsonPrimitive();

   Harvestable.Type getType();

   String toJsonString();

   public static enum Type {
      ARRAY,
      OBJECT,
      VALUE;

      static {
         Harvestable.Type[] var0 = new Harvestable.Type[]{OBJECT, ARRAY, VALUE};
      }
   }
}
