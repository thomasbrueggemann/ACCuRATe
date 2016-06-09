package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.ads.internal.client.zzai;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;

@zzhb
public class zzl {
   public static String zzuq = null;
   private zzm zzup;

   public zzl() {
      ClientApi.retainReference();
      if(zzuq != null) {
         try {
            this.zzup = (zzm)zzl.class.getClassLoader().loadClass(zzuq).newInstance();
         } catch (Exception var2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to instantiate ClientApi class.", var2);
            this.zzup = new zzai();
         }
      } else {
         com.google.android.gms.ads.internal.util.client.zzb.zzaK("No client jar implementation found.");
         this.zzup = new zzai();
      }
   }

   @Nullable
   public zzfv createAdOverlay(Activity var1) {
      return this.zzup.createAdOverlay(var1);
   }

   @Nullable
   public zzge createInAppPurchaseManager(Activity var1) {
      return this.zzup.createInAppPurchaseManager(var1);
   }
}
