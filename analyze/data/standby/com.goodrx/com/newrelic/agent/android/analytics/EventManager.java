package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticsEvent;
import java.util.Collection;

public interface EventManager {
   boolean addEvent(AnalyticsEvent var1);

   void empty();

   int getEventsEjected();

   int getEventsRecorded();

   int getMaxEventBufferTime();

   int getMaxEventPoolSize();

   Collection<AnalyticsEvent> getQueuedEvents();

   void initialize();

   boolean isMaxEventBufferTimeExceeded();

   boolean isMaxEventPoolSizeExceeded();

   boolean isTransmitRequired();

   void setMaxEventBufferTime(int var1);

   void setMaxEventPoolSize(int var1);

   void shutdown();

   int size();
}
