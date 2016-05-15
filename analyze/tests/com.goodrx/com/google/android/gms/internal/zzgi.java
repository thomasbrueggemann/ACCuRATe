package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzgi extends zzgd.zza {
   private final InAppPurchaseListener zzuO;

   public zzgi(InAppPurchaseListener var1) {
      this.zzuO = var1;
   }

   public void zza(zzgc var1) {
      this.zzuO.onInAppPurchaseRequested(new zzgl(var1));
   }
}
