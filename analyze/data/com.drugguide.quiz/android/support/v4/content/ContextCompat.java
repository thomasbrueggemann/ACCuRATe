package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompatHoneycomb;
import android.support.v4.content.ContextCompatJellybean;

public class ContextCompat {
   public static boolean startActivities(Context var0, Intent[] var1) {
      return startActivities(var0, var1, (Bundle)null);
   }

   public static boolean startActivities(Context var0, Intent[] var1, Bundle var2) {
      int var3 = VERSION.SDK_INT;
      if(var3 >= 16) {
         ContextCompatJellybean.startActivities(var0, var1, var2);
         return true;
      } else if(var3 >= 11) {
         ContextCompatHoneycomb.startActivities(var0, var1);
         return true;
      } else {
         return false;
      }
   }
}
