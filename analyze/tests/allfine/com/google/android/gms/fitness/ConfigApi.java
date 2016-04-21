package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public interface ConfigApi {
    PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient var1, DataTypeCreateRequest var2);

    PendingResult<Status> disableFit(GoogleApiClient var1);

    PendingResult<DataTypeResult> readDataType(GoogleApiClient var1, String var2);
}
