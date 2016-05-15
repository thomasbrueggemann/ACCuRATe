package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceType;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TraceMachine extends HarvestAdapter {
   public static final String ACTIVITY_BACKGROUND_METRIC_PREFIX = "Mobile/Activity/Background/Name/";
   public static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Name/";
   public static final String ACTIVTY_DISPLAY_NAME_PREFIX = "Display ";
   public static final int HEALTHY_TRACE_TIMEOUT = 500;
   public static final String NR_TRACE_FIELD = "_nr_trace";
   public static final String NR_TRACE_TYPE = "Lcom/newrelic/agent/android/tracing/Trace;";
   public static final int UNHEALTHY_TRACE_TIMEOUT = 60000;
   private static final List<ActivitySighting> activityHistory = new CopyOnWriteArrayList();
   public static final AtomicBoolean enabled = new AtomicBoolean(true);
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private static final ThreadLocal<Trace> threadLocalTrace = new ThreadLocal();
   private static final ThreadLocal<TraceMachine.TraceStack> threadLocalTraceStack = new ThreadLocal();
   private static final Collection<TraceLifecycleAware> traceListeners = new CopyOnWriteArrayList();
   private static TraceMachine traceMachine = null;
   private static TraceMachineInterface traceMachineInterface;
   private ActivityTrace activityTrace;

   protected TraceMachine(Trace var1) {
      this.activityTrace = new ActivityTrace(var1);
      Harvest.addHarvestListener(this);
   }

   public static void addTraceListener(TraceLifecycleAware var0) {
      traceListeners.add(var0);
   }

   public static void clearActivityHistory() {
      activityHistory.clear();
   }

   public static void endLastActivitySighting() {
      ActivitySighting var0 = getLastActivitySighting();
      if(var0 != null) {
         var0.end(System.currentTimeMillis());
      }

   }

   public static void endTrace() {
      traceMachine.completeActivityTrace();
   }

   public static void endTrace(String var0) {
      try {
         if(getActivityTrace().rootTrace.myUUID.toString().equals(var0)) {
            traceMachine.completeActivityTrace();
         }

      } catch (TracingInactiveException var2) {
         ;
      }
   }

   public static void enterMethod(Trace param0, String param1, ArrayList<String> param2) {
      // $FF: Couldn't be decompiled
   }

   public static void enterMethod(String var0) {
      enterMethod((Trace)null, var0, (ArrayList)null);
   }

   public static void enterMethod(String var0, ArrayList<String> var1) {
      enterMethod((Trace)null, var0, var1);
   }

   public static void enterNetworkSegment(String var0) {
      try {
         if(!isTracingInactive()) {
            if(getCurrentTrace().getType() == TraceType.NETWORK) {
               exitMethod();
            }

            enterMethod((Trace)null, var0, (ArrayList)null);
            getCurrentTrace().setType(TraceType.NETWORK);
         }
      } catch (TracingInactiveException var3) {
         ;
      } catch (Exception var4) {
         log.error("Caught error while calling enterNetworkSegment()", var4);
         AgentHealth.noticeException(var4);
      }
   }

   public static void exitMethod() {
      // $FF: Couldn't be decompiled
   }

   public static String formatActivityBackgroundMetricName(String var0) {
      return "Mobile/Activity/Background/Name/" + var0;
   }

   public static String formatActivityDisplayName(String var0) {
      return "Display " + var0;
   }

   public static String formatActivityMetricName(String var0) {
      return "Mobile/Activity/Name/" + var0;
   }

   public static ActivityHistory getActivityHistory() {
      return new ActivityHistory(activityHistory);
   }

   public static ActivityTrace getActivityTrace() throws TracingInactiveException {
      try {
         ActivityTrace var1 = traceMachine.activityTrace;
         return var1;
      } catch (NullPointerException var2) {
         throw new TracingInactiveException();
      }
   }

   public static String getCurrentScope() {
      try {
         if(isTracingInactive()) {
            return null;
         } else if(traceMachineInterface != null && !traceMachineInterface.isUIThread()) {
            String var1 = traceMachine.activityTrace.rootTrace.metricBackgroundName;
            return var1;
         } else {
            return traceMachine.activityTrace.rootTrace.metricName;
         }
      } catch (Exception var2) {
         log.error("Caught error while calling getCurrentScope()", var2);
         AgentHealth.noticeException(var2);
         return null;
      }
   }

   public static Trace getCurrentTrace() throws TracingInactiveException {
      if(isTracingInactive()) {
         throw new TracingInactiveException();
      } else {
         Trace var0 = (Trace)threadLocalTrace.get();
         return var0 != null?var0:getRootTrace();
      }
   }

   public static Map<String, Object> getCurrentTraceParams() throws TracingInactiveException {
      return getCurrentTrace().getParams();
   }

   public static ActivitySighting getLastActivitySighting() {
      return activityHistory.isEmpty()?null:(ActivitySighting)activityHistory.get(-1 + activityHistory.size());
   }

   public static Trace getRootTrace() throws TracingInactiveException {
      try {
         Trace var1 = traceMachine.activityTrace.rootTrace;
         return var1;
      } catch (NullPointerException var2) {
         throw new TracingInactiveException();
      }
   }

   public static TraceMachine getTraceMachine() {
      return traceMachine;
   }

   public static void haltTracing() {
      if(!isTracingInactive()) {
         TraceMachine var0 = traceMachine;
         traceMachine = null;
         var0.activityTrace.discard();
         endLastActivitySighting();
         Harvest.removeHarvestListener(var0);
         threadLocalTrace.remove();
         threadLocalTraceStack.remove();
      }
   }

   protected static boolean isEnabled() {
      return enabled.get() && FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing);
   }

   public static boolean isTracingActive() {
      return traceMachine != null;
   }

   public static boolean isTracingInactive() {
      return !isTracingActive();
   }

   private static void loadTraceContext(Trace var0) {
      if(!isTracingInactive()) {
         if(threadLocalTrace.get() == null) {
            threadLocalTrace.set(var0);
            threadLocalTraceStack.set(new TraceMachine.TraceStack());
            if(var0 == null) {
               return;
            }

            ((TraceMachine.TraceStack)threadLocalTraceStack.get()).push(var0);
         } else if(var0 == null) {
            if(((TraceMachine.TraceStack)threadLocalTraceStack.get()).isEmpty()) {
               if(log.getLevel() == 5) {
                  log.debug("No context to load!");
               }

               threadLocalTrace.set((Object)null);
               return;
            }

            var0 = (Trace)((TraceMachine.TraceStack)threadLocalTraceStack.get()).peek();
            threadLocalTrace.set(var0);
         }

         if(log.getLevel() == 4) {
            log.verbose("Trace " + var0.myUUID.toString() + " is now active");
            return;
         }
      }

   }

   private static void pushTraceContext(Trace var0) {
      if(!isTracingInactive() && var0 != null) {
         TraceMachine.TraceStack var1 = (TraceMachine.TraceStack)threadLocalTraceStack.get();
         if(var1.empty()) {
            var1.push(var0);
         } else if(var1.peek() != var0) {
            var1.push(var0);
         }

         threadLocalTrace.set(var0);
      }
   }

   private static Trace registerNewTrace(String var0) throws TracingInactiveException {
      if(isTracingInactive()) {
         log.debug("Tried to register a new trace but tracing is inactive!");
         throw new TracingInactiveException();
      } else {
         Trace var1 = getCurrentTrace();
         Trace var2 = new Trace(var0, var1.myUUID, traceMachine);

         try {
            traceMachine.activityTrace.addTrace(var2);
         } catch (Exception var4) {
            throw new TracingInactiveException();
         }

         if(log.getLevel() == 4) {
            log.verbose("Registering trace of " + var0 + " with parent " + var1.displayName);
         }

         var1.addChild(var2);
         return var2;
      }
   }

   public static void removeTraceListener(TraceLifecycleAware var0) {
      traceListeners.remove(var0);
   }

   private static void renameActivityHistory(String var0, String var1) {
      Iterator var2 = activityHistory.iterator();

      while(var2.hasNext()) {
         ActivitySighting var3 = (ActivitySighting)var2.next();
         if(var3.getName().equals(var0)) {
            var3.setName(var1);
         }
      }

   }

   public static void setCurrentDisplayName(String var0) {
      if(!isTracingInactive()) {
         try {
            getCurrentTrace().displayName = var0;
         } catch (TracingInactiveException var2) {
            ;
         }
      }
   }

   public static void setCurrentTraceParam(String var0, Object var1) {
      if(!isTracingInactive()) {
         try {
            getCurrentTrace().getParams().put(var0, var1);
         } catch (TracingInactiveException var3) {
            ;
         }
      }
   }

   public static void setRootDisplayName(String var0) {
      if(!isTracingInactive()) {
         try {
            Trace var2 = getRootTrace();
            Measurements.renameActivity(var2.displayName, var0);
            renameActivityHistory(var2.displayName, var0);
            var2.metricName = formatActivityMetricName(var0);
            var2.metricBackgroundName = formatActivityBackgroundMetricName(var0);
            var2.displayName = var0;
            getCurrentTrace().scope = getCurrentScope();
         } catch (TracingInactiveException var3) {
            ;
         }
      }
   }

   public static void setTraceMachineInterface(TraceMachineInterface var0) {
      traceMachineInterface = var0;
   }

   public static void startTracing(String var0) {
      startTracing(var0, false);
   }

   public static void startTracing(String var0, boolean var1) {
      startTracing(var0, false, false);
   }

   public static void startTracing(String param0, boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public static void unloadTraceContext(Object var0) {
      try {
         if(isTracingInactive()) {
            return;
         }

         if(traceMachineInterface == null || !traceMachineInterface.isUIThread()) {
            if(threadLocalTrace.get() != null && log.getLevel() == 4) {
               log.verbose("Trace " + ((Trace)threadLocalTrace.get()).myUUID.toString() + " is now inactive");
            }

            threadLocalTrace.remove();
            threadLocalTraceStack.remove();

            try {
               ((TraceFieldInterface)var0)._nr_setTrace((Trace)null);
               return;
            } catch (ClassCastException var3) {
               ExceptionHelper.recordSupportabilityMetric(var3, "TraceFieldInterface");
               log.error("Not a TraceFieldInterface: " + var3.getMessage());
               return;
            }
         }
      } catch (Exception var4) {
         log.error("Caught error while calling unloadTraceContext()", var4);
         AgentHealth.noticeException(var4);
      }

   }

   protected void completeActivityTrace() {
      if(!isTracingInactive()) {
         TraceMachine var1 = traceMachine;
         traceMachine = null;
         var1.activityTrace.complete();
         endLastActivitySighting();
         Iterator var2 = traceListeners.iterator();

         while(var2.hasNext()) {
            ((TraceLifecycleAware)var2.next()).onTraceComplete(var1.activityTrace);
         }

         Harvest.removeHarvestListener(var1);
      }
   }

   public void onHarvestBefore() {
      if(!isTracingActive()) {
         log.debug("TraceMachine is inactive");
      } else {
         long var1 = System.currentTimeMillis();
         long var3 = traceMachine.activityTrace.lastUpdatedAt;
         long var5 = traceMachine.activityTrace.startedAt;
         if(500L + var3 < var1 && !traceMachine.activityTrace.hasMissingChildren()) {
            log.debug("Completing activity trace after hitting healthy timeout (500ms)");
            this.completeActivityTrace();
            StatsEngine.get().inc("Supportability/AgentHealth/HealthyActivityTraces");
         } else if(60000L + var5 < var1) {
            log.debug("Completing activity trace after hitting unhealthy timeout (60000ms)");
            this.completeActivityTrace();
            StatsEngine.get().inc("Supportability/AgentHealth/UnhealthyActivityTraces");
            return;
         }

      }
   }

   public void onHarvestSendFailed() {
      try {
         traceMachine.activityTrace.incrementReportAttemptCount();
      } catch (NullPointerException var2) {
         ;
      }
   }

   public void storeCompletedTrace(Trace var1) {
      try {
         if(isTracingInactive()) {
            log.debug("Attempted to store a completed trace with no trace machine!");
         } else {
            this.activityTrace.addCompletedTrace(var1);
         }
      } catch (Exception var3) {
         log.error("Caught error while calling storeCompletedTrace()", var3);
         AgentHealth.noticeException(var3);
      }
   }

   private static class TraceStack extends Stack<Trace> {
      private TraceStack() {
      }

      // $FF: synthetic method
      TraceStack(Object var1) {
         this();
      }
   }
}
