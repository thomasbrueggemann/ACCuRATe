package com.google.android.gms.wallet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface Payments {
   void changeMaskedWallet(GoogleApiClient var1, String var2, String var3, int var4);

   void checkForPreAuthorization(GoogleApiClient var1, int var2);

   void loadFullWallet(GoogleApiClient var1, FullWalletRequest var2, int var3);

   void loadMaskedWallet(GoogleApiClient var1, MaskedWalletRequest var2, int var3);

   void notifyTransactionStatus(GoogleApiClient var1, NotifyTransactionStatusRequest var2);
}
