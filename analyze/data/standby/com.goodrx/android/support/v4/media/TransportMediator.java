package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.v4.media.TransportController;
import android.support.v4.media.TransportMediatorCallback;
import android.support.v4.media.TransportMediatorJellybeanMR2;
import android.support.v4.media.TransportPerformer;
import android.support.v4.media.TransportStateListener;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.KeyEvent.Callback;
import java.util.ArrayList;

public class TransportMediator extends TransportController {
   public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
   public static final int FLAG_KEY_MEDIA_NEXT = 128;
   public static final int FLAG_KEY_MEDIA_PAUSE = 16;
   public static final int FLAG_KEY_MEDIA_PLAY = 4;
   public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
   public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
   public static final int FLAG_KEY_MEDIA_REWIND = 2;
   public static final int FLAG_KEY_MEDIA_STOP = 32;
   public static final int KEYCODE_MEDIA_PAUSE = 127;
   public static final int KEYCODE_MEDIA_PLAY = 126;
   public static final int KEYCODE_MEDIA_RECORD = 130;
   final AudioManager mAudioManager;
   final TransportPerformer mCallbacks;
   final Context mContext;
   final TransportMediatorJellybeanMR2 mController;
   final Object mDispatcherState;
   final Callback mKeyEventCallback;
   final ArrayList<TransportStateListener> mListeners;
   final TransportMediatorCallback mTransportKeyCallback;
   final View mView;

   public TransportMediator(Activity var1, TransportPerformer var2) {
      this(var1, (View)null, var2);
   }

   private TransportMediator(Activity var1, View var2, TransportPerformer var3) {
      this.mListeners = new ArrayList();
      this.mTransportKeyCallback = new TransportMediatorCallback() {
         public long getPlaybackPosition() {
            return TransportMediator.this.mCallbacks.onGetCurrentPosition();
         }

         public void handleAudioFocusChange(int var1) {
            TransportMediator.this.mCallbacks.onAudioFocusChange(var1);
         }

         public void handleKey(KeyEvent var1) {
            var1.dispatch(TransportMediator.this.mKeyEventCallback);
         }

         public void playbackPositionUpdate(long var1) {
            TransportMediator.this.mCallbacks.onSeekTo(var1);
         }
      };
      this.mKeyEventCallback = new Callback() {
         public boolean onKeyDown(int var1, KeyEvent var2) {
            return TransportMediator.isMediaKey(var1)?TransportMediator.this.mCallbacks.onMediaButtonDown(var1, var2):false;
         }

         public boolean onKeyLongPress(int var1, KeyEvent var2) {
            return false;
         }

         public boolean onKeyMultiple(int var1, int var2, KeyEvent var3) {
            return false;
         }

         public boolean onKeyUp(int var1, KeyEvent var2) {
            return TransportMediator.isMediaKey(var1)?TransportMediator.this.mCallbacks.onMediaButtonUp(var1, var2):false;
         }
      };
      Object var4;
      if(var1 != null) {
         var4 = var1;
      } else {
         var4 = var2.getContext();
      }

      this.mContext = (Context)var4;
      this.mCallbacks = var3;
      this.mAudioManager = (AudioManager)this.mContext.getSystemService("audio");
      if(var1 != null) {
         var2 = var1.getWindow().getDecorView();
      }

      this.mView = var2;
      this.mDispatcherState = KeyEventCompat.getKeyDispatcherState(this.mView);
      if(VERSION.SDK_INT >= 18) {
         this.mController = new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);
      } else {
         this.mController = null;
      }
   }

   public TransportMediator(View var1, TransportPerformer var2) {
      this((Activity)null, var1, var2);
   }

   private TransportStateListener[] getListeners() {
      if(this.mListeners.size() <= 0) {
         return null;
      } else {
         TransportStateListener[] var1 = new TransportStateListener[this.mListeners.size()];
         this.mListeners.toArray(var1);
         return var1;
      }
   }

   static boolean isMediaKey(int var0) {
      switch(var0) {
      case 79:
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
      case 90:
      case 91:
      case 126:
      case 127:
      case 130:
         return true;
      default:
         return false;
      }
   }

   private void pushControllerState() {
      if(this.mController != null) {
         this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
      }

   }

   private void reportPlayingChanged() {
      TransportStateListener[] var1 = this.getListeners();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1[var3].onPlayingChanged(this);
         }
      }

   }

   private void reportTransportControlsChanged() {
      TransportStateListener[] var1 = this.getListeners();
      if(var1 != null) {
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            var1[var3].onTransportControlsChanged(this);
         }
      }

   }

   public void destroy() {
      this.mController.destroy();
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      return KeyEventCompat.dispatch(var1, this.mKeyEventCallback, this.mDispatcherState, this);
   }

   public int getBufferPercentage() {
      return this.mCallbacks.onGetBufferPercentage();
   }

   public long getCurrentPosition() {
      return this.mCallbacks.onGetCurrentPosition();
   }

   public long getDuration() {
      return this.mCallbacks.onGetDuration();
   }

   public Object getRemoteControlClient() {
      return this.mController != null?this.mController.getRemoteControlClient():null;
   }

   public int getTransportControlFlags() {
      return this.mCallbacks.onGetTransportControlFlags();
   }

   public boolean isPlaying() {
      return this.mCallbacks.onIsPlaying();
   }

   public void pausePlaying() {
      if(this.mController != null) {
         this.mController.pausePlaying();
      }

      this.mCallbacks.onPause();
      this.pushControllerState();
      this.reportPlayingChanged();
   }

   public void refreshState() {
      this.pushControllerState();
      this.reportPlayingChanged();
      this.reportTransportControlsChanged();
   }

   public void registerStateListener(TransportStateListener var1) {
      this.mListeners.add(var1);
   }

   public void seekTo(long var1) {
      this.mCallbacks.onSeekTo(var1);
   }

   public void startPlaying() {
      if(this.mController != null) {
         this.mController.startPlaying();
      }

      this.mCallbacks.onStart();
      this.pushControllerState();
      this.reportPlayingChanged();
   }

   public void stopPlaying() {
      if(this.mController != null) {
         this.mController.stopPlaying();
      }

      this.mCallbacks.onStop();
      this.pushControllerState();
      this.reportPlayingChanged();
   }

   public void unregisterStateListener(TransportStateListener var1) {
      this.mListeners.remove(var1);
   }
}
