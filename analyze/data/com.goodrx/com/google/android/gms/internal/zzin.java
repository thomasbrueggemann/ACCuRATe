package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzin extends com.google.android.gms.ads.internal.util.client.zzb {
   // $FF: renamed from: v (java.lang.String) void
   public static void method_33(String var0) {
      if(zzhp()) {
         Log.v("Ads", var0);
      }

   }

   public static boolean zzho() {
      return ((Boolean)zzbt.zzwK.get()).booleanValue();
   }

   private static boolean zzhp() {
      return zzQ(2) && zzho();
   }
}
