package com.comscore.metrics;

import com.comscore.utils.TransmissionMode;

// $FF: renamed from: com.comscore.metrics.a
// $FF: synthetic class
class class_55 {
   // $FF: renamed from: a int[]
   // $FF: synthetic field
   static final int[] field_460 = new int[TransmissionMode.values().length];

   static {
      try {
         field_460[TransmissionMode.NEVER.ordinal()] = 1;
      } catch (NoSuchFieldError var9) {
         ;
      }

      try {
         field_460[TransmissionMode.DISABLED.ordinal()] = 2;
      } catch (NoSuchFieldError var8) {
         ;
      }

      try {
         field_460[TransmissionMode.DEFAULT.ordinal()] = 3;
      } catch (NoSuchFieldError var7) {
         ;
      }

      try {
         field_460[TransmissionMode.WIFIONLY.ordinal()] = 4;
      } catch (NoSuchFieldError var6) {
         ;
      }

      try {
         field_460[TransmissionMode.PIGGYBACK.ordinal()] = 5;
      } catch (NoSuchFieldError var5) {
         ;
      }
   }
}
