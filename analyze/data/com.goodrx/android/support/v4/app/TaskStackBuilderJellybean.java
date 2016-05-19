package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class TaskStackBuilderJellybean {
   public static PendingIntent getActivitiesPendingIntent(Context var0, int var1, Intent[] var2, int var3, Bundle var4) {
      return PendingIntent.getActivities(var0, var1, var2, var3, var4);
   }
}
