package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzh implements zzk {
   private final Context mContext;
   private final Lock zzXG;
   private final com.google.android.gms.common.zzc zzags;
   private final Api.zza<? extends zzrn, zzro> zzagt;
   private final Map<Api<?>, Integer> zzahA;
   private ArrayList<Future<?>> zzahB = new ArrayList();
   private final zzl zzahj;
   private ConnectionResult zzahm;
   private int zzahn;
   private int zzaho = 0;
   private int zzahp;
   private final Bundle zzahq = new Bundle();
   private final Set<Api.zzc> zzahr = new HashSet();
   private zzrn zzahs;
   private int zzaht;
   private boolean zzahu;
   private boolean zzahv;
   private com.google.android.gms.common.internal.zzp zzahw;
   private boolean zzahx;
   private boolean zzahy;
   private final com.google.android.gms.common.internal.zzf zzahz;

   public zzh(zzl var1, com.google.android.gms.common.internal.zzf var2, Map<Api<?>, Integer> var3, com.google.android.gms.common.zzc var4, Api.zza<? extends zzrn, zzro> var5, Lock var6, Context var7) {
      this.zzahj = var1;
      this.zzahz = var2;
      this.zzahA = var3;
      this.zzags = var4;
      this.zzagt = var5;
      this.zzXG = var6;
      this.mContext = var7;
   }

   private void zzZ(boolean var1) {
      if(this.zzahs != null) {
         if(this.zzahs.isConnected() && var1) {
            this.zzahs.zzFG();
         }

         this.zzahs.disconnect();
         this.zzahw = null;
      }

   }

   // $FF: synthetic method
   static void zza(zzh var0, ConnectionResult var1, Api var2, int var3) {
      var0.zzb(var1, var2, var3);
   }

   private void zza(SignInResponse var1) {
      if(this.zzbz(0)) {
         ConnectionResult var2 = var1.zzqY();
         if(var2.isSuccess()) {
            ResolveAccountResponse var3 = var1.zzFP();
            ConnectionResult var4 = var3.zzqY();
            if(!var4.isSuccess()) {
               Log.wtf("GoogleApiClientConnecting", "Sign-in succeeded with resolve account failure: " + var4, new Exception());
               this.zzg(var4);
            } else {
               this.zzahv = true;
               this.zzahw = var3.zzqX();
               this.zzahx = var3.zzqZ();
               this.zzahy = var3.zzra();
               this.zzpv();
            }
         } else if(this.zzf(var2)) {
            this.zzpy();
            this.zzpv();
         } else {
            this.zzg(var2);
         }
      }
   }

   private boolean zza(int var1, int var2, ConnectionResult var3) {
      return (var2 != 1 || this.zze(var3)) && (this.zzahm == null || var1 < this.zzahn);
   }

   // $FF: synthetic method
   static boolean zza(zzh var0, int var1) {
      return var0.zzbz(var1);
   }

   private void zzb(ConnectionResult var1, Api<?> var2, int var3) {
      if(var3 != 2) {
         int var5 = var2.zzoP().getPriority();
         if(this.zza(var5, var3, var1)) {
            this.zzahm = var1;
            this.zzahn = var5;
         }
      }

      this.zzahj.zzaio.put(var2.zzoR(), var1);
   }

   private String zzbA(int var1) {
      switch(var1) {
      case 0:
         return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
      case 1:
         return "STEP_GETTING_REMOTE_SERVICE";
      default:
         return "UNKNOWN";
      }
   }

   private boolean zzbz(int var1) {
      if(this.zzaho != var1) {
         Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
         Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + this.zzbA(this.zzaho) + " but received callback for step " + this.zzbA(var1), new Exception());
         this.zzg(new ConnectionResult(8, (PendingIntent)null));
         return false;
      } else {
         return true;
      }
   }

   private boolean zze(ConnectionResult var1) {
      return var1.hasResolution() || this.zzags.zzbu(var1.getErrorCode()) != null;
   }

   private boolean zzf(ConnectionResult var1) {
      return this.zzaht == 2 || this.zzaht == 1 && !var1.hasResolution();
   }

   private void zzg(ConnectionResult var1) {
      this.zzpz();
      boolean var2;
      if(!var1.hasResolution()) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.zzZ(var2);
      this.zzahj.zzh(var1);
      this.zzahj.zzais.zzd(var1);
   }

   // $FF: synthetic method
   static boolean zzk(zzh var0) {
      return var0.zzpu();
   }

   private Set<Scope> zzpA() {
      if(this.zzahz == null) {
         return Collections.emptySet();
      } else {
         HashSet var1 = new HashSet(this.zzahz.zzqs());
         Map var2 = this.zzahz.zzqu();
         Iterator var3 = var2.keySet().iterator();

         while(var3.hasNext()) {
            Api var4 = (Api)var3.next();
            if(!this.zzahj.zzaio.containsKey(var4.zzoR())) {
               var1.addAll(((com.google.android.gms.common.internal.zzf.zza)var2.get(var4)).zzXf);
            }
         }

         return var1;
      }
   }

   private boolean zzpu() {
      this.zzahp += -1;
      if(this.zzahp > 0) {
         return false;
      } else if(this.zzahp < 0) {
         Log.i("GoogleApiClientConnecting", this.zzahj.zzagW.zzpH());
         Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
         this.zzg(new ConnectionResult(8, (PendingIntent)null));
         return false;
      } else if(this.zzahm != null) {
         this.zzahj.zzair = this.zzahn;
         this.zzg(this.zzahm);
         return false;
      } else {
         return true;
      }
   }

   private void zzpv() {
      if(this.zzahp == 0 && (!this.zzahu || this.zzahv)) {
         this.zzpw();
      }
   }

   private void zzpw() {
      ArrayList var1 = new ArrayList();
      this.zzaho = 1;
      this.zzahp = this.zzahj.zzahT.size();
      Iterator var2 = this.zzahj.zzahT.keySet().iterator();

      while(var2.hasNext()) {
         Api.zzc var4 = (Api.zzc)var2.next();
         if(this.zzahj.zzaio.containsKey(var4)) {
            if(this.zzpu()) {
               this.zzpx();
            }
         } else {
            var1.add(this.zzahj.zzahT.get(var4));
         }
      }

      if(!var1.isEmpty()) {
         this.zzahB.add(zzm.zzpN().submit(new zzh.zzc(var1)));
      }

   }

   private void zzpx() {
      this.zzahj.zzpL();
      zzm.zzpN().execute(new Runnable() {
         public void run() {
            zzh.this.zzags.zzal(zzh.this.mContext);
         }
      });
      if(this.zzahs != null) {
         if(this.zzahx) {
            this.zzahs.zza(this.zzahw, this.zzahy);
         }

         this.zzZ(false);
      }

      Iterator var1 = this.zzahj.zzaio.keySet().iterator();

      while(var1.hasNext()) {
         Api.zzc var3 = (Api.zzc)var1.next();
         ((Api.zzb)this.zzahj.zzahT.get(var3)).disconnect();
      }

      Bundle var2;
      if(this.zzahq.isEmpty()) {
         var2 = null;
      } else {
         var2 = this.zzahq;
      }

      this.zzahj.zzais.zzi(var2);
   }

   private void zzpy() {
      this.zzahu = false;
      this.zzahj.zzagW.zzahU = Collections.emptySet();
      Iterator var1 = this.zzahr.iterator();

      while(var1.hasNext()) {
         Api.zzc var2 = (Api.zzc)var1.next();
         if(!this.zzahj.zzaio.containsKey(var2)) {
            this.zzahj.zzaio.put(var2, new ConnectionResult(17, (PendingIntent)null));
         }
      }

   }

   private void zzpz() {
      Iterator var1 = this.zzahB.iterator();

      while(var1.hasNext()) {
         ((Future)var1.next()).cancel(true);
      }

      this.zzahB.clear();
   }

   public void begin() {
      this.zzahj.zzaio.clear();
      this.zzahu = false;
      this.zzahm = null;
      this.zzaho = 0;
      this.zzaht = 2;
      this.zzahv = false;
      this.zzahx = false;
      HashMap var1 = new HashMap();
      Iterator var2 = this.zzahA.keySet().iterator();

      boolean var3;
      boolean var10;
      for(var3 = false; var2.hasNext(); var3 = var10) {
         Api var6 = (Api)var2.next();
         Api.zzb var7 = (Api.zzb)this.zzahj.zzahT.get(var6.zzoR());
         int var8 = ((Integer)this.zzahA.get(var6)).intValue();
         boolean var9;
         if(var6.zzoP().getPriority() == 1) {
            var9 = true;
         } else {
            var9 = false;
         }

         var10 = var9 | var3;
         if(var7.zzmE()) {
            this.zzahu = true;
            if(var8 < this.zzaht) {
               this.zzaht = var8;
            }

            if(var8 != 0) {
               this.zzahr.add(var6.zzoR());
            }
         }

         var1.put(var7, new zzh.zza(this, var6, var8));
      }

      if(var3) {
         this.zzahu = false;
      }

      if(this.zzahu) {
         this.zzahz.zza(Integer.valueOf(this.zzahj.zzagW.getSessionId()));
         zzh.zze var5 = new zzh.zze(null);
         this.zzahs = (zzrn)this.zzagt.zza(this.mContext, this.zzahj.zzagW.getLooper(), this.zzahz, this.zzahz.zzqy(), var5, var5);
      }

      this.zzahp = this.zzahj.zzahT.size();
      this.zzahB.add(zzm.zzpN().submit(new zzh.zzb(var1)));
   }

   public void connect() {
   }

   public boolean disconnect() {
      this.zzpz();
      this.zzZ(true);
      this.zzahj.zzh((ConnectionResult)null);
      return true;
   }

   public void onConnected(Bundle var1) {
      if(this.zzbz(1)) {
         if(var1 != null) {
            this.zzahq.putAll(var1);
         }

         if(this.zzpu()) {
            this.zzpx();
            return;
         }
      }

   }

   public void onConnectionSuspended(int var1) {
      this.zzg(new ConnectionResult(8, (PendingIntent)null));
   }

   public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(T var1) {
      this.zzahj.zzagW.zzahN.add(var1);
      return var1;
   }

   public void zza(ConnectionResult var1, Api<?> var2, int var3) {
      if(this.zzbz(1)) {
         this.zzb(var1, var2, var3);
         if(this.zzpu()) {
            this.zzpx();
            return;
         }
      }

   }

   public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(T var1) {
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
   }

   private static class zza implements GoogleApiClient.zza {
      private final Api<?> zzagT;
      private final int zzagU;
      private final WeakReference<zzh> zzahD;

      public zza(zzh var1, Api<?> var2, int var3) {
         this.zzahD = new WeakReference(var1);
         this.zzagT = var2;
         this.zzagU = var3;
      }

      public void zza(@NonNull ConnectionResult param1) {
         // $FF: Couldn't be decompiled
      }
   }

   private class zzb extends zzh.zzf {
      private final Map<Api.zzb, GoogleApiClient.zza> zzahE;

      public zzb(Map<Api.zzb, GoogleApiClient.zza> var1) {
         super();
         this.zzahE = var2;
      }

      @WorkerThread
      public void zzpt() {
         int var1 = zzh.this.zzags.isGooglePlayServicesAvailable(zzh.this.mContext);
         if(var1 != 0) {
            final ConnectionResult var2 = new ConnectionResult(var1, (PendingIntent)null);
            zzh.this.zzahj.zza(new zzl.zza(zzh.this) {
               public void zzpt() {
                  zzh.this.zzg(var2);
               }
            });
         } else {
            if(zzh.this.zzahu) {
               zzh.this.zzahs.connect();
            }

            Iterator var3 = this.zzahE.keySet().iterator();

            while(var3.hasNext()) {
               Api.zzb var4 = (Api.zzb)var3.next();
               var4.zza((GoogleApiClient.zza)this.zzahE.get(var4));
            }
         }

      }
   }

   private class zzc extends zzh.zzf {
      private final ArrayList<Api.zzb> zzahH;

      public zzc(ArrayList<Api.zzb> var1) {
         super();
         this.zzahH = var2;
      }

      @WorkerThread
      public void zzpt() {
         zzh.this.zzahj.zzagW.zzahU = zzh.this.zzpA();
         Iterator var1 = this.zzahH.iterator();

         while(var1.hasNext()) {
            ((Api.zzb)var1.next()).zza(zzh.this.zzahw, zzh.this.zzahj.zzagW.zzahU);
         }

      }
   }

   private static class zzd extends com.google.android.gms.signin.internal.zzb {
      private final WeakReference<zzh> zzahD;

      zzd(zzh var1) {
         this.zzahD = new WeakReference(var1);
      }

      @BinderThread
      public void zzb(final SignInResponse var1) {
         final zzh var2 = (zzh)this.zzahD.get();
         if(var2 != null) {
            var2.zzahj.zza(new zzl.zza(var2) {
               public void zzpt() {
                  var2.zza(var1);
               }
            });
         }
      }
   }

   private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      private zze() {
      }

      // $FF: synthetic method
      zze(Object var2) {
         this();
      }

      public void onConnected(Bundle var1) {
         zzh.this.zzahs.zza(new zzh.zzd(zzh.this));
      }

      public void onConnectionFailed(@NonNull ConnectionResult var1) {
         zzh.this.zzXG.lock();

         try {
            if(zzh.this.zzf(var1)) {
               zzh.this.zzpy();
               zzh.this.zzpv();
            } else {
               zzh.this.zzg(var1);
            }
         } finally {
            zzh.this.zzXG.unlock();
         }

      }

      public void onConnectionSuspended(int var1) {
      }
   }

   private abstract class zzf implements Runnable {
      private zzf() {
      }

      // $FF: synthetic method
      zzf(Object var2) {
         this();
      }

      @WorkerThread
      public void run() {
         // $FF: Couldn't be decompiled
      }

      @WorkerThread
      protected abstract void zzpt();
   }
}
