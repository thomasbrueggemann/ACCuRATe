package com.comscore.utils;

public enum TransmissionMode {
   DEFAULT,
   DISABLED,
   NEVER,
   PIGGYBACK,
   WIFIONLY;

   static {
      TransmissionMode[] var0 = new TransmissionMode[]{DEFAULT, NEVER, WIFIONLY, PIGGYBACK, DISABLED};
   }
}
