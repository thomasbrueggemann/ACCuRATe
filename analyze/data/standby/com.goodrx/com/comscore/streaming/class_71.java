package com.comscore.streaming;

import com.comscore.streaming.StreamSenseMediaPlayer;
import java.util.HashMap;
import java.util.TimerTask;

// $FF: renamed from: com.comscore.streaming.k
class class_71 extends TimerTask {
   // $FF: renamed from: a long
   // $FF: synthetic field
   final long field_505;
   // $FF: renamed from: b java.util.HashMap
   // $FF: synthetic field
   final HashMap field_506;
   // $FF: renamed from: c com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_507;

   class_71(StreamSenseMediaPlayer var1, long var2, HashMap var4) {
      this.field_507 = var1;
      this.field_505 = var2;
      this.field_506 = var4;
   }

   public void run() {
      if(StreamSenseMediaPlayer.method_634(this.field_507) - this.field_505 >= 500L) {
         StreamSenseMediaPlayer.method_637(this.field_507);
         StreamSenseMediaPlayer.method_607(this.field_507, this.field_506);
         StreamSenseMediaPlayer.method_639(this.field_507);
      } else {
         StreamSenseMediaPlayer.method_637(this.field_507);
         StreamSenseMediaPlayer.method_615(this.field_507, this.field_506);
      }
   }
}
