package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import com.newrelic.agent.android.analytics.EventManager;
import java.util.Map;
import java.util.Set;

public interface AnalyticsController {
   boolean addEvent(AnalyticsEvent var1);

   boolean addEvent(String var1, AnalyticsEventCategory var2, String var3, Set<AnalyticAttribute> var4);

   boolean addEvent(String var1, Set<AnalyticAttribute> var2);

   AnalyticAttribute getAttribute(String var1);

   EventManager getEventManager();

   int getMaxEventBufferTime();

   int getMaxEventPoolSize();

   int getSessionAttributeCount();

   Set<AnalyticAttribute> getSessionAttributes();

   int getSystemAttributeCount();

   Set<AnalyticAttribute> getSystemAttributes();

   int getUserAttributeCount();

   Set<AnalyticAttribute> getUserAttributes();

   boolean incrementAttribute(String var1, float var2);

   boolean incrementAttribute(String var1, float var2, boolean var3);

   boolean recordEvent(String var1, Map<String, Object> var2);

   boolean removeAllAttributes();

   boolean removeAttribute(String var1);

   boolean setAttribute(String var1, float var2);

   boolean setAttribute(String var1, float var2, boolean var3);

   boolean setAttribute(String var1, String var2);

   boolean setAttribute(String var1, String var2, boolean var3);

   boolean setAttribute(String var1, boolean var2);

   boolean setAttribute(String var1, boolean var2, boolean var3);

   void setMaxEventBufferTime(int var1);

   void setMaxEventPoolSize(int var1);
}
