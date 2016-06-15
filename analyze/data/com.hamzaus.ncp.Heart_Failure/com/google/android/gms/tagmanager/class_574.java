package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.class_279;
import com.google.android.gms.tagmanager.class_515;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.tagmanager.a
class class_574 {
   private static class_574 aee;
   // $FF: renamed from: tn java.lang.Object
   private static Object field_3022 = new Object();
   private volatile long adZ;
   private volatile long aea;
   private volatile long aeb;
   private final class_19 aec;
   private class_574.class_1293 aed;
   private volatile boolean mClosed;
   private final Context mContext;
   // $FF: renamed from: sc java.lang.Thread
   private final Thread field_3023;
   // $FF: renamed from: tp com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   private volatile AdvertisingIdClient.Info field_3024;

   private class_574(Context var1) {
      this(var1, (class_574.class_1293)null, class_279.method_1858());
   }

   class_574(Context var1, class_574.class_1293 var2, class_19 var3) {
      this.adZ = 900000L;
      this.aea = 30000L;
      this.mClosed = false;
      this.aed = new class_574.class_1293() {
         // $FF: renamed from: lb () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
         public AdvertisingIdClient.Info method_764() {
            try {
               AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(class_574.this.mContext);
               return var6;
            } catch (IllegalStateException var7) {
               class_515.method_2919("IllegalStateException getting Advertising Id Info");
               return null;
            } catch (GooglePlayServicesRepairableException var8) {
               class_515.method_2919("GooglePlayServicesRepairableException getting Advertising Id Info");
               return null;
            } catch (IOException var9) {
               class_515.method_2919("IOException getting Ad Id Info");
               return null;
            } catch (GooglePlayServicesNotAvailableException var10) {
               class_515.method_2919("GooglePlayServicesNotAvailableException getting Advertising Id Info");
               return null;
            } catch (Exception var11) {
               class_515.method_2919("Unknown exception. Could not get the Advertising Id Info.");
               return null;
            }
         }
      };
      this.aec = var3;
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      if(var2 != null) {
         this.aed = var2;
      }

      this.field_3023 = new Thread(new Runnable() {
         public void run() {
            class_574.this.method_3200();
         }
      });
   }

   // $FF: renamed from: J (android.content.Context) com.google.android.gms.tagmanager.a
   static class_574 method_3197(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: kZ () void
   private void method_3200() {
      Process.setThreadPriority(10);

      while(!this.mClosed) {
         try {
            this.field_3024 = this.aed.method_764();
            Thread.sleep(this.adZ);
         } catch (InterruptedException var2) {
            class_515.method_2917("sleep interrupted in AdvertiserDataPoller thread; continuing");
         }
      }

   }

   // $FF: renamed from: la () void
   private void method_3201() {
      if(this.aec.currentTimeMillis() - this.aeb >= this.aea) {
         this.interrupt();
         this.aeb = this.aec.currentTimeMillis();
      }
   }

   void interrupt() {
      this.field_3023.interrupt();
   }

   public boolean isLimitAdTrackingEnabled() {
      this.method_3201();
      return this.field_3024 == null?true:this.field_3024.isLimitAdTrackingEnabled();
   }

   // $FF: renamed from: kY () java.lang.String
   public String method_3202() {
      this.method_3201();
      return this.field_3024 == null?null:this.field_3024.getId();
   }

   void start() {
      this.field_3023.start();
   }

   public interface class_1293 {
      // $FF: renamed from: lb () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
      AdvertisingIdClient.Info method_764();
   }
}
