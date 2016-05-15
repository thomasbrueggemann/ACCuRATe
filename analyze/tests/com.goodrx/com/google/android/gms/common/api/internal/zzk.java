package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zza;

public interface zzk {
   void begin();

   void connect();

   boolean disconnect();

   void onConnected(Bundle var1);

   void onConnectionSuspended(int var1);

   <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T var1);

   void zza(ConnectionResult var1, Api<?> var2, int var3);

   <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T var1);
}
