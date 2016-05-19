package com.comscore.streaming;

import com.comscore.streaming.StreamSenseVideoView;
import com.comscore.utils.CSLog;
import java.util.HashMap;
import java.util.TimerTask;

// $FF: renamed from: com.comscore.streaming.m
class class_56 extends TimerTask {
   // $FF: renamed from: a long
   // $FF: synthetic field
   final long field_482;
   // $FF: renamed from: b java.util.HashMap
   // $FF: synthetic field
   final HashMap field_483;
   // $FF: renamed from: c com.comscore.streaming.StreamSenseVideoView
   // $FF: synthetic field
   final StreamSenseVideoView field_484;

   class_56(StreamSenseVideoView var1, long var2, HashMap var4) {
      this.field_484 = var1;
      this.field_482 = var2;
      this.field_483 = var4;
   }

   public void run() {
      CSLog.method_372("StreamSenseVideoView", "startEventTimer -> lastPosition:" + this.field_482 + " currentPosition:" + StreamSenseVideoView.method_573(this.field_484));
      long var1 = Long.parseLong((String)this.field_483.get("ns_ts"));
      long var3 = StreamSenseVideoView.method_573(this.field_484) - this.field_482;
      long var5 = System.currentTimeMillis() - var1;
      if(var3 >= 500L) {
         long var8 = var5 - var3;
         if(var8 > 0L) {
            StreamSenseVideoView.method_574(this.field_484, var8);
            CSLog.method_372("StreamSenseVideoView", "addToBufferingTotal=" + var8);
            this.field_483.put("ns_ts", String.valueOf(var1 + var8));
         }

         this.field_483.put("ns_st_bt", String.valueOf(StreamSenseVideoView.method_582(this.field_484)));
         StreamSenseVideoView.method_587(this.field_484);
         StreamSenseVideoView.method_578(this.field_484, this.field_483, StreamSenseVideoView.method_573(this.field_484));
         StreamSenseVideoView.method_588(this.field_484);
      } else {
         StreamSenseVideoView.method_587(this.field_484);
         StreamSenseVideoView.method_577(this.field_484, this.field_483);
      }
   }
}
