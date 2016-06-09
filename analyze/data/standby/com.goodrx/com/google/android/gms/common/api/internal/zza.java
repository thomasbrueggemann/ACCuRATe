package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzb;
import com.google.android.gms.common.api.internal.zzj;
import java.util.concurrent.atomic.AtomicReference;

public class zza {
   public abstract static class zza<R extends Result, A extends Api.zzb> extends zzb<R> implements zza.zzb<R>, zzj.zze<A> {
      private final Api.zzc<A> zzaeE;
      private AtomicReference<zzj.zzd> zzagH = new AtomicReference();

      protected zza(Api.zzc<A> var1, GoogleApiClient var2) {
         super((GoogleApiClient)com.google.android.gms.common.internal.zzx.zzb(var2, "GoogleApiClient must not be null"));
         this.zzaeE = (Api.zzc)com.google.android.gms.common.internal.zzx.zzz(var1);
      }

      private void zza(RemoteException var1) {
         this.zzw(new Status(8, var1.getLocalizedMessage(), (PendingIntent)null));
      }

      protected abstract void zza(A var1) throws RemoteException;

      public void zza(zzj.zzd var1) {
         this.zzagH.set(var1);
      }

      public final void zzb(A var1) throws DeadObjectException {
         try {
            this.zza(var1);
         } catch (DeadObjectException var4) {
            this.zza((RemoteException)var4);
            throw var4;
         } catch (RemoteException var5) {
            this.zza(var5);
         }
      }

      public final Api.zzc<A> zzoR() {
         return this.zzaeE;
      }

      public void zzpe() {
         this.setResultCallback((ResultCallback)null);
      }

      protected void zzpf() {
         zzj.zzd var1 = (zzj.zzd)this.zzagH.getAndSet((Object)null);
         if(var1 != null) {
            var1.zzc(this);
         }

      }

      // $FF: synthetic method
      public void zzs(Object var1) {
         super.zza((Result)var1);
      }

      public final void zzw(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         com.google.android.gms.common.internal.zzx.zzb(var2, "Failed result must not be success");
         this.zza((Result)this.zzc(var1));
      }
   }

   public interface zzb<R> {
      void zzs(R var1);
   }
}
