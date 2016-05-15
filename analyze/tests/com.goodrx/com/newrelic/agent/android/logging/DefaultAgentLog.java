package com.newrelic.agent.android.logging;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.NullAgentLog;

public class DefaultAgentLog implements AgentLog {
   private AgentLog impl = new NullAgentLog();

   public void debug(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void error(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void error(String param1, Throwable param2) {
      // $FF: Couldn't be decompiled
   }

   public int getLevel() {
      // $FF: Couldn't be decompiled
   }

   public void info(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void setImpl(AgentLog param1) {
      // $FF: Couldn't be decompiled
   }

   public void setLevel(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void verbose(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void warning(String param1) {
      // $FF: Couldn't be decompiled
   }
}
