package com.google.android.gms.ads.purchase;

import com.google.android.gms.ads.purchase.InAppPurchaseResult;

public interface PlayStorePurchaseListener {
   boolean isValidPurchase(String var1);

   void onInAppPurchaseFinished(InAppPurchaseResult var1);
}
