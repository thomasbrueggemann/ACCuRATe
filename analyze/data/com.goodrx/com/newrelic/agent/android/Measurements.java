package com.newrelic.agent.android;

import com.newrelic.agent.android.MeasurementEngine;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.activity.MeasuredActivity;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.ThreadInfo;
import com.newrelic.agent.android.measurement.consumer.ActivityMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.CustomMetricConsumer;
import com.newrelic.agent.android.measurement.consumer.HttpErrorHarvestingConsumer;
import com.newrelic.agent.android.measurement.consumer.HttpTransactionHarvestingConsumer;
import com.newrelic.agent.android.measurement.consumer.MeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.MethodMeasurementConsumer;
import com.newrelic.agent.android.measurement.consumer.SummaryMetricMeasurementConsumer;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.measurement.producer.ActivityMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.CustomMetricProducer;
import com.newrelic.agent.android.measurement.producer.HttpErrorMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MeasurementProducer;
import com.newrelic.agent.android.measurement.producer.MethodMeasurementProducer;
import com.newrelic.agent.android.measurement.producer.NetworkMeasurementProducer;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.tracing.Trace;
import java.util.Map;

public class Measurements {
   private static final ActivityMeasurementConsumer activityConsumer = new ActivityMeasurementConsumer();
   private static final ActivityMeasurementProducer activityMeasurementProducer = new ActivityMeasurementProducer();
   private static boolean broadcastNewMeasurements = true;
   private static final CustomMetricConsumer customMetricConsumer = new CustomMetricConsumer();
   private static final CustomMetricProducer customMetricProducer = new CustomMetricProducer();
   private static final HttpErrorHarvestingConsumer httpErrorHarvester = new HttpErrorHarvestingConsumer();
   private static final HttpErrorMeasurementProducer httpErrorMeasurementProducer = new HttpErrorMeasurementProducer();
   private static final HttpTransactionHarvestingConsumer httpTransactionHarvester = new HttpTransactionHarvestingConsumer();
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private static final MeasurementEngine measurementEngine = new MeasurementEngine();
   private static final MethodMeasurementConsumer methodMeasurementConsumer = new MethodMeasurementConsumer();
   private static final MethodMeasurementProducer methodMeasurementProducer = new MethodMeasurementProducer();
   private static final NetworkMeasurementProducer networkMeasurementProducer = new NetworkMeasurementProducer();
   private static final SummaryMetricMeasurementConsumer summaryMetricMeasurementConsumer = new SummaryMetricMeasurementConsumer();

   public static void addCustomMetric(String var0, String var1, int var2, double var3, double var5) {
      if(!Harvest.isDisabled()) {
         customMetricProducer.produceMeasurement(var0, var1, var2, var3, var5);
         newMeasurementBroadcast();
      }
   }

   public static void addCustomMetric(String var0, String var1, int var2, double var3, double var5, MetricUnit var7, MetricUnit var8) {
      if(!Harvest.isDisabled()) {
         customMetricProducer.produceMeasurement(var0, var1, var2, var3, var5, var7, var8);
         newMeasurementBroadcast();
      }
   }

   public static void addHttpError(TransactionData var0, String var1, Map<String, String> var2) {
      if(var0 == null) {
         log.error("TransactionData is null. HttpError measurement not created.");
      } else {
         addHttpError(var0.getUrl(), var0.getHttpMethod(), var0.getStatusCode(), var1, var2);
      }
   }

   public static void addHttpError(String var0, String var1, int var2) {
      if(!Harvest.isDisabled()) {
         httpErrorMeasurementProducer.produceMeasurement(var0, var1, var2);
         newMeasurementBroadcast();
      }
   }

   public static void addHttpError(String var0, String var1, int var2, String var3) {
      if(!Harvest.isDisabled()) {
         httpErrorMeasurementProducer.produceMeasurement(var0, var1, var2, var3);
         newMeasurementBroadcast();
      }
   }

   public static void addHttpError(String var0, String var1, int var2, String var3, Map<String, String> var4) {
      if(!Harvest.isDisabled()) {
         httpErrorMeasurementProducer.produceMeasurement(var0, var1, var2, var3, var4);
         newMeasurementBroadcast();
      }
   }

   public static void addHttpError(String var0, String var1, int var2, String var3, Map<String, String> var4, ThreadInfo var5) {
      if(!Harvest.isDisabled()) {
         httpErrorMeasurementProducer.produceMeasurement(var0, var1, var2, var3, var4, var5);
         newMeasurementBroadcast();
      }
   }

   public static void addHttpTransaction(HttpTransactionMeasurement var0) {
      if(!Harvest.isDisabled()) {
         if(var0 == null) {
            log.error("TransactionMeasurement is null. HttpTransactionMeasurement measurement not created.");
         } else {
            networkMeasurementProducer.produceMeasurement(var0);
            newMeasurementBroadcast();
         }
      }
   }

   public static void addMeasurementConsumer(MeasurementConsumer var0) {
      measurementEngine.addMeasurementConsumer(var0);
   }

   public static void addMeasurementProducer(MeasurementProducer var0) {
      measurementEngine.addMeasurementProducer(var0);
   }

   public static void addTracedMethod(Trace var0) {
      if(!Harvest.isDisabled()) {
         methodMeasurementProducer.produceMeasurement(var0);
         newMeasurementBroadcast();
      }
   }

   public static void broadcast() {
      measurementEngine.broadcastMeasurements();
   }

   public static void endActivity(MeasuredActivity var0) {
      if(!Harvest.isDisabled()) {
         measurementEngine.endActivity(var0);
         activityMeasurementProducer.produceMeasurement(var0);
         newMeasurementBroadcast();
      }
   }

   public static void endActivity(String var0) {
      if(!Harvest.isDisabled()) {
         MeasuredActivity var1 = measurementEngine.endActivity(var0);
         activityMeasurementProducer.produceMeasurement(var1);
         newMeasurementBroadcast();
      }
   }

   public static void endActivityWithoutMeasurement(MeasuredActivity var0) {
      if(!Harvest.isDisabled()) {
         measurementEngine.endActivity(var0);
      }
   }

   public static void initialize() {
      log.info("Measurement Engine initialized.");
      TaskQueue.start();
      addMeasurementProducer(httpErrorMeasurementProducer);
      addMeasurementProducer(networkMeasurementProducer);
      addMeasurementProducer(activityMeasurementProducer);
      addMeasurementProducer(methodMeasurementProducer);
      addMeasurementProducer(customMetricProducer);
      addMeasurementConsumer(httpErrorHarvester);
      addMeasurementConsumer(httpTransactionHarvester);
      addMeasurementConsumer(activityConsumer);
      addMeasurementConsumer(methodMeasurementConsumer);
      addMeasurementConsumer(summaryMetricMeasurementConsumer);
      addMeasurementConsumer(customMetricConsumer);
   }

   private static void newMeasurementBroadcast() {
      if(broadcastNewMeasurements) {
         broadcast();
      }

   }

   public static void process() {
      measurementEngine.broadcastMeasurements();
   }

   public static void removeMeasurementConsumer(MeasurementConsumer var0) {
      measurementEngine.removeMeasurementConsumer(var0);
   }

   public static void removeMeasurementProducer(MeasurementProducer var0) {
      measurementEngine.removeMeasurementProducer(var0);
   }

   public static void renameActivity(String var0, String var1) {
      measurementEngine.renameActivity(var0, var1);
   }

   public static void setBroadcastNewMeasurements(boolean var0) {
      broadcastNewMeasurements = var0;
   }

   public static void shutdown() {
      TaskQueue.stop();
      measurementEngine.clear();
      log.info("Measurement Engine shutting down.");
      removeMeasurementProducer(httpErrorMeasurementProducer);
      removeMeasurementProducer(networkMeasurementProducer);
      removeMeasurementProducer(activityMeasurementProducer);
      removeMeasurementProducer(methodMeasurementProducer);
      removeMeasurementProducer(customMetricProducer);
      removeMeasurementConsumer(httpErrorHarvester);
      removeMeasurementConsumer(httpTransactionHarvester);
      removeMeasurementConsumer(activityConsumer);
      removeMeasurementConsumer(methodMeasurementConsumer);
      removeMeasurementConsumer(summaryMetricMeasurementConsumer);
      removeMeasurementConsumer(customMetricConsumer);
   }

   public static MeasuredActivity startActivity(String var0) {
      return Harvest.isDisabled()?null:measurementEngine.startActivity(var0);
   }
}
