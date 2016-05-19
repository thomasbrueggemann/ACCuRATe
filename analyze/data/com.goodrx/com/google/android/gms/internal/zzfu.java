package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzfu extends com.google.android.gms.dynamic.zzg<zzfw> {
   private static final zzfu zzFp = new zzfu();

   private zzfu() {
      super("com.google.android.gms.ads.AdOverlayCreatorImpl");
   }

   @Nullable
   public static zzfv createAdOverlay(Activity param0) {
      // $FF: Couldn't be decompiled
   }

   private static boolean zzb(Activity var0) throws zzfu.zza {
      Intent var1 = var0.getIntent();
      if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
         throw new zzfu.zza("Ad overlay requires the useClientJar flag in intent extras.");
      } else {
         return var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
      }
   }

   private zzfv zzc(Activity var1) {
      try {
         com.google.android.gms.dynamic.zzd var4 = com.google.android.gms.dynamic.zze.zzC(var1);
         zzfv var5 = zzfv.zza.zzL(((zzfw)this.zzaB(var1)).zze(var4));
         return var5;
      } catch (RemoteException var6) {
         com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", var6);
         return null;
      } catch (com.google.android.gms.dynamic.zzg.zza var7) {
         com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", var7);
         return null;
      }
   }

   protected zzfw zzK(IBinder var1) {
      return zzfw.zza.zzM(var1);
   }

   // $FF: synthetic method
   protected Object zzd(IBinder var1) {
      return this.zzK(var1);
   }

   private static final class zza extends Exception {
      public zza(String var1) {
         super(var1);
      }
   }
}
