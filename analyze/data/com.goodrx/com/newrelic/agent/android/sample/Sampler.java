package com.newrelic.agent.android.sample;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Sampler implements TraceLifecycleAware, Runnable {
   private static final int KB_IN_MB = 1024;
   private static final int[] PID;
   private static final long SAMPLE_FREQ_MS = 100L;
   protected static final long SAMPLE_FREQ_MS_MAX = 250L;
   protected static boolean cpuSamplingDisabled;
   private static final AgentLog log;
   protected static Sampler sampler;
   private static final ReentrantLock samplerLock;
   private final ActivityManager activityManager;
   private RandomAccessFile appStatFile;
   protected final AtomicBoolean isRunning = new AtomicBoolean(false);
   private Long lastAppCpuTime;
   private Long lastCpuTime;
   private RandomAccessFile procStatFile;
   protected long sampleFreqMs = 100L;
   protected ScheduledFuture sampleFuture;
   private Metric samplerServiceMetric;
   private final EnumMap<Sample.SampleType, Collection<Sample>> samples = new EnumMap(Sample.SampleType.class);
   private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Sampler"));

   static {
      int[] var0 = new int[]{Process.myPid()};
      PID = var0;
      log = AgentLogManager.getAgentLog();
      samplerLock = new ReentrantLock();
      cpuSamplingDisabled = false;
   }

   protected Sampler(Context var1) {
      this.activityManager = (ActivityManager)var1.getSystemService("activity");
      this.samples.put(Sample.SampleType.MEMORY, new ArrayList());
      this.samples.put(Sample.SampleType.CPU, new ArrayList());
   }

   public static Map<Sample.SampleType, Collection<Sample>> copySamples() {
      // $FF: Couldn't be decompiled
   }

   private Collection<Sample> getSampleCollection(Sample.SampleType var1) {
      return (Collection)this.samples.get(var1);
   }

   public static void init(Context var0) {
      samplerLock.lock();

      try {
         if(sampler == null) {
            sampler = new Sampler(var0);
            sampler.sampleFreqMs = 100L;
            sampler.samplerServiceMetric = new Metric("samplerServiceTime");
            TraceMachine.addTraceListener(sampler);
            log.debug("Sampler initialized");
         }

         return;
      } catch (Exception var5) {
         log.error("Sampler init failed: " + var5.getMessage());
         shutdown();
      } finally {
         samplerLock.unlock();
      }

   }

   protected static boolean isRunning() {
      return sampler != null && sampler.sampleFuture != null && !sampler.sampleFuture.isDone();
   }

   private void resetCpuSampler() {
      this.lastCpuTime = null;
      this.lastAppCpuTime = null;
      if(this.appStatFile != null && this.procStatFile != null) {
         try {
            this.appStatFile.close();
            this.procStatFile.close();
            this.appStatFile = null;
            this.procStatFile = null;
         } catch (IOException var2) {
            log.debug("Exception hit while resetting CPU sampler: " + var2.getMessage());
            AgentHealth.noticeException((Exception)var2);
            return;
         }
      }

   }

   protected static Sample sampleCpuInstance() {
      return sampler == null?null:sampler.sampleCpu();
   }

   public static Sample sampleMemory() {
      return sampler == null?null:sampleMemory(sampler.activityManager);
   }

   public static Sample sampleMemory(ActivityManager param0) {
      // $FF: Couldn't be decompiled
   }

   public static void shutdown() {
      samplerLock.lock();

      try {
         if(sampler != null) {
            TraceMachine.removeTraceListener(sampler);
            stop();
            sampler = null;
            log.debug("Sampler shutdown");
         }
      } finally {
         samplerLock.unlock();
      }

   }

   public static void start() {
      samplerLock.lock();

      try {
         if(sampler != null) {
            sampler.schedule();
            log.debug("Sampler started");
         }
      } finally {
         samplerLock.unlock();
      }

   }

   public static void stop() {
      samplerLock.lock();

      try {
         if(sampler != null) {
            sampler.stop(false);
            log.debug("Sampler stopped");
         }
      } finally {
         samplerLock.unlock();
      }

   }

   public static void stopNow() {
      samplerLock.lock();

      try {
         if(sampler != null) {
            sampler.stop(true);
            log.debug("Sampler hard stopped");
         }
      } finally {
         samplerLock.unlock();
      }

   }

   protected void clear() {
      Iterator var1 = this.samples.values().iterator();

      while(var1.hasNext()) {
         ((Collection)var1.next()).clear();
      }

   }

   protected void monitorSamplerServiceTime(double var1) {
      this.samplerServiceMetric.sample(var1);
      if(Double.valueOf(this.samplerServiceMetric.getTotal() / (double)this.samplerServiceMetric.getCount()).doubleValue() > (double)this.sampleFreqMs) {
         log.debug("Sampler: sample service time has been exceeded. Increase by 10%");
         this.sampleFreqMs = Math.min((long)(1.1F * (float)this.sampleFreqMs), 250L);
         if(this.sampleFuture != null) {
            this.sampleFuture.cancel(true);
         }

         this.sampleFuture = this.scheduler.scheduleWithFixedDelay(this, 0L, this.sampleFreqMs, TimeUnit.MILLISECONDS);
         AgentLog var3 = log;
         Object[] var4 = new Object[]{Long.valueOf(this.sampleFreqMs)};
         var3.debug(String.format("Sampler scheduler restarted; sampling will now occur every %d ms.", var4));
         this.samplerServiceMetric.clear();
      }

   }

   public void onEnterMethod() {
      if(!this.isRunning.get()) {
         start();
      }
   }

   public void onExitMethod() {
   }

   public void onTraceComplete(ActivityTrace var1) {
      stop();
      var1.setVitals(copySamples());
      this.clear();
   }

   public void onTraceStart(ActivityTrace var1) {
      start();
   }

   public void run() {
      try {
         if(this.isRunning.get()) {
            this.sample();
         }

      } catch (Exception var2) {
         log.error("Caught exception while running the sampler", var2);
         AgentHealth.noticeException(var2);
      }
   }

   protected void sample() {
      // $FF: Couldn't be decompiled
   }

   public Sample sampleCpu() {
      // $FF: Couldn't be decompiled
   }

   protected void schedule() {
      samplerLock.lock();

      try {
         if(!this.isRunning.get()) {
            this.clear();
            this.sampleFuture = this.scheduler.scheduleWithFixedDelay(this, 0L, this.sampleFreqMs, TimeUnit.MILLISECONDS);
            this.isRunning.set(true);
            AgentLog var3 = log;
            Object[] var4 = new Object[]{Long.valueOf(this.sampleFreqMs)};
            var3.debug(String.format("Sampler scheduler started; sampling will occur every %d ms.", var4));
         }

         return;
      } catch (Exception var7) {
         log.error("Sampler scheduling failed: " + var7.getMessage());
         AgentHealth.noticeException(var7);
      } finally {
         samplerLock.unlock();
      }

   }

   protected void stop(boolean var1) {
      samplerLock.lock();

      try {
         if(this.isRunning.get()) {
            this.isRunning.set(false);
            if(this.sampleFuture != null) {
               this.sampleFuture.cancel(var1);
            }

            this.resetCpuSampler();
            log.debug("Sampler canceled");
         }

         return;
      } catch (Exception var6) {
         log.error("Sampler stop failed: " + var6.getMessage());
         AgentHealth.noticeException(var6);
      } finally {
         samplerLock.unlock();
      }

   }
}
