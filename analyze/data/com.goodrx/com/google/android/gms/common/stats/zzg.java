package com.google.android.gms.common.stats;

import android.os.Process;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;

public class zzg {
   public static String zza(WakeLock var0, String var1) {
      StringBuilder var2 = (new StringBuilder()).append(String.valueOf((long)Process.myPid() << 32 | (long)System.identityHashCode(var0)));
      if(TextUtils.isEmpty(var1)) {
         var1 = "";
      }

      return var2.append(var1).toString();
   }
}
