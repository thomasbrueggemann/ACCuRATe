package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import java.util.Set;

public class InteractionEvent extends AnalyticsEvent {
   public InteractionEvent(String var1) {
      super(var1, AnalyticsEventCategory.Interaction);
   }

   public InteractionEvent(String var1, Set<AnalyticAttribute> var2) {
      super(var1, AnalyticsEventCategory.Interaction, "Mobile", var2);
   }
}
