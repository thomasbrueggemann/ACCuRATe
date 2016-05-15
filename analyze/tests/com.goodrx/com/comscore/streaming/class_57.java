package com.comscore.streaming;

import com.comscore.streaming.StreamSenseVideoView;
import java.util.TimerTask;

// $FF: renamed from: com.comscore.streaming.n
class class_57 extends TimerTask {
   // $FF: renamed from: a long
   // $FF: synthetic field
   final long field_485;
   // $FF: renamed from: b com.comscore.streaming.StreamSenseVideoView
   // $FF: synthetic field
   final StreamSenseVideoView field_486;

   class_57(StreamSenseVideoView var1, long var2) {
      this.field_486 = var1;
      this.field_485 = var2;
   }

   public void run() {
      if(StreamSenseVideoView.method_590(this.field_486) != null) {
         long var1 = StreamSenseVideoView.method_573(this.field_486);
         boolean var3;
         if(this.field_485 == var1) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(!StreamSenseVideoView.method_593(this.field_486) || !var3 || StreamSenseVideoView.method_595(this.field_486)) {
            StreamSenseVideoView.method_597(this.field_486);
            StreamSenseVideoView.method_588(this.field_486);
            return;
         }

         StreamSenseVideoView.method_597(this.field_486);
         StreamSenseVideoView.method_599(this.field_486);
      }

   }
}
