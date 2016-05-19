package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class ContextCompatJellybean {
   public static void startActivities(Context var0, Intent[] var1, Bundle var2) {
      var0.startActivities(var1, var2);
   }
}
