package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzkf;

public class zzki extends com.google.android.gms.common.internal.zzj<zzkf> {
   public zzki(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 19, var3, var4, var5);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzai(var1);
   }

   protected zzkf zzai(IBinder var1) {
      return zzkf.zza.zzag(var1);
   }

   protected String zzgu() {
      return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
   }

   protected String zzgv() {
      return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
   }

   public zzkf zzmj() throws DeadObjectException {
      return (zzkf)this.zzqJ();
   }
}
