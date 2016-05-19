package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Build.VERSION;
import android.support.v4.app.BundleCompatDonut;
import android.support.v4.app.BundleCompatJellybeanMR2;

public final class BundleCompat {
   public static IBinder getBinder(Bundle var0, String var1) {
      return VERSION.SDK_INT >= 18?BundleCompatJellybeanMR2.getBinder(var0, var1):BundleCompatDonut.getBinder(var0, var1);
   }

   public static void putBinder(Bundle var0, String var1, IBinder var2) {
      if(VERSION.SDK_INT >= 18) {
         BundleCompatJellybeanMR2.putBinder(var0, var1, var2);
      } else {
         BundleCompatDonut.putBinder(var0, var1, var2);
      }
   }
}
