package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzj extends zzw.zza {
   private final AppEventListener zzun;

   public zzj(AppEventListener var1) {
      this.zzun = var1;
   }

   public void onAppEvent(String var1, String var2) {
      this.zzun.onAppEvent(var1, var2);
   }
}
