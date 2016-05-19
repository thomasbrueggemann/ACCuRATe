package android.support.v7.media;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.media.MediaRouterJellybean;
import java.lang.ref.WeakReference;

abstract class RemoteControlClientCompat {
   protected final Context mContext;
   protected final Object mRcc;
   protected RemoteControlClientCompat.VolumeCallback mVolumeCallback;

   protected RemoteControlClientCompat(Context var1, Object var2) {
      this.mContext = var1;
      this.mRcc = var2;
   }

   public static RemoteControlClientCompat obtain(Context var0, Object var1) {
      return (RemoteControlClientCompat)(VERSION.SDK_INT >= 16?new RemoteControlClientCompat.JellybeanImpl(var0, var1):new RemoteControlClientCompat.LegacyImpl(var0, var1));
   }

   public Object getRemoteControlClient() {
      return this.mRcc;
   }

   public void setPlaybackInfo(RemoteControlClientCompat.PlaybackInfo var1) {
   }

   public void setVolumeCallback(RemoteControlClientCompat.VolumeCallback var1) {
      this.mVolumeCallback = var1;
   }

   static class JellybeanImpl extends RemoteControlClientCompat {
      private boolean mRegistered;
      private final Object mRouterObj;
      private final Object mUserRouteCategoryObj;
      private final Object mUserRouteObj;

      public JellybeanImpl(Context var1, Object var2) {
         super(var1, var2);
         this.mRouterObj = MediaRouterJellybean.getMediaRouter(var1);
         this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, "", false);
         this.mUserRouteObj = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
      }

      public void setPlaybackInfo(RemoteControlClientCompat.PlaybackInfo var1) {
         MediaRouterJellybean.UserRouteInfo.setVolume(this.mUserRouteObj, var1.volume);
         MediaRouterJellybean.UserRouteInfo.setVolumeMax(this.mUserRouteObj, var1.volumeMax);
         MediaRouterJellybean.UserRouteInfo.setVolumeHandling(this.mUserRouteObj, var1.volumeHandling);
         MediaRouterJellybean.UserRouteInfo.setPlaybackStream(this.mUserRouteObj, var1.playbackStream);
         MediaRouterJellybean.UserRouteInfo.setPlaybackType(this.mUserRouteObj, var1.playbackType);
         if(!this.mRegistered) {
            this.mRegistered = true;
            MediaRouterJellybean.UserRouteInfo.setVolumeCallback(this.mUserRouteObj, MediaRouterJellybean.createVolumeCallback(new RemoteControlClientCompat.VolumeCallbackWrapper(this)));
            MediaRouterJellybean.UserRouteInfo.setRemoteControlClient(this.mUserRouteObj, this.mRcc);
         }

      }
   }

   private static final class VolumeCallbackWrapper implements MediaRouterJellybean.VolumeCallback {
      private final WeakReference<RemoteControlClientCompat.JellybeanImpl> mImplWeak;

      public VolumeCallbackWrapper(RemoteControlClientCompat.JellybeanImpl var1) {
         this.mImplWeak = new WeakReference(var1);
      }

      public void onVolumeSetRequest(Object var1, int var2) {
         RemoteControlClientCompat.JellybeanImpl var3 = (RemoteControlClientCompat.JellybeanImpl)this.mImplWeak.get();
         if(var3 != null && var3.mVolumeCallback != null) {
            var3.mVolumeCallback.onVolumeSetRequest(var2);
         }

      }

      public void onVolumeUpdateRequest(Object var1, int var2) {
         RemoteControlClientCompat.JellybeanImpl var3 = (RemoteControlClientCompat.JellybeanImpl)this.mImplWeak.get();
         if(var3 != null && var3.mVolumeCallback != null) {
            var3.mVolumeCallback.onVolumeUpdateRequest(var2);
         }

      }
   }

   static class LegacyImpl extends RemoteControlClientCompat {
      public LegacyImpl(Context var1, Object var2) {
         super(var1, var2);
      }
   }

   public static final class PlaybackInfo {
      public int playbackStream = 3;
      public int playbackType = 1;
      public int volume;
      public int volumeHandling = 0;
      public int volumeMax;
   }

   public interface VolumeCallback {
      void onVolumeSetRequest(int var1);

      void onVolumeUpdateRequest(int var1);
   }
}
