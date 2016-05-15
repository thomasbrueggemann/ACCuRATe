package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import com.newrelic.agent.android.activity.config.ActivityTraceConfigurationDeserializer;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.harvest.HarvestConnection;
import com.newrelic.agent.android.harvest.HarvestData;
import com.newrelic.agent.android.harvest.HarvestLifecycleAware;
import com.newrelic.agent.android.harvest.HarvestResponse;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.GsonBuilder;
import com.newrelic.com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Harvester {
   private AgentConfiguration agentConfiguration;
   private HarvestConfiguration configuration;
   private HarvestConnection harvestConnection;
   private HarvestData harvestData;
   private final Collection<HarvestLifecycleAware> harvestListeners;
   private final AgentLog log = AgentLogManager.getAgentLog();
   private Harvester.State state;
   protected boolean stateChanged;

   public Harvester() {
      this.state = Harvester.State.UNINITIALIZED;
      this.configuration = HarvestConfiguration.getDefaultHarvestConfiguration();
      this.harvestListeners = new ArrayList();
   }

   private void changeState(Harvester.State var1) {
      this.log.debug("Harvester changing state: " + this.state + " -> " + var1);
      if(this.state == Harvester.State.CONNECTED) {
         if(var1 == Harvester.State.DISCONNECTED) {
            this.fireOnHarvestDisconnected();
         } else if(var1 == Harvester.State.DISABLED) {
            this.fireOnHarvestDisabled();
         }
      }

      this.state = var1;
      this.stateChanged = true;
   }

   private void configureHarvester(HarvestConfiguration var1) {
      this.configuration.reconfigure(var1);
      this.harvestData.setDataToken(this.configuration.getDataToken());
      Harvest.setHarvestConfiguration(this.configuration);
   }

   private void fireOnHarvest() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestBefore() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestComplete() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestConnected() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestDisabled() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestDisconnected() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestError() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestFinalize() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestSendFailed() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestStart() {
      // $FF: Couldn't be decompiled
   }

   private void fireOnHarvestStop() {
      // $FF: Couldn't be decompiled
   }

   private Collection<HarvestLifecycleAware> getHarvestListeners() {
      return new ArrayList(this.harvestListeners);
   }

   private HarvestConfiguration parseHarvesterConfiguration(HarvestResponse var1) {
      GsonBuilder var2 = new GsonBuilder();
      var2.registerTypeAdapter(ActivityTraceConfiguration.class, new ActivityTraceConfigurationDeserializer());
      Gson var4 = var2.create();

      try {
         HarvestConfiguration var6 = (HarvestConfiguration)var4.fromJson(var1.getResponseBody(), HarvestConfiguration.class);
         return var6;
      } catch (JsonSyntaxException var7) {
         this.log.error("Unable to parse collector configuration: " + var7.getMessage());
         AgentHealth.noticeException((Exception)var7);
         return null;
      }
   }

   private boolean stateIn(Harvester.State var1, Harvester.State... var2) {
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1 == var2[var4]) {
            return true;
         }
      }

      return false;
   }

   public void addHarvestListener(HarvestLifecycleAware param1) {
      // $FF: Couldn't be decompiled
   }

   protected void connected() {
      this.log.info("Harvester: connected");
      this.log.info("Harvester: Sending " + this.harvestData.getHttpTransactions().count() + " HTTP transactions.");
      this.log.info("Harvester: Sending " + this.harvestData.getHttpErrors().count() + " HTTP errors.");
      this.log.info("Harvester: Sending " + this.harvestData.getActivityTraces().count() + " activity traces.");
      this.harvestData.setAnalyticsEnabled(this.agentConfiguration.getEnableAnalyticsEvents());
      if(this.agentConfiguration.getEnableAnalyticsEvents() && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents)) {
         EventManager var3 = AnalyticsControllerImpl.getInstance().getEventManager();
         if(var3.isTransmitRequired()) {
            HashSet var4 = new HashSet();
            var4.addAll(AnalyticsControllerImpl.getInstance().getSystemAttributes());
            var4.addAll(AnalyticsControllerImpl.getInstance().getUserAttributes());
            this.harvestData.setSessionAttributes(var4);
            this.log.info("Harvester: Sending " + this.harvestData.getSessionAttributes().size() + " session attributes.");
            Collection var7 = var3.getQueuedEvents();
            this.harvestData.setAnalyticsEvents(var7);
            var3.empty();
         }

         this.log.info("Harvester: Sending " + this.harvestData.getAnalyticsEvents().size() + " analytics events.");
      }

      HarvestResponse var1 = this.harvestConnection.sendData(this.harvestData);
      if(var1 != null && !var1.isUnknown()) {
         this.harvestData.reset();
         StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", var1.getResponseTime());
         this.log.debug("Harvest data response: " + var1.getResponseCode());
         this.log.debug("Harvest data response status code: " + var1.getStatusCode());
         this.log.debug("Harvest data response BODY: " + var1.getResponseBody());
         if(var1.isError()) {
            this.fireOnHarvestError();
            switch(null.$SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[var1.getResponseCode().ordinal()]) {
            case 1:
            case 2:
               this.harvestData.getDataToken().clear();
               this.transition(Harvester.State.DISCONNECTED);
               return;
            case 3:
               if(var1.isDisableCommand()) {
                  this.log.error("Collector has commanded Agent to disable.");
                  this.transition(Harvester.State.DISABLED);
                  return;
               }

               this.log.error("Unexpected Collector response: FORBIDDEN");
               this.transition(Harvester.State.DISCONNECTED);
               return;
            case 4:
            case 5:
               this.log.error("Invalid ConnectionInformation was sent to the Collector.");
               return;
            default:
               this.log.error("An unknown error occurred when connecting to the Collector.");
            }
         } else {
            HarvestConfiguration var2 = this.parseHarvesterConfiguration(var1);
            if(var2 == null) {
               this.log.error("Unable to configure Harvester using Collector configuration.");
            } else {
               this.configureHarvester(var2);
               this.fireOnHarvestComplete();
            }
         }
      } else {
         this.fireOnHarvestSendFailed();
      }
   }

   protected void disabled() {
      Harvest.stop();
      this.fireOnHarvestDisabled();
   }

   protected void disconnected() {
      if(this.configuration == null) {
         this.configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
      }

      if(this.harvestData.isValid()) {
         this.log.verbose("Skipping connect call, saved state is available: " + this.harvestData.getDataToken());
         StatsEngine.get().sample("Session/Start", 1.0F);
         this.fireOnHarvestConnected();
         this.transition(Harvester.State.CONNECTED);
         this.execute();
      } else {
         this.log.info("Connecting, saved state is not available: " + this.harvestData.getDataToken());
         HarvestResponse var1 = this.harvestConnection.sendConnect();
         if(var1 == null) {
            this.log.error("Unable to connect to the Collector.");
         } else if(var1.isOK()) {
            HarvestConfiguration var2 = this.parseHarvesterConfiguration(var1);
            if(var2 == null) {
               this.log.error("Unable to configure Harvester using Collector configuration.");
            } else {
               this.configureHarvester(var2);
               StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Harvest", var1.getResponseTime());
               this.fireOnHarvestConnected();
               this.transition(Harvester.State.CONNECTED);
            }
         } else {
            this.log.debug("Harvest connect response: " + var1.getResponseCode());
            switch(null.$SwitchMap$com$newrelic$agent$android$harvest$HarvestResponse$Code[var1.getResponseCode().ordinal()]) {
            case 1:
            case 2:
               this.harvestData.getDataToken().clear();
               this.fireOnHarvestDisconnected();
               return;
            case 3:
               if(var1.isDisableCommand()) {
                  this.log.error("Collector has commanded Agent to disable.");
                  this.fireOnHarvestDisabled();
                  this.transition(Harvester.State.DISABLED);
                  return;
               }

               this.log.error("Unexpected Collector response: FORBIDDEN");
               break;
            case 4:
            case 5:
               this.log.error("Invalid ConnectionInformation was sent to the Collector.");
               break;
            default:
               this.log.error("An unknown error occurred when connecting to the Collector.");
            }

            this.fireOnHarvestError();
         }
      }
   }

   protected void execute() {
      this.log.debug("Harvester state: " + this.state);
      this.stateChanged = false;

      try {
         this.expireHarvestData();
         switch(null.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[this.state.ordinal()]) {
         case 1:
            this.uninitialized();
            return;
         case 2:
            this.fireOnHarvestBefore();
            this.disconnected();
            return;
         case 3:
            this.fireOnHarvestBefore();
            this.fireOnHarvest();
            this.fireOnHarvestFinalize();
            TaskQueue.synchronousDequeue();
            this.connected();
            return;
         case 4:
            this.disabled();
            return;
         default:
            throw new IllegalStateException();
         }
      } catch (Exception var2) {
         this.log.error("Exception encountered while attempting to harvest", var2);
         AgentHealth.noticeException(var2);
      }
   }

   public void expireActivityTraces() {
      // $FF: Couldn't be decompiled
   }

   public void expireHarvestData() {
      this.expireHttpErrors();
      this.expireHttpTransactions();
      this.expireActivityTraces();
   }

   public void expireHttpErrors() {
      // $FF: Couldn't be decompiled
   }

   public void expireHttpTransactions() {
      // $FF: Couldn't be decompiled
   }

   public Harvester.State getCurrentState() {
      return this.state;
   }

   public HarvestConnection getHarvestConnection() {
      return this.harvestConnection;
   }

   public HarvestData getHarvestData() {
      return this.harvestData;
   }

   public boolean isDisabled() {
      return Harvester.State.DISABLED == this.state;
   }

   public void removeHarvestListener(HarvestLifecycleAware param1) {
      // $FF: Couldn't be decompiled
   }

   public void setAgentConfiguration(AgentConfiguration var1) {
      this.agentConfiguration = var1;
   }

   public void setConfiguration(HarvestConfiguration var1) {
      this.configuration = var1;
   }

   public void setHarvestConnection(HarvestConnection var1) {
      this.harvestConnection = var1;
   }

   public void setHarvestData(HarvestData var1) {
      this.harvestData = var1;
   }

   public void start() {
      this.fireOnHarvestStart();
   }

   public void stop() {
      this.fireOnHarvestStop();
   }

   protected void transition(Harvester.State var1) {
      if(this.stateChanged) {
         this.log.debug("Ignoring multiple transition: " + var1);
      } else if(this.state != var1) {
         switch(null.$SwitchMap$com$newrelic$agent$android$harvest$Harvester$State[this.state.ordinal()]) {
         case 1:
            Harvester.State[] var4 = new Harvester.State[]{Harvester.State.DISCONNECTED, var1, Harvester.State.CONNECTED, Harvester.State.DISABLED};
            if(!this.stateIn(var1, var4)) {
               throw new IllegalStateException();
            }
            break;
         case 2:
            Harvester.State[] var3 = new Harvester.State[]{Harvester.State.UNINITIALIZED, Harvester.State.CONNECTED, Harvester.State.DISABLED};
            if(!this.stateIn(var1, var3)) {
               throw new IllegalStateException();
            }
            break;
         case 3:
            Harvester.State[] var2 = new Harvester.State[]{Harvester.State.DISCONNECTED, Harvester.State.DISABLED};
            if(!this.stateIn(var1, var2)) {
               throw new IllegalStateException();
            }
            break;
         default:
            throw new IllegalStateException();
         }

         this.changeState(var1);
         return;
      }

   }

   protected void uninitialized() {
      if(this.agentConfiguration == null) {
         this.log.error("Agent configuration unavailable.");
      } else {
         if(Agent.getImpl().updateSavedConnectInformation()) {
            this.configureHarvester(HarvestConfiguration.getDefaultHarvestConfiguration());
            this.harvestData.getDataToken().clear();
         }

         Harvest.setHarvestConnectInformation(new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation()));
         this.harvestConnection.setApplicationToken(this.agentConfiguration.getApplicationToken());
         this.harvestConnection.setCollectorHost(this.agentConfiguration.getCollectorHost());
         this.harvestConnection.useSsl(this.agentConfiguration.useSsl());
         this.transition(Harvester.State.DISCONNECTED);
         this.execute();
      }
   }

   protected static enum State {
      CONNECTED,
      DISABLED,
      DISCONNECTED,
      UNINITIALIZED;

      static {
         Harvester.State[] var0 = new Harvester.State[]{UNINITIALIZED, DISCONNECTED, CONNECTED, DISABLED};
      }
   }
}
