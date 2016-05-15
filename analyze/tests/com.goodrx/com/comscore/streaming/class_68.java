package com.comscore.streaming;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.comscore.streaming.StreamSenseMediaPlayer;

// $FF: renamed from: com.comscore.streaming.j
class class_68 implements OnPreparedListener {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_501;

   class_68(StreamSenseMediaPlayer var1) {
      this.field_501 = var1;
   }

   public void onPrepared(MediaPlayer var1) {
      StreamSenseMediaPlayer.method_603(this.field_501, String.valueOf(this.field_501.getCurrentPosition()));
      if(StreamSenseMediaPlayer.method_632(this.field_501) != null) {
         StreamSenseMediaPlayer.method_632(this.field_501).onPrepared(var1);
      }

   }
}
