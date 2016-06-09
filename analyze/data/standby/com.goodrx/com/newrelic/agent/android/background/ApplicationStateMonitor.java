package com.newrelic.agent.android.background;

import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ApplicationStateMonitor implements Runnable {
   private static ApplicationStateMonitor instance;
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private final int activitySnoozeTimeInMilliseconds;
   protected final ArrayList<ApplicationStateListener> applicationStateListeners;
   private AtomicLong count;
   protected final ScheduledThreadPoolExecutor executor;
   private final Lock foregroundLock;
   protected AtomicBoolean foregrounded;
   private final Lock snoozeLock;
   private AtomicLong snoozeStartTime;

   private ApplicationStateMonitor() {
      this(5, 5, TimeUnit.SECONDS, 5000);
   }

   ApplicationStateMonitor(int var1, int var2, TimeUnit var3, int var4) {
      this.count = new AtomicLong(0L);
      this.snoozeStartTime = new AtomicLong(0L);
      this.snoozeLock = new ReentrantLock();
      this.applicationStateListeners = new ArrayList();
      this.foregrounded = new AtomicBoolean(true);
      this.foregroundLock = new ReentrantLock();
      this.executor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("AppStateMon"));
      this.activitySnoozeTimeInMilliseconds = var4;
      this.executor.scheduleAtFixedRate(this, (long)var1, (long)var2, var3);
      log.info("Application state monitor has started");
   }

   // $FF: synthetic method
   static Lock access$300(ApplicationStateMonitor var0) {
      return var0.snoozeLock;
   }

   // $FF: synthetic method
   static AtomicLong access$400(ApplicationStateMonitor var0) {
      return var0.count;
   }

   // $FF: synthetic method
   static AtomicLong access$500(ApplicationStateMonitor var0) {
      return var0.snoozeStartTime;
   }

   // $FF: synthetic method
   static void access$600(ApplicationStateMonitor var0) {
      var0.notifyApplicationInForeground();
   }

   public static ApplicationStateMonitor getInstance() {
      if(instance == null) {
         instance = new ApplicationStateMonitor();
      }

      return instance;
   }

   private long getSnoozeTime() {
      // $FF: Couldn't be decompiled
   }

   public static boolean isAppInBackground() {
      return !getInstance().getForegrounded();
   }

   private void notifyApplicationInBackground() {
      // $FF: Couldn't be decompiled
   }

   private void notifyApplicationInForeground() {
      // $FF: Couldn't be decompiled
   }

   public void activityStarted() {
      Runnable var1 = new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      };
      this.executor.execute(var1);
   }

   public void activityStopped() {
      Runnable var1 = new Runnable() {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      };
      this.executor.execute(var1);
   }

   public void addApplicationStateListener(ApplicationStateListener param1) {
      // $FF: Couldn't be decompiled
   }

   public ScheduledThreadPoolExecutor getExecutor() {
      return this.executor;
   }

   public boolean getForegrounded() {
      return this.foregrounded.get();
   }

   public void removeApplicationStateListener(ApplicationStateListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void run() {
      try {
         this.foregroundLock.lock();
         if(this.foregrounded.get() && this.getSnoozeTime() >= (long)this.activitySnoozeTimeInMilliseconds) {
            this.foregrounded.set(false);
            this.notifyApplicationInBackground();
         }
      } finally {
         this.foregroundLock.unlock();
      }

   }

   public void uiHidden() {
      Runnable var1 = new Runnable() {
         public void run() {
            try {
               ApplicationStateMonitor.this.foregroundLock.lock();
               if(ApplicationStateMonitor.this.foregrounded.get()) {
                  ApplicationStateMonitor.log.info("UI has become hidden (app backgrounded)");
                  ApplicationStateMonitor.this.notifyApplicationInBackground();
                  ApplicationStateMonitor.this.foregrounded.set(false);
               }
            } finally {
               ApplicationStateMonitor.this.foregroundLock.unlock();
            }

         }
      };
      this.executor.execute(var1);
   }
}
