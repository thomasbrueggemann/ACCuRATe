package com.google.android.gms.identity.intents;

public interface AddressConstants {
   public interface ErrorCodes {
      int ERROR_CODE_NO_APPLICABLE_ADDRESSES = 555;
   }

   public interface Extras {
      String EXTRA_ADDRESS = "com.google.android.gms.identity.intents.EXTRA_ADDRESS";
      String EXTRA_ERROR_CODE = "com.google.android.gms.identity.intents.EXTRA_ERROR_CODE";
   }

   public interface ResultCodes {
      int RESULT_ERROR = 1;
   }

   public interface Themes {
      int THEME_HOLO_DARK = 0;
      int THEME_HOLO_LIGHT = 1;
   }
}
