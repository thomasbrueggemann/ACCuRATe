package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.Build.VERSION;
import android.os.IBinder.DeathRecipient;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaControllerCompatApi23;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MediaControllerCompat {
   private static final String TAG = "MediaControllerCompat";
   private final MediaControllerCompat.MediaControllerImpl mImpl;
   private final MediaSessionCompat.Token mToken;

   public MediaControllerCompat(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
      if(var2 == null) {
         throw new IllegalArgumentException("sessionToken must not be null");
      } else {
         this.mToken = var2;
         if(VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerCompat.MediaControllerImplApi23(var1, var2);
         } else if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerCompat.MediaControllerImplApi21(var1, var2);
         } else {
            this.mImpl = new MediaControllerCompat.MediaControllerImplBase(this.mToken);
         }
      }
   }

   public MediaControllerCompat(Context var1, MediaSessionCompat var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("session must not be null");
      } else {
         this.mToken = var2.getSessionToken();
         if(VERSION.SDK_INT >= 23) {
            this.mImpl = new MediaControllerCompat.MediaControllerImplApi23(var1, var2);
         } else if(VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerCompat.MediaControllerImplApi21(var1, var2);
         } else {
            this.mImpl = new MediaControllerCompat.MediaControllerImplBase(this.mToken);
         }
      }
   }

   public void adjustVolume(int var1, int var2) {
      this.mImpl.adjustVolume(var1, var2);
   }

   public boolean dispatchMediaButtonEvent(KeyEvent var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("KeyEvent may not be null");
      } else {
         return this.mImpl.dispatchMediaButtonEvent(var1);
      }
   }

   public Bundle getExtras() {
      return this.mImpl.getExtras();
   }

   public long getFlags() {
      return this.mImpl.getFlags();
   }

   public Object getMediaController() {
      return this.mImpl.getMediaController();
   }

   public MediaMetadataCompat getMetadata() {
      return this.mImpl.getMetadata();
   }

   public String getPackageName() {
      return this.mImpl.getPackageName();
   }

   public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
      return this.mImpl.getPlaybackInfo();
   }

   public PlaybackStateCompat getPlaybackState() {
      return this.mImpl.getPlaybackState();
   }

   public List<MediaSessionCompat.QueueItem> getQueue() {
      return this.mImpl.getQueue();
   }

   public CharSequence getQueueTitle() {
      return this.mImpl.getQueueTitle();
   }

   public int getRatingType() {
      return this.mImpl.getRatingType();
   }

   public PendingIntent getSessionActivity() {
      return this.mImpl.getSessionActivity();
   }

   public MediaSessionCompat.Token getSessionToken() {
      return this.mToken;
   }

   public MediaControllerCompat.TransportControls getTransportControls() {
      return this.mImpl.getTransportControls();
   }

   public void registerCallback(MediaControllerCompat.Callback var1) {
      this.registerCallback(var1, (Handler)null);
   }

   public void registerCallback(MediaControllerCompat.Callback var1, Handler var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback cannot be null");
      } else {
         if(var2 == null) {
            var2 = new Handler();
         }

         this.mImpl.registerCallback(var1, var2);
      }
   }

   public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
      if(TextUtils.isEmpty(var1)) {
         throw new IllegalArgumentException("command cannot be null or empty");
      } else {
         this.mImpl.sendCommand(var1, var2, var3);
      }
   }

   public void setVolumeTo(int var1, int var2) {
      this.mImpl.setVolumeTo(var1, var2);
   }

   public void unregisterCallback(MediaControllerCompat.Callback var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("callback cannot be null");
      } else {
         this.mImpl.unregisterCallback(var1);
      }
   }

   public abstract static class Callback implements DeathRecipient {
      private final Object mCallbackObj;
      private MediaControllerCompat.MessageHandler mHandler;
      private boolean mRegistered = false;

      public Callback() {
         if(VERSION.SDK_INT >= 21) {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new MediaControllerCompat.StubApi21());
         } else {
            this.mCallbackObj = new MediaControllerCompat.StubCompat();
         }
      }

      private void setHandler(Handler var1) {
         this.mHandler = new MediaControllerCompat.MessageHandler(var1.getLooper());
      }

      public void binderDied() {
         this.onSessionDestroyed();
      }

      public void onAudioInfoChanged(MediaControllerCompat.PlaybackInfo var1) {
      }

      public void onExtrasChanged(Bundle var1) {
      }

      public void onMetadataChanged(MediaMetadataCompat var1) {
      }

      public void onPlaybackStateChanged(PlaybackStateCompat var1) {
      }

      public void onQueueChanged(List<MediaSessionCompat.QueueItem> var1) {
      }

      public void onQueueTitleChanged(CharSequence var1) {
      }

      public void onSessionDestroyed() {
      }

      public void onSessionEvent(String var1, Bundle var2) {
      }
   }

   private class MessageHandler extends Handler {
      private static final int MSG_DESTROYED = 8;
      private static final int MSG_EVENT = 1;
      private static final int MSG_UPDATE_EXTRAS = 7;
      private static final int MSG_UPDATE_METADATA = 3;
      private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
      private static final int MSG_UPDATE_QUEUE = 5;
      private static final int MSG_UPDATE_QUEUE_TITLE = 6;
      private static final int MSG_UPDATE_VOLUME = 4;

      public MessageHandler(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         if(MediaControllerCompat.super.mRegistered) {
            switch(var1.what) {
            case 1:
               MediaControllerCompat.this.onSessionEvent((String)var1.obj, var1.getData());
               return;
            case 2:
               MediaControllerCompat.this.onPlaybackStateChanged((PlaybackStateCompat)var1.obj);
               return;
            case 3:
               MediaControllerCompat.this.onMetadataChanged((MediaMetadataCompat)var1.obj);
               return;
            case 4:
               MediaControllerCompat.this.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo)var1.obj);
               return;
            case 5:
               MediaControllerCompat.this.onQueueChanged((List)var1.obj);
               return;
            case 6:
               MediaControllerCompat.this.onQueueTitleChanged((CharSequence)var1.obj);
               return;
            case 7:
               MediaControllerCompat.this.onExtrasChanged((Bundle)var1.obj);
               return;
            case 8:
               MediaControllerCompat.this.onSessionDestroyed();
               return;
            default:
            }
         }
      }

      public void post(int var1, Object var2, Bundle var3) {
         Message var4 = this.obtainMessage(var1, var2);
         var4.setData(var3);
         var4.sendToTarget();
      }
   }

   private class StubApi21 implements MediaControllerCompatApi21.Callback {
      private StubApi21() {
      }

      // $FF: synthetic method
      StubApi21(Object var2) {
         this();
      }

      public void onMetadataChanged(Object var1) {
         MediaControllerCompat.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(var1));
      }

      public void onPlaybackStateChanged(Object var1) {
         MediaControllerCompat.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(var1));
      }

      public void onSessionDestroyed() {
         MediaControllerCompat.this.onSessionDestroyed();
      }

      public void onSessionEvent(String var1, Bundle var2) {
         MediaControllerCompat.this.onSessionEvent(var1, var2);
      }
   }

   private class StubCompat extends IMediaControllerCallback.Stub {
      private StubCompat() {
      }

      // $FF: synthetic method
      StubCompat(Object var2) {
         this();
      }

      public void onEvent(String var1, Bundle var2) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(1, var1, var2);
      }

      public void onExtrasChanged(Bundle var1) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(7, var1, (Bundle)null);
      }

      public void onMetadataChanged(MediaMetadataCompat var1) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(3, var1, (Bundle)null);
      }

      public void onPlaybackStateChanged(PlaybackStateCompat var1) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(2, var1, (Bundle)null);
      }

      public void onQueueChanged(List<MediaSessionCompat.QueueItem> var1) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(5, var1, (Bundle)null);
      }

      public void onQueueTitleChanged(CharSequence var1) throws RemoteException {
         MediaControllerCompat.super.mHandler.post(6, var1, (Bundle)null);
      }

      public void onSessionDestroyed() throws RemoteException {
         MediaControllerCompat.super.mHandler.post(8, (Object)null, (Bundle)null);
      }

      public void onVolumeInfoChanged(ParcelableVolumeInfo var1) throws RemoteException {
         MediaControllerCompat.PlaybackInfo var2 = null;
         if(var1 != null) {
            var2 = new MediaControllerCompat.PlaybackInfo(var1.volumeType, var1.audioStream, var1.controlType, var1.maxVolume, var1.currentVolume);
         }

         MediaControllerCompat.super.mHandler.post(4, var2, (Bundle)null);
      }
   }

   interface MediaControllerImpl {
      void adjustVolume(int var1, int var2);

      boolean dispatchMediaButtonEvent(KeyEvent var1);

      Bundle getExtras();

      long getFlags();

      Object getMediaController();

      MediaMetadataCompat getMetadata();

      String getPackageName();

      MediaControllerCompat.PlaybackInfo getPlaybackInfo();

      PlaybackStateCompat getPlaybackState();

      List<MediaSessionCompat.QueueItem> getQueue();

      CharSequence getQueueTitle();

      int getRatingType();

      PendingIntent getSessionActivity();

      MediaControllerCompat.TransportControls getTransportControls();

      void registerCallback(MediaControllerCompat.Callback var1, Handler var2);

      void sendCommand(String var1, Bundle var2, ResultReceiver var3);

      void setVolumeTo(int var1, int var2);

      void unregisterCallback(MediaControllerCompat.Callback var1);
   }

   static class MediaControllerImplApi21 implements MediaControllerCompat.MediaControllerImpl {
      protected final Object mControllerObj;

      public MediaControllerImplApi21(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
         this.mControllerObj = MediaControllerCompatApi21.fromToken(var1, var2.getToken());
         if(this.mControllerObj == null) {
            throw new RemoteException();
         }
      }

      public MediaControllerImplApi21(Context var1, MediaSessionCompat var2) {
         this.mControllerObj = MediaControllerCompatApi21.fromToken(var1, var2.getSessionToken().getToken());
      }

      public void adjustVolume(int var1, int var2) {
         MediaControllerCompatApi21.adjustVolume(this.mControllerObj, var1, var2);
      }

      public boolean dispatchMediaButtonEvent(KeyEvent var1) {
         return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, var1);
      }

      public Bundle getExtras() {
         return MediaControllerCompatApi21.getExtras(this.mControllerObj);
      }

      public long getFlags() {
         return MediaControllerCompatApi21.getFlags(this.mControllerObj);
      }

      public Object getMediaController() {
         return this.mControllerObj;
      }

      public MediaMetadataCompat getMetadata() {
         Object var1 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
         return var1 != null?MediaMetadataCompat.fromMediaMetadata(var1):null;
      }

      public String getPackageName() {
         return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
      }

      public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
         Object var1 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
         return var1 != null?new MediaControllerCompat.PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(var1), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(var1), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(var1), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(var1), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(var1)):null;
      }

      public PlaybackStateCompat getPlaybackState() {
         Object var1 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
         return var1 != null?PlaybackStateCompat.fromPlaybackState(var1):null;
      }

      public List<MediaSessionCompat.QueueItem> getQueue() {
         List var1 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
         ArrayList var2;
         if(var1 == null) {
            var2 = null;
         } else {
            var2 = new ArrayList();
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
               var2.add(MediaSessionCompat.QueueItem.obtain(var3.next()));
            }
         }

         return var2;
      }

      public CharSequence getQueueTitle() {
         return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
      }

      public int getRatingType() {
         return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
      }

      public PendingIntent getSessionActivity() {
         return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
      }

      public MediaControllerCompat.TransportControls getTransportControls() {
         Object var1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
         return var1 != null?new MediaControllerCompat.TransportControlsApi21(var1):null;
      }

      public void registerCallback(MediaControllerCompat.Callback var1, Handler var2) {
         MediaControllerCompatApi21.registerCallback(this.mControllerObj, var1.mCallbackObj, var2);
      }

      public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
         MediaControllerCompatApi21.sendCommand(this.mControllerObj, var1, var2, var3);
      }

      public void setVolumeTo(int var1, int var2) {
         MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, var1, var2);
      }

      public void unregisterCallback(MediaControllerCompat.Callback var1) {
         MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, var1.mCallbackObj);
      }
   }

   static class MediaControllerImplApi23 extends MediaControllerCompat.MediaControllerImplApi21 {
      public MediaControllerImplApi23(Context var1, MediaSessionCompat.Token var2) throws RemoteException {
         super(var1, var2);
      }

      public MediaControllerImplApi23(Context var1, MediaSessionCompat var2) {
         super(var1, var2);
      }

      public MediaControllerCompat.TransportControls getTransportControls() {
         Object var1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
         return var1 != null?new MediaControllerCompat.TransportControlsApi23(var1):null;
      }
   }

   static class MediaControllerImplBase implements MediaControllerCompat.MediaControllerImpl {
      private IMediaSession mBinder;
      private MediaSessionCompat.Token mToken;
      private MediaControllerCompat.TransportControls mTransportControls;

      public MediaControllerImplBase(MediaSessionCompat.Token var1) {
         this.mToken = var1;
         this.mBinder = IMediaSession.Stub.asInterface((IBinder)var1.getToken());
      }

      public void adjustVolume(int var1, int var2) {
         try {
            this.mBinder.adjustVolume(var1, var2, (String)null);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in adjustVolume. " + var4);
         }
      }

      public boolean dispatchMediaButtonEvent(KeyEvent var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("event may not be null.");
         } else {
            try {
               this.mBinder.sendMediaButton(var1);
            } catch (RemoteException var3) {
               Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent. " + var3);
            }

            return false;
         }
      }

      public Bundle getExtras() {
         try {
            Bundle var3 = this.mBinder.getExtras();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getExtras. " + var4);
            return null;
         }
      }

      public long getFlags() {
         try {
            long var3 = this.mBinder.getFlags();
            return var3;
         } catch (RemoteException var5) {
            Log.e("MediaControllerCompat", "Dead object in getFlags. " + var5);
            return 0L;
         }
      }

      public Object getMediaController() {
         return null;
      }

      public MediaMetadataCompat getMetadata() {
         try {
            MediaMetadataCompat var3 = this.mBinder.getMetadata();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getMetadata. " + var4);
            return null;
         }
      }

      public String getPackageName() {
         try {
            String var3 = this.mBinder.getPackageName();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getPackageName. " + var4);
            return null;
         }
      }

      public MediaControllerCompat.PlaybackInfo getPlaybackInfo() {
         try {
            ParcelableVolumeInfo var3 = this.mBinder.getVolumeAttributes();
            MediaControllerCompat.PlaybackInfo var4 = new MediaControllerCompat.PlaybackInfo(var3.volumeType, var3.audioStream, var3.controlType, var3.maxVolume, var3.currentVolume);
            return var4;
         } catch (RemoteException var5) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackInfo. " + var5);
            return null;
         }
      }

      public PlaybackStateCompat getPlaybackState() {
         try {
            PlaybackStateCompat var3 = this.mBinder.getPlaybackState();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getPlaybackState. " + var4);
            return null;
         }
      }

      public List<MediaSessionCompat.QueueItem> getQueue() {
         try {
            List var3 = this.mBinder.getQueue();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getQueue. " + var4);
            return null;
         }
      }

      public CharSequence getQueueTitle() {
         try {
            CharSequence var3 = this.mBinder.getQueueTitle();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getQueueTitle. " + var4);
            return null;
         }
      }

      public int getRatingType() {
         try {
            int var3 = this.mBinder.getRatingType();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getRatingType. " + var4);
            return 0;
         }
      }

      public PendingIntent getSessionActivity() {
         try {
            PendingIntent var3 = this.mBinder.getLaunchPendingIntent();
            return var3;
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in getSessionActivity. " + var4);
            return null;
         }
      }

      public MediaControllerCompat.TransportControls getTransportControls() {
         if(this.mTransportControls == null) {
            this.mTransportControls = new MediaControllerCompat.TransportControlsBase(this.mBinder);
         }

         return this.mTransportControls;
      }

      public void registerCallback(MediaControllerCompat.Callback var1, Handler var2) {
         if(var1 == null) {
            throw new IllegalArgumentException("callback may not be null.");
         } else {
            try {
               this.mBinder.asBinder().linkToDeath(var1, 0);
               this.mBinder.registerCallbackListener((IMediaControllerCallback)var1.mCallbackObj);
               var1.setHandler(var2);
               var1.mRegistered = true;
            } catch (RemoteException var4) {
               Log.e("MediaControllerCompat", "Dead object in registerCallback. " + var4);
               var1.onSessionDestroyed();
            }
         }
      }

      public void sendCommand(String var1, Bundle var2, ResultReceiver var3) {
         try {
            this.mBinder.sendCommand(var1, var2, new MediaSessionCompat.ResultReceiverWrapper(var3));
         } catch (RemoteException var5) {
            Log.e("MediaControllerCompat", "Dead object in sendCommand. " + var5);
         }
      }

      public void setVolumeTo(int var1, int var2) {
         try {
            this.mBinder.setVolumeTo(var1, var2, (String)null);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in setVolumeTo. " + var4);
         }
      }

      public void unregisterCallback(MediaControllerCompat.Callback var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("callback may not be null.");
         } else {
            try {
               this.mBinder.unregisterCallbackListener((IMediaControllerCallback)var1.mCallbackObj);
               this.mBinder.asBinder().unlinkToDeath(var1, 0);
               var1.mRegistered = false;
            } catch (RemoteException var3) {
               Log.e("MediaControllerCompat", "Dead object in unregisterCallback. " + var3);
            }
         }
      }
   }

   public static final class PlaybackInfo {
      public static final int PLAYBACK_TYPE_LOCAL = 1;
      public static final int PLAYBACK_TYPE_REMOTE = 2;
      private final int mAudioStream;
      private final int mCurrentVolume;
      private final int mMaxVolume;
      private final int mPlaybackType;
      private final int mVolumeControl;

      PlaybackInfo(int var1, int var2, int var3, int var4, int var5) {
         this.mPlaybackType = var1;
         this.mAudioStream = var2;
         this.mVolumeControl = var3;
         this.mMaxVolume = var4;
         this.mCurrentVolume = var5;
      }

      public int getAudioStream() {
         return this.mAudioStream;
      }

      public int getCurrentVolume() {
         return this.mCurrentVolume;
      }

      public int getMaxVolume() {
         return this.mMaxVolume;
      }

      public int getPlaybackType() {
         return this.mPlaybackType;
      }

      public int getVolumeControl() {
         return this.mVolumeControl;
      }
   }

   public abstract static class TransportControls {
      public abstract void fastForward();

      public abstract void pause();

      public abstract void play();

      public abstract void playFromMediaId(String var1, Bundle var2);

      public abstract void playFromSearch(String var1, Bundle var2);

      public abstract void playFromUri(Uri var1, Bundle var2);

      public abstract void rewind();

      public abstract void seekTo(long var1);

      public abstract void sendCustomAction(PlaybackStateCompat.CustomAction var1, Bundle var2);

      public abstract void sendCustomAction(String var1, Bundle var2);

      public abstract void setRating(RatingCompat var1);

      public abstract void skipToNext();

      public abstract void skipToPrevious();

      public abstract void skipToQueueItem(long var1);

      public abstract void stop();
   }

   static class TransportControlsApi21 extends MediaControllerCompat.TransportControls {
      protected final Object mControlsObj;

      public TransportControlsApi21(Object var1) {
         this.mControlsObj = var1;
      }

      public void fastForward() {
         MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
      }

      public void pause() {
         MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
      }

      public void play() {
         MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
      }

      public void playFromMediaId(String var1, Bundle var2) {
         MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, var1, var2);
      }

      public void playFromSearch(String var1, Bundle var2) {
         MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, var1, var2);
      }

      public void playFromUri(Uri var1, Bundle var2) {
         if(var1 != null && !Uri.EMPTY.equals(var1)) {
            Bundle var3 = new Bundle();
            var3.putParcelable("android.support.v4.media.session.action.ARGUMENT_URI", var1);
            var3.putParcelable("android.support.v4.media.session.action.ARGUMENT_EXTRAS", var2);
            this.sendCustomAction("android.support.v4.media.session.action.PLAY_FROM_URI", var3);
         } else {
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
         }
      }

      public void rewind() {
         MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
      }

      public void seekTo(long var1) {
         MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, var1);
      }

      public void sendCustomAction(PlaybackStateCompat.CustomAction var1, Bundle var2) {
         MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, var1.getAction(), var2);
      }

      public void sendCustomAction(String var1, Bundle var2) {
         MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, var1, var2);
      }

      public void setRating(RatingCompat var1) {
         Object var2 = this.mControlsObj;
         Object var3;
         if(var1 != null) {
            var3 = var1.getRating();
         } else {
            var3 = null;
         }

         MediaControllerCompatApi21.TransportControls.setRating(var2, var3);
      }

      public void skipToNext() {
         MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
      }

      public void skipToPrevious() {
         MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
      }

      public void skipToQueueItem(long var1) {
         MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, var1);
      }

      public void stop() {
         MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
      }
   }

   static class TransportControlsApi23 extends MediaControllerCompat.TransportControlsApi21 {
      public TransportControlsApi23(Object var1) {
         super(var1);
      }

      public void playFromUri(Uri var1, Bundle var2) {
         MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, var1, var2);
      }
   }

   static class TransportControlsBase extends MediaControllerCompat.TransportControls {
      private IMediaSession mBinder;

      public TransportControlsBase(IMediaSession var1) {
         this.mBinder = var1;
      }

      public void fastForward() {
         try {
            this.mBinder.fastForward();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in fastForward. " + var2);
         }
      }

      public void pause() {
         try {
            this.mBinder.pause();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in pause. " + var2);
         }
      }

      public void play() {
         try {
            this.mBinder.play();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in play. " + var2);
         }
      }

      public void playFromMediaId(String var1, Bundle var2) {
         try {
            this.mBinder.playFromMediaId(var1, var2);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in playFromMediaId. " + var4);
         }
      }

      public void playFromSearch(String var1, Bundle var2) {
         try {
            this.mBinder.playFromSearch(var1, var2);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in playFromSearch. " + var4);
         }
      }

      public void playFromUri(Uri var1, Bundle var2) {
         try {
            this.mBinder.playFromUri(var1, var2);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in playFromUri. " + var4);
         }
      }

      public void rewind() {
         try {
            this.mBinder.rewind();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in rewind. " + var2);
         }
      }

      public void seekTo(long var1) {
         try {
            this.mBinder.seekTo(var1);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in seekTo. " + var4);
         }
      }

      public void sendCustomAction(PlaybackStateCompat.CustomAction var1, Bundle var2) {
         this.sendCustomAction(var1.getAction(), var2);
      }

      public void sendCustomAction(String var1, Bundle var2) {
         try {
            this.mBinder.sendCustomAction(var1, var2);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in sendCustomAction. " + var4);
         }
      }

      public void setRating(RatingCompat var1) {
         try {
            this.mBinder.rate(var1);
         } catch (RemoteException var3) {
            Log.e("MediaControllerCompat", "Dead object in setRating. " + var3);
         }
      }

      public void skipToNext() {
         try {
            this.mBinder.next();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in skipToNext. " + var2);
         }
      }

      public void skipToPrevious() {
         try {
            this.mBinder.previous();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in skipToPrevious. " + var2);
         }
      }

      public void skipToQueueItem(long var1) {
         try {
            this.mBinder.skipToQueueItem(var1);
         } catch (RemoteException var4) {
            Log.e("MediaControllerCompat", "Dead object in skipToQueueItem. " + var4);
         }
      }

      public void stop() {
         try {
            this.mBinder.stop();
         } catch (RemoteException var2) {
            Log.e("MediaControllerCompat", "Dead object in stop. " + var2);
         }
      }
   }
}
