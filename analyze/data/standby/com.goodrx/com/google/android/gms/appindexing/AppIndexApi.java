package com.google.android.gms.appindexing;

import android.net.Uri;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface AppIndexApi {
   PendingResult<Status> end(GoogleApiClient var1, Action var2);

   PendingResult<Status> start(GoogleApiClient var1, Action var2);

   @Deprecated
   public static final class AppIndexingLink {
      public final Uri appIndexingUrl;
      public final int viewId;
      public final Uri webUrl;
   }
}
