package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import java.util.Set;

public class CrashEvent extends AnalyticsEvent {
   public CrashEvent(String var1) {
      super(var1, AnalyticsEventCategory.Crash);
   }

   public CrashEvent(String var1, Set<AnalyticAttribute> var2) {
      super(var1, AnalyticsEventCategory.Crash, "Mobile", var2);
   }
}
