package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

@zzhb
public final class zzgj extends com.google.android.gms.dynamic.zzg<zzgf> {
   private static final zzgj zzGa = new zzgj();

   private zzgj() {
      super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
   }

   @Nullable
   public static zzge createInAppPurchaseManager(Activity param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean zzb(Activity var0) throws zzgj.zza {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
         throw new zzgj.zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
      }
   }

   private zzge zzd(Activity var1) {
      try {
         com.google.android.gms.dynamic.zzd var4 = com.google.android.gms.dynamic.zze.zzC(var1);
         zzge var5 = zzge.zza.zzQ(((zzgf)this.zzaB(var1)).zzf(var4));
         return var5;
      } catch (RemoteException var6) {
         zzin.zzd("Could not create remote InAppPurchaseManager.", var6);
         return null;
      } catch (com.google.android.gms.dynamic.zzg.zza var7) {
         zzin.zzd("Could not create remote InAppPurchaseManager.", var7);
         return null;
      }
   }

   protected zzgf zzU(IBinder var1) {
      return zzgf.zza.zzR(var1);
   }

   // $FF: synthetic method
   protected Object zzd(IBinder var1) {
      return this.zzU(var1);
   }

   private static final class zza extends Exception {
      public zza(String var1) {
         super(var1);
      }
   }
}
