package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzu;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzu {
   private Semaphore zzXp = new Semaphore(0);
   private Set<GoogleApiClient> zzXq;

   public zzb(Context var1, Set<GoogleApiClient> var2) {
      super(var1);
      this.zzXq = var2;
   }

   // $FF: synthetic method
   public Object loadInBackground() {
      return this.zzmZ();
   }

   protected void onStartLoading() {
      this.zzXp.drainPermits();
      this.forceLoad();
   }

   public Void zzmZ() {
      Iterator var1 = this.zzXq.iterator();

      int var2;
      int var6;
      for(var2 = 0; var1.hasNext(); var2 = var6) {
         if(((GoogleApiClient)var1.next()).zza((zzu)this)) {
            var6 = var2 + 1;
         } else {
            var6 = var2;
         }
      }

      try {
         this.zzXp.tryAcquire(var2, 5L, TimeUnit.SECONDS);
      } catch (InterruptedException var7) {
         Log.i("GACSignInLoader", "Unexpected InterruptedException", var7);
         Thread.currentThread().interrupt();
      }

      return null;
   }

   public void zzna() {
      this.zzXp.release();
   }
}
