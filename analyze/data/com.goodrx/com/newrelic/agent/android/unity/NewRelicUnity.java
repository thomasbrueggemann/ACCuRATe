package com.newrelic.agent.android.unity;

import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.crashes.CrashReporter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.unity.UnityEvent;
import com.newrelic.agent.android.unity.UnityException;
import com.newrelic.agent.android.util.NetworkFailure;
import java.lang.Thread.UncaughtExceptionHandler;

public class NewRelicUnity {
   private static final String ROOT_TRACE_NAME = "Unity";
   private static final AgentLog log = AgentLogManager.getAgentLog();

   static void handleUnityCrash(UnityException var0) {
      UncaughtExceptionHandler var1 = Thread.getDefaultUncaughtExceptionHandler();
      if(var1 != null && var1 instanceof CrashReporter.UncaughtExceptionHandler) {
         var1.uncaughtException(Thread.currentThread(), var0);
      }

   }

   static void noticeNetworkFailure(String var0, String var1, long var2, long var4, int var6, String var7) {
      NewRelic.noticeNetworkFailure(var0, var1, var2, var4, NetworkFailure.fromErrorCode(var6), var7);
   }

   static boolean recordEvent(UnityEvent var0) {
      return NewRelic.recordEvent(var0.getName(), var0.getAttributes());
   }
}
