package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public interface BleApi {
   PendingResult<Status> claimBleDevice(GoogleApiClient var1, BleDevice var2);

   PendingResult<Status> claimBleDevice(GoogleApiClient var1, String var2);

   PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient var1);

   PendingResult<Status> startBleScan(GoogleApiClient var1, StartBleScanRequest var2);

   PendingResult<Status> stopBleScan(GoogleApiClient var1, BleScanCallback var2);

   PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, BleDevice var2);

   PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, String var2);
}
