package com.comscore.streaming;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.comscore.streaming.StreamSenseMediaPlayer;

// $FF: renamed from: com.comscore.streaming.h
class class_66 implements OnInfoListener {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_499;

   class_66(StreamSenseMediaPlayer var1) {
      this.field_499 = var1;
   }

   public boolean onInfo(MediaPlayer var1, int var2, int var3) {
      if(var2 == 701 && !StreamSenseMediaPlayer.method_617(this.field_499) && !StreamSenseMediaPlayer.method_620(this.field_499)) {
         StreamSenseMediaPlayer.method_621(this.field_499);
      } else if(var2 == 702 && !StreamSenseMediaPlayer.method_617(this.field_499) && StreamSenseMediaPlayer.method_620(this.field_499)) {
         StreamSenseMediaPlayer.method_625(this.field_499);
      }

      return StreamSenseMediaPlayer.method_627(this.field_499) != null?StreamSenseMediaPlayer.method_627(this.field_499).onInfo(var1, var2, var3):true;
   }
}
