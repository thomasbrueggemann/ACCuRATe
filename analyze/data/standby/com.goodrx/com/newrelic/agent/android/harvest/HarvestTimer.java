package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.Harvester;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HarvestTimer implements Runnable {
   private static final long DEFAULT_HARVEST_PERIOD = 60000L;
   private static final long HARVEST_PERIOD_LEEWAY = 1000L;
   private static final long NEVER_TICKED = -1L;
   protected final Harvester harvester;
   protected long lastTickTime;
   private Lock lock = new ReentrantLock();
   private final AgentLog log = AgentLogManager.getAgentLog();
   protected long period = 60000L;
   private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Harvester"));
   private long startTimeMs;
   private ScheduledFuture tickFuture = null;

   public HarvestTimer(Harvester var1) {
      this.harvester = var1;
      this.startTimeMs = 0L;
   }

   private long now() {
      return System.currentTimeMillis();
   }

   private void tickIfReady() {
      long var1 = this.timeSinceLastTick();
      if(1000L + var1 < this.period && var1 != -1L) {
         this.log.debug("HarvestTimer: Tick is too soon (" + var1 + " delta) Last tick time: " + this.lastTickTime + " . Skipping.");
      } else {
         this.log.debug("HarvestTimer: time since last tick: " + var1);
         long var3 = this.now();

         try {
            this.tick();
         } catch (Exception var6) {
            this.log.error("HarvestTimer: Exception in timer tick: " + var6.getMessage());
            var6.printStackTrace();
            AgentHealth.noticeException(var6);
         }

         this.lastTickTime = var3;
         this.log.debug("Set last tick time to: " + this.lastTickTime);
      }
   }

   protected void cancelPendingTasks() {
      try {
         this.lock.lock();
         if(this.tickFuture != null) {
            this.tickFuture.cancel(true);
            this.tickFuture = null;
         }
      } finally {
         this.lock.unlock();
      }

   }

   public boolean isRunning() {
      return this.tickFuture != null;
   }

   public void run() {
      try {
         this.lock.lock();
         this.tickIfReady();
         return;
      } catch (Exception var5) {
         this.log.error("HarvestTimer: Exception in timer tick: " + var5.getMessage());
         var5.printStackTrace();
         AgentHealth.noticeException(var5);
      } finally {
         this.lock.unlock();
      }

   }

   public void setPeriod(long var1) {
      this.period = var1;
   }

   public void shutdown() {
      this.cancelPendingTasks();
      this.scheduler.shutdownNow();
   }

   public void start() {
      if(ApplicationStateMonitor.isAppInBackground()) {
         this.log.warning("HarvestTimer: Attempting to start while app is in background");
      } else if(this.isRunning()) {
         this.log.warning("HarvestTimer: Attempting to start while already running");
      } else if(this.period <= 0L) {
         this.log.error("HarvestTimer: Refusing to start with a period of 0 ms");
      } else {
         this.log.debug("HarvestTimer: Starting with a period of " + this.period + "ms");
         this.startTimeMs = System.currentTimeMillis();
         this.tickFuture = this.scheduler.scheduleAtFixedRate(this, 0L, this.period, TimeUnit.MILLISECONDS);
         this.harvester.start();
      }
   }

   public void stop() {
      if(!this.isRunning()) {
         this.log.warning("HarvestTimer: Attempting to stop when not running");
      } else {
         this.cancelPendingTasks();
         this.log.debug("HarvestTimer: Stopped.");
         this.startTimeMs = 0L;
         this.harvester.stop();
      }
   }

   protected void tick() {
      this.log.debug("Harvest: tick");
      TicToc var1 = new TicToc();
      var1.tic();

      try {
         if(ApplicationStateMonitor.isAppInBackground()) {
            this.log.error("HarvestTimer: Attempting to harvest while app is in background");
         } else {
            this.harvester.execute();
            this.log.debug("Harvest: executed");
         }
      } catch (Exception var5) {
         this.log.error("HarvestTimer: Exception in harvest execute: " + var5.getMessage());
         var5.printStackTrace();
         AgentHealth.noticeException(var5);
      }

      if(this.harvester.isDisabled()) {
         this.stop();
      }

      long var3 = var1.toc();
      this.log.debug("HarvestTimer tick took " + var3 + "ms");
   }

   public void tickNow() {
      ScheduledFuture var1 = this.scheduler.schedule(new Runnable() {
         public void run() {
            HarvestTimer.this.tick();
         }
      }, 0L, TimeUnit.SECONDS);

      try {
         var1.get();
      } catch (Exception var3) {
         this.log.error("Exception waiting for tickNow to finish: " + var3.getMessage());
         var3.printStackTrace();
         AgentHealth.noticeException(var3);
      }
   }

   public long timeSinceLastTick() {
      return this.lastTickTime == 0L?-1L:this.now() - this.lastTickTime;
   }

   public long timeSinceStart() {
      return this.startTimeMs == 0L?0L:this.now() - this.startTimeMs;
   }
}
