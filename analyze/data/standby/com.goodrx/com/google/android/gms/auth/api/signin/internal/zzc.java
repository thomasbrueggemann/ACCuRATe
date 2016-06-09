package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.internal.zza;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.auth.api.signin.internal.zzq;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

public class zzc implements GoogleSignInApi {
   public PendingResult<Status> revokeAccess(final GoogleApiClient var1) {
      zzq.zzaf(var1.getContext()).zznr();
      Iterator var2 = GoogleApiClient.zzoV().iterator();

      while(var2.hasNext()) {
         ((GoogleApiClient)var2.next()).zzoW();
      }

      return var1.zzb((com.google.android.gms.common.api.internal.zza.zza)(new zzc.zza(var1) {
         protected void zza(zzd var1) throws RemoteException {
            ((zzh)var1.zzqJ()).zzc(new zza() {
               public void zzm(Status var1) throws RemoteException {
                  zza((Result)var1);
               }
            }, var1.zznd());
         }

         protected Status zzb(Status var1) {
            return var1;
         }

         // $FF: synthetic method
         protected Result zzc(Status var1) {
            return this.zzb(var1);
         }
      }));
   }

   private abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.zza<R, zzd> {
      public zza(GoogleApiClient var2) {
         super(Auth.zzVx, var2);
      }
   }
}
