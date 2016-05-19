package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzmj;

abstract class zzmi<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzmj> {
   public zzmi(GoogleApiClient var1) {
      super(zzmf.zzUI, var1);
   }

   abstract static class zza extends zzmi<Status> {
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
}
