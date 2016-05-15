package com.google.android.gms.ads.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;

public class ClientApi implements zzm {
   public static void retainReference() {
      com.google.android.gms.ads.internal.client.zzl.zzuq = ClientApi.class.getName();
   }

   public zzfv createAdOverlay(Activity var1) {
      return new com.google.android.gms.ads.internal.overlay.zzd(var1);
   }

   public zzge createInAppPurchaseManager(Activity var1) {
      return new com.google.android.gms.ads.internal.purchase.zze(var1);
   }
}
