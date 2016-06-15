package com.google.ads;

@Deprecated
public final class AdRequest {
   public static final String LOGTAG = "Ads";
   public static final String TEST_EMULATOR;
   public static final String VERSION = "0.0.0";

   static {
      TEST_EMULATOR = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
   }

   public static enum ErrorCode {
      INTERNAL_ERROR("There was an internal error."),
      INVALID_REQUEST("Invalid Ad request."),
      NETWORK_ERROR("A network error occurred."),
      NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory.");

      private final String description;

      static {
         AdRequest.ErrorCode[] var0 = new AdRequest.ErrorCode[]{INVALID_REQUEST, NO_FILL, NETWORK_ERROR, INTERNAL_ERROR};
      }

      private ErrorCode(String var3) {
         this.description = var3;
      }

      public String toString() {
         return this.description;
      }
   }

   public static enum Gender {
      FEMALE,
      MALE,
      UNKNOWN;

      static {
         AdRequest.Gender[] var0 = new AdRequest.Gender[]{UNKNOWN, MALE, FEMALE};
      }
   }
}
