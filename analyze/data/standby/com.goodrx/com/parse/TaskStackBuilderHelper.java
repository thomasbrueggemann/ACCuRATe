package com.parse;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;

@TargetApi(16)
class TaskStackBuilderHelper {
   public static void startActivities(Context var0, Class<? extends Activity> var1, Intent var2) {
      TaskStackBuilder var3 = TaskStackBuilder.create(var0);
      var3.addParentStack(var1);
      var3.addNextIntent(var2);
      var3.startActivities();
   }
}
