package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Map;

public abstract class HarvestableObject extends BaseHarvestable {
   public HarvestableObject() {
      super(Harvestable.Type.OBJECT);
   }

   public static HarvestableObject fromMap(final Map<String, String> var0) {
      return new HarvestableObject() {
         public JsonObject asJsonObject() {
            return (JsonObject)(new Gson()).toJsonTree(var0, GSON_STRING_MAP_TYPE);
         }
      };
   }

   public abstract JsonObject asJsonObject();
}
