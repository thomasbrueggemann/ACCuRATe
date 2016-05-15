package com.newrelic.agent.android.harvest.type;

import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import com.newrelic.com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class BaseHarvestable implements Harvestable {
   protected static final Type GSON_STRING_MAP_TYPE = (new TypeToken() {
   }).getType();
   private final Harvestable.Type type;

   public BaseHarvestable(Harvestable.Type var1) {
      this.type = var1;
   }

   public JsonElement asJson() {
      switch(null.$SwitchMap$com$newrelic$agent$android$harvest$type$Harvestable$Type[this.type.ordinal()]) {
      case 1:
         return this.asJsonObject();
      case 2:
         return this.asJsonArray();
      case 3:
         return this.asJsonPrimitive();
      default:
         return null;
      }
   }

   public JsonArray asJsonArray() {
      return null;
   }

   public JsonObject asJsonObject() {
      return null;
   }

   public JsonPrimitive asJsonPrimitive() {
      return null;
   }

   public Harvestable.Type getType() {
      return this.type;
   }

   protected void notEmpty(String var1) {
      if(var1 == null || var1.length() == 0) {
         throw new IllegalArgumentException("Missing Harvestable field.");
      }
   }

   protected void notNull(Object var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null field in Harvestable object");
      }
   }

   protected String optional(String var1) {
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }

   public String toJsonString() {
      return this.asJson().toString();
   }
}
