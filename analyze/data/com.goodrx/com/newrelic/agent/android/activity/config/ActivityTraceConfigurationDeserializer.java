package com.newrelic.agent.android.activity.config;

import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonDeserializationContext;
import com.newrelic.com.google.gson.JsonDeserializer;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonParseException;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

public class ActivityTraceConfigurationDeserializer implements JsonDeserializer<ActivityTraceConfiguration> {
   private final AgentLog log = AgentLogManager.getAgentLog();

   private void error(String var1) {
      this.log.error("ActivityTraceConfigurationDeserializer: " + var1);
   }

   private Integer getInteger(JsonElement var1) {
      if(!var1.isJsonPrimitive()) {
         this.error("Expected an integer.");
         return null;
      } else {
         JsonPrimitive var2 = var1.getAsJsonPrimitive();
         if(!var2.isNumber()) {
            this.error("Expected an integer.");
            return null;
         } else {
            int var3 = var2.getAsInt();
            if(var3 < 0) {
               this.error("Integer value must not be negative");
               return null;
            } else {
               return Integer.valueOf(var3);
            }
         }
      }
   }

   public ActivityTraceConfiguration deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      ActivityTraceConfiguration var4 = new ActivityTraceConfiguration();
      if(!var1.isJsonArray()) {
         this.error("Expected root element to be an array.");
         return null;
      } else {
         JsonArray var5 = var1.getAsJsonArray();
         if(var5.size() != 2) {
            this.error("Root array must contain 2 elements.");
            return null;
         } else {
            Integer var6 = this.getInteger(var5.get(0));
            if(var6 == null) {
               return null;
            } else if(var6.intValue() < 0) {
               this.error("The first element of the root array must not be negative.");
               return null;
            } else {
               var4.setMaxTotalTraceCount(var6.intValue());
               return var4;
            }
         }
      }
   }
}
