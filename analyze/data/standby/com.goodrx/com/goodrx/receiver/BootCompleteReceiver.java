package com.goodrx.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.goodrx.receiver.ReminderAlarmReceiver;

public class BootCompleteReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      if("android.intent.action.BOOT_COMPLETED".equals(var2.getAction())) {
         ReminderAlarmReceiver.getInstance().scheduleAlarm(var1);
      }

   }
}
