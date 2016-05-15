package com.nostra13.universalimageloader.core.assist;

public class FailReason {
   private final Throwable cause;
   private final FailReason.FailType type;

   public FailReason(FailReason.FailType var1, Throwable var2) {
      this.type = var1;
      this.cause = var2;
   }

   public static enum FailType {
      DECODING_ERROR,
      IO_ERROR,
      NETWORK_DENIED,
      OUT_OF_MEMORY,
      UNKNOWN;

      static {
         FailReason.FailType[] var0 = new FailReason.FailType[]{IO_ERROR, DECODING_ERROR, NETWORK_DENIED, OUT_OF_MEMORY, UNKNOWN};
      }
   }
}
