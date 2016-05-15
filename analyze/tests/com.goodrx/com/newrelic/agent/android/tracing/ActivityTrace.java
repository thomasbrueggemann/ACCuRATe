package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.activity.NamedActivity;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceType;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ActivityTrace extends HarvestableArray {
   private static final HashMap<String, String> ACTIVITY_HISTORY_TYPE = new HashMap() {
      {
         this.put("type", "ACTIVITY_HISTORY");
      }
   };
   private static final HashMap<String, String> ENVIRONMENT_TYPE = new HashMap() {
      {
         this.put("type", "ENVIRONMENT");
      }
   };
   public static final int MAX_TRACES = 2000;
   private static final String SIZE_NORMAL = "NORMAL";
   public static final String TRACE_VERSION = "1.0";
   private static final HashMap<String, String> VITALS_TYPE = new HashMap() {
      {
         this.put("type", "VITALS");
      }
   };
   private boolean complete = false;
   public long lastUpdatedAt;
   private final AgentLog log = AgentLogManager.getAgentLog();
   private NamedActivity measuredActivity;
   private final Set<UUID> missingChildren = Collections.synchronizedSet(new HashSet());
   public final Metric networkCountMetric = new Metric("Mobile/Activity/Network/<activity>/Count");
   public final Metric networkTimeMetric = new Metric("Mobile/Activity/Network/<activity>/Time");
   private final HashMap<String, String> params = new HashMap();
   public ActivitySighting previousActivity;
   private long reportAttemptCount = 0L;
   public Trace rootTrace;
   public long startedAt;
   private int traceCount = 0;
   private final ConcurrentHashMap<UUID, Trace> traces = new ConcurrentHashMap();
   private Map<Sample.SampleType, Collection<Sample>> vitals;

   public ActivityTrace() {
   }

   public ActivityTrace(Trace var1) {
      this.rootTrace = var1;
      this.lastUpdatedAt = var1.entryTimestamp;
      this.startedAt = this.lastUpdatedAt;
      this.params.put("traceVersion", "1.0");
      this.params.put("type", "ACTIVITY");
      this.measuredActivity = (NamedActivity)Measurements.startActivity(var1.displayName);
      this.measuredActivity.setStartTime(var1.entryTimestamp);
   }

   private JsonArray getEnvironment() {
      JsonArray var1 = new JsonArray();
      var1.add((new Gson()).toJsonTree(ENVIRONMENT_TYPE, GSON_STRING_MAP_TYPE));
      var1.addAll((new ConnectInformation(Agent.getApplicationInformation(), Agent.getDeviceInformation())).asJsonArray());
      HashMap var2 = new HashMap();
      var2.put("size", "NORMAL");
      var1.add((new Gson()).toJsonTree(var2, GSON_STRING_MAP_TYPE));
      return var1;
   }

   private JsonArray getPreviousActivityAsJson() {
      JsonArray var1 = new JsonArray();
      var1.add((new Gson()).toJsonTree(ACTIVITY_HISTORY_TYPE, GSON_STRING_MAP_TYPE));
      var1.addAll(this.previousActivity.asJsonArray());
      return var1;
   }

   private JsonArray getVitalsAsJson() {
      JsonArray var1 = new JsonArray();
      var1.add((new Gson()).toJsonTree(VITALS_TYPE, GSON_STRING_MAP_TYPE));
      JsonObject var2 = new JsonObject();
      if(this.vitals != null) {
         Iterator var3 = this.vitals.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            JsonArray var5 = new JsonArray();
            Iterator var6 = ((Collection)var4.getValue()).iterator();

            while(var6.hasNext()) {
               Sample var7 = (Sample)var6.next();
               if(var7.getTimestamp() <= this.lastUpdatedAt) {
                  var5.add(var7.asJsonArray());
               }
            }

            var2.add(((Sample.SampleType)var4.getKey()).toString(), var5);
         }
      }

      var1.add(var2);
      return var1;
   }

   private JsonArray traceToTree(Trace var1) {
      JsonArray var2 = new JsonArray();
      var1.prepareForSerialization();
      var2.add((new Gson()).toJsonTree(var1.getParams(), GSON_STRING_MAP_TYPE));
      var2.add(SafeJsonPrimitive.factory((Number)Long.valueOf(var1.entryTimestamp)));
      var2.add(SafeJsonPrimitive.factory((Number)Long.valueOf(var1.exitTimestamp)));
      var2.add(SafeJsonPrimitive.factory(var1.displayName));
      JsonArray var3 = new JsonArray();
      var3.add(SafeJsonPrimitive.factory((Number)Long.valueOf(var1.threadId)));
      var3.add(SafeJsonPrimitive.factory(var1.threadName));
      var2.add(var3);
      if(var1.getChildren().isEmpty()) {
         var2.add(new JsonArray());
         return var2;
      } else {
         JsonArray var4 = new JsonArray();
         Iterator var5 = var1.getChildren().iterator();

         while(var5.hasNext()) {
            UUID var6 = (UUID)var5.next();
            Trace var7 = (Trace)this.traces.get(var6);
            if(var7 != null) {
               var4.add(this.traceToTree(var7));
            }
         }

         var2.add(var4);
         return var2;
      }
   }

   public void addCompletedTrace(Trace var1) {
      if(var1.getType() == TraceType.NETWORK) {
         this.networkCountMetric.sample(1.0D);
         this.networkTimeMetric.sample((double)var1.getDurationAsSeconds());
      }

      var1.traceMachine = null;
      this.missingChildren.remove(var1.myUUID);
      if(this.traceCount > 2000) {
         this.log.verbose("Maximum trace limit reached, discarding trace " + var1.myUUID);
      } else {
         this.traces.put(var1.myUUID, var1);
         ++this.traceCount;
         if(var1.exitTimestamp > this.rootTrace.exitTimestamp) {
            this.rootTrace.exitTimestamp = var1.exitTimestamp;
         }

         if(this.log.getLevel() == 4) {
            this.log.verbose("Added trace " + var1.myUUID.toString() + " missing children: " + this.missingChildren.size());
         }

         this.lastUpdatedAt = System.currentTimeMillis();
      }
   }

   public void addTrace(Trace var1) {
      this.missingChildren.add(var1.myUUID);
      this.lastUpdatedAt = System.currentTimeMillis();
   }

   public JsonArray asJsonArray() {
      JsonArray var1 = new JsonArray();
      if(!this.complete) {
         this.log.verbose("Attempted to serialize trace " + this.rootTrace.myUUID.toString() + " but it has yet to be finalized");
         return null;
      } else {
         var1.add((new Gson()).toJsonTree(this.params, GSON_STRING_MAP_TYPE));
         var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.rootTrace.entryTimestamp)));
         var1.add(SafeJsonPrimitive.factory((Number)Long.valueOf(this.rootTrace.exitTimestamp)));
         var1.add(SafeJsonPrimitive.factory(this.rootTrace.displayName));
         JsonArray var2 = new JsonArray();
         var2.add(this.getEnvironment());
         var2.add(this.traceToTree(this.rootTrace));
         var2.add(this.getVitalsAsJson());
         if(this.previousActivity != null) {
            var2.add(this.getPreviousActivityAsJson());
         }

         var1.add(var2);
         return var1;
      }
   }

   public void complete() {
      this.log.debug("Completing trace of " + this.rootTrace.displayName + ":" + this.rootTrace.myUUID.toString() + "(" + this.traces.size() + " traces)");
      if(this.rootTrace.exitTimestamp == 0L) {
         this.rootTrace.exitTimestamp = System.currentTimeMillis();
      }

      if(this.traces.isEmpty()) {
         this.rootTrace.traceMachine = null;
         this.complete = true;
         Measurements.endActivityWithoutMeasurement(this.measuredActivity);
      } else {
         this.measuredActivity.setEndTime(this.rootTrace.exitTimestamp);
         Measurements.endActivity((MeasuredActivity)this.measuredActivity);
         this.rootTrace.traceMachine = null;
         this.complete = true;
         TaskQueue.queue(this);
      }
   }

   public void discard() {
      this.log.debug("Discarding trace of " + this.rootTrace.displayName + ":" + this.rootTrace.myUUID.toString() + "(" + this.traces.size() + " traces)");
      this.rootTrace.traceMachine = null;
      this.complete = true;
      Measurements.endActivityWithoutMeasurement(this.measuredActivity);
   }

   public String getActivityName() {
      String var1 = "<activity>";
      if(this.rootTrace != null) {
         var1 = this.rootTrace.displayName;
         if(var1 != null) {
            int var2 = var1.indexOf("#");
            if(var2 > 0) {
               var1 = var1.substring(0, var2);
            }
         }
      }

      return var1;
   }

   public String getId() {
      return this.rootTrace == null?null:this.rootTrace.myUUID.toString();
   }

   public long getLastUpdatedAt() {
      return this.lastUpdatedAt;
   }

   public long getReportAttemptCount() {
      return this.reportAttemptCount;
   }

   public Map<UUID, Trace> getTraces() {
      return this.traces;
   }

   public boolean hasMissingChildren() {
      return !this.missingChildren.isEmpty();
   }

   public void incrementReportAttemptCount() {
      ++this.reportAttemptCount;
   }

   public boolean isComplete() {
      return this.complete;
   }

   public void setLastUpdatedAt(long var1) {
      this.lastUpdatedAt = var1;
   }

   public void setVitals(Map<Sample.SampleType, Collection<Sample>> var1) {
      this.vitals = var1;
   }
}
