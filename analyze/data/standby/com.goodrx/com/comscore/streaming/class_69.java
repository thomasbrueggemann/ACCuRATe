package com.comscore.streaming;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.comscore.streaming.StreamSenseMediaPlayer;

// $FF: renamed from: com.comscore.streaming.i
class class_69 implements OnSeekCompleteListener {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_502;

   class_69(StreamSenseMediaPlayer var1) {
      this.field_502 = var1;
   }

   public void onSeekComplete(MediaPlayer var1) {
      if(StreamSenseMediaPlayer.method_617(this.field_502)) {
         StreamSenseMediaPlayer.method_611(this.field_502, false);
         StreamSenseMediaPlayer.method_614(this.field_502, var1);
      }

      if(StreamSenseMediaPlayer.method_630(this.field_502) != null) {
         StreamSenseMediaPlayer.method_630(this.field_502).onSeekComplete(var1);
      }

   }
}
