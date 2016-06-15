package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface Account {
   @Deprecated
   void clearDefaultAccount(GoogleApiClient var1);

   String getAccountName(GoogleApiClient var1);

   PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient var1);
}
