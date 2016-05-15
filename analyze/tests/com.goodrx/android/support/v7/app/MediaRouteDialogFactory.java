package android.support.v7.app;

import android.support.annotation.NonNull;
import android.support.v7.app.MediaRouteChooserDialogFragment;
import android.support.v7.app.MediaRouteControllerDialogFragment;

public class MediaRouteDialogFactory {
   private static final MediaRouteDialogFactory sDefault = new MediaRouteDialogFactory();

   @NonNull
   public static MediaRouteDialogFactory getDefault() {
      return sDefault;
   }

   @NonNull
   public MediaRouteChooserDialogFragment onCreateChooserDialogFragment() {
      return new MediaRouteChooserDialogFragment();
   }

   @NonNull
   public MediaRouteControllerDialogFragment onCreateControllerDialogFragment() {
      return new MediaRouteControllerDialogFragment();
   }
}
