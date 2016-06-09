package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements Api.zzb, zzk.zza {
   public static final String[] zzalJ = new String[]{"service_esmobile", "service_googleme"};
   private final Context mContext;
   final Handler mHandler;
   private final Account zzTI;
   private final Set<Scope> zzXf;
   private final Looper zzagr;
   private final com.google.android.gms.common.zzc zzags;
   private final zzf zzahz;
   private GoogleApiClient.zza zzalA;
   private T zzalB;
   private final ArrayList<zzj<T>.com/google/android/gms/common/internal/zzj$zzc<?>> zzalC;
   private zzj<T>.com/google/android/gms/common/internal/zzj$zze zzalD;
   private int zzalE;
   private final GoogleApiClient.ConnectionCallbacks zzalF;
   private final GoogleApiClient.OnConnectionFailedListener zzalG;
   private final int zzalH;
   protected AtomicInteger zzalI;
   private int zzals;
   private long zzalt;
   private long zzalu;
   private int zzalv;
   private long zzalw;
   private final zzl zzalx;
   private final Object zzaly;
   private zzs zzalz;
   private final Object zzpV;

   protected zzj(Context var1, Looper var2, int var3, zzf var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      this(var1, var2, zzl.zzau(var1), com.google.android.gms.common.zzc.zzoK(), var3, var4, (GoogleApiClient.ConnectionCallbacks)zzx.zzz(var5), (GoogleApiClient.OnConnectionFailedListener)zzx.zzz(var6));
   }

   protected zzj(Context var1, Looper var2, zzl var3, com.google.android.gms.common.zzc var4, int var5, zzf var6, GoogleApiClient.ConnectionCallbacks var7, GoogleApiClient.OnConnectionFailedListener var8) {
      this.zzpV = new Object();
      this.zzaly = new Object();
      this.zzalA = new zzj.zzf();
      this.zzalC = new ArrayList();
      this.zzalE = 1;
      this.zzalI = new AtomicInteger(0);
      this.mContext = (Context)zzx.zzb(var1, "Context must not be null");
      this.zzagr = (Looper)zzx.zzb(var2, "Looper must not be null");
      this.zzalx = (zzl)zzx.zzb(var3, "Supervisor must not be null");
      this.zzags = (com.google.android.gms.common.zzc)zzx.zzb(var4, "API availability must not be null");
      this.mHandler = new zzj.zzb(var2);
      this.zzalH = var5;
      this.zzahz = (zzf)zzx.zzz(var6);
      this.zzTI = var6.getAccount();
      this.zzXf = this.zza(var6.zzqt());
      this.zzalF = var7;
      this.zzalG = var8;
   }

   // $FF: synthetic method
   static zzs zza(zzj var0, zzs var1) {
      var0.zzalz = var1;
      return var1;
   }

   // $FF: synthetic method
   static Object zza(zzj var0) {
      return var0.zzaly;
   }

   private Set<Scope> zza(Set<Scope> var1) {
      Set var2 = this.zzb(var1);
      if(var2 == null) {
         return var2;
      } else {
         Iterator var3 = var2.iterator();

         do {
            if(!var3.hasNext()) {
               return var2;
            }
         } while(var1.contains((Scope)var3.next()));

         throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
   }

   private boolean zza(int param1, int param2, T param3) {
      // $FF: Couldn't be decompiled
   }

   private void zzb(int param1, T param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static ArrayList zzd(zzj var0) {
      return var0.zzalC;
   }

   private void zzqE() {
      if(this.zzalD != null) {
         Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + this.zzgu());
         this.zzalx.zzb(this.zzgu(), this.zzalD, this.zzqD());
         this.zzalI.incrementAndGet();
      }

      this.zzalD = new zzj.zze(this.zzalI.get());
      if(!this.zzalx.zza(this.zzgu(), this.zzalD, this.zzqD())) {
         Log.e("GmsClient", "unable to connect to service: " + this.zzgu());
         this.zzm(8, this.zzalI.get());
      }

   }

   private void zzqF() {
      if(this.zzalD != null) {
         this.zzalx.zzb(this.zzgu(), this.zzalD, this.zzqD());
         this.zzalD = null;
      }

   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public void dump(String param1, FileDescriptor param2, PrintWriter param3, String[] param4) {
      // $FF: Couldn't be decompiled
   }

   public final Context getContext() {
      return this.mContext;
   }

   public boolean isConnected() {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnecting() {
      // $FF: Couldn't be decompiled
   }

   @CallSuper
   protected void onConnectionFailed(ConnectionResult var1) {
      this.zzalv = var1.getErrorCode();
      this.zzalw = System.currentTimeMillis();
   }

   @CallSuper
   protected void onConnectionSuspended(int var1) {
      this.zzals = var1;
      this.zzalt = System.currentTimeMillis();
   }

   @Nullable
   protected abstract T zzW(IBinder var1);

   @BinderThread
   protected void zza(int var1, IBinder var2, Bundle var3, int var4) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, var4, -1, new zzj.zzg(var1, var2, var3)));
   }

   @CallSuper
   protected void zza(@NonNull T var1) {
      this.zzalu = System.currentTimeMillis();
   }

   public void zza(@NonNull GoogleApiClient.zza var1) {
      this.zzalA = (GoogleApiClient.zza)zzx.zzb(var1, "Connection progress callbacks cannot be null.");
      this.zzb(2, (IInterface)null);
   }

   @WorkerThread
   public void zza(zzp param1, Set<Scope> param2) {
      // $FF: Couldn't be decompiled
   }

   @NonNull
   protected Set<Scope> zzb(@NonNull Set<Scope> var1) {
      return var1;
   }

   public void zzbS(int var1) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzalI.get(), var1));
   }

   void zzc(int var1, T var2) {
   }

   @NonNull
   protected abstract String zzgu();

   @NonNull
   protected abstract String zzgv();

   protected void zzm(int var1, int var2) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(5, var2, -1, new zzj.zzh(var1)));
   }

   public boolean zzmE() {
      return false;
   }

   protected Bundle zzml() {
      return new Bundle();
   }

   public boolean zznb() {
      return false;
   }

   public Intent zznc() {
      throw new UnsupportedOperationException("Not a sign in API");
   }

   @Nullable
   public IBinder zzoT() {
      // $FF: Couldn't be decompiled
   }

   public Bundle zzoi() {
      return null;
   }

   @Nullable
   protected final String zzqD() {
      return this.zzahz.zzqw();
   }

   public void zzqG() {
      int var1 = this.zzags.isGooglePlayServicesAvailable(this.mContext);
      if(var1 != 0) {
         this.zzb(1, (IInterface)null);
         this.zzalA = new zzj.zzf();
         this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzalI.get(), var1));
      } else {
         this.zza((GoogleApiClient.zza)(new zzj.zzf()));
      }
   }

   protected final zzf zzqH() {
      return this.zzahz;
   }

   protected final void zzqI() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public final T zzqJ() throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   public boolean zzqK() {
      return false;
   }

   public final Account zzqq() {
      return this.zzTI != null?this.zzTI:new Account("<<default account>>", "com.google");
   }

   private abstract class zza extends zzj<T>.com/google/android/gms/common/internal/zzj$zzc<Boolean> {
      public final int statusCode;
      public final Bundle zzalK;

      @BinderThread
      protected zza(int var2, Bundle var3) {
         super();
         this.statusCode = var2;
         this.zzalK = var3;
      }

      protected void zzc(Boolean var1) {
         if(var1 == null) {
            zzj.this.zzb(1, (IInterface)null);
         } else {
            switch(this.statusCode) {
            case 0:
               if(!this.zzqL()) {
                  zzj.this.zzb(1, (IInterface)null);
                  this.zzj(new ConnectionResult(8, (PendingIntent)null));
                  return;
               }
               break;
            case 10:
               zzj.this.zzb(1, (IInterface)null);
               throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            default:
               zzj.this.zzb(1, (IInterface)null);
               Bundle var2 = this.zzalK;
               PendingIntent var3 = null;
               if(var2 != null) {
                  var3 = (PendingIntent)this.zzalK.getParcelable("pendingIntent");
               }

               this.zzj(new ConnectionResult(this.statusCode, var3));
               return;
            }
         }

      }

      protected abstract void zzj(ConnectionResult var1);

      protected abstract boolean zzqL();

      protected void zzqM() {
      }

      // $FF: synthetic method
      protected void zzw(Object var1) {
         this.zzc((Boolean)var1);
      }
   }

   final class zzb extends Handler {
      public zzb(Looper var2) {
         super(var2);
      }

      private void zza(Message var1) {
         zzj.zzc var2 = (zzj.zzc)var1.obj;
         var2.zzqM();
         var2.unregister();
      }

      private boolean zzb(Message var1) {
         return var1.what == 2 || var1.what == 1 || var1.what == 5;
      }

      public void handleMessage(Message var1) {
         if(zzj.this.zzalI.get() != var1.arg1) {
            if(this.zzb(var1)) {
               this.zza(var1);
            }

         } else if((var1.what == 1 || var1.what == 5) && !zzj.this.isConnecting()) {
            this.zza(var1);
         } else if(var1.what == 3) {
            ConnectionResult var2 = new ConnectionResult(var1.arg2, (PendingIntent)null);
            zzj.this.zzalA.zza(var2);
            zzj.this.onConnectionFailed(var2);
         } else if(var1.what == 4) {
            zzj.this.zzb(4, (IInterface)null);
            if(zzj.this.zzalF != null) {
               zzj.this.zzalF.onConnectionSuspended(var1.arg2);
            }

            zzj.this.onConnectionSuspended(var1.arg2);
            zzj.this.zza(4, 1, (IInterface)null);
         } else if(var1.what == 2 && !zzj.this.isConnected()) {
            this.zza(var1);
         } else if(this.zzb(var1)) {
            ((zzj.zzc)var1.obj).zzqN();
         } else {
            Log.wtf("GmsClient", "Don\'t know how to handle message: " + var1.what, new Exception());
         }
      }
   }

   protected abstract class zzc<TListener> {
      private TListener mListener;
      private boolean zzalM;

      public zzc(TListener var1) {
         this.mListener = var2;
         this.zzalM = false;
      }

      public void unregister() {
         // $FF: Couldn't be decompiled
      }

      protected abstract void zzqM();

      public void zzqN() {
         // $FF: Couldn't be decompiled
      }

      public void zzqO() {
         // $FF: Couldn't be decompiled
      }

      protected abstract void zzw(TListener var1);
   }

   public static final class zzd extends zzr.zza {
      private zzj zzalN;
      private final int zzalO;

      public zzd(@NonNull zzj var1, int var2) {
         this.zzalN = var1;
         this.zzalO = var2;
      }

      private void zzqP() {
         this.zzalN = null;
      }

      @BinderThread
      public void zza(int var1, @NonNull IBinder var2, @Nullable Bundle var3) {
         zzx.zzb(this.zzalN, "onPostInitComplete can be called only once per call to getRemoteService");
         this.zzalN.zza(var1, var2, var3, this.zzalO);
         this.zzqP();
      }

      @BinderThread
      public void zzb(int var1, @Nullable Bundle var2) {
         Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
      }
   }

   public final class zze implements ServiceConnection {
      private final int zzalO;

      public zze(int var2) {
         this.zzalO = var2;
      }

      public void onServiceConnected(ComponentName param1, IBinder param2) {
         // $FF: Couldn't be decompiled
      }

      public void onServiceDisconnected(ComponentName param1) {
         // $FF: Couldn't be decompiled
      }
   }

   protected class zzf implements GoogleApiClient.zza {
      public void zza(@NonNull ConnectionResult var1) {
         if(var1.isSuccess()) {
            zzj.this.zza((zzp)null, (Set)zzj.this.zzXf);
         } else if(zzj.this.zzalG != null) {
            zzj.this.zzalG.onConnectionFailed(var1);
            return;
         }

      }
   }

   protected final class zzg extends zzj<T>.com/google/android/gms/common/internal/zzj$zza {
      public final IBinder zzalP;

      @BinderThread
      public zzg(int var2, IBinder var3, Bundle var4) {
         super();
         this.zzalP = var3;
      }

      protected void zzj(ConnectionResult var1) {
         if(zzj.this.zzalG != null) {
            zzj.this.zzalG.onConnectionFailed(var1);
         }

         zzj.this.onConnectionFailed(var1);
      }

      protected boolean zzqL() {
         String var3;
         try {
            var3 = this.zzalP.getInterfaceDescriptor();
         } catch (RemoteException var6) {
            Log.w("GmsClient", "service probably died");
            return false;
         }

         if(!zzj.this.zzgv().equals(var3)) {
            Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzgv() + " vs. " + var3);
         } else {
            IInterface var4 = zzj.this.zzW(this.zzalP);
            if(var4 != null && zzj.this.zza(2, 3, var4)) {
               Bundle var5 = zzj.this.zzoi();
               if(zzj.this.zzalF != null) {
                  zzj.this.zzalF.onConnected(var5);
               }

               return true;
            }
         }

         return false;
      }
   }

   protected final class zzh extends zzj<T>.com/google/android/gms/common/internal/zzj$zza {
      @BinderThread
      public zzh(int var2) {
         super();
      }

      protected void zzj(ConnectionResult var1) {
         zzj.this.zzalA.zza(var1);
         zzj.this.onConnectionFailed(var1);
      }

      protected boolean zzqL() {
         zzj.this.zzalA.zza(ConnectionResult.zzafB);
         return true;
      }
   }
}
