package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.deviceconnection.features.DeviceFeature;
import com.google.android.gms.deviceconnection.features.class_252;

public class DeviceFeatureBuffer extends DataBuffer<DeviceFeature> {
   public DeviceFeature get(int var1) {
      return new class_252(this.JG, var1);
   }
}
