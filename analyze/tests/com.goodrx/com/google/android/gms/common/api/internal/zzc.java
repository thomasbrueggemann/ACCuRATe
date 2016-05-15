package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzl;

public class zzc implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   public final Api<?> zzagT;
   private final int zzagU;
   private zzl zzagV;

   public zzc(Api<?> var1, int var2) {
      this.zzagT = var1;
      this.zzagU = var2;
   }

   private void zzpi() {
      com.google.android.gms.common.internal.zzx.zzb(this.zzagV, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
   }

   public void onConnected(@Nullable Bundle var1) {
      this.zzpi();
      this.zzagV.onConnected(var1);
   }

   public void onConnectionFailed(@NonNull ConnectionResult var1) {
      this.zzpi();
      this.zzagV.zza(var1, this.zzagT, this.zzagU);
   }

   public void onConnectionSuspended(int var1) {
      this.zzpi();
      this.zzagV.onConnectionSuspended(var1);
   }

   public void zza(zzl var1) {
      this.zzagV = var1;
   }
}
