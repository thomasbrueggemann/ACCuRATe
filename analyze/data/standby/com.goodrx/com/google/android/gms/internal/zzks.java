package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzku;

public class zzks extends com.google.android.gms.common.internal.zzj<zzku> {
   public zzks(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 74, var3, var4, var5);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzaq(var1);
   }

   protected zzku zzaq(IBinder var1) {
      return zzku.zza.zzas(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.auth.api.accountstatus.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
   }
}
