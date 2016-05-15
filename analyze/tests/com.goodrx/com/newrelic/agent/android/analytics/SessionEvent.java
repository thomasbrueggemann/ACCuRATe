package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import java.util.Set;

public class SessionEvent extends AnalyticsEvent {
   public SessionEvent() {
      super((String)null, AnalyticsEventCategory.Session);
   }

   public SessionEvent(Set<AnalyticAttribute> var1) {
      super((String)null, AnalyticsEventCategory.Session, "Mobile", var1);
   }
}
