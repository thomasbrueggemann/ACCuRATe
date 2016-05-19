package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
   private final Context mContext;
   com.google.android.gms.common.zza zzoS;
   zzat zzoT;
   boolean zzoU;
   Object zzoV;
   AdvertisingIdClient.zza zzoW;
   final long zzoX;

   public AdvertisingIdClient(Context var1) {
      this(var1, 30000L);
   }

   public AdvertisingIdClient(Context var1, long var2) {
      this.zzoV = new Object();
      zzx.zzz(var1);
      this.mContext = var1;
      this.zzoU = false;
      this.zzoX = var2;
   }

   public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      AdvertisingIdClient var1 = new AdvertisingIdClient(var0, -1L);

      AdvertisingIdClient.Info var3;
      try {
         var1.zzb(false);
         var3 = var1.getInfo();
      } finally {
         var1.finish();
      }

      return var3;
   }

   public static void setShouldSkipGmsCoreVersionCheck(boolean var0) {
   }

   static zzat zza(Context var0, com.google.android.gms.common.zza var1) throws IOException {
      try {
         zzat var4 = zzat.zza.zzb(var1.zzoJ());
         return var4;
      } catch (InterruptedException var5) {
         throw new IOException("Interrupted exception");
      } catch (Throwable var6) {
         throw new IOException(var6);
      }
   }

   private void zzaJ() {
      // $FF: Couldn't be decompiled
   }

   static com.google.android.gms.common.zza zzp(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var9) {
         throw new GooglePlayServicesNotAvailableException(9);
      }

      switch(zzc.zzoK().isGooglePlayServicesAvailable(var0)) {
      case 0:
      case 2:
         com.google.android.gms.common.zza var3 = new com.google.android.gms.common.zza();
         Intent var4 = new Intent("com.google.android.gms.ads.identifier.service.START");
         var4.setPackage("com.google.android.gms");

         boolean var7;
         try {
            var7 = zzb.zzrP().zza(var0, var4, var3, 1);
         } catch (Throwable var8) {
            throw new IOException(var8);
         }

         if(var7) {
            return var3;
         }

         throw new IOException("Connection failure");
      case 1:
      default:
         throw new IOException("Google Play services not available");
      }
   }

   protected void finalize() throws Throwable {
      this.finish();
      super.finalize();
   }

   public void finish() {
      // $FF: Couldn't be decompiled
   }

   public AdvertisingIdClient.Info getInfo() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      this.zzb(true);
   }

   protected void zzb(boolean param1) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      // $FF: Couldn't be decompiled
   }

   public static final class Info {
      private final String zzpc;
      private final boolean zzpd;

      public Info(String var1, boolean var2) {
         this.zzpc = var1;
         this.zzpd = var2;
      }

      public String getId() {
         return this.zzpc;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.zzpd;
      }

      public String toString() {
         return "{" + this.zzpc + "}" + this.zzpd;
      }
   }

   static class zza extends Thread {
      private WeakReference<AdvertisingIdClient> zzoY;
      private long zzoZ;
      CountDownLatch zzpa;
      boolean zzpb;

      public zza(AdvertisingIdClient var1, long var2) {
         this.zzoY = new WeakReference(var1);
         this.zzoZ = var2;
         this.zzpa = new CountDownLatch(1);
         this.zzpb = false;
         this.start();
      }

      private void disconnect() {
         AdvertisingIdClient var1 = (AdvertisingIdClient)this.zzoY.get();
         if(var1 != null) {
            var1.finish();
            this.zzpb = true;
         }

      }

      public void cancel() {
         this.zzpa.countDown();
      }

      public void run() {
         try {
            if(!this.zzpa.await(this.zzoZ, TimeUnit.MILLISECONDS)) {
               this.disconnect();
            }

         } catch (InterruptedException var2) {
            this.disconnect();
         }
      }

      public boolean zzaK() {
         return this.zzpb;
      }
   }
}
