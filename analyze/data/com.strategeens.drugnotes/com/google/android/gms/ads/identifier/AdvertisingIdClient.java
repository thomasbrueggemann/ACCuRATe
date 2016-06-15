package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_861;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_70;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
   // $FF: renamed from: ln com.google.android.gms.common.a
   class_861 field_2868;
   // $FF: renamed from: lo com.google.android.gms.internal.s
   class_70 field_2869;
   // $FF: renamed from: lp boolean
   boolean field_2870;
   // $FF: renamed from: lq java.lang.Object
   Object field_2871;
   // $FF: renamed from: lr com.google.android.gms.ads.identifier.AdvertisingIdClient$a
   AdvertisingIdClient.class_1156 field_2872;
   // $FF: renamed from: ls long
   final long field_2873;
   private final Context mContext;

   public AdvertisingIdClient(Context var1) {
      this(var1, 30000L);
   }

   public AdvertisingIdClient(Context var1, long var2) {
      this.field_2871 = new Object();
      class_335.method_2311(var1);
      this.mContext = var1;
      this.field_2870 = false;
      this.field_2873 = var2;
   }

   // $FF: renamed from: Z () void
   private void method_3777() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.common.a) com.google.android.gms.internal.s
   static class_70 method_3778(Context var0, class_861 var1) throws IOException {
      try {
         class_70 var3 = class_70.class_1374.method_5767(var1.method_4824());
         return var3;
      } catch (InterruptedException var4) {
         throw new IOException("Interrupted exception");
      }
   }

   public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      AdvertisingIdClient var1 = new AdvertisingIdClient(var0, -1L);

      AdvertisingIdClient.Info var3;
      try {
         var1.method_3780(false);
         var3 = var1.getInfo();
      } finally {
         var1.finish();
      }

      return var3;
   }

   // $FF: renamed from: h (android.content.Context) com.google.android.gms.common.a
   static class_861 method_3779(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var7) {
         throw new GooglePlayServicesNotAvailableException(9);
      }

      try {
         GooglePlayServicesUtil.method_4791(var0);
      } catch (GooglePlayServicesNotAvailableException var6) {
         throw new IOException(var6);
      }

      class_861 var4 = new class_861();
      Intent var5 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var5.setPackage("com.google.android.gms");
      if(var0.bindService(var5, var4, 1)) {
         return var4;
      } else {
         throw new IOException("Connection failure");
      }
   }

   // $FF: renamed from: b (boolean) void
   protected void method_3780(boolean param1) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      // $FF: Couldn't be decompiled
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
      this.method_3780(true);
   }

   public static final class Info {
      // $FF: renamed from: lx java.lang.String
      private final String field_4413;
      // $FF: renamed from: ly boolean
      private final boolean field_4414;

      public Info(String var1, boolean var2) {
         this.field_4413 = var1;
         this.field_4414 = var2;
      }

      public String getId() {
         return this.field_4413;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.field_4414;
      }

      public String toString() {
         return "{" + this.field_4413 + "}" + this.field_4414;
      }
   }

   static class class_1156 extends Thread {
      // $FF: renamed from: lt java.lang.ref.WeakReference
      private WeakReference<AdvertisingIdClient> field_1606;
      // $FF: renamed from: lu long
      private long field_1607;
      // $FF: renamed from: lv java.util.concurrent.CountDownLatch
      CountDownLatch field_1608;
      // $FF: renamed from: lw boolean
      boolean field_1609;

      public class_1156(AdvertisingIdClient var1, long var2) {
         this.field_1606 = new WeakReference(var1);
         this.field_1607 = var2;
         this.field_1608 = new CountDownLatch(1);
         this.field_1609 = false;
         this.start();
      }

      private void disconnect() {
         AdvertisingIdClient var1 = (AdvertisingIdClient)this.field_1606.get();
         if(var1 != null) {
            var1.finish();
            this.field_1609 = true;
         }

      }

      // $FF: renamed from: aa () boolean
      public boolean method_3000() {
         return this.field_1609;
      }

      public void cancel() {
         this.field_1608.countDown();
      }

      public void run() {
         try {
            if(!this.field_1608.await(this.field_1607, TimeUnit.MILLISECONDS)) {
               this.disconnect();
            }

         } catch (InterruptedException var2) {
            this.disconnect();
         }
      }
   }
}
