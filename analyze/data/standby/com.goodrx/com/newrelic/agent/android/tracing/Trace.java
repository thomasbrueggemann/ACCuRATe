package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TraceType;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Trace {
   private static final String CATEGORY_PARAMETER = "category";
   private static final AgentLog log = AgentLogManager.getAgentLog();
   public long childExclusiveTime = 0L;
   private volatile Set<UUID> children;
   public String displayName;
   public long entryTimestamp = 0L;
   public long exclusiveTime = 0L;
   public long exitTimestamp = 0L;
   private boolean isComplete;
   public String metricBackgroundName;
   public String metricName;
   public final UUID myUUID = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
   private volatile Map<String, Object> params;
   public final UUID parentUUID;
   private List<String> rawAnnotationParams;
   public String scope;
   public long threadId = 0L;
   public String threadName = "main";
   public TraceMachine traceMachine;
   private TraceType type;

   public Trace() {
      this.type = TraceType.TRACE;
      this.isComplete = false;
      this.parentUUID = null;
   }

   public Trace(String var1, UUID var2, TraceMachine var3) {
      this.type = TraceType.TRACE;
      this.isComplete = false;
      this.displayName = var1;
      this.parentUUID = var2;
      this.traceMachine = var3;
   }

   private static Object createParameter(String var0, String var1, String var2) {
      Class var4;
      try {
         var4 = Class.forName(var1);
      } catch (ClassNotFoundException var5) {
         log.error("Unable to resolve parameter class in enterMethod: " + var5.getMessage(), var5);
         return null;
      }

      if(MetricCategory.class == var4) {
         var2 = MetricCategory.valueOf((String)var2);
      } else if(String.class != var4) {
         return null;
      }

      return var2;
   }

   public void addChild(Trace param1) {
      // $FF: Couldn't be decompiled
   }

   public void complete() throws TracingInactiveException {
      if(this.isComplete) {
         log.warning("Attempted to double complete trace " + this.myUUID.toString());
      } else {
         if(this.exitTimestamp == 0L) {
            this.exitTimestamp = System.currentTimeMillis();
         }

         this.exclusiveTime = this.getDurationAsMilliseconds() - this.childExclusiveTime;
         this.isComplete = true;

         try {
            this.traceMachine.storeCompletedTrace(this);
         } catch (NullPointerException var2) {
            throw new TracingInactiveException();
         }
      }
   }

   public Map<String, Object> getAnnotationParams() {
      HashMap var1 = new HashMap();
      if(this.rawAnnotationParams != null && this.rawAnnotationParams.size() > 0) {
         Iterator var2 = this.rawAnnotationParams.iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            Object var4 = createParameter(var3, (String)var2.next(), (String)var2.next());
            if(var4 != null) {
               var1.put(var3, var4);
            }
         }
      }

      return var1;
   }

   public MetricCategory getCategory() {
      if(!this.getAnnotationParams().containsKey("category")) {
         return null;
      } else {
         Object var1 = this.getAnnotationParams().get("category");
         if(!(var1 instanceof MetricCategory)) {
            log.error("Category annotation parameter is not of type MetricCategory");
            return null;
         } else {
            return (MetricCategory)var1;
         }
      }
   }

   public Set<UUID> getChildren() {
      // $FF: Couldn't be decompiled
   }

   public long getDurationAsMilliseconds() {
      return this.exitTimestamp - this.entryTimestamp;
   }

   public float getDurationAsSeconds() {
      return (float)(this.exitTimestamp - this.entryTimestamp) / 1000.0F;
   }

   public Map<String, Object> getParams() {
      // $FF: Couldn't be decompiled
   }

   public TraceType getType() {
      return this.type;
   }

   public boolean isComplete() {
      return this.isComplete;
   }

   public void prepareForSerialization() {
      this.getParams().put("type", this.type.toString());
   }

   public void setAnnotationParams(List<String> var1) {
      this.rawAnnotationParams = var1;
   }

   public void setType(TraceType var1) {
      this.type = var1;
   }
}
