package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkj;
import java.util.List;

public final class zzkk implements com.google.android.gms.appdatasearch.zzk, AppIndexApi {
   public static Intent zza(String var0, Uri var1) {
      zzb(var0, var1);
      if(zzk(var1)) {
         return new Intent("android.intent.action.VIEW", var1);
      } else if(zzl(var1)) {
         return new Intent("android.intent.action.VIEW", zzj(var1));
      } else {
         throw new RuntimeException("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: " + var1);
      }
   }

   private PendingResult<Status> zza(GoogleApiClient var1, Action var2, int var3) {
      String var4 = var1.getContext().getPackageName();
      return this.zza(var1, new UsageInfo[]{zzkj.zza(var2, System.currentTimeMillis(), var4, var3)});
   }

   private static void zzb(String var0, Uri var1) {
      if(zzk(var1)) {
         if(var1.getHost().isEmpty()) {
            throw new IllegalArgumentException("AppIndex: The web URL must have a host (follow the format http(s)://<host>/[path]). Provided URI: " + var1);
         }
      } else {
         if(!zzl(var1)) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must either be \'http(s)\' or \'android-app\'. If the latter, it must follow the format \'android-app://<package_name>/<scheme>/[host_path]\'. Provided URI: " + var1);
         }

         if(var0 != null && !var0.equals(var1.getHost())) {
            throw new IllegalArgumentException("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/[host_path]. Provided URI: " + var1);
         }

         List var2 = var1.getPathSegments();
         if(var2.isEmpty() || ((String)var2.get(0)).isEmpty()) {
            throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + var1);
         }
      }

   }

   private static Uri zzj(Uri var0) {
      List var1 = var0.getPathSegments();
      String var2 = (String)var1.get(0);
      Builder var3 = new Builder();
      var3.scheme(var2);
      if(var1.size() > 1) {
         var3.authority((String)var1.get(1));

         for(int var8 = 2; var8 < var1.size(); ++var8) {
            var3.appendPath((String)var1.get(var8));
         }
      }

      var3.encodedQuery(var0.getEncodedQuery());
      var3.encodedFragment(var0.getEncodedFragment());
      return var3.build();
   }

   private static boolean zzk(Uri var0) {
      String var1 = var0.getScheme();
      return "http".equals(var1) || "https".equals(var1);
   }

   private static boolean zzl(Uri var0) {
      return "android-app".equals(var0.getScheme());
   }

   public PendingResult<Status> end(GoogleApiClient var1, Action var2) {
      return this.zza(var1, var2, 2);
   }

   public PendingResult<Status> start(GoogleApiClient var1, Action var2) {
      return this.zza(var1, var2, 1);
   }

   public PendingResult<Status> zza(final GoogleApiClient var1, final UsageInfo... var2) {
      return var1.zza((com.google.android.gms.common.api.internal.zza.zza)(new zzkk.zzc(var1) {
         // $FF: synthetic field
         final String zzUA;

         {
            this.zzUA = var3;
         }

         protected void zza(zzkf var1) throws RemoteException {
            var1.zza(new zzkk.zzd(this), this.zzUA, (UsageInfo[])var2);
         }
      }));
   }

   private abstract static class zzb<T extends Result> extends com.google.android.gms.common.api.internal.zza.zza<T, zzki> {
      public zzb(GoogleApiClient var1) {
         super(com.google.android.gms.appdatasearch.zza.zzTy, var1);
      }

      protected abstract void zza(zzkf var1) throws RemoteException;

      protected final void zza(zzki var1) throws RemoteException {
         this.zza(var1.zzmj());
      }
   }

   private abstract static class zzc<T extends Result> extends zzkk.zzb<Status> {
      zzc(GoogleApiClient var1) {
         super(var1);
      }

      protected Status zzb(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      protected Result zzc(Status var1) {
         return this.zzb(var1);
      }
   }

   private static final class zzd extends zzkh<Status> {
      public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> var1) {
         super(var1);
      }

      public void zza(Status var1) {
         this.zzUz.zzs(var1);
      }
   }
}
