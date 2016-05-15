package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.MediaRouteChooserDialog;
import android.support.v7.media.MediaRouteSelector;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class MediaRouteChooserDialogFragment extends DialogFragment implements TraceFieldInterface {
   private final String ARGUMENT_SELECTOR = "selector";
   private MediaRouteSelector mSelector;

   public MediaRouteChooserDialogFragment() {
      this.setCancelable(true);
   }

   private void ensureRouteSelector() {
      if(this.mSelector == null) {
         Bundle var1 = this.getArguments();
         if(var1 != null) {
            this.mSelector = MediaRouteSelector.fromBundle(var1.getBundle("selector"));
         }

         if(this.mSelector == null) {
            this.mSelector = MediaRouteSelector.EMPTY;
         }
      }

   }

   public MediaRouteSelector getRouteSelector() {
      this.ensureRouteSelector();
      return this.mSelector;
   }

   public MediaRouteChooserDialog onCreateChooserDialog(Context var1, Bundle var2) {
      return new MediaRouteChooserDialog(var1);
   }

   public Dialog onCreateDialog(Bundle var1) {
      MediaRouteChooserDialog var2 = this.onCreateChooserDialog(this.getActivity(), var1);
      var2.setRouteSelector(this.getRouteSelector());
      return var2;
   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void setRouteSelector(MediaRouteSelector var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         this.ensureRouteSelector();
         if(!this.mSelector.equals(var1)) {
            this.mSelector = var1;
            Bundle var2 = this.getArguments();
            if(var2 == null) {
               var2 = new Bundle();
            }

            var2.putBundle("selector", var1.asBundle());
            this.setArguments(var2);
            MediaRouteChooserDialog var3 = (MediaRouteChooserDialog)this.getDialog();
            if(var3 != null) {
               var3.setRouteSelector(var1);
            }
         }

      }
   }
}
