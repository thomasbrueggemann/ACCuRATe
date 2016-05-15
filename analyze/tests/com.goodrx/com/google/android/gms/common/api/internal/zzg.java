package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.api.internal.zzx;
import java.util.Iterator;

public class zzg implements zzk {
   private final zzl zzahj;
   private boolean zzahk = false;

   public zzg(zzl var1) {
      this.zzahj = var1;
   }

   private <A extends Api.zzb> void zza(zzj.zze<A> var1) throws DeadObjectException {
      this.zzahj.zzagW.zzb(var1);
      Api.zzb var2 = this.zzahj.zzagW.zza(var1.zzoR());
      if(!var2.isConnected() && this.zzahj.zzaio.containsKey(var1.zzoR())) {
         var1.zzw(new Status(17));
      } else {
         var1.zzb(var2);
      }
   }

   public void begin() {
   }

   public void connect() {
      if(this.zzahk) {
         this.zzahk = false;
         this.zzahj.zza(new zzl.zza(this) {
            public void zzpt() {
               zzg.this.zzahj.zzais.zzi((Bundle)null);
            }
         });
      }

   }

   public boolean disconnect() {
      if(this.zzahk) {
         return false;
      } else if(!this.zzahj.zzagW.zzpG()) {
         this.zzahj.zzh((ConnectionResult)null);
         return true;
      } else {
         this.zzahk = true;
         Iterator var1 = this.zzahj.zzagW.zzaia.iterator();

         while(var1.hasNext()) {
            ((zzx)var1.next()).zzpU();
         }

         return false;
      }
   }

   public void onConnected(Bundle var1) {
   }

   public void onConnectionSuspended(int var1) {
      this.zzahj.zzh((ConnectionResult)null);
      this.zzahj.zzais.zzc(var1, this.zzahk);
   }

   public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T var1) {
      return this.zzb(var1);
   }

   public void zza(ConnectionResult var1, Api<?> var2, int var3) {
   }

   public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T var1) {
      try {
         this.zza((zzj.zze)var1);
         return var1;
      } catch (DeadObjectException var3) {
         this.zzahj.zza(new zzl.zza(this) {
            public void zzpt() {
               zzg.this.onConnectionSuspended(1);
            }
         });
         return var1;
      }
   }

   void zzps() {
      if(this.zzahk) {
         this.zzahk = false;
         this.zzahj.zzagW.zzaa(false);
         this.disconnect();
      }

   }
}
