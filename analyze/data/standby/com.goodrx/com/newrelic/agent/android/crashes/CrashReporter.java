package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.crashes.CrashStore;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrashReporter {
   private static final String CRASH_COLLECTOR_PATH = "/mobile_crash";
   private static final int CRASH_COLLECTOR_TIMEOUT = 5000;
   private static AgentConfiguration agentConfiguration;
   private static ExecutorService executor;
   protected static final AtomicBoolean initialized = new AtomicBoolean(false);
   protected static CrashReporter instance = new CrashReporter();
   private CrashStore crashStore;
   protected boolean isEnabled = false;
   private final AgentLog log = AgentLogManager.getAgentLog();
   private java.lang.Thread.UncaughtExceptionHandler previousExceptionHandler;
   private boolean reportCrashes = true;

   // $FF: synthetic method
   static AgentConfiguration access$100() {
      return agentConfiguration;
   }

   // $FF: synthetic method
   static CrashStore access$200(CrashReporter var0) {
      return var0.crashStore;
   }

   // $FF: synthetic method
   static ExecutorService access$300() {
      return executor;
   }

   public static void clear() {
      instance.crashStore.clear();
   }

   public static List<Crash> fetchAllCrashes() {
      return instance.crashStore.fetchAll();
   }

   public static AgentConfiguration getAgentConfiguration() {
      return agentConfiguration;
   }

   public static CrashReporter.UncaughtExceptionHandler getInstanceHandler() {
      return instance.getHandler();
   }

   public static int getStoredCrashCount() {
      return instance.crashStore.count();
   }

   public static void initialize(AgentConfiguration var0) {
      if(initialized.compareAndSet(false, true)) {
         executor = Executors.newCachedThreadPool(new NamedThreadFactory("CrashUploader"));
         agentConfiguration = var0;
         instance.isEnabled = agentConfiguration.getReportCrashes();
         instance.crashStore = agentConfiguration.getCrashStore();
         instance.reportSavedCrashes();
         instance.reportSupportabilityMetrics();
         if(instance.isEnabled) {
            instance.installCrashHandler();
            return;
         }
      }

   }

   private void installCrashHandler() {
      java.lang.Thread.UncaughtExceptionHandler var1 = Thread.getDefaultUncaughtExceptionHandler();
      if(var1 != null) {
         if(var1 instanceof CrashReporter.UncaughtExceptionHandler) {
            this.log.debug("New Relic crash handler already installed.");
            return;
         }

         this.previousExceptionHandler = var1;
         this.log.debug("Installing New Relic crash handler and chaining " + this.previousExceptionHandler.getClass().getName() + ".");
      } else {
         this.log.debug("Installing New Relic crash handler.");
      }

      Thread.setDefaultUncaughtExceptionHandler(new CrashReporter.UncaughtExceptionHandler());
   }

   public static void setReportCrashes(boolean var0) {
      instance.reportCrashes = var0;
   }

   public CrashReporter.UncaughtExceptionHandler getHandler() {
      return new CrashReporter.UncaughtExceptionHandler();
   }

   protected void recordFailedUpload(String var1) {
      this.log.error(var1);
      StatsEngine.get().inc("Supportability/AgentHealth/Crash/FailedUpload");
   }

   protected Future<?> reportCrash(Crash var1) {
      boolean var2 = this.reportCrashes;
      Future var3 = null;
      if(var2) {
         CrashReporter.CrashSender var4 = new CrashReporter.CrashSender(var1);
         var3 = executor.submit(var4);
      }

      return var3;
   }

   protected void reportSavedCrashes() {
      Iterator var1 = this.crashStore.fetchAll().iterator();

      while(var1.hasNext()) {
         this.reportCrash((Crash)var1.next());
      }

   }

   protected void reportSupportabilityMetrics() {
   }

   protected void storeSupportabilityMetrics() {
      StatsEngine.get().getStatsMap();
   }

   private class CrashSender implements Runnable {
      private final Crash crash;

      CrashSender(Crash var2) {
         this.crash = var2;
      }

      private boolean requestWasSuccessful(HttpURLConnection var1) throws IOException {
         switch(var1.getResponseCode()) {
         case 200:
            return true;
         default:
            return false;
         }
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }

   public class UncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
      private final AtomicBoolean handledException = new AtomicBoolean(false);

      private void chainExceptionHandler(Thread var1, Throwable var2) {
         if(CrashReporter.this.previousExceptionHandler != null) {
            CrashReporter.this.log.debug("Chaining crash reporting duties to " + CrashReporter.this.previousExceptionHandler.getClass().getSimpleName());
            CrashReporter.this.previousExceptionHandler.uncaughtException(var1, var2);
         }

      }

      public void uncaughtException(Thread param1, Throwable param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
