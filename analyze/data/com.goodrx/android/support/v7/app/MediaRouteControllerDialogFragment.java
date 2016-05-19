package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.MediaRouteControllerDialog;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class MediaRouteControllerDialogFragment extends DialogFragment implements TraceFieldInterface {
   public MediaRouteControllerDialogFragment() {
      this.setCancelable(true);
   }

   public MediaRouteControllerDialog onCreateControllerDialog(Context var1, Bundle var2) {
      return new MediaRouteControllerDialog(var1);
   }

   public Dialog onCreateDialog(Bundle var1) {
      return this.onCreateControllerDialog(this.getActivity(), var1);
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
