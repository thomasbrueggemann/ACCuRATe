package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.class_782;

// $FF: renamed from: com.google.android.gms.internal.mo
public class class_773 implements BleApi {
   // $FF: renamed from: VB com.google.android.gms.common.api.Status
   private static final Status field_3433 = new Status(5007);

   public PendingResult<Status> claimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return new class_782(field_3433);
   }

   public PendingResult<Status> claimBleDevice(GoogleApiClient var1, String var2) {
      return new class_782(field_3433);
   }

   public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient var1) {
      return new class_782(BleDevicesResult.method_3530(field_3433));
   }

   public PendingResult<Status> startBleScan(GoogleApiClient var1, StartBleScanRequest var2) {
      return new class_782(field_3433);
   }

   public PendingResult<Status> stopBleScan(GoogleApiClient var1, BleScanCallback var2) {
      return new class_782(field_3433);
   }

   public PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, BleDevice var2) {
      return new class_782(field_3433);
   }

   public PendingResult<Status> unclaimBleDevice(GoogleApiClient var1, String var2) {
      return new class_782(field_3433);
   }
}
