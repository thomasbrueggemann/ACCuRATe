package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.api.internal.zzx;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class GoogleApiClient {
   private static final Set<GoogleApiClient> zzagg = Collections.newSetFromMap(new WeakHashMap());

   public static Set<GoogleApiClient> zzoV() {
      return zzagg;
   }

   // $FF: synthetic method
   static Set zzoX() {
      return zzagg;
   }

   public abstract ConnectionResult blockingConnect();

   public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

   public abstract void connect();

   public void connect(int var1) {
      throw new UnsupportedOperationException();
   }

   public abstract void disconnect();

   public abstract void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

   public Context getContext() {
      throw new UnsupportedOperationException();
   }

   public Looper getLooper() {
      throw new UnsupportedOperationException();
   }

   public abstract boolean isConnected();

   public abstract void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener var1);

   public abstract void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener var1);

   @NonNull
   public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> var1) {
      throw new UnsupportedOperationException();
   }

   public <A extends Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.zza<R, A>> T zza(@NonNull T var1) {
      throw new UnsupportedOperationException();
   }

   public void zza(zzx var1) {
      throw new UnsupportedOperationException();
   }

   public boolean zza(zzu var1) {
      throw new UnsupportedOperationException();
   }

   public <A extends Api.zzb, T extends com.google.android.gms.common.api.internal.zza.zza<? extends Result, A>> T zzb(@NonNull T var1) {
      throw new UnsupportedOperationException();
   }

   public void zzb(zzx var1) {
      throw new UnsupportedOperationException();
   }

   public void zzoW() {
      throw new UnsupportedOperationException();
   }

   public static final class Builder {
      private final Context mContext;
      private Account zzTI;
      private String zzUW;
      private final Set<Scope> zzagh = new HashSet();
      private final Set<Scope> zzagi = new HashSet();
      private int zzagj;
      private View zzagk;
      private String zzagl;
      private final Map<Api<?>, zzf.zza> zzagm = new ArrayMap();
      private final Map<Api<?>, Api.ApiOptions> zzagn = new ArrayMap();
      private FragmentActivity zzago;
      private int zzagp = -1;
      private GoogleApiClient.OnConnectionFailedListener zzagq;
      private Looper zzagr;
      private com.google.android.gms.common.zzc zzags = com.google.android.gms.common.zzc.zzoK();
      private Api.zza<? extends zzrn, zzro> zzagt;
      private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzagu;
      private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzagv;

      public Builder(@NonNull Context var1) {
         this.zzagt = zzrl.zzUJ;
         this.zzagu = new ArrayList();
         this.zzagv = new ArrayList();
         this.mContext = var1;
         this.zzagr = var1.getMainLooper();
         this.zzUW = var1.getPackageName();
         this.zzagl = var1.getClass().getName();
      }

      private static <C extends Api.zzb, O> C zza(Api.zza<C, O> var0, Object var1, Context var2, Looper var3, zzf var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return var0.zza(var2, var3, var4, var1, var5, var6);
      }

      private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> var0, Object var1, Context var2, Looper var3, zzf var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         return new zzad(var2, var3, var0.zzoU(), var5, var6, var4, var0.zzq(var1));
      }

      private void zza(zzw var1, GoogleApiClient var2) {
         var1.zza(this.zzagp, var2, this.zzagq);
      }

      private void zze(final GoogleApiClient var1) {
         zzw var2 = zzw.zza(this.zzago);
         if(var2 == null) {
            (new Handler(this.mContext.getMainLooper())).post(new Runnable() {
               public void run() {
                  if(!Builder.this.zzago.isFinishing() && !Builder.this.zzago.getSupportFragmentManager().isDestroyed()) {
                     Builder.this.zza(zzw.zzb(Builder.this.zzago), var1);
                  }
               }
            });
         } else {
            this.zza(var2, var1);
         }
      }

      private GoogleApiClient zzoZ() {
         zzf var1 = this.zzoY();
         Api var2 = null;
         Map var3 = var1.zzqu();
         ArrayMap var4 = new ArrayMap();
         ArrayMap var5 = new ArrayMap();
         ArrayList var6 = new ArrayList();
         Iterator var7 = this.zzagn.keySet().iterator();

         Api var8;
         Api var14;
         for(var8 = null; var7.hasNext(); var2 = var14) {
            var14 = (Api)var7.next();
            Object var15 = this.zzagn.get(var14);
            Object var16 = var3.get(var14);
            byte var17 = 0;
            if(var16 != null) {
               if(((zzf.zza)var3.get(var14)).zzalf) {
                  var17 = 1;
               } else {
                  var17 = 2;
               }
            }

            var4.put(var14, Integer.valueOf(var17));
            com.google.android.gms.common.api.internal.zzc var19 = new com.google.android.gms.common.api.internal.zzc(var14, var17);
            var6.add(var19);
            Object var23;
            Api var24;
            if(var14.zzoS()) {
               Api.zze var26 = var14.zzoQ();
               Api var27;
               if(var26.getPriority() == 1) {
                  var27 = var14;
               } else {
                  var27 = var8;
               }

               var23 = zza((Api.zze)var26, var15, this.mContext, this.zzagr, var1, var19, var19);
               var24 = var27;
            } else {
               Api.zza var21 = var14.zzoP();
               Api var22;
               if(var21.getPriority() == 1) {
                  var22 = var14;
               } else {
                  var22 = var8;
               }

               var23 = zza((Api.zza)var21, var15, this.mContext, this.zzagr, var1, var19, var19);
               var24 = var22;
            }

            var5.put(var14.zzoR(), var23);
            if(((Api.zzb)var23).zznb()) {
               if(var2 != null) {
                  throw new IllegalStateException(var14.getName() + " cannot be used with " + var2.getName());
               }
            } else {
               var14 = var2;
            }

            var8 = var24;
         }

         if(var2 != null) {
            if(var8 != null) {
               throw new IllegalStateException(var2.getName() + " cannot be used with " + var8.getName());
            }

            boolean var10;
            if(this.zzTI == null) {
               var10 = true;
            } else {
               var10 = false;
            }

            Object[] var11 = new Object[]{var2.getName()};
            com.google.android.gms.common.internal.zzx.zza(var10, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", var11);
            boolean var12 = this.zzagh.equals(this.zzagi);
            Object[] var13 = new Object[]{var2.getName()};
            com.google.android.gms.common.internal.zzx.zza(var12, "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", var13);
         }

         int var9 = zzj.zza(var5.values(), true);
         return new zzj(this.mContext, new ReentrantLock(), this.zzagr, var1, this.zzags, this.zzagt, var4, this.zzagu, this.zzagv, var5, this.zzagp, var9, var6);
      }

      public GoogleApiClient.Builder addApi(@NonNull Api<? extends Api.NotRequiredOptions> var1) {
         com.google.android.gms.common.internal.zzx.zzb(var1, "Api must not be null");
         this.zzagn.put(var1, (Object)null);
         List var4 = var1.zzoP().zzo((Object)null);
         this.zzagi.addAll(var4);
         this.zzagh.addAll(var4);
         return this;
      }

      public <O extends Api.HasOptions> GoogleApiClient.Builder addApi(@NonNull Api<O> var1, @NonNull O var2) {
         com.google.android.gms.common.internal.zzx.zzb(var1, "Api must not be null");
         com.google.android.gms.common.internal.zzx.zzb(var2, "Null options are not permitted for this Api");
         this.zzagn.put(var1, var2);
         List var6 = var1.zzoP().zzo(var2);
         this.zzagi.addAll(var6);
         this.zzagh.addAll(var6);
         return this;
      }

      public GoogleApiClient.Builder addConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks var1) {
         com.google.android.gms.common.internal.zzx.zzb(var1, "Listener must not be null");
         this.zzagu.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addOnConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener var1) {
         com.google.android.gms.common.internal.zzx.zzb(var1, "Listener must not be null");
         this.zzagv.add(var1);
         return this;
      }

      public GoogleApiClient build() {
         // $FF: Couldn't be decompiled
      }

      public GoogleApiClient.Builder setHandler(@NonNull Handler var1) {
         com.google.android.gms.common.internal.zzx.zzb(var1, "Handler must not be null");
         this.zzagr = var1.getLooper();
         return this;
      }

      public zzf zzoY() {
         zzro var1 = zzro.zzbgV;
         if(this.zzagn.containsKey(zzrl.API)) {
            var1 = (zzro)this.zzagn.get(zzrl.API);
         }

         return new zzf(this.zzTI, this.zzagh, this.zzagm, this.zzagj, this.zzagk, this.zzUW, this.zzagl, var1);
      }
   }

   public interface ConnectionCallbacks {
      void onConnected(@Nullable Bundle var1);

      void onConnectionSuspended(int var1);
   }

   public interface OnConnectionFailedListener {
      void onConnectionFailed(@NonNull ConnectionResult var1);
   }

   public interface zza {
      void zza(@NonNull ConnectionResult var1);
   }
}
