package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface ActivityRecognitionApi {
   PendingResult<Status> removeActivityUpdates(GoogleApiClient var1, PendingIntent var2);

   PendingResult<Status> requestActivityUpdates(GoogleApiClient var1, long var2, PendingIntent var4);
}
