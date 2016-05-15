package android.support.v7.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;

public class MediaRouteDiscoveryFragment extends Fragment implements TraceFieldInterface {
   private final String ARGUMENT_SELECTOR = "selector";
   private MediaRouter.Callback mCallback;
   private MediaRouter mRouter;
   private MediaRouteSelector mSelector;

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

   private void ensureRouter() {
      if(this.mRouter == null) {
         this.mRouter = MediaRouter.getInstance(this.getActivity());
      }

   }

   public MediaRouter getMediaRouter() {
      this.ensureRouter();
      return this.mRouter;
   }

   public MediaRouteSelector getRouteSelector() {
      this.ensureRouteSelector();
      return this.mSelector;
   }

   public MediaRouter.Callback onCreateCallback() {
      return new MediaRouter.Callback() {
      };
   }

   public int onPrepareCallbackFlags() {
      return 4;
   }

   public void onStart() {
      ApplicationStateMonitor.getInstance().activityStarted();
      super.onStart();
      this.ensureRouteSelector();
      this.ensureRouter();
      this.mCallback = this.onCreateCallback();
      if(this.mCallback != null) {
         this.mRouter.addCallback(this.mSelector, this.mCallback, this.onPrepareCallbackFlags());
      }

   }

   public void onStop() {
      ApplicationStateMonitor.getInstance().activityStopped();
      if(this.mCallback != null) {
         this.mRouter.removeCallback(this.mCallback);
         this.mCallback = null;
      }

      super.onStop();
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
            if(this.mCallback != null) {
               this.mRouter.removeCallback(this.mCallback);
               this.mRouter.addCallback(this.mSelector, this.mCallback, this.onPrepareCallbackFlags());
            }
         }

      }
   }
}
