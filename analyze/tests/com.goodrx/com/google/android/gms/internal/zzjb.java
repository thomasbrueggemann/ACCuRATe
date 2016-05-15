package com.google.android.gms.internal;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import java.util.concurrent.Callable;

@zzhb
public class zzjb {
   public static <T> T zzb(Callable<T> var0) {
      ThreadPolicy var1 = StrictMode.getThreadPolicy();

      try {
         StrictMode.setThreadPolicy((new Builder(var1)).permitDiskReads().permitDiskWrites().build());
         Object var4 = var0.call();
         return var4;
      } catch (Throwable var7) {
         zzin.zzb("Unexpected exception.", var7);
         com.google.android.gms.ads.internal.zzr.zzbF().zzb(var7, true);
      } finally {
         StrictMode.setThreadPolicy(var1);
      }

      return null;
   }
}
