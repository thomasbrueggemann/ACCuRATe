package com.comscore.streaming;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.comscore.streaming.StreamSenseMediaPlayer;

// $FF: renamed from: com.comscore.streaming.g
class class_67 implements OnCompletionListener {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_500;

   class_67(StreamSenseMediaPlayer var1) {
      this.field_500 = var1;
   }

   public void onCompletion(MediaPlayer var1) {
      StreamSenseMediaPlayer.method_606(this.field_500, var1);
      if(StreamSenseMediaPlayer.method_602(this.field_500) != null) {
         StreamSenseMediaPlayer.method_602(this.field_500).onCompletion(var1);
      }

   }
}
