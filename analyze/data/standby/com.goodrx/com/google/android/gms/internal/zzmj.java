package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzml;

public class zzmj extends com.google.android.gms.common.internal.zzj<zzml> {
   public zzmj(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5) {
      super(var1, var2, 39, var3, var4, var5);
   }

   // $FF: synthetic method
   protected IInterface zzW(IBinder var1) {
      return this.zzaW(var1);
   }

   protected zzml zzaW(IBinder var1) {
      return zzml.zza.zzaY(var1);
   }

   public String zzgu() {
      return "com.google.android.gms.common.service.START";
   }

   protected String zzgv() {
      return "com.google.android.gms.common.internal.service.ICommonService";
   }
}
