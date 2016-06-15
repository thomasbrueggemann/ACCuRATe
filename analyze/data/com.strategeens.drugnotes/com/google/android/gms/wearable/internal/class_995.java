package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;

// $FF: renamed from: com.google.android.gms.wearable.internal.av
public final class class_995 {
   // $FF: renamed from: gN (int) com.google.android.gms.common.api.Status
   public static Status method_5491(int var0) {
      return new Status(var0, WearableStatusCodes.getStatusCodeString(var0));
   }
}
