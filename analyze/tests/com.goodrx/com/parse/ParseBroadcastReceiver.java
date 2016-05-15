package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.parse.PLog;
import com.parse.PushService;

public class ParseBroadcastReceiver extends BroadcastReceiver {
   private static final String TAG = "com.parse.ParseBroadcastReceiver";

   public void onReceive(Context var1, Intent var2) {
      PLog.method_359("com.parse.ParseBroadcastReceiver", "received " + var2.getAction());
      PushService.startServiceIfRequired(var1);
   }
}
