package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import java.util.Set;

public class CustomEvent extends AnalyticsEvent {
   public CustomEvent(String var1) {
      super(var1, AnalyticsEventCategory.Custom);
   }

   public CustomEvent(String var1, String var2, Set<AnalyticAttribute> var3) {
      super(var1, AnalyticsEventCategory.Custom, var2, var3);
   }

   public CustomEvent(String var1, Set<AnalyticAttribute> var2) {
      super(var1, AnalyticsEventCategory.Custom, (String)null, var2);
   }
}
