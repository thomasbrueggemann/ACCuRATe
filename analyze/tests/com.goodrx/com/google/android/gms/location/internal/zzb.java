package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.internal.zzi;
import com.google.android.gms.location.internal.zzp;

public class zzb extends com.google.android.gms.common.internal.zzj<zzi> {
   private final String zzaOs;
   protected final zzp<zzi> zzaOt = new zzp() {
      public void zzqI() {
         zzb.this.zzqI();
      }

      // $FF: synthetic method
      public IInterface zzqJ() throws DeadObjectException {
         return this.zzyM();
      }

      public zzi zzyM() throws DeadObjectException {
         return (zzi)zzb.this.zzqJ();
      }
   };

   public zzb(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, com.google.android.gms.common.internal.zzf var6) {
      super(var1, var2, 23, var6, var3, var4);
      this.zzaOs = var5;
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzcg(var1);
   }

   protected zzi zzcg(IBinder var1) {
      return zzi.zza.zzcj(var1);
   }

   protected String zzgu() {
      return "com.google.android.location.internal.GoogleLocationManagerService.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
   }

   protected Bundle zzml() {
      Bundle var1 = new Bundle();
      var1.putString("client_name", this.zzaOs);
      return var1;
   }
}
