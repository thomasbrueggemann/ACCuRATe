package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.util.concurrent.Callable;

public class zzpl {
   public static <T> T zzb(Callable<T> var0) {
      ThreadPolicy var1 = StrictMode.getThreadPolicy();

      try {
         StrictMode.setThreadPolicy(ThreadPolicy.LAX);
         Object var4 = var0.call();
         return var4;
      } catch (Throwable var7) {
         ;
      } finally {
         StrictMode.setThreadPolicy(var1);
      }

      return null;
   }
}
