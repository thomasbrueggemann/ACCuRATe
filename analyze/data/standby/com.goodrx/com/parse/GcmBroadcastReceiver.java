package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.parse.PushService;
import com.parse.ServiceUtils;

public class GcmBroadcastReceiver extends BroadcastReceiver {
   public final void onReceive(Context var1, Intent var2) {
      ServiceUtils.runWakefulIntentInService(var1, var2, PushService.class);
   }
}
