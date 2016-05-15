package com.google.android.gms.location.internal;

import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.internal.FusedLocationProviderResult;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzl;

public class zzd implements FusedLocationProviderApi {
   public Location getLastLocation(GoogleApiClient var1) {
      zzl var2 = LocationServices.zzi(var1);

      try {
         Location var4 = var2.getLastLocation();
         return var4;
      } catch (Exception var5) {
         return null;
      }
   }

   public PendingResult<Status> removeLocationUpdates(final GoogleApiClient var1, final LocationListener var2) {
      return var1.zzb((com.google.android.gms.common.api.internal.zza.zza)(new zzd.zza(var1) {
         protected void zza(zzl var1) throws RemoteException {
            zzd.zzb var2x = new zzd.zzb(this);
            var1.zza(var2, var2x);
         }
      }));
   }

   public PendingResult<Status> requestLocationUpdates(final GoogleApiClient var1, final LocationRequest var2, final LocationListener var3) {
      return var1.zzb((com.google.android.gms.common.api.internal.zza.zza)(new zzd.zza(var1) {
         protected void zza(zzl var1) throws RemoteException {
            zzd.zzb var2x = new zzd.zzb(this);
            var1.zza(var2, var3, (Looper)null, var2x);
         }
      }));
   }

   private abstract static class zza extends LocationServices.zza<Status> {
      public zza(GoogleApiClient var1) {
         super(var1);
      }

      public Status zzb(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result zzc(Status var1) {
         return this.zzb(var1);
      }
   }

   private static class zzb extends zzg.zza {
      private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

      public zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> var1) {
         this.zzamC = var1;
      }

      public void zza(FusedLocationProviderResult var1) {
         this.zzamC.zzs(var1.getStatus());
      }
   }
}
