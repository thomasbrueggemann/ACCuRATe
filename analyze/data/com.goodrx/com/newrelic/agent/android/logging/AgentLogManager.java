package com.newrelic.agent.android.logging;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.DefaultAgentLog;

public class AgentLogManager {
   private static DefaultAgentLog instance = new DefaultAgentLog();

   public static AgentLog getAgentLog() {
      return instance;
   }

   public static void setAgentLog(AgentLog var0) {
      instance.setImpl(var0);
   }
}
