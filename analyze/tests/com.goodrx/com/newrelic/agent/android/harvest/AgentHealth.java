package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.AgentHealthExceptions;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import java.text.MessageFormat;

public class AgentHealth extends HarvestableArray {
   public static final String DEFAULT_KEY = "Exception";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   protected final AgentHealthExceptions agentHealthExceptions = new AgentHealthExceptions();

   public static void noticeException(AgentHealthException var0) {
      noticeException(var0, "Exception");
   }

   public static void noticeException(AgentHealthException var0, String var1) {
      if(var0 != null) {
         StatsEngine var2 = StatsEngine.get();
         if(var2 != null) {
            if(var1 == null) {
               log.warning("Passed metric key is null. Defaulting to Exception");
            }

            Object[] var3 = new Object[4];
            if(var1 == null) {
               var1 = "Exception";
            }

            var3[0] = var1;
            var3[1] = var0.getSourceClass();
            var3[2] = var0.getSourceMethod();
            var3[3] = var0.getExceptionClass();
            var2.inc(MessageFormat.format("Supportability/AgentHealth/{0}/{1}/{2}/{3}", var3));
            TaskQueue.queue(var0);
         } else {
            log.error("StatsEngine is null. Exception not recorded.");
         }
      } else {
         log.error("AgentHealthException is null. StatsEngine not updated");
      }
   }

   public static void noticeException(Exception var0) {
      AgentHealthException var1 = null;
      if(var0 != null) {
         var1 = new AgentHealthException(var0);
      }

      noticeException(var1);
   }

   public void addException(AgentHealthException var1) {
      this.agentHealthExceptions.add(var1);
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      if(!this.agentHealthExceptions.isEmpty()) {
         var1.add(this.agentHealthExceptions.asJsonObject());
      }

      return var1;
   }

   public void clear() {
      this.agentHealthExceptions.clear();
   }
}
