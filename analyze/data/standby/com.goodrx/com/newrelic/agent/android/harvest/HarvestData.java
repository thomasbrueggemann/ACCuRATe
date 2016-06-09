package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.harvest.ActivityTraces;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HttpErrors;
import com.newrelic.agent.android.harvest.HttpTransactions;
import com.newrelic.agent.android.harvest.MachineMeasurements;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HarvestData extends HarvestableArray {
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private ActivityTraces activityTraces = new ActivityTraces();
   private AgentHealth agentHealth = new AgentHealth();
   private boolean analyticsEnabled = false;
   private Collection<AnalyticsEvent> analyticsEvents = new HashSet();
   private DataToken dataToken = new DataToken();
   private DeviceInformation deviceInformation = Agent.getDeviceInformation();
   private double harvestTimeDelta;
   private HttpErrors httpErrors = new HttpErrors();
   private HttpTransactions httpTransactions = new HttpTransactions();
   private MachineMeasurements machineMeasurements = new MachineMeasurements();
   private Set<AnalyticAttribute> sessionAttributes = new HashSet();

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      var1.add(this.dataToken.asJson());
      var1.add(this.deviceInformation.asJson());
      var1.add(new JsonPrimitive(Double.valueOf(this.harvestTimeDelta)));
      var1.add(this.httpTransactions.asJson());
      var1.add(this.machineMeasurements.asJson());
      var1.add(this.httpErrors.asJson());
      JsonElement var2 = this.activityTraces.asJson();
      String var3 = var2.toString();
      if(var3.length() < Harvest.getHarvestConfiguration().getActivity_trace_max_size()) {
         var1.add(var2);
      } else {
         StatsEngine.get().sample("Supportability/AgentHealth/BigActivityTracesDropped", (float)var3.length());
      }

      var1.add(this.agentHealth.asJson());
      if(this.analyticsEnabled) {
         JsonObject var4 = new JsonObject();
         Iterator var5 = this.sessionAttributes.iterator();

         while(var5.hasNext()) {
            AnalyticAttribute var8 = (AnalyticAttribute)var5.next();
            switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[var8.getAttributeDataType().ordinal()]) {
            case 1:
               var4.addProperty(var8.getName(), var8.getStringValue());
               break;
            case 2:
               var4.addProperty(var8.getName(), (Number)Float.valueOf(var8.getFloatValue()));
               break;
            case 3:
               var4.addProperty(var8.getName(), Boolean.valueOf(var8.getBooleanValue()));
            }
         }

         var1.add(var4);
         JsonArray var6 = new JsonArray();
         Iterator var7 = this.analyticsEvents.iterator();

         while(var7.hasNext()) {
            var6.add(((AnalyticsEvent)var7.next()).asJsonObject());
         }

         var1.add(var6);
      }

      return var1;
   }

   public ActivityTraces getActivityTraces() {
      return this.activityTraces;
   }

   public AgentHealth getAgentHealth() {
      return this.agentHealth;
   }

   public Collection<AnalyticsEvent> getAnalyticsEvents() {
      return this.analyticsEvents;
   }

   public DataToken getDataToken() {
      return this.dataToken;
   }

   public DeviceInformation getDeviceInformation() {
      return this.deviceInformation;
   }

   public HttpErrors getHttpErrors() {
      return this.httpErrors;
   }

   public HttpTransactions getHttpTransactions() {
      return this.httpTransactions;
   }

   public MachineMeasurements getMetrics() {
      return this.machineMeasurements;
   }

   public Set<AnalyticAttribute> getSessionAttributes() {
      return this.sessionAttributes;
   }

   public boolean isAnalyticsEnabled() {
      return this.analyticsEnabled;
   }

   public boolean isValid() {
      return this.dataToken.isValid();
   }

   public void reset() {
      this.httpErrors.clear();
      this.httpTransactions.clear();
      this.activityTraces.clear();
      this.machineMeasurements.clear();
      this.agentHealth.clear();
      this.sessionAttributes.clear();
      this.analyticsEvents.clear();
   }

   public void setActivityTraces(ActivityTraces var1) {
      this.activityTraces = var1;
   }

   public void setAnalyticsEnabled(boolean var1) {
      this.analyticsEnabled = var1;
   }

   public void setAnalyticsEvents(Collection<AnalyticsEvent> var1) {
      this.analyticsEvents = new HashSet(var1);
   }

   public void setDataToken(DataToken var1) {
      if(var1 != null) {
         this.dataToken = var1;
      }
   }

   public void setDeviceInformation(DeviceInformation var1) {
      this.deviceInformation = var1;
   }

   public void setHarvestTimeDelta(double var1) {
      this.harvestTimeDelta = var1;
   }

   public void setHttpErrors(HttpErrors var1) {
      this.httpErrors = var1;
   }

   public void setHttpTransactions(HttpTransactions var1) {
      this.httpTransactions = var1;
   }

   public void setMachineMeasurements(MachineMeasurements var1) {
      this.machineMeasurements = var1;
   }

   public void setSessionAttributes(Set<AnalyticAttribute> var1) {
      log.debug("HarvestData.setSessionAttributes invoked with attribute set " + var1);
      this.sessionAttributes = new HashSet(var1);
   }

   public String toString() {
      return "HarvestData{\n\tdataToken=" + this.dataToken + ", \n\tdeviceInformation=" + this.deviceInformation + ", \n\tharvestTimeDelta=" + this.harvestTimeDelta + ", \n\thttpTransactions=" + this.httpTransactions + ", \n\tmachineMeasurements=" + this.machineMeasurements + ", \n\thttpErrors=" + this.httpErrors + ", \n\tactivityTraces=" + this.activityTraces + ", \n\tsessionAttributes=" + this.sessionAttributes + ", \n\tanalyticAttributes=" + this.analyticsEvents + '}';
   }
}
