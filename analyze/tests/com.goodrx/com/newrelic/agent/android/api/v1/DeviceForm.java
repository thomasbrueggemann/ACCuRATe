package com.newrelic.agent.android.api.v1;

public enum DeviceForm {
   LARGE,
   NORMAL,
   SMALL,
   UNKNOWN,
   XLARGE;

   static {
      DeviceForm[] var0 = new DeviceForm[]{UNKNOWN, SMALL, NORMAL, LARGE, XLARGE};
   }
}
