package com.comscore.streaming;

import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.class_61;
import com.comscore.streaming.class_62;
import com.comscore.utils.CSLog;
import java.util.HashMap;

// $FF: renamed from: com.comscore.streaming.d
class class_63 extends class_62 {
   // $FF: renamed from: a com.comscore.streaming.StreamSenseState
   // $FF: synthetic field
   final StreamSenseState field_492;
   // $FF: renamed from: b java.util.HashMap
   // $FF: synthetic field
   final HashMap field_493;
   // $FF: renamed from: c com.comscore.streaming.StreamSense
   // $FF: synthetic field
   final StreamSense field_494;

   class_63(StreamSense var1, StreamSenseState var2, HashMap var3) {
      super(var1, (class_61)null);
      this.field_494 = var1;
      this.field_492 = var2;
      this.field_493 = var3;
   }

   public StreamSenseState getNextState() {
      return this.field_492;
   }

   public void run() {
      CSLog.method_372(this.field_494, "Performing delayed transition");
      StreamSense.method_90(this.field_494, this.field_492, this.field_493);
   }
}
