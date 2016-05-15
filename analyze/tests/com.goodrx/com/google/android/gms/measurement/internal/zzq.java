package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzz;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class zzq extends zzz {
   public zzq(zzw var1) {
      super(var1);
   }

   // $FF: synthetic method
   static byte[] zza(zzq var0, HttpURLConnection var1) throws IOException {
      return var0.zzc(var1);
   }

   @WorkerThread
   private byte[] zzc(HttpURLConnection param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   @WorkerThread
   public void zza(String var1, URL var2, Map<String, String> var3, zzq.zza var4) {
      this.zzjk();
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var2);
      com.google.android.gms.common.internal.zzx.zzz(var4);
      this.zzCn().zzh(new zzq.zzc(var1, var2, (byte[])null, var3, var4));
   }

   @WorkerThread
   public void zza(String var1, URL var2, byte[] var3, Map<String, String> var4, zzq.zza var5) {
      this.zzjk();
      this.zzjv();
      com.google.android.gms.common.internal.zzx.zzz(var2);
      com.google.android.gms.common.internal.zzx.zzz(var3);
      com.google.android.gms.common.internal.zzx.zzz(var5);
      this.zzCn().zzh(new zzq.zzc(var1, var2, var3, var4, var5));
   }

   @WorkerThread
   protected HttpURLConnection zzc(URL var1) throws IOException {
      URLConnection var2 = HttpInstrumentation.openConnection(var1.openConnection());
      if(!(var2 instanceof HttpURLConnection)) {
         throw new IOException("Failed to obtain HTTP connection");
      } else {
         HttpURLConnection var3 = (HttpURLConnection)var2;
         var3.setDefaultUseCaches(false);
         var3.setConnectTimeout((int)this.zzCp().zzBO());
         var3.setReadTimeout((int)this.zzCp().zzBP());
         var3.setInstanceFollowRedirects(false);
         var3.setDoInput(true);
         return var3;
      }
   }

   protected void zziJ() {
   }

   public boolean zzlB() {
      this.zzjv();
      ConnectivityManager var1 = (ConnectivityManager)this.getContext().getSystemService("connectivity");

      NetworkInfo var3;
      NetworkInfo var4;
      try {
         var4 = var1.getActiveNetworkInfo();
      } catch (SecurityException var5) {
         var3 = null;
         return var3 != null && var3.isConnected();
      }

      var3 = var4;
      return var3 != null && var3.isConnected();
   }

   @WorkerThread
   interface zza {
      void zza(String var1, int var2, Throwable var3, byte[] var4);
   }

   @WorkerThread
   private static class zzb implements Runnable {
      private final int zzBc;
      private final String zzTJ;
      private final zzq.zza zzaWP;
      private final Throwable zzaWQ;
      private final byte[] zzaWR;

      private zzb(String var1, zzq.zza var2, int var3, Throwable var4, byte[] var5) {
         com.google.android.gms.common.internal.zzx.zzz(var2);
         this.zzaWP = var2;
         this.zzBc = var3;
         this.zzaWQ = var4;
         this.zzaWR = var5;
         this.zzTJ = var1;
      }

      // $FF: synthetic method
      zzb(String var1, zzq.zza var2, int var3, Throwable var4, byte[] var5, Object var6) {
         this(var1, var2, var3, var4, var5);
      }

      public void run() {
         this.zzaWP.zza(this.zzTJ, this.zzBc, this.zzaWQ, this.zzaWR);
      }
   }

   @WorkerThread
   private class zzc implements Runnable {
      private final String zzTJ;
      private final byte[] zzaWS;
      private final zzq.zza zzaWT;
      private final Map<String, String> zzaWU;
      private final URL zzzq;

      public zzc(String var1, URL var2, byte[] var3, Map<String, String> var4, zzq.zza var5) {
         com.google.android.gms.common.internal.zzx.zzcM(var2);
         com.google.android.gms.common.internal.zzx.zzz(var3);
         com.google.android.gms.common.internal.zzx.zzz(var6);
         this.zzzq = var3;
         this.zzaWS = var4;
         this.zzaWT = var6;
         this.zzTJ = var2;
         this.zzaWU = var5;
      }

      public void run() {
         // $FF: Couldn't be decompiled
      }
   }
}
