package com.goodrx.activity;

import android.support.v4.app.Fragment;
import com.goodrx.utils.tracker.GAHelper;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class BaseFragmentWitGA extends Fragment implements TraceFieldInterface {
   private String mScreenName;
   private boolean mTrackingEnabled;

   public void enableScreenViewTracking(String var1) {
      this.mTrackingEnabled = true;
      this.mScreenName = var1;
   }

   public void onPause() {
      if(this.mTrackingEnabled) {
         GAHelper.pushCloseScreenEvent(this.getContext(), this.mScreenName);
      }

      super.onPause();
   }

   public void onResume() {
      super.onResume();
      if(this.mTrackingEnabled) {
         GAHelper.sendGoogleAnalyticsScreenView(this.getContext(), this.mScreenName);
      }

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
