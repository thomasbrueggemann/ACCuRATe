package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ActivityCompatJB {
   public static void finishAffinity(Activity var0) {
      var0.finishAffinity();
   }

   public static void startActivity(Context var0, Intent var1, Bundle var2) {
      var0.startActivity(var1, var2);
   }

   public static void startActivityForResult(Activity var0, Intent var1, int var2, Bundle var3) {
      var0.startActivityForResult(var1, var2, var3);
   }
}
