package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AgentHealthExceptions extends HarvestableObject {
   private static final JsonArray keyArray = new JsonArray();
   private final Map<String, AgentHealthException> agentHealthExceptions = new ConcurrentHashMap();

   public AgentHealthExceptions() {
      keyArray.add(new JsonPrimitive("ExceptionClass"));
      keyArray.add(new JsonPrimitive("Message"));
      keyArray.add(new JsonPrimitive("ThreadName"));
      keyArray.add(new JsonPrimitive("CallStack"));
      keyArray.add(new JsonPrimitive("Count"));
      keyArray.add(new JsonPrimitive("Extras"));
   }

   public void add(AgentHealthException param1) {
      // $FF: Couldn't be decompiled
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();
      Iterator var3 = this.agentHealthExceptions.values().iterator();

      while(var3.hasNext()) {
         var2.add(((AgentHealthException)var3.next()).asJsonArray());
      }

      var1.add("Type", new JsonPrimitive("AgentErrors"));
      var1.add("Keys", keyArray);
      var1.add("Data", var2);
      return var1;
   }

   public void clear() {
      // $FF: Couldn't be decompiled
   }

   public Map<String, AgentHealthException> getAgentHealthExceptions() {
      return this.agentHealthExceptions;
   }

   public final String getKey(AgentHealthException var1) {
      String var2 = this.getClass().getName();
      if(var1 != null) {
         var2 = var1.getExceptionClass() + var1.getStackTrace()[0].toString();
      }

      return var2;
   }

   public boolean isEmpty() {
      return this.agentHealthExceptions.isEmpty();
   }
}
