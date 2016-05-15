package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import com.google.android.gms.internal.zzlz;

public class zzmp {
   public static boolean zzk(Context var0, String var1) {
      PackageManager var2 = var0.getPackageManager();

      int var4;
      try {
         var4 = var2.getApplicationInfo(var1, 0).flags;
      } catch (NameNotFoundException var7) {
         return false;
      }

      int var5 = var4 & 2097152;
      boolean var6 = false;
      if(var5 != 0) {
         var6 = true;
      }

      return var6;
   }

   public static boolean zzkr() {
      return com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized() && zzlz.zzpW() == Process.myUid();
   }
}
