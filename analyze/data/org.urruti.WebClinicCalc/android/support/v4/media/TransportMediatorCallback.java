package android.support.v4.media;

import android.view.KeyEvent;

interface TransportMediatorCallback {
   long getPlaybackPosition();

   void handleAudioFocusChange(int var1);

   void handleKey(KeyEvent var1);

   void playbackPositionUpdate(long var1);
}
