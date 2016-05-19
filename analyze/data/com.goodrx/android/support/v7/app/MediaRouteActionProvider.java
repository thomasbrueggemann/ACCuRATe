package android.support.v7.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ActionProvider;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.app.MediaRouteDialogFactory;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public class MediaRouteActionProvider extends ActionProvider {
   private static final String TAG = "MediaRouteActionProvider";
   private MediaRouteButton mButton;
   private final MediaRouteActionProvider.MediaRouterCallback mCallback;
   private MediaRouteDialogFactory mDialogFactory;
   private final MediaRouter mRouter;
   private MediaRouteSelector mSelector;

   public MediaRouteActionProvider(Context var1) {
      super(var1);
      this.mSelector = MediaRouteSelector.EMPTY;
      this.mDialogFactory = MediaRouteDialogFactory.getDefault();
      this.mRouter = MediaRouter.getInstance(var1);
      this.mCallback = new MediaRouteActionProvider.MediaRouterCallback(this);
   }

   private void refreshRoute() {
      this.refreshVisibility();
   }

   @NonNull
   public MediaRouteDialogFactory getDialogFactory() {
      return this.mDialogFactory;
   }

   @Nullable
   public MediaRouteButton getMediaRouteButton() {
      return this.mButton;
   }

   @NonNull
   public MediaRouteSelector getRouteSelector() {
      return this.mSelector;
   }

   public boolean isVisible() {
      return this.mRouter.isRouteAvailable(this.mSelector, 1);
   }

   public View onCreateActionView() {
      if(this.mButton != null) {
         Log.e("MediaRouteActionProvider", "onCreateActionView: this ActionProvider is already associated with a menu item. Don\'t reuse MediaRouteActionProvider instances! Abandoning the old menu item...");
      }

      this.mButton = this.onCreateMediaRouteButton();
      this.mButton.setCheatSheetEnabled(true);
      this.mButton.setRouteSelector(this.mSelector);
      this.mButton.setDialogFactory(this.mDialogFactory);
      this.mButton.setLayoutParams(new LayoutParams(-2, -1));
      return this.mButton;
   }

   public MediaRouteButton onCreateMediaRouteButton() {
      return new MediaRouteButton(this.getContext());
   }

   public boolean onPerformDefaultAction() {
      return this.mButton != null?this.mButton.showDialog():false;
   }

   public boolean overridesItemVisibility() {
      return true;
   }

   public void setDialogFactory(@NonNull MediaRouteDialogFactory var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("factory must not be null");
      } else {
         if(this.mDialogFactory != var1) {
            this.mDialogFactory = var1;
            if(this.mButton != null) {
               this.mButton.setDialogFactory(var1);
            }
         }

      }
   }

   public void setRouteSelector(@NonNull MediaRouteSelector var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("selector must not be null");
      } else {
         if(!this.mSelector.equals(var1)) {
            if(!this.mSelector.isEmpty()) {
               this.mRouter.removeCallback(this.mCallback);
            }

            if(!var1.isEmpty()) {
               this.mRouter.addCallback(var1, this.mCallback);
            }

            this.mSelector = var1;
            this.refreshRoute();
            if(this.mButton != null) {
               this.mButton.setRouteSelector(var1);
            }
         }

      }
   }

   private static final class MediaRouterCallback extends MediaRouter.Callback {
      private final WeakReference<MediaRouteActionProvider> mProviderWeak;

      public MediaRouterCallback(MediaRouteActionProvider var1) {
         this.mProviderWeak = new WeakReference(var1);
      }

      private void refreshRoute(MediaRouter var1) {
         MediaRouteActionProvider var2 = (MediaRouteActionProvider)this.mProviderWeak.get();
         if(var2 != null) {
            var2.refreshRoute();
         } else {
            var1.removeCallback(this);
         }
      }

      public void onProviderAdded(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         this.refreshRoute(var1);
      }

      public void onProviderChanged(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         this.refreshRoute(var1);
      }

      public void onProviderRemoved(MediaRouter var1, MediaRouter.ProviderInfo var2) {
         this.refreshRoute(var1);
      }

      public void onRouteAdded(MediaRouter var1, MediaRouter.RouteInfo var2) {
         this.refreshRoute(var1);
      }

      public void onRouteChanged(MediaRouter var1, MediaRouter.RouteInfo var2) {
         this.refreshRoute(var1);
      }

      public void onRouteRemoved(MediaRouter var1, MediaRouter.RouteInfo var2) {
         this.refreshRoute(var1);
      }
   }
}
