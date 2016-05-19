package com.comscore.streaming;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.comscore.streaming.StreamSenseVideoView;

// $FF: renamed from: com.comscore.streaming.o
class class_58 implements OnCompletionListener {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseVideoView
   // $FF: synthetic field
   final StreamSenseVideoView field_487;

   class_58(StreamSenseVideoView var1) {
      this.field_487 = var1;
   }

   public void onCompletion(MediaPlayer var1) {
      StreamSenseVideoView.method_576(this.field_487, var1);
      if(StreamSenseVideoView.method_600(this.field_487) != null) {
         StreamSenseVideoView.method_600(this.field_487).onCompletion(var1);
      }

   }
}
