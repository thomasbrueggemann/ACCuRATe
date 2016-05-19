package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzne;

@zzhb
public class zze {
   public void zza(Context var1, AdOverlayInfoParcel var2, boolean var3) {
      if(var2.zzEJ == 4 && var2.zzEC == null) {
         if(var2.zzEB != null) {
            var2.zzEB.onAdClicked();
         }

         zzr.zzbz().zza(var1, var2.zzEA, var2.zzEI);
      } else {
         Intent var4 = new Intent();
         var4.setClassName(var1, "com.google.android.gms.ads.AdActivity");
         var4.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", var2.zzrl.zzNb);
         var4.putExtra("shouldCallOnOverlayOpened", var3);
         AdOverlayInfoParcel.zza(var4, var2);
         if(!zzne.isAtLeastL()) {
            var4.addFlags(524288);
         }

         if(!(var1 instanceof Activity)) {
            var4.addFlags(268435456);
         }

         zzr.zzbC().zzb(var1, var4);
      }
   }
}
