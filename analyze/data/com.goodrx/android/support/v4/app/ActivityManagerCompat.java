package android.support.v4.app;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityManagerCompatKitKat;

public final class ActivityManagerCompat {
   public static boolean isLowRamDevice(@NonNull ActivityManager var0) {
      return VERSION.SDK_INT >= 19?ActivityManagerCompatKitKat.isLowRamDevice(var0):false;
   }
}
