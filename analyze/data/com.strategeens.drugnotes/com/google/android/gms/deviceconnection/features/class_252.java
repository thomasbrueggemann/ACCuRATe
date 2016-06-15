package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.deviceconnection.features.DeviceFeature;
import com.google.android.gms.internal.class_336;

// $FF: renamed from: com.google.android.gms.deviceconnection.features.a
public final class class_252 extends class_251 implements DeviceFeature {
   public class_252(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getFeatureName() {
      return this.getString("feature_name");
   }

   public long getLastConnectionTimestampMillis() {
      return this.getLong("last_connection_timestamp");
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("FeatureName", this.getFeatureName()).method_3424("Timestamp", Long.valueOf(this.getLastConnectionTimestampMillis())).toString();
   }
}
