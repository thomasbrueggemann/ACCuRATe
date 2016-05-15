package com.comscore.streaming;

import com.comscore.streaming.StreamSenseMediaPlayer;
import java.util.TimerTask;

// $FF: renamed from: com.comscore.streaming.l
class class_70 extends TimerTask {
   // $FF: renamed from: a long
   // $FF: synthetic field
   final long field_503;
   // $FF: renamed from: b com.comscore.streaming.StreamSenseMediaPlayer
   // $FF: synthetic field
   final StreamSenseMediaPlayer field_504;

   class_70(StreamSenseMediaPlayer var1, long var2) {
      this.field_504 = var1;
      this.field_503 = var2;
   }

   public void run() {
      if(StreamSenseMediaPlayer.method_640(this.field_504) != null) {
         long var1 = StreamSenseMediaPlayer.method_634(this.field_504);
         boolean var3;
         if(this.field_503 == var1) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(StreamSenseMediaPlayer.method_643(this.field_504) && !this.field_504.isPlayerPausedForSeeking() && var3 && !this.field_504.isPlayerPausedForBuffering()) {
            StreamSenseMediaPlayer.method_621(this.field_504);
         } else if(StreamSenseMediaPlayer.method_643(this.field_504) && !this.field_504.isPlayerPausedForSeeking() && !var3 && this.field_504.isPlayerPausedForBuffering()) {
            StreamSenseMediaPlayer.method_625(this.field_504);
         }

         StreamSenseMediaPlayer.method_645(this.field_504);
         StreamSenseMediaPlayer.method_639(this.field_504);
      }

   }
}
