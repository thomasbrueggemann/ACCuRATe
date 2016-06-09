package com.newrelic.agent.android;

import android.content.Context;
import android.text.TextUtils;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.NullAgentImpl;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.NetworkFailure;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class NewRelic {
   private static final String DEFAULT_COLLECTOR_ADDR = "mobile-collector.newrelic.com";
   private static final String UNKNOWN_HTTP_REQUEST_TYPE = "unknown";
   private static final AgentConfiguration agentConfiguration = new AgentConfiguration();
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private static boolean started = false;
   private int logLevel = 3;
   private boolean loggingEnabled = true;

   private NewRelic(String var1) {
      agentConfiguration.setApplicationToken(var1);
   }

   private static void _noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11, Map<String, String> var12, String var13) {
      checkEmpty(var0, "noticeHttpTransaction: url must not be empty.");
      checkEmpty(var1, "noticeHttpTransaction: httpMethod must not be empty.");

      try {
         new URL(var0);
      } catch (MalformedURLException var18) {
         throw new IllegalArgumentException("noticeHttpTransaction: URL is malformed: " + var0);
      }

      double var15 = (double)(var5 - var3);
      if(!checkNegative((int)var15, "noticeHttpTransaction: the startTimeMs is later than the endTimeMs, resulting in a negative total time.")) {
         TaskQueue.queue(new HttpTransactionMeasurement(var0, var1, var2, 0, var3, var15 / 1000.0D, var7, var9, var13));
         if((long)var2 >= 400L) {
            Measurements.addHttpError(var0, var1, var2, var11, var12);
         }
      }

   }

   private static void checkEmpty(String var0, String var1) {
      checkNull(var0, var1);
      if(var0.length() == 0) {
         throw new IllegalArgumentException(var1);
      }
   }

   private static boolean checkNegative(int var0, String var1) {
      if(var0 < 0) {
         log.error(var1);
         return true;
      } else {
         return false;
      }
   }

   private static void checkNull(Object var0, String var1) {
      if(var0 == null) {
         throw new IllegalArgumentException(var1);
      }
   }

   public static void crashNow() {
      crashNow("This is a demonstration crash courtesy of New Relic");
   }

   public static void crashNow(String var0) {
      throw new RuntimeException(var0);
   }

   public static String currentSessionId() {
      return agentConfiguration.getSessionID();
   }

   public static void disableFeature(FeatureFlag var0) {
      FeatureFlag.disableFeature(var0);
   }

   public static void enableFeature(FeatureFlag var0) {
      FeatureFlag.enableFeature(var0);
   }

   public static void endInteraction(String var0) {
      log.debug("NewRelic.endInteraction invoked. id: " + var0);
      TraceMachine.endTrace(var0);
   }

   public static void endMethodTrace() {
      log.debug("NewRelic.endMethodTrace invoked.");
      TraceMachine.exitMethod();
   }

   public static boolean incrementAttribute(String var0) {
      return AnalyticsControllerImpl.getInstance().incrementAttribute(var0, 1.0F);
   }

   public static boolean incrementAttribute(String var0, float var1) {
      return AnalyticsControllerImpl.getInstance().incrementAttribute(var0, var1);
   }

   private boolean isInstrumented() {
      return true;
   }

   public static boolean isStarted() {
      return started;
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8) {
      _noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, (String)null, (Map)null, (String)null);
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8, String var10) {
      _noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, var10, (Map)null, (String)null);
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8, String var10, Map<String, String> var11) {
      _noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, var10, var11, (String)null);
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8, String var10, Map<String, String> var11, String var12) {
      _noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, var10, var11, var12);
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8, String var10, Map<String, String> var11, URLConnection var12) {
      noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, var10, var11, var12);
   }

   @Deprecated
   public static void noticeHttpTransaction(String var0, int var1, long var2, long var4, long var6, long var8, String var10, Map<String, String> var11, HttpResponse var12) {
      noticeHttpTransaction(var0, "unknown", var1, var2, var4, var6, var8, var10, var11, var12);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9) {
      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, (String)null, (Map)null, (String)null);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11) {
      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, (Map)null, (String)null);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11, Map<String, String> var12) {
      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, (String)null);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11, Map<String, String> var12, String var13) {
      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, var13);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11, Map<String, String> var12, URLConnection var13) {
      if(var13 != null) {
         String var14 = var13.getHeaderField("X-NewRelic-ID");
         if(var14 != null && var14.length() > 0) {
            _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, var14);
            return;
         }
      }

      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, (String)null);
   }

   public static void noticeHttpTransaction(String var0, String var1, int var2, long var3, long var5, long var7, long var9, String var11, Map<String, String> var12, HttpResponse var13) {
      if(var13 != null) {
         Header var14 = var13.getFirstHeader("X-NewRelic-ID");
         if(var14 != null && var14.getValue() != null && var14.getValue().length() > 0) {
            _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, var14.getValue());
            return;
         }
      }

      _noticeHttpTransaction(var0, var1, var2, var3, var5, var7, var9, var11, var12, (String)null);
   }

   @Deprecated
   public static void noticeNetworkFailure(String var0, long var1, long var3, NetworkFailure var5) {
      noticeNetworkFailure(var0, "unknown", var1, var3, var5);
   }

   @Deprecated
   public static void noticeNetworkFailure(String var0, long var1, long var3, Exception var5) {
      noticeNetworkFailure(var0, "unknown", var1, var3, var5);
   }

   public static void noticeNetworkFailure(String var0, String var1, long var2, long var4, NetworkFailure var6) {
      noticeNetworkFailure(var0, var1, var2, var4, var6, "");
   }

   public static void noticeNetworkFailure(String var0, String var1, long var2, long var4, NetworkFailure var6, String var7) {
      float var8 = (float)(var4 - var2) / 1000.0F;
      TransactionState var9 = new TransactionState();
      TransactionStateUtil.inspectAndInstrument(var9, var0, var1);
      var9.setErrorCode(var6.getErrorCode());
      TransactionData var10 = var9.end();
      TreeMap var11 = new TreeMap();
      var11.put("content_length", "0");
      var11.put("content_type", "text/html");
      TaskQueue.queue(new HttpTransactionMeasurement(var10.getUrl(), var10.getHttpMethod(), var10.getStatusCode(), var10.getErrorCode(), var2, (double)var8, var10.getBytesSent(), var10.getBytesReceived(), var10.getAppData()));
      Measurements.addHttpError(var10.getUrl(), var10.getHttpMethod(), var10.getStatusCode(), var7, var11);
   }

   public static void noticeNetworkFailure(String var0, String var1, long var2, long var4, Exception var6) {
      checkEmpty(var0, "noticeHttpException: url must not be empty.");
      noticeNetworkFailure(var0, var1, var2, var4, NetworkFailure.exceptionToNetworkFailure(var6), var6.getMessage());
   }

   public static boolean recordEvent(String var0, Map<String, Object> var1) {
      return AnalyticsControllerImpl.getInstance().recordEvent(var0, var1);
   }

   public static void recordMetric(String var0, String var1) {
      recordMetric(var0, var1, 1.0D);
   }

   public static void recordMetric(String var0, String var1, double var2) {
      recordMetric(var0, var1, 1, var2, var2, (MetricUnit)null, (MetricUnit)null);
   }

   public static void recordMetric(String var0, String var1, int var2, double var3, double var5) {
      recordMetric(var0, var1, var2, var3, var5, (MetricUnit)null, (MetricUnit)null);
   }

   public static void recordMetric(String var0, String var1, int var2, double var3, double var5, MetricUnit var7, MetricUnit var8) {
      log.debug("NewRelic.recordMeric invoked for name " + var0 + ", category: " + var1 + ", count: " + var2 + ", totalValue " + var3 + ", exclusiveValue: " + var5 + ", countUnit: " + var7 + ", valueUnit: " + var8);
      checkNull(var1, "recordMetric: category must not be null. If no MetricCategory is applicable, use MetricCategory.NONE.");
      checkEmpty(var0, "recordMetric: name must not be empty.");
      if(!checkNegative(var2, "recordMetric: count must not be negative.")) {
         Measurements.addCustomMetric(var0, var1, var2, var3, var5, var7, var8);
      }

   }

   public static boolean removeAllAttributes() {
      return AnalyticsControllerImpl.getInstance().removeAllAttributes();
   }

   public static boolean removeAttribute(String var0) {
      return AnalyticsControllerImpl.getInstance().removeAttribute(var0);
   }

   public static boolean setAttribute(String var0, float var1) {
      return AnalyticsControllerImpl.getInstance().setAttribute(var0, var1);
   }

   public static boolean setAttribute(String var0, String var1) {
      return AnalyticsControllerImpl.getInstance().setAttribute(var0, var1);
   }

   public static boolean setAttribute(String var0, boolean var1) {
      return AnalyticsControllerImpl.getInstance().setAttribute(var0, var1);
   }

   public static void setInteractionName(String var0) {
      TraceMachine.setRootDisplayName(var0);
   }

   public static void setMaxEventBufferTime(int var0) {
      AnalyticsControllerImpl.getInstance().setMaxEventBufferTime(var0);
   }

   public static void setMaxEventPoolSize(int var0) {
      AnalyticsControllerImpl.getInstance().setMaxEventPoolSize(var0);
   }

   @Deprecated
   public static void shutdown() {
      StatsEngine.get().inc("Supportability/AgentHealth/Deprecated/Shutdown");
      if(started) {
         try {
            Agent.getImpl().stop();
         } finally {
            Agent.setImpl(NullAgentImpl.instance);
            started = false;
         }
      }

   }

   @Deprecated
   public static String startInteraction(Context var0, String var1) {
      checkNull(var0, "startInteraction: context must be an Activity instance.");
      checkNull(var1, "startInteraction: actionName must be an action/method name.");
      TraceMachine.startTracing(var0.getClass().getSimpleName() + "#" + var1.replace("/", "."), false, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));

      try {
         String var3 = TraceMachine.getActivityTrace().getId();
         return var3;
      } catch (TracingInactiveException var4) {
         return null;
      }
   }

   @Deprecated
   public static String startInteraction(Context var0, String var1, boolean var2) {
      if(TraceMachine.isTracingActive() && !var2) {
         log.warning("startInteraction: An interaction is already being traced, and invalidateActiveTrace is false. This interaction will not be traced.");
         return null;
      } else {
         return startInteraction(var0, var1);
      }
   }

   public static String startInteraction(String var0) {
      checkNull(var0, "startInteraction: actionName must be an action/method name.");
      log.debug("NewRelic.startInteraction invoked. actionName: " + var0);
      TraceMachine.startTracing(var0.replace("/", "."), true, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));

      try {
         String var2 = TraceMachine.getActivityTrace().getId();
         return var2;
      } catch (TracingInactiveException var3) {
         return null;
      }
   }

   public static void startMethodTrace(String var0) {
      checkNull(var0, "startMethodTrace: actionName must be an action/method name.");
      TraceMachine.enterMethod(var0);
   }

   public static NewRelic withApplicationToken(String var0) {
      return new NewRelic(var0);
   }

   public void start(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public NewRelic usingCollectorAddress(String var1) {
      agentConfiguration.setCollectorHost(var1);
      return this;
   }

   public NewRelic usingCrashCollectorAddress(String var1) {
      agentConfiguration.setCrashCollectorHost(var1);
      return this;
   }

   public NewRelic usingSsl(boolean var1) {
      agentConfiguration.setUseSsl(var1);
      return this;
   }

   public NewRelic withAnalyticsEvents(boolean var1) {
      if(var1) {
         enableFeature(FeatureFlag.AnalyticsEvents);
         return this;
      } else {
         disableFeature(FeatureFlag.AnalyticsEvents);
         return this;
      }
   }

   public NewRelic withApplicationBuild(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         agentConfiguration.setCustomBuildIdentifier(var1);
      }

      return this;
   }

   public NewRelic withApplicationVersion(String var1) {
      if(var1 != null) {
         agentConfiguration.setCustomApplicationVersion(var1);
      }

      return this;
   }

   @Deprecated
   public NewRelic withBuildIdentifier(String var1) {
      StatsEngine.get().inc("Supportability/AgentHealth/Deprecated/WithBuildIdentifier");
      return this.withApplicationBuild(var1);
   }

   public NewRelic withCrashReportingEnabled(boolean var1) {
      agentConfiguration.setReportCrashes(var1);
      if(var1) {
         enableFeature(FeatureFlag.CrashReporting);
         return this;
      } else {
         disableFeature(FeatureFlag.CrashReporting);
         return this;
      }
   }

   public NewRelic withHttpResponseBodyCaptureEnabled(boolean var1) {
      if(var1) {
         enableFeature(FeatureFlag.HttpResponseBodyCapture);
         return this;
      } else {
         disableFeature(FeatureFlag.HttpResponseBodyCapture);
         return this;
      }
   }

   public NewRelic withInteractionTracing(boolean var1) {
      if(var1) {
         enableFeature(FeatureFlag.InteractionTracing);
         return this;
      } else {
         disableFeature(FeatureFlag.InteractionTracing);
         return this;
      }
   }

   public NewRelic withLocationServiceEnabled(boolean var1) {
      agentConfiguration.setUseLocationService(var1);
      return this;
   }

   public NewRelic withLogLevel(int var1) {
      this.logLevel = var1;
      return this;
   }

   public NewRelic withLoggingEnabled(boolean var1) {
      this.loggingEnabled = var1;
      return this;
   }
}
