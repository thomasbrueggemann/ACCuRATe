package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends Api.ApiOptions> {
   private final String mName;
   private final Api.zzc<?> zzaeE;
   private final Api.zza<?, O> zzafW;
   private final Api.zze<?, O> zzafX;
   private final Api.zzf<?> zzafY;

   public <C extends Api.zzb> Api(String var1, Api.zza<C, O> var2, Api.zzc<C> var3) {
      zzx.zzb(var2, "Cannot construct an Api with a null ClientBuilder");
      zzx.zzb(var3, "Cannot construct an Api with a null ClientKey");
      this.mName = var1;
      this.zzafW = var2;
      this.zzafX = null;
      this.zzaeE = var3;
      this.zzafY = null;
   }

   public String getName() {
      return this.mName;
   }

   public Api.zza<?, O> zzoP() {
      boolean var1;
      if(this.zzafW != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zza(var1, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return this.zzafW;
   }

   public Api.zze<?, O> zzoQ() {
      boolean var1;
      if(this.zzafX != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zza(var1, "This API was constructed with a ClientBuilder. Use getClientBuilder");
      return this.zzafX;
   }

   public Api.zzc<?> zzoR() {
      boolean var1;
      if(this.zzaeE != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      zzx.zza(var1, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
      return this.zzaeE;
   }

   public boolean zzoS() {
      return this.zzafY != null;
   }

   public interface ApiOptions {
   }

   public interface HasOptions extends Api.ApiOptions {
   }

   public static final class NoOptions implements Api.NotRequiredOptions {
   }

   public interface NotRequiredOptions extends Api.ApiOptions {
   }

   public interface Optional extends Api.HasOptions, Api.NotRequiredOptions {
   }

   public abstract static class zza<T extends Api.zzb, O> {
      public int getPriority() {
         return Integer.MAX_VALUE;
      }

      public abstract T zza(Context var1, Looper var2, com.google.android.gms.common.internal.zzf var3, O var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6);

      public List<Scope> zzo(O var1) {
         return Collections.emptyList();
      }
   }

   public interface zzb {
      void disconnect();

      void dump(String var1, FileDescriptor var2, PrintWriter var3, String[] var4);

      boolean isConnected();

      void zza(GoogleApiClient.zza var1);

      void zza(zzp var1, Set<Scope> var2);

      boolean zzmE();

      boolean zznb();

      Intent zznc();

      IBinder zzoT();
   }

   public static final class zzc<C extends Api.zzb> {
   }

   public interface zzd<T extends IInterface> {
      T zzW(IBinder var1);

      void zza(int var1, T var2);

      String zzgu();

      String zzgv();
   }

   public interface zze<T extends Api.zzd, O> {
      int getPriority();

      int zzoU();

      T zzq(O var1);
   }

   public static final class zzf<C extends Api.zzd> {
   }
}
