package com.newrelic.agent.android;

import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.AgentHealthException;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskQueue extends HarvestAdapter {
   private static final long DEQUEUE_PERIOD_MS = 1000L;
   private static Future dequeueFuture;
   private static final Runnable dequeueTask = new Runnable() {
      public void run() {
         TaskQueue.dequeue();
      }
   };
   private static final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue();
   private static final ScheduledExecutorService queueExecutor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("TaskQueue"));

   public static void backgroundDequeue() {
      queueExecutor.execute(dequeueTask);
   }

   public static void clear() {
      queue.clear();
   }

   private static void dequeue() {
      if(queue.size() != 0) {
         Measurements.setBroadcastNewMeasurements(false);

         while(!queue.isEmpty()) {
            try {
               Object var1 = queue.remove();
               if(var1 instanceof ActivityTrace) {
                  Harvest.addActivityTrace((ActivityTrace)var1);
               } else if(var1 instanceof Metric) {
                  Harvest.addMetric((Metric)var1);
               } else if(var1 instanceof AgentHealthException) {
                  Harvest.addAgentHealthException((AgentHealthException)var1);
               } else if(var1 instanceof Trace) {
                  Measurements.addTracedMethod((Trace)var1);
               } else if(var1 instanceof HttpTransactionMeasurement) {
                  Measurements.addHttpTransaction((HttpTransactionMeasurement)var1);
               }
            } catch (Exception var2) {
               var2.printStackTrace();
               AgentHealth.noticeException(var2);
            }
         }

         Measurements.broadcast();
         Measurements.setBroadcastNewMeasurements(true);
      }
   }

   public static void queue(Object var0) {
      queue.add(var0);
   }

   public static int size() {
      return queue.size();
   }

   public static void start() {
      if(dequeueFuture == null) {
         dequeueFuture = queueExecutor.scheduleAtFixedRate(dequeueTask, 0L, 1000L, TimeUnit.MILLISECONDS);
      }
   }

   public static void stop() {
      if(dequeueFuture != null) {
         dequeueFuture.cancel(true);
         dequeueFuture = null;
      }
   }

   public static void synchronousDequeue() {
      Future var0 = queueExecutor.submit(dequeueTask);

      try {
         var0.get();
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      } catch (ExecutionException var4) {
         var4.printStackTrace();
      }
   }
}
