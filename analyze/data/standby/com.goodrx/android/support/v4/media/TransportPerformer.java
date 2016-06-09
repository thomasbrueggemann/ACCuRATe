package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class TransportPerformer {
   static final int AUDIOFOCUS_GAIN = 1;
   static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
   static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
   static final int AUDIOFOCUS_LOSS = -1;
   static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
   static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

   public void onAudioFocusChange(int var1) {
      byte var2 = 0;
      switch(var1) {
      case -1:
         var2 = 127;
      default:
         if(var2 != 0) {
            long var3 = SystemClock.uptimeMillis();
            this.onMediaButtonDown(var2, new KeyEvent(var3, var3, 0, var2, 0));
            this.onMediaButtonUp(var2, new KeyEvent(var3, var3, 1, var2, 0));
         }

      }
   }

   public int onGetBufferPercentage() {
      return 100;
   }

   public abstract long onGetCurrentPosition();

   public abstract long onGetDuration();

   public int onGetTransportControlFlags() {
      return 60;
   }

   public abstract boolean onIsPlaying();

   public boolean onMediaButtonDown(int var1, KeyEvent var2) {
      switch(var1) {
      case 79:
      case 85:
         if(this.onIsPlaying()) {
            this.onPause();
            return true;
         }

         this.onStart();
         return true;
      case 86:
         this.onStop();
         return true;
      case 126:
         this.onStart();
         return true;
      case 127:
         this.onPause();
         return true;
      default:
         return true;
      }
   }

   public boolean onMediaButtonUp(int var1, KeyEvent var2) {
      return true;
   }

   public abstract void onPause();

   public abstract void onSeekTo(long var1);

   public abstract void onStart();

   public abstract void onStop();
}
