package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.SessionEvent;
import com.newrelic.agent.android.harvest.ActivityTraces;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.harvest.HarvestConnection;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.HarvestDataValidator;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.harvest.HarvestTimer;
import com.newrelic.agent.android.harvest.HarvestableCache;
import com.newrelic.agent.android.harvest.Harvester;
import com.newrelic.agent.android.harvest.HttpError;
import com.newrelic.agent.android.harvest.HttpErrors;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.harvest.HttpTransactions;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class Harvest {
   private static final boolean DISABLE_ACTIVITY_TRACE_LIMITS_FOR_DEBUGGING;
   public static final long INVALID_SESSION_DURATION;
   private static final HarvestableCache activityTraceCache = new HarvestableCache();
   protected static Harvest instance = new Harvest();
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private static final Collection<HarvestLifecycleAware> unregisteredLifecycleListeners = new ArrayList();
   private HarvestConfiguration configuration = HarvestConfiguration.getDefaultHarvestConfiguration();
   private HarvestConnection harvestConnection;
   protected HarvestData harvestData;
   private HarvestDataValidator harvestDataValidator;
   private HarvestTimer harvestTimer;
   private Harvester harvester;

   public static void addActivityTrace(ActivityTrace var0) {
      if(!isDisabled()) {
         if(!isInitialized()) {
            activityTraceCache.add(var0);
         } else if(var0.rootTrace == null) {
            log.error("Activity trace is lacking a root trace!");
         } else if(var0.rootTrace.childExclusiveTime == 0L) {
            log.error("Total trace exclusive time is zero. Ignoring trace " + var0.rootTrace.displayName);
         } else {
            double var1 = (double)var0.rootTrace.childExclusiveTime / 1000.0D;
            if(var1 < instance.getConfiguration().getActivity_trace_min_utilization()) {
               StatsEngine.get().inc("Supportability/AgentHealth/IgnoredTraces");
               log.debug("Total trace exclusive time is too low (" + var1 + "). Ignoring trace " + var0.rootTrace.displayName);
            } else {
               ActivityTraces var3 = instance.getHarvestData().getActivityTraces();
               ActivityTraceConfiguration var4 = instance.getActivityTraceConfiguration();
               instance.getHarvester().expireActivityTraces();
               if(var3.count() >= var4.getMaxTotalTraceCount()) {
                  log.debug("Activity trace limit of " + var4.getMaxTotalTraceCount() + " exceeded. Ignoring trace: " + var0.toJsonString());
               } else {
                  log.debug("Adding activity trace: " + var0.toJsonString());
                  var3.add(var0);
               }
            }
         }
      }
   }

   public static void addAgentHealthException(AgentHealthException var0) {
      if(!isDisabled() && isInitialized()) {
         instance.getHarvestData().getAgentHealth().addException(var0);
      }
   }

   public static void addHarvestListener(HarvestLifecycleAware var0) {
      if(var0 == null) {
         log.error("Harvest: Argument to addHarvestListener cannot be null.");
      } else {
         if(isInitialized()) {
            instance.getHarvester().addHarvestListener(var0);
            return;
         }

         if(!isUnregisteredListener(var0)) {
            addUnregisteredListener(var0);
            return;
         }
      }

   }

   public static void addHttpError(HttpError var0) {
      if(instance.shouldCollectNetworkErrors() && !isDisabled()) {
         HttpErrors var1 = instance.getHarvestData().getHttpErrors();
         instance.getHarvester().expireHttpErrors();
         int var2 = instance.getConfiguration().getError_limit();
         if(var1.count() >= var2) {
            StatsEngine.get().inc("Supportability/AgentHealth/ErrorsDropped");
            log.debug("Maximum number of HTTP errors (" + var2 + ") reached. HTTP Error dropped.");
         } else {
            var1.addHttpError(var0);
            log.verbose("Harvest: " + instance + " now contains " + var1.count() + " errors.");
         }
      }
   }

   public static void addHttpTransaction(HttpTransaction var0) {
      if(!isDisabled()) {
         HttpTransactions var1 = instance.getHarvestData().getHttpTransactions();
         instance.getHarvester().expireHttpTransactions();
         int var2 = instance.getConfiguration().getReport_max_transaction_count();
         if(var1.count() >= var2) {
            StatsEngine.get().inc("Supportability/AgentHealth/TransactionsDropped");
            log.debug("Maximum number of transactions (" + var2 + ") reached. HTTP Transaction dropped.");
         } else {
            var1.add(var0);
         }
      }
   }

   public static void addMetric(Metric var0) {
      if(!isDisabled() && isInitialized()) {
         instance.getHarvestData().getMetrics().addMetric(var0);
      }
   }

   private static void addUnregisteredListener(HarvestLifecycleAware param0) {
      // $FF: Couldn't be decompiled
   }

   private void flushActivityTraceCache() {
      Iterator var1 = activityTraceCache.flush().iterator();

      while(var1.hasNext()) {
         addActivityTrace((ActivityTrace)((Harvestable)var1.next()));
      }

   }

   private void flushHarvestableCaches() {
      try {
         this.flushActivityTraceCache();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public static int getActivityTraceCacheSize() {
      return activityTraceCache.getSize();
   }

   public static HarvestConfiguration getHarvestConfiguration() {
      return !isInitialized()?HarvestConfiguration.getDefaultHarvestConfiguration():instance.getConfiguration();
   }

   public static Harvest getInstance() {
      return instance;
   }

   public static long getMillisSinceStart() {
      long var0 = 0L;
      Harvest var2 = getInstance();
      if(var2 != null && var2.getHarvestTimer() != null) {
         var0 = var2.getHarvestTimer().timeSinceStart();
         if(var0 < 0L) {
            var0 = 0L;
         }
      }

      return var0;
   }

   public static void harvestNow() {
      if(isInitialized()) {
         long var0 = getMillisSinceStart();
         if(var0 == 0L) {
            log.error("Session duration is invalid!");
            StatsEngine.get().inc("Supportability/AgentHealth/Session/InvalidDuration");
         }

         StatsEngine.get().sampleTimeMs("Session/Duration", var0);
         log.debug("Harvest.harvestNow - Generating sessionDuration attribute with value " + var0);
         AnalyticsControllerImpl var2 = AnalyticsControllerImpl.getInstance();
         var2.setAttribute("sessionDuration", (float)var0, false);
         log.debug("Harvest.harvestNow - Generating session event.");
         var2.addEvent(new SessionEvent());
         var2.getEventManager().shutdown();
         instance.getHarvestTimer().tickNow();
      }
   }

   public static void initialize(AgentConfiguration var0) {
      instance.initializeHarvester(var0);
      registerUnregisteredListeners();
      addHarvestListener(StatsEngine.get());
   }

   public static boolean isDisabled() {
      return !isInitialized()?false:instance.getHarvester().isDisabled();
   }

   public static boolean isInitialized() {
      return instance != null && instance.getHarvester() != null;
   }

   private static boolean isUnregisteredListener(HarvestLifecycleAware var0) {
      return var0 == null?false:unregisteredLifecycleListeners.contains(var0);
   }

   private static void registerUnregisteredListeners() {
      Iterator var0 = unregisteredLifecycleListeners.iterator();

      while(var0.hasNext()) {
         addHarvestListener((HarvestLifecycleAware)var0.next());
      }

      unregisteredLifecycleListeners.clear();
   }

   public static void removeHarvestListener(HarvestLifecycleAware var0) {
      if(var0 == null) {
         log.error("Harvest: Argument to removeHarvestListener cannot be null.");
      } else {
         if(isInitialized()) {
            instance.getHarvester().removeHarvestListener(var0);
            return;
         }

         if(isUnregisteredListener(var0)) {
            removeUnregisteredListener(var0);
            return;
         }
      }

   }

   private static void removeUnregisteredListener(HarvestLifecycleAware param0) {
      // $FF: Couldn't be decompiled
   }

   public static void setHarvestConfiguration(HarvestConfiguration var0) {
      if(!isInitialized()) {
         log.error("Cannot configure Harvester before initialization.");
         (new Exception()).printStackTrace();
      } else {
         log.debug("Harvest Configuration: " + var0);
         instance.setConfiguration(var0);
      }
   }

   public static void setHarvestConnectInformation(ConnectInformation var0) {
      if(!isInitialized()) {
         log.error("Cannot configure Harvester before initialization.");
         (new Exception()).printStackTrace();
      } else {
         log.debug("Setting Harvest connect information: " + var0);
         instance.setConnectInformation(var0);
      }
   }

   public static void setInstance(Harvest var0) {
      if(var0 == null) {
         log.error("Attempt to set Harvest instance to null value!");
      } else {
         instance = var0;
      }
   }

   public static void setPeriod(long var0) {
      instance.getHarvestTimer().setPeriod(var0);
   }

   public static boolean shouldCollectActivityTraces() {
      boolean var0 = true;
      if(isDisabled()) {
         var0 = false;
      } else if(isInitialized()) {
         ActivityTraceConfiguration var1 = instance.getActivityTraceConfiguration();
         if(var1 != null && var1.getMaxTotalTraceCount() <= 0) {
            return false;
         }
      }

      return var0;
   }

   public static void shutdown() {
      if(isInitialized()) {
         stop();
         instance.shutdownHarvester();
      }
   }

   public static void start() {
      instance.getHarvestTimer().start();
   }

   public static void stop() {
      instance.getHarvestTimer().stop();
   }

   public void createHarvester() {
      this.harvestConnection = new HarvestConnection();
      this.harvestData = new HarvestData();
      this.harvester = new Harvester();
      this.harvester.setHarvestConnection(this.harvestConnection);
      this.harvester.setHarvestData(this.harvestData);
      this.harvestTimer = new HarvestTimer(this.harvester);
      this.harvestDataValidator = new HarvestDataValidator();
      addHarvestListener(this.harvestDataValidator);
   }

   protected ActivityTraceConfiguration getActivityTraceConfiguration() {
      return this.configuration.getAt_capture();
   }

   public HarvestConfiguration getConfiguration() {
      return this.configuration;
   }

   public HarvestConnection getHarvestConnection() {
      return this.harvestConnection;
   }

   public HarvestData getHarvestData() {
      return this.harvestData;
   }

   protected HarvestTimer getHarvestTimer() {
      return this.harvestTimer;
   }

   protected Harvester getHarvester() {
      return this.harvester;
   }

   public void initializeHarvester(AgentConfiguration var1) {
      this.createHarvester();
      this.harvester.setAgentConfiguration(var1);
      this.harvester.setConfiguration(instance.getConfiguration());
      this.flushHarvestableCaches();
   }

   public void setConfiguration(HarvestConfiguration var1) {
      this.configuration.reconfigure(var1);
      this.harvestTimer.setPeriod(TimeUnit.MILLISECONDS.convert((long)this.configuration.getData_report_period(), TimeUnit.SECONDS));
      this.harvestConnection.setServerTimestamp(this.configuration.getServer_timestamp());
      this.harvestData.setDataToken(this.configuration.getDataToken());
      this.harvester.setConfiguration(this.configuration);
   }

   public void setConnectInformation(ConnectInformation var1) {
      this.harvestConnection.setConnectInformation(var1);
      this.harvestData.setDeviceInformation(var1.getDeviceInformation());
   }

   public void setHarvestConnection(HarvestConnection var1) {
      this.harvestConnection = var1;
   }

   public boolean shouldCollectNetworkErrors() {
      return this.configuration.isCollect_network_errors();
   }

   public void shutdownHarvester() {
      this.harvestTimer.shutdown();
      this.harvestTimer = null;
      this.harvester = null;
      this.harvestConnection = null;
      this.harvestData = null;
   }
}
