package com.comscore.utils;

import com.comscore.utils.ConnectivityChangeReceiver;

// $FF: renamed from: com.comscore.utils.a
class class_20 implements Runnable {
   // $FF: renamed from: a com.comscore.utils.ConnectivityChangeReceiver
   // $FF: synthetic field
   final ConnectivityChangeReceiver field_133;

   class_20(ConnectivityChangeReceiver var1) {
      this.field_133 = var1;
   }

   public void run() {
      this.field_133.method_71(false);
   }
}
