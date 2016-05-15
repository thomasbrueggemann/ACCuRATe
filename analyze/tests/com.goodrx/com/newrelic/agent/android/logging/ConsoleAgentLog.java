package com.newrelic.agent.android.logging;

import com.newrelic.agent.android.logging.AgentLog;

public class ConsoleAgentLog implements AgentLog {
   private int level = 3;

   private static void print(String var0, String var1) {
      System.out.println("[" + var0 + "] " + var1);
   }

   public void debug(String var1) {
      if(this.level == 5) {
         print("DEBUG", var1);
      }

   }

   public void error(String var1) {
      if(this.level >= 1) {
         print("ERROR", var1);
      }

   }

   public void error(String var1, Throwable var2) {
      if(this.level >= 1) {
         print("ERROR", var1 + " " + var2.getMessage());
      }

   }

   public int getLevel() {
      return this.level;
   }

   public void info(String var1) {
      if(this.level >= 3) {
         print("INFO", var1);
      }

   }

   public void setLevel(int var1) {
      this.level = var1;
   }

   public void verbose(String var1) {
      if(this.level >= 4) {
         print("VERBOSE", var1);
      }

   }

   public void warning(String var1) {
      if(this.level >= 2) {
         print("WARN", var1);
      }

   }
}
