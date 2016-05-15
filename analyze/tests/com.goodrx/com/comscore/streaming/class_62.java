package com.comscore.streaming;

import com.comscore.streaming.StreamSense;
import com.comscore.streaming.StreamSenseState;
import com.comscore.streaming.class_61;

// $FF: renamed from: com.comscore.streaming.f
abstract class class_62 implements Runnable {
   // $FF: renamed from: d com.comscore.streaming.StreamSense
   // $FF: synthetic field
   final StreamSense field_491;

   private class_62(StreamSense var1) {
      this.field_491 = var1;
   }

   // $FF: synthetic method
   class_62(StreamSense var1, class_61 var2) {
      this(var1);
   }

   public abstract StreamSenseState getNextState();
}
