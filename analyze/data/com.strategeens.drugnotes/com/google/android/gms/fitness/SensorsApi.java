package com.google.android.gms.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public interface SensorsApi {
   PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, PendingIntent var3);

   PendingResult<Status> add(GoogleApiClient var1, SensorRequest var2, OnDataPointListener var3);

   PendingResult<DataSourcesResult> findDataSources(GoogleApiClient var1, DataSourcesRequest var2);

   PendingResult<Status> remove(GoogleApiClient var1, PendingIntent var2);

   PendingResult<Status> remove(GoogleApiClient var1, OnDataPointListener var2);
}
