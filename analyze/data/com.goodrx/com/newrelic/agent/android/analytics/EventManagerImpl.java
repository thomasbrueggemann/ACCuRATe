package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class EventManagerImpl implements EventManager {
   public static int DEFAULT_MAX_EVENT_BUFFER_SIZE = 1000;
   public static int DEFAULT_MAX_EVENT_BUFFER_TIME = 600;
   private static final AgentLog log = AgentLogManager.getAgentLog();
   private List<AnalyticsEvent> events;
   private AtomicInteger eventsEjected;
   private AtomicInteger eventsRecorded;
   private long firstEventTimestamp;
   private AtomicBoolean initialized;
   private int maxBufferTimeInSec;
   private int maxEventPoolSize;

   public EventManagerImpl() {
      this(DEFAULT_MAX_EVENT_BUFFER_SIZE, DEFAULT_MAX_EVENT_BUFFER_TIME);
   }

   public EventManagerImpl(int var1, int var2) {
      this.initialized = new AtomicBoolean(false);
      this.eventsRecorded = new AtomicInteger(0);
      this.eventsEjected = new AtomicInteger(0);
      this.events = Collections.synchronizedList(new ArrayList(var1));
      this.maxBufferTimeInSec = var2;
      this.maxEventPoolSize = var1;
      this.firstEventTimestamp = 0L;
      this.eventsRecorded.set(0);
      this.eventsEjected.set(0);
   }

   public boolean addEvent(AnalyticsEvent var1) {
      int var2 = this.eventsRecorded.incrementAndGet();
      if(this.events.size() == 0) {
         log.verbose("EventManagerImpl.addEvent - Queue is currently empty, setting first event timestamp to " + System.currentTimeMillis());
         this.firstEventTimestamp = System.currentTimeMillis();
      }

      if(this.events.size() >= this.maxEventPoolSize) {
         this.eventsEjected.incrementAndGet();
         int var4 = (int)(Math.random() * (double)var2);
         if(var4 >= this.maxEventPoolSize) {
            return true;
         }

         this.events.remove(var4);
      }

      return this.events.add(var1);
   }

   public void empty() {
      this.events.clear();
      this.firstEventTimestamp = 0L;
   }

   public int getEventsEjected() {
      return this.eventsEjected.get();
   }

   public int getEventsRecorded() {
      return this.eventsRecorded.get();
   }

   public int getMaxEventBufferTime() {
      return this.maxBufferTimeInSec;
   }

   public int getMaxEventPoolSize() {
      return this.maxEventPoolSize;
   }

   public Collection<AnalyticsEvent> getQueuedEvents() {
      return Collections.unmodifiableCollection(this.events);
   }

   public void initialize() {
      if(!this.initialized.compareAndSet(false, true)) {
         log.verbose("EventManagerImpl has already been initialized.  Bypassing...");
      } else {
         this.firstEventTimestamp = 0L;
         this.eventsRecorded.set(0);
         this.eventsEjected.set(0);
         this.empty();
      }
   }

   public boolean isMaxEventBufferTimeExceeded() {
      long var4;
      int var1 = (var4 = this.firstEventTimestamp - 0L) == 0L?0:(var4 < 0L?-1:1);
      boolean var2 = false;
      if(var1 > 0) {
         long var5;
         int var3 = (var5 = System.currentTimeMillis() - this.firstEventTimestamp - (long)(1000 * this.maxBufferTimeInSec)) == 0L?0:(var5 < 0L?-1:1);
         var2 = false;
         if(var3 > 0) {
            var2 = true;
         }
      }

      return var2;
   }

   public boolean isMaxEventPoolSizeExceeded() {
      return this.events.size() > this.maxEventPoolSize;
   }

   public boolean isTransmitRequired() {
      return !this.initialized.get() && this.events.size() > 0 || this.isMaxEventBufferTimeExceeded();
   }

   public void setMaxEventBufferTime(int var1) {
      this.maxBufferTimeInSec = var1;
   }

   public void setMaxEventPoolSize(int var1) {
      this.maxEventPoolSize = var1;
   }

   public void shutdown() {
      this.initialized.set(false);
   }

   public int size() {
      return this.events.size();
   }
}
