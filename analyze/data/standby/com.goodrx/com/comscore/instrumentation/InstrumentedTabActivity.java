package com.comscore.instrumentation;

import android.app.TabActivity;
import android.os.Bundle;
import com.comscore.analytics.comScore;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Deprecated
@Instrumented
public class InstrumentedTabActivity extends TabActivity implements TraceFieldInterface {
   protected void onCreate(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPause() {
      super.onPause();
      comScore.onExitForeground();
   }

   protected void onResume() {
      super.onResume();
      comScore.getCore().setCurrentActivityName(this.getClass().getSimpleName());
      comScore.onEnterForeground();
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }
}
