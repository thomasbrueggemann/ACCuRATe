package com.google.android.gms.location.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.internal.zzb;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzk;

public class zzl extends zzb {
   private final zzk zzaOM;

   public zzl(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, com.google.android.gms.common.internal.zzf var6) {
      super(var1, var2, var3, var4, var5, var6);
      this.zzaOM = new zzk(var1, this.zzaOt);
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public Location getLastLocation() {
      return this.zzaOM.getLastLocation();
   }

   public void zza(LocationListener var1, zzg var2) throws RemoteException {
      this.zzaOM.zza(var1, var2);
   }

   public void zza(LocationRequest param1, LocationListener param2, Looper param3, zzg param4) throws RemoteException {
      // $FF: Couldn't be decompiled
   }
}
