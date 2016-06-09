package com.comscore.streaming.plugin;

import com.comscore.streaming.StreamSenseState;

// $FF: renamed from: com.comscore.streaming.plugin.b
// $FF: synthetic class
class class_1 {
   // $FF: renamed from: a int[]
   // $FF: synthetic field
   static final int[] field_2 = new int[StreamSenseState.values().length];

   static {
      try {
         field_2[StreamSenseState.BUFFERING.ordinal()] = 1;
      } catch (NoSuchFieldError var7) {
         ;
      }

      try {
         field_2[StreamSenseState.IDLE.ordinal()] = 2;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         field_2[StreamSenseState.PAUSED.ordinal()] = 3;
      } catch (NoSuchFieldError var5) {
         ;
      }

      try {
         field_2[StreamSenseState.PLAYING.ordinal()] = 4;
      } catch (NoSuchFieldError var4) {
         ;
      }
   }
}
