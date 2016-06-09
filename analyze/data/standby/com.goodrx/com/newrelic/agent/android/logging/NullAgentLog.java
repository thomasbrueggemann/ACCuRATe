package com.newrelic.agent.android.logging;

import com.newrelic.agent.android.logging.AgentLog;

public class NullAgentLog implements AgentLog {
   public void debug(String var1) {
   }

   public void error(String var1) {
   }

   public void error(String var1, Throwable var2) {
   }

   public int getLevel() {
      return 5;
   }

   public void info(String var1) {
   }

   public void setLevel(int var1) {
   }

   public void verbose(String var1) {
   }

   public void warning(String var1) {
   }
}
