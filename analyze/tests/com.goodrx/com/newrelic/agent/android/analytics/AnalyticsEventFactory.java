package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsEvent;
import com.newrelic.agent.android.analytics.AnalyticsEventCategory;
import com.newrelic.agent.android.analytics.CrashEvent;
import com.newrelic.agent.android.analytics.CustomEvent;
import com.newrelic.agent.android.analytics.InteractionEvent;
import com.newrelic.agent.android.analytics.SessionEvent;
import java.util.Set;

public class AnalyticsEventFactory {
   static AnalyticsEvent createEvent(String var0, AnalyticsEventCategory var1, String var2, Set<AnalyticAttribute> var3) {
      switch(null.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsEventCategory[var1.ordinal()]) {
      case 1:
         return new SessionEvent(var3);
      case 2:
         return new InteractionEvent(var0, var3);
      case 3:
         return new CrashEvent(var0, var3);
      case 4:
         return new CustomEvent(var0, var2, var3);
      default:
         return null;
      }
   }
}
