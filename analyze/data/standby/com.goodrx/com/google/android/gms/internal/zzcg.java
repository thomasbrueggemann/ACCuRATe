package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzcg extends zzcf.zza {
   private final OnCustomRenderedAdLoadedListener zzuQ;

   public zzcg(OnCustomRenderedAdLoadedListener var1) {
      this.zzuQ = var1;
   }

   public void zza(zzce var1) {
      this.zzuQ.onCustomRenderedAdLoaded(new zzcd(var1));
   }
}
