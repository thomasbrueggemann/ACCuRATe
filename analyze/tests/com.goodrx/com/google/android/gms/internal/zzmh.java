package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.internal.zzml;

public final class zzmh implements zzmg {
   public PendingResult<Status> zzf(final GoogleApiClient var1) {
      return var1.zzb((com.google.android.gms.common.api.internal.zza.zza)(new zzmi.zza(var1) {
         protected void zza(zzmj var1) throws RemoteException {
            ((zzml)var1.zzqJ()).zza(new zzmh.zza(this));
         }
      }));
   }

   private static class zza extends zzme {
      private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

      public zza(com.google.android.gms.common.api.internal.zza.zzb<Status> var1) {
         this.zzamC = var1;
      }

      public void zzcb(int var1) throws RemoteException {
         this.zzamC.zzs(new Status(var1));
      }
   }
}
