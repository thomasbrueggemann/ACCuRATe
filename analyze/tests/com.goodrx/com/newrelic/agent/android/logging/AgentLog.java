package com.newrelic.agent.android.logging;

public interface AgentLog {
   int DEBUG = 5;
   int ERROR = 1;
   int INFO = 3;
   int VERBOSE = 4;
   int WARNING = 2;

   void debug(String var1);

   void error(String var1);

   void error(String var1, Throwable var2);

   int getLevel();

   void info(String var1);

   void setLevel(int var1);

   void verbose(String var1);

   void warning(String var1);
}
