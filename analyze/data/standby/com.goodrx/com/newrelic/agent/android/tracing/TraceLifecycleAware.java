package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.tracing.ActivityTrace;

public interface TraceLifecycleAware {
   void onEnterMethod();

   void onExitMethod();

   void onTraceComplete(ActivityTrace var1);

   void onTraceStart(ActivityTrace var1);
}
