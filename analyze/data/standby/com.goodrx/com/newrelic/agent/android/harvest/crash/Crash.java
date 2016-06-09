package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.crashes.CrashReporter;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.harvest.crash.DeviceInfo;
import com.newrelic.agent.android.harvest.crash.ExceptionInfo;
import com.newrelic.agent.android.harvest.crash.ThreadInfo;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.agent.android.util.Util;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonParser;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Crash extends HarvestableObject {
   public static final int PROTOCOL_VERSION = 1;
   private ActivityHistory activityHistory;
   private boolean analyticsEnabled;
   private final String appToken;
   private ApplicationInfo applicationInfo;
   private final String buildId;
   private DeviceInfo deviceInfo;
   private Collection<AnalyticsEvent> events;
   private ExceptionInfo exceptionInfo;
   private Set<AnalyticAttribute> sessionAttributes;
   private List<ThreadInfo> threads;
   private final long timestamp;
   private final UUID uuid;

   public Crash(Throwable var1) {
      this(var1, new HashSet(), new HashSet(), false);
   }

   public Crash(Throwable var1, Set<AnalyticAttribute> var2, Collection<AnalyticsEvent> var3, boolean var4) {
      AgentImpl var5 = Agent.getImpl();
      Throwable var6 = getRootCause(var1);
      this.uuid = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
      this.buildId = getBuildId();
      this.timestamp = System.currentTimeMillis() / 1000L;
      this.appToken = CrashReporter.getAgentConfiguration().getApplicationToken();
      this.deviceInfo = new DeviceInfo(var5.getDeviceInformation(), var5.getEnvironmentInformation());
      this.applicationInfo = new ApplicationInfo(var5.getApplicationInformation());
      this.exceptionInfo = new ExceptionInfo(var6);
      this.threads = ThreadInfo.extractThreads(var6);
      this.activityHistory = TraceMachine.getActivityHistory();
      this.sessionAttributes = var2;
      this.events = var3;
      this.analyticsEnabled = var4;
   }

   public Crash(UUID var1, String var2, long var3) {
      AgentImpl var5 = Agent.getImpl();
      this.uuid = var1;
      this.buildId = var2;
      this.timestamp = var3;
      this.appToken = CrashReporter.getAgentConfiguration().getApplicationToken();
      this.deviceInfo = new DeviceInfo(var5.getDeviceInformation(), var5.getEnvironmentInformation());
      this.applicationInfo = new ApplicationInfo(var5.getApplicationInformation());
      this.exceptionInfo = new ExceptionInfo();
      this.threads = new ArrayList();
      this.activityHistory = new ActivityHistory(new ArrayList());
      this.sessionAttributes = new HashSet();
      this.events = new HashSet();
      this.analyticsEnabled = false;
   }

   public static Crash crashFromJsonString(String var0) {
      JsonObject var1 = (new JsonParser()).parse(var0).getAsJsonObject();
      String var2 = var1.get("uuid").getAsString();
      String var3 = var1.get("buildId").getAsString();
      long var4 = var1.get("timestamp").getAsLong();
      Crash var6 = new Crash(UUID.fromString(var2), var3, var4);
      var6.deviceInfo = DeviceInfo.newFromJson(var1.get("deviceInfo").getAsJsonObject());
      var6.applicationInfo = ApplicationInfo.newFromJson(var1.get("appInfo").getAsJsonObject());
      var6.exceptionInfo = ExceptionInfo.newFromJson(var1.get("exception").getAsJsonObject());
      var6.threads = ThreadInfo.newListFromJson(var1.get("threads").getAsJsonArray());
      var6.activityHistory = ActivityHistory.newFromJson(var1.get("activityHistory").getAsJsonArray());
      boolean var7;
      if(!var1.has("sessionAttributes") && !var1.has("analyticsEvents")) {
         var7 = false;
      } else {
         var7 = true;
      }

      var6.analyticsEnabled = var7;
      if(var1.has("sessionAttributes")) {
         var6.setSessionAttributes(AnalyticAttribute.newFromJson(var1.get("sessionAttributes").getAsJsonObject()));
      }

      if(var1.has("analyticsEvents")) {
         var6.setAnalyticsEvents(AnalyticsEvent.newFromJson(var1.get("analyticsEvents").getAsJsonArray()));
      }

      return var6;
   }

   public static String getBuildId() {
      return "ae476de5-f37d-4fd9-a524-181fc4b4ec9a";
   }

   protected static Throwable getRootCause(Throwable var0) {
      if(var0 != null) {
         Throwable var1 = var0.getCause();
         return var1 == null?var0:getRootCause(var1);
      } else {
         return new Throwable("Unknown cause");
      }
   }

   public JsonObject asJsonObject() {
      JsonObject var1 = new JsonObject();
      var1.add("protocolVersion", new JsonPrimitive(Integer.valueOf(1)));
      var1.add("platform", new JsonPrimitive("Android"));
      var1.add("uuid", SafeJsonPrimitive.factory(this.uuid.toString()));
      var1.add("buildId", SafeJsonPrimitive.factory(this.buildId));
      var1.add("timestamp", SafeJsonPrimitive.factory((Number)Long.valueOf(this.timestamp)));
      var1.add("appToken", SafeJsonPrimitive.factory(this.appToken));
      var1.add("deviceInfo", this.deviceInfo.asJsonObject());
      var1.add("appInfo", this.applicationInfo.asJsonObject());
      var1.add("exception", this.exceptionInfo.asJsonObject());
      var1.add("threads", this.getThreadsAsJson());
      var1.add("activityHistory", this.activityHistory.asJsonArrayWithoutDuration());
      if(this.analyticsEnabled && FeatureFlag.featureEnabled(FeatureFlag.AnalyticsEvents)) {
         JsonObject var3 = new JsonObject();
         if(this.sessionAttributes != null) {
            Iterator var6 = this.sessionAttributes.iterator();

            while(var6.hasNext()) {
               AnalyticAttribute var7 = (AnalyticAttribute)var6.next();
               var3.add(var7.getName(), var7.asJsonElement());
            }
         }

         var1.add("sessionAttributes", var3);
         JsonArray var4 = new JsonArray();
         if(this.events != null) {
            Iterator var5 = this.events.iterator();

            while(var5.hasNext()) {
               var4.add(((AnalyticsEvent)var5.next()).asJsonObject());
            }
         }

         var1.add("analyticsEvents", var4);
      }

      DataToken var2 = Harvest.getHarvestConfiguration().getDataToken();
      if(var2 != null) {
         var1.add("dataToken", var2.asJsonArray());
      }

      return var1;
   }

   public ExceptionInfo getExceptionInfo() {
      return this.exceptionInfo;
   }

   protected JsonArray getThreadsAsJson() {
      JsonArray var1 = new JsonArray();
      if(this.threads != null) {
         Iterator var2 = this.threads.iterator();

         while(var2.hasNext()) {
            var1.add(((ThreadInfo)var2.next()).asJsonObject());
         }
      }

      return var1;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public void setAnalyticsEvents(Collection<AnalyticsEvent> var1) {
      this.events = var1;
   }

   public void setSessionAttributes(Set<AnalyticAttribute> var1) {
      this.sessionAttributes = var1;
   }
}
