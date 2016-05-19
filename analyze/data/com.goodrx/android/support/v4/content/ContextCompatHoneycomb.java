package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

class ContextCompatHoneycomb {
   public static File getObbDir(Context var0) {
      return var0.getObbDir();
   }

   static void startActivities(Context var0, Intent[] var1) {
      var0.startActivities(var1);
   }
}
