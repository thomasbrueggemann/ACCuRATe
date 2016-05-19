package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.api.internal.zzl;
import java.util.Collections;

public class zzi implements zzk {
   private final zzl zzahj;

   public zzi(zzl var1) {
      this.zzahj = var1;
   }

   public void begin() {
      this.zzahj.zzpM();
      this.zzahj.zzagW.zzahU = Collections.emptySet();
   }

   public void connect() {
      this.zzahj.zzpK();
   }

   public boolean disconnect() {
      return true;
   }

   public void onConnected(Bundle var1) {
   }

   public void onConnectionSuspended(int var1) {
   }

   public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T var1) {
      this.zzahj.zzagW.zzahN.add(var1);
      return var1;
   }

   public void zza(ConnectionResult var1, Api<?> var2, int var3) {
   }

   public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T var1) {
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
   }
}
