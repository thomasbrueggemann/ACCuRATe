package android.support.v4.app;

import android.app.ActivityManager;

class ActivityManagerCompatKitKat {
   public static boolean isLowRamDevice(ActivityManager var0) {
      return var0.isLowRamDevice();
   }
}
