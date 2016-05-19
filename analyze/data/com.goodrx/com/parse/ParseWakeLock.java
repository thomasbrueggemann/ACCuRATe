package com.parse;

import android.content.Context;
import android.os.PowerManager.WakeLock;

class ParseWakeLock {
   private static final String TAG = "com.parse.ParseWakeLock";
   private static volatile boolean hasWakeLockPermission = true;
   private final WakeLock wakeLock;

   private ParseWakeLock(WakeLock var1) {
      this.wakeLock = var1;
   }

   public static ParseWakeLock acquireNewWakeLock(Context param0, int param1, String param2, long param3) {
      // $FF: Couldn't be decompiled
   }

   public void release() {
      if(this.wakeLock != null) {
         this.wakeLock.release();
      }

   }
}
