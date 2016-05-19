package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.IBinder.DeathRecipient;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zzc;
import com.google.android.gms.common.api.internal.zzd;
import com.google.android.gms.common.api.internal.zzl;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.api.internal.zzp;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzv;
import com.google.android.gms.common.api.internal.zzx;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzj extends GoogleApiClient implements zzp.zza {
   private final Context mContext;
   private final Lock zzXG;
   private final int zzagp;
   private final Looper zzagr;
   private final com.google.android.gms.common.zzc zzags;
   final Api.zza<? extends zzrn, zzro> zzagt;
   final Map<Api<?>, Integer> zzahA;
   private final com.google.android.gms.common.internal.zzk zzahL;
   private zzp zzahM = null;
   final Queue<zza.zza<?, ?>> zzahN = new LinkedList();
   private volatile boolean zzahO;
   private long zzahP = 120000L;
   private long zzahQ = 5000L;
   private final zzj.zza zzahR;
   zzj.zzc zzahS;
   final Map<Api.zzc<?>, Api.zzb> zzahT;
   Set<Scope> zzahU = new HashSet();
   private final Set<zzq<?>> zzahV = Collections.newSetFromMap(new WeakHashMap());
   final Set<zzj.zze<?>> zzahW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
   private com.google.android.gms.common.api.zza zzahX;
   private final ArrayList<zzc> zzahY;
   private Integer zzahZ = null;
   final zzf zzahz;
   Set<zzx> zzaia = null;
   private final zzj.zzd zzaib = new zzj.zzd() {
      public void zzc(zzj.zze<?> var1) {
         zzj.this.zzahW.remove(var1);
         if(var1.zzpa() != null && zzj.this.zzahX != null) {
            zzj.this.zzahX.remove(var1.zzpa().intValue());
         }

      }
   };
   private final com.google.android.gms.common.internal.zzk.zza zzaic = new com.google.android.gms.common.internal.zzk.zza() {
      public boolean isConnected() {
         return zzj.this.isConnected();
      }

      public Bundle zzoi() {
         return null;
      }
   };

   public zzj(Context var1, Lock var2, Looper var3, zzf var4, com.google.android.gms.common.zzc var5, Api.zza<? extends zzrn, zzro> var6, Map<Api<?>, Integer> var7, List<GoogleApiClient.ConnectionCallbacks> var8, List<GoogleApiClient.OnConnectionFailedListener> var9, Map<Api.zzc<?>, Api.zzb> var10, int var11, int var12, ArrayList<zzc> var13) {
      this.mContext = var1;
      this.zzXG = var2;
      this.zzahL = new com.google.android.gms.common.internal.zzk(var3, this.zzaic);
      this.zzagr = var3;
      this.zzahR = new zzj.zza(var3);
      this.zzags = var5;
      this.zzagp = var11;
      if(this.zzagp >= 0) {
         this.zzahZ = Integer.valueOf(var12);
      }

      this.zzahA = var7;
      this.zzahT = var10;
      this.zzahY = var13;
      Iterator var14 = var8.iterator();

      while(var14.hasNext()) {
         GoogleApiClient.ConnectionCallbacks var17 = (GoogleApiClient.ConnectionCallbacks)var14.next();
         this.zzahL.registerConnectionCallbacks(var17);
      }

      Iterator var15 = var9.iterator();

      while(var15.hasNext()) {
         GoogleApiClient.OnConnectionFailedListener var16 = (GoogleApiClient.OnConnectionFailedListener)var15.next();
         this.zzahL.registerConnectionFailedListener(var16);
      }

      this.zzahz = var4;
      this.zzagt = var6;
   }

   private void resume() {
      this.zzXG.lock();

      try {
         if(this.zzpB()) {
            this.zzpC();
         }
      } finally {
         this.zzXG.unlock();
      }

   }

   public static int zza(Iterable<Api.zzb> var0, boolean var1) {
      byte var2 = 1;
      Iterator var3 = var0.iterator();
      byte var4 = 0;

      byte var5;
      byte var7;
      for(var5 = 0; var3.hasNext(); var4 = var7) {
         Api.zzb var6 = (Api.zzb)var3.next();
         if(var6.zzmE()) {
            var5 = var2;
         }

         if(var6.zznb()) {
            var7 = var2;
         } else {
            var7 = var4;
         }
      }

      if(var5 != 0) {
         if(var4 != 0 && var1) {
            var2 = 2;
         }

         return var2;
      } else {
         return 3;
      }
   }

   private void zza(final GoogleApiClient var1, final zzv var2, final boolean var3) {
      zzmf.zzamA.zzf(var1).setResultCallback(new ResultCallback() {
         // $FF: synthetic method
         public void onResult(@NonNull Result var1x) {
            this.zzp((Status)var1x);
         }

         public void zzp(@NonNull Status var1x) {
            com.google.android.gms.auth.api.signin.internal.zzq.zzaf(zzj.this.mContext).zznr();
            if(var1x.isSuccess() && zzj.this.isConnected()) {
               zzj.this.reconnect();
            }

            var2.zza(var1x);
            if(var3) {
               var1.disconnect();
            }

         }
      });
   }

   private static void zza(zzj.zze<?> var0, com.google.android.gms.common.api.zza var1, IBinder var2) {
      if(var0.isReady()) {
         var0.zza(new zzj.zzb(var0, var1, var2, null));
      } else if(var2 != null && var2.isBinderAlive()) {
         zzj.zzb var3 = new zzj.zzb(var0, var1, var2, null);
         var0.zza(var3);

         try {
            var2.linkToDeath(var3, 0);
         } catch (RemoteException var5) {
            var0.cancel();
            var1.remove(var0.zzpa().intValue());
         }
      } else {
         var0.zza((zzj.zzd)null);
         var0.cancel();
         var1.remove(var0.zzpa().intValue());
      }
   }

   private void zzbB(int var1) {
      if(this.zzahZ == null) {
         this.zzahZ = Integer.valueOf(var1);
      } else if(this.zzahZ.intValue() != var1) {
         throw new IllegalStateException("Cannot use sign-in mode: " + zzbC(var1) + ". Mode was already set to " + zzbC(this.zzahZ.intValue()));
      }

      if(this.zzahM == null) {
         Iterator var2 = this.zzahT.values().iterator();
         boolean var3 = false;

         boolean var4;
         boolean var6;
         for(var4 = false; var2.hasNext(); var3 = var6) {
            Api.zzb var5 = (Api.zzb)var2.next();
            if(var5.zzmE()) {
               var4 = true;
            }

            if(var5.zznb()) {
               var6 = true;
            } else {
               var6 = var3;
            }
         }

         switch(this.zzahZ.intValue()) {
         case 1:
            if(!var4) {
               throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }

            if(var3) {
               throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            break;
         case 2:
            if(var4) {
               this.zzahM = new zzd(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY);
               return;
            }
         case 3:
         }

         this.zzahM = new zzl(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY, this);
      }
   }

   static String zzbC(int var0) {
      switch(var0) {
      case 1:
         return "SIGN_IN_MODE_REQUIRED";
      case 2:
         return "SIGN_IN_MODE_OPTIONAL";
      case 3:
         return "SIGN_IN_MODE_NONE";
      default:
         return "UNKNOWN";
      }
   }

   private void zzpC() {
      this.zzahL.zzqR();
      this.zzahM.connect();
   }

   private void zzpD() {
      this.zzXG.lock();

      try {
         if(this.zzpF()) {
            this.zzpC();
         }
      } finally {
         this.zzXG.unlock();
      }

   }

   public ConnectionResult blockingConnect() {
      // $FF: Couldn't be decompiled
   }

   public PendingResult<Status> clearDefaultAccountAndReconnect() {
      com.google.android.gms.common.internal.zzx.zza(this.isConnected(), "GoogleApiClient is not connected yet.");
      boolean var1;
      if(this.zzahZ.intValue() != 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      com.google.android.gms.common.internal.zzx.zza(var1, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
      final zzv var2 = new zzv(this);
      if(this.zzahT.containsKey(zzmf.zzUI)) {
         this.zza(this, var2, false);
         return var2;
      } else {
         final AtomicReference var3 = new AtomicReference();
         GoogleApiClient.ConnectionCallbacks var4 = new GoogleApiClient.ConnectionCallbacks() {
            public void onConnected(Bundle var1) {
               zzj.this.zza((GoogleApiClient)var3.get(), var2, true);
            }

            public void onConnectionSuspended(int var1) {
            }
         };
         GoogleApiClient.OnConnectionFailedListener var5 = new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(@NonNull ConnectionResult var1) {
               var2.zza(new Status(8));
            }
         };
         GoogleApiClient var6 = (new GoogleApiClient.Builder(this.mContext)).addApi(zzmf.API).addConnectionCallbacks(var4).addOnConnectionFailedListener(var5).setHandler(this.zzahR).build();
         var3.set(var6);
         var6.connect();
         return var2;
      }
   }

   public void connect() {
      // $FF: Couldn't be decompiled
   }

   public void connect(int var1) {
      byte var2 = 1;
      this.zzXG.lock();
      if(var1 != 3 && var1 != var2 && var1 != 2) {
         var2 = 0;
      }

      try {
         com.google.android.gms.common.internal.zzx.zzb((boolean)var2, "Illegal sign-in mode: " + var1);
         this.zzbB(var1);
         this.zzpC();
      } finally {
         this.zzXG.unlock();
      }

   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4) {
      var3.append(var1).append("mContext=").println(this.mContext);
      var3.append(var1).append("mResuming=").print(this.zzahO);
      var3.append(" mWorkQueue.size()=").print(this.zzahN.size());
      var3.append(" mUnconsumedRunners.size()=").println(this.zzahW.size());
      if(this.zzahM != null) {
         this.zzahM.dump(var1, var2, var3, var4);
      }

   }

   public Context getContext() {
      return this.mContext;
   }

   public Looper getLooper() {
      return this.zzagr;
   }

   public int getSessionId() {
      return System.identityHashCode(this);
   }

   public boolean isConnected() {
      return this.zzahM != null && this.zzahM.isConnected();
   }

   public void reconnect() {
      this.disconnect();
      this.connect();
   }

   public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener var1) {
      this.zzahL.registerConnectionFailedListener(var1);
   }

   public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener var1) {
      this.zzahL.unregisterConnectionFailedListener(var1);
   }

   @NonNull
   public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> var1) {
      Api.zzb var2 = (Api.zzb)this.zzahT.get(var1);
      com.google.android.gms.common.internal.zzx.zzb(var2, "Appropriate Api was not requested.");
      return var2;
   }

   public <A extends Api.zzb, R extends Result, T extends zza.zza<R, A>> T zza(@NonNull T var1) {
      boolean var2;
      if(var1.zzoR() != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      com.google.android.gms.common.internal.zzx.zzb(var2, "This task can not be enqueued (it\'s probably a Batch or malformed)");
      com.google.android.gms.common.internal.zzx.zzb(this.zzahT.containsKey(var1.zzoR()), "GoogleApiClient is not configured to use the API required for this call.");
      this.zzXG.lock();

      zza.zza var4;
      try {
         if(this.zzahM == null) {
            this.zzahN.add(var1);
            return var1;
         }

         var4 = this.zzahM.zza(var1);
      } finally {
         this.zzXG.unlock();
      }

      return var4;
   }

   public void zza(zzx var1) {
      this.zzXG.lock();

      try {
         if(this.zzaia == null) {
            this.zzaia = new HashSet();
         }

         this.zzaia.add(var1);
      } finally {
         this.zzXG.unlock();
      }

   }

   public boolean zza(zzu var1) {
      return this.zzahM != null && this.zzahM.zza(var1);
   }

   void zzaa(boolean var1) {
      Iterator var2 = this.zzahW.iterator();

      while(var2.hasNext()) {
         zzj.zze var3 = (zzj.zze)var2.next();
         if(var3.zzpa() == null) {
            if(var1) {
               var3.zzpg();
            } else {
               var3.cancel();
               this.zzahW.remove(var3);
            }
         } else {
            var3.zzpe();
            IBinder var4 = this.zza(var3.zzoR()).zzoT();
            zza(var3, this.zzahX, var4);
            this.zzahW.remove(var3);
         }
      }

   }

   public <A extends Api.zzb, T extends zza.zza<? extends Result, A>> T zzb(@NonNull T param1) {
      // $FF: Couldn't be decompiled
   }

   <A extends Api.zzb> void zzb(zzj.zze<A> var1) {
      this.zzahW.add(var1);
      var1.zza(this.zzaib);
   }

   public void zzb(zzx var1) {
      this.zzXG.lock();

      try {
         if(this.zzaia == null) {
            Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
         } else if(!this.zzaia.remove(var1)) {
            Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
         } else if(!this.zzpG()) {
            this.zzahM.zzpj();
         }
      } finally {
         this.zzXG.unlock();
      }

   }

   public void zzc(int var1, boolean var2) {
      if(var1 == 1 && !var2) {
         this.zzpE();
      }

      zzj.zze var4;
      for(Iterator var3 = this.zzahW.iterator(); var3.hasNext(); var4.zzx(new Status(8, "The connection to Google Play services was lost"))) {
         var4 = (zzj.zze)var3.next();
         if(var2) {
            var4.zzpe();
         }
      }

      this.zzahW.clear();
      this.zzahL.zzbT(var1);
      this.zzahL.zzqQ();
      if(var1 == 2) {
         this.zzpC();
      }

   }

   public void zzd(ConnectionResult var1) {
      if(!this.zzags.zzd(this.mContext, var1.getErrorCode())) {
         this.zzpF();
      }

      if(!this.zzpB()) {
         this.zzahL.zzk(var1);
         this.zzahL.zzqQ();
      }

   }

   public void zzi(Bundle var1) {
      while(!this.zzahN.isEmpty()) {
         this.zzb((zza.zza)this.zzahN.remove());
      }

      this.zzahL.zzk(var1);
   }

   public void zzoW() {
      if(this.zzahM != null) {
         this.zzahM.zzoW();
      }

   }

   boolean zzpB() {
      return this.zzahO;
   }

   void zzpE() {
      if(!this.zzpB()) {
         this.zzahO = true;
         if(this.zzahS == null) {
            this.zzahS = (zzj.zzc)zzn.zza(this.mContext.getApplicationContext(), new zzj.zzc(this), this.zzags);
         }

         this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(1), this.zzahP);
         this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(2), this.zzahQ);
      }
   }

   boolean zzpF() {
      if(!this.zzpB()) {
         return false;
      } else {
         this.zzahO = false;
         this.zzahR.removeMessages(2);
         this.zzahR.removeMessages(1);
         if(this.zzahS != null) {
            this.zzahS.unregister();
            this.zzahS = null;
         }

         return true;
      }
   }

   boolean zzpG() {
      // $FF: Couldn't be decompiled
   }

   String zzpH() {
      StringWriter var1 = new StringWriter();
      this.dump("", (FileDescriptor)null, new PrintWriter(var1), (String[])null);
      return var1.toString();
   }

   final class zza extends Handler {
      zza(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            zzj.this.zzpD();
            return;
         case 2:
            zzj.this.resume();
            return;
         default:
            Log.w("GoogleApiClientImpl", "Unknown message id: " + var1.what);
         }
      }
   }

   private static class zzb implements DeathRecipient, zzj.zzd {
      private final WeakReference<zzj.zze<?>> zzaii;
      private final WeakReference<com.google.android.gms.common.api.zza> zzaij;
      private final WeakReference<IBinder> zzaik;

      private zzb(zzj.zze var1, com.google.android.gms.common.api.zza var2, IBinder var3) {
         this.zzaij = new WeakReference(var2);
         this.zzaii = new WeakReference(var1);
         this.zzaik = new WeakReference(var3);
      }

      // $FF: synthetic method
      zzb(zzj.zze var1, com.google.android.gms.common.api.zza var2, IBinder var3, Object var4) {
         this(var1, var2, var3);
      }

      private void zzpI() {
         zzj.zze var1 = (zzj.zze)this.zzaii.get();
         com.google.android.gms.common.api.zza var2 = (com.google.android.gms.common.api.zza)this.zzaij.get();
         if(var2 != null && var1 != null) {
            var2.remove(var1.zzpa().intValue());
         }

         IBinder var3 = (IBinder)this.zzaik.get();
         if(this.zzaik != null) {
            var3.unlinkToDeath(this, 0);
         }

      }

      public void binderDied() {
         this.zzpI();
      }

      public void zzc(zzj.zze<?> var1) {
         this.zzpI();
      }
   }

   static class zzc extends zzn {
      private WeakReference<zzj> zzail;

      zzc(zzj var1) {
         this.zzail = new WeakReference(var1);
      }

      public void zzpJ() {
         zzj var1 = (zzj)this.zzail.get();
         if(var1 != null) {
            var1.resume();
         }
      }
   }

   interface zzd {
      void zzc(zzj.zze<?> var1);
   }

   interface zze<A extends Api.zzb> {
      void cancel();

      boolean isReady();

      void zza(zzj.zzd var1);

      void zzb(A var1) throws DeadObjectException;

      Api.zzc<A> zzoR();

      Integer zzpa();

      void zzpe();

      void zzpg();

      void zzw(Status var1);

      void zzx(Status var1);
   }
}
