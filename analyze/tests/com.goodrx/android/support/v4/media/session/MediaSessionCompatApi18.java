package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompatApi14;
import android.util.Log;

class MediaSessionCompatApi18 {
   private static final long ACTION_SEEK_TO = 256L;
   private static final String TAG = "MediaSessionCompatApi18";
   private static boolean sIsMbrPendingIntentSupported = true;

   public static Object createPlaybackPositionUpdateListener(MediaSessionCompatApi18.Callback var0) {
      return new MediaSessionCompatApi18.OnPlaybackPositionUpdateListener(var0);
   }

   static int getRccTransportControlFlagsFromActions(long var0) {
      int var2 = MediaSessionCompatApi14.getRccTransportControlFlagsFromActions(var0);
      if((256L & var0) != 0L) {
         var2 |= 256;
      }

      return var2;
   }

   public static void registerMediaButtonEventReceiver(Context var0, PendingIntent var1, ComponentName var2) {
      AudioManager var3 = (AudioManager)var0.getSystemService("audio");
      if(sIsMbrPendingIntentSupported) {
         try {
            var3.registerMediaButtonEventReceiver(var1);
         } catch (NullPointerException var5) {
            Log.w("MediaSessionCompatApi18", "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
            sIsMbrPendingIntentSupported = false;
         }
      }

      if(!sIsMbrPendingIntentSupported) {
         var3.registerMediaButtonEventReceiver(var2);
      }

   }

   public static void setOnPlaybackPositionUpdateListener(Object var0, Object var1) {
      ((RemoteControlClient)var0).setPlaybackPositionUpdateListener((android.media.RemoteControlClient.OnPlaybackPositionUpdateListener)var1);
   }

   public static void setState(Object var0, int var1, long var2, float var4, long var5) {
      long var7 = SystemClock.elapsedRealtime();
      if(var1 == 3 && var2 > 0L) {
         long var10 = 0L;
         if(var5 > 0L) {
            var10 = var7 - var5;
            if(var4 > 0.0F && var4 != 1.0F) {
               var10 = (long)(var4 * (float)var10);
            }
         }

         var2 += var10;
      }

      int var9 = MediaSessionCompatApi14.getRccStateFromState(var1);
      ((RemoteControlClient)var0).setPlaybackState(var9, var2, var4);
   }

   public static void setTransportControlFlags(Object var0, long var1) {
      ((RemoteControlClient)var0).setTransportControlFlags(getRccTransportControlFlagsFromActions(var1));
   }

   public static void unregisterMediaButtonEventReceiver(Context var0, PendingIntent var1, ComponentName var2) {
      AudioManager var3 = (AudioManager)var0.getSystemService("audio");
      if(sIsMbrPendingIntentSupported) {
         var3.unregisterMediaButtonEventReceiver(var1);
      } else {
         var3.unregisterMediaButtonEventReceiver(var2);
      }
   }

   interface Callback {
      void onSeekTo(long var1);
   }

   static class OnPlaybackPositionUpdateListener<T extends MediaSessionCompatApi18.Callback> implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener {
      protected final T mCallback;

      public OnPlaybackPositionUpdateListener(T var1) {
         this.mCallback = var1;
      }

      public void onPlaybackPositionUpdate(long var1) {
         this.mCallback.onSeekTo(var1);
      }
   }
}
