package android.support.v4.app;

import android.app.Activity;

class ActivityCompatApi23 {
   public static void requestPermissions(Activity var0, String[] var1, int var2) {
      if(var0 instanceof ActivityCompatApi23.RequestPermissionsRequestCodeValidator) {
         ((ActivityCompatApi23.RequestPermissionsRequestCodeValidator)var0).validateRequestPermissionsRequestCode(var2);
      }

      var0.requestPermissions(var1, var2);
   }

   public static boolean shouldShowRequestPermissionRationale(Activity var0, String var1) {
      return var0.shouldShowRequestPermissionRationale(var1);
   }

   public interface RequestPermissionsRequestCodeValidator {
      void validateRequestPermissionsRequestCode(int var1);
   }
}
