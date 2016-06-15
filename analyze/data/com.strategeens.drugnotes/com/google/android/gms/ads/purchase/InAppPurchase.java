package com.google.android.gms.ads.purchase;

public interface InAppPurchase {
   int RESOLUTION_CANCELED = 2;
   int RESOLUTION_FAILURE = 0;
   int RESOLUTION_INVALID_PRODUCT = 3;
   int RESOLUTION_SUCCESS = 1;

   String getProductId();

   void recordPlayBillingResolution(int var1);

   void recordResolution(int var1);
}
