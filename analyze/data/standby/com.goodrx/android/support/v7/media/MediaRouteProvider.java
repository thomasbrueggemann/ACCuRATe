package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.media.MediaRouteDiscoveryRequest;
import android.support.v7.media.MediaRouteProviderDescriptor;
import android.support.v7.media.MediaRouter;

public abstract class MediaRouteProvider {
   private static final int MSG_DELIVER_DESCRIPTOR_CHANGED = 1;
   private static final int MSG_DELIVER_DISCOVERY_REQUEST_CHANGED = 2;
   private MediaRouteProvider.Callback mCallback;
   private final Context mContext;
   private MediaRouteProviderDescriptor mDescriptor;
   private MediaRouteDiscoveryRequest mDiscoveryRequest;
   private final MediaRouteProvider.ProviderHandler mHandler;
   private final MediaRouteProvider.ProviderMetadata mMetadata;
   private boolean mPendingDescriptorChange;
   private boolean mPendingDiscoveryRequestChange;

   public MediaRouteProvider(@NonNull Context var1) {
      this(var1, (MediaRouteProvider.ProviderMetadata)null);
   }

   MediaRouteProvider(Context var1, MediaRouteProvider.ProviderMetadata var2) {
      this.mHandler = new MediaRouteProvider.ProviderHandler();
      if(var1 == null) {
         throw new IllegalArgumentException("context must not be null");
      } else {
         this.mContext = var1;
         if(var2 == null) {
            this.mMetadata = new MediaRouteProvider.ProviderMetadata(new ComponentName(var1, this.getClass()));
         } else {
            this.mMetadata = var2;
         }
      }
   }

   private void deliverDescriptorChanged() {
      this.mPendingDescriptorChange = false;
      if(this.mCallback != null) {
         this.mCallback.onDescriptorChanged(this, this.mDescriptor);
      }

   }

   private void deliverDiscoveryRequestChanged() {
      this.mPendingDiscoveryRequestChange = false;
      this.onDiscoveryRequestChanged(this.mDiscoveryRequest);
   }

   public final Context getContext() {
      return this.mContext;
   }

   @Nullable
   public final MediaRouteProviderDescriptor getDescriptor() {
      return this.mDescriptor;
   }

   @Nullable
   public final MediaRouteDiscoveryRequest getDiscoveryRequest() {
      return this.mDiscoveryRequest;
   }

   public final Handler getHandler() {
      return this.mHandler;
   }

   public final MediaRouteProvider.ProviderMetadata getMetadata() {
      return this.mMetadata;
   }

   @Nullable
   public MediaRouteProvider.RouteController onCreateRouteController(String var1) {
      return null;
   }

   public void onDiscoveryRequestChanged(@Nullable MediaRouteDiscoveryRequest var1) {
   }

   public final void setCallback(@Nullable MediaRouteProvider.Callback var1) {
      MediaRouter.checkCallingThread();
      this.mCallback = var1;
   }

   public final void setDescriptor(@Nullable MediaRouteProviderDescriptor var1) {
      MediaRouter.checkCallingThread();
      if(this.mDescriptor != var1) {
         this.mDescriptor = var1;
         if(!this.mPendingDescriptorChange) {
            this.mPendingDescriptorChange = true;
            this.mHandler.sendEmptyMessage(1);
         }
      }

   }

   public final void setDiscoveryRequest(MediaRouteDiscoveryRequest var1) {
      MediaRouter.checkCallingThread();
      if(this.mDiscoveryRequest != var1 && (this.mDiscoveryRequest == null || !this.mDiscoveryRequest.equals(var1))) {
         this.mDiscoveryRequest = var1;
         if(!this.mPendingDiscoveryRequestChange) {
            this.mPendingDiscoveryRequestChange = true;
            this.mHandler.sendEmptyMessage(2);
            return;
         }
      }

   }

   public abstract static class Callback {
      public void onDescriptorChanged(@NonNull MediaRouteProvider var1, @Nullable MediaRouteProviderDescriptor var2) {
      }
   }

   private final class ProviderHandler extends Handler {
      private ProviderHandler() {
      }

      // $FF: synthetic method
      ProviderHandler(Object var2) {
         this();
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            MediaRouteProvider.this.deliverDescriptorChanged();
            return;
         case 2:
            MediaRouteProvider.this.deliverDiscoveryRequestChanged();
            return;
         default:
         }
      }
   }

   public static final class ProviderMetadata {
      private final ComponentName mComponentName;

      ProviderMetadata(ComponentName var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("componentName must not be null");
         } else {
            this.mComponentName = var1;
         }
      }

      public ComponentName getComponentName() {
         return this.mComponentName;
      }

      public String getPackageName() {
         return this.mComponentName.getPackageName();
      }

      public String toString() {
         return "ProviderMetadata{ componentName=" + this.mComponentName.flattenToShortString() + " }";
      }
   }

   public abstract static class RouteController {
      public boolean onControlRequest(Intent var1, @Nullable MediaRouter.ControlRequestCallback var2) {
         return false;
      }

      public void onRelease() {
      }

      public void onSelect() {
      }

      public void onSetVolume(int var1) {
      }

      public void onUnselect() {
      }

      public void onUnselect(int var1) {
         this.onUnselect();
      }

      public void onUpdateVolume(int var1) {
      }
   }
}
