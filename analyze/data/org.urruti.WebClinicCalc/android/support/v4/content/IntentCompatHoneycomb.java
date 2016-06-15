package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class IntentCompatHoneycomb {
   public static Intent makeMainActivity(ComponentName var0) {
      return Intent.makeMainActivity(var0);
   }

   public static Intent makeRestartActivityTask(ComponentName var0) {
      return Intent.makeRestartActivityTask(var0);
   }
}
