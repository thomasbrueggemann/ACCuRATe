package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.class_720;
import com.google.android.gms.tagmanager.class_613;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.tagmanager.a
class class_675 {
   private static class_675 aqa;
   // $FF: renamed from: xO java.lang.Object
   private static Object field_2912 = new Object();
   private volatile long apW;
   private volatile long apX;
   private volatile long apY;
   private class_675.class_1678 apZ;
   private volatile boolean mClosed;
   private final Context mContext;
   // $FF: renamed from: wb com.google.android.gms.internal.ld
   private final class_141 field_2913;
   // $FF: renamed from: wu java.lang.Thread
   private final Thread field_2914;
   // $FF: renamed from: xQ com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   private volatile AdvertisingIdClient.Info field_2915;

   private class_675(Context var1) {
      this(var1, (class_675.class_1678)null, class_720.method_4198());
   }

   class_675(Context var1, class_675.class_1678 var2, class_141 var3) {
      this.apW = 900000L;
      this.apX = 30000L;
      this.mClosed = false;
      this.apZ = new class_675.class_1678() {
         // $FF: renamed from: pd () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
         public AdvertisingIdClient.Info method_934() {
            try {
               AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(class_675.this.mContext);
               return var6;
            } catch (IllegalStateException var7) {
               class_613.method_3494("IllegalStateException getting Advertising Id Info");
               return null;
            } catch (GooglePlayServicesRepairableException var8) {
               class_613.method_3494("GooglePlayServicesRepairableException getting Advertising Id Info");
               return null;
            } catch (IOException var9) {
               class_613.method_3494("IOException getting Ad Id Info");
               return null;
            } catch (GooglePlayServicesNotAvailableException var10) {
               class_613.method_3494("GooglePlayServicesNotAvailableException getting Advertising Id Info");
               return null;
            } catch (Exception var11) {
               class_613.method_3494("Unknown exception. Could not get the Advertising Id Info.");
               return null;
            }
         }
      };
      this.field_2913 = var3;
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      if(var2 != null) {
         this.apZ = var2;
      }

      this.field_2914 = new Thread(new Runnable() {
         public void run() {
            class_675.this.method_3832();
         }
      });
   }

   // $FF: renamed from: W (android.content.Context) com.google.android.gms.tagmanager.a
   static class_675 method_3829(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: pb () void
   private void method_3832() {
      Process.setThreadPriority(10);

      while(!this.mClosed) {
         try {
            this.field_2915 = this.apZ.method_934();
            Thread.sleep(this.apW);
         } catch (InterruptedException var2) {
            class_613.method_3492("sleep interrupted in AdvertiserDataPoller thread; continuing");
         }
      }

   }

   // $FF: renamed from: pc () void
   private void method_3833() {
      if(this.field_2913.currentTimeMillis() - this.apY >= this.apX) {
         this.interrupt();
         this.apY = this.field_2913.currentTimeMillis();
      }
   }

   void interrupt() {
      this.field_2914.interrupt();
   }

   public boolean isLimitAdTrackingEnabled() {
      this.method_3833();
      return this.field_2915 == null?true:this.field_2915.isLimitAdTrackingEnabled();
   }

   // $FF: renamed from: pa () java.lang.String
   public String method_3834() {
      this.method_3833();
      return this.field_2915 == null?null:this.field_2915.getId();
   }

   void start() {
      this.field_2914.start();
   }

   public interface class_1678 {
      // $FF: renamed from: pd () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
      AdvertisingIdClient.Info method_934();
   }
}
