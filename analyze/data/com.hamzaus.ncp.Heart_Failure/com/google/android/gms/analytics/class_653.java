package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.analytics.class_138;
import com.google.android.gms.analytics.class_669;
import com.google.android.gms.analytics.class_671;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.analytics.a
class class_653 implements class_138 {
   // $FF: renamed from: tn java.lang.Object
   private static Object field_3414 = new Object();
   // $FF: renamed from: to com.google.android.gms.analytics.a
   private static class_653 field_3415;
   private Context mContext;
   // $FF: renamed from: tp com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   private AdvertisingIdClient.Info field_3416;
   // $FF: renamed from: tq long
   private long field_3417;
   // $FF: renamed from: tr java.lang.String
   private String field_3418;
   // $FF: renamed from: ts boolean
   private boolean field_3419 = false;
   // $FF: renamed from: tt java.lang.Object
   private Object field_3420 = new Object();

   class_653(Context var1) {
      this.mContext = var1.getApplicationContext();
   }

   // $FF: renamed from: H (java.lang.String) java.lang.String
   static String method_3731(String var0) {
      MessageDigest var1 = class_671.method_3907("MD5");
      if(var1 == null) {
         return null;
      } else {
         Locale var2 = Locale.US;
         Object[] var3 = new Object[]{new BigInteger(1, var1.digest(var0.getBytes()))};
         return String.format(var2, "%032X", var3);
      }
   }

   // $FF: renamed from: I (java.lang.String) boolean
   private boolean method_3732(String var1) {
      try {
         String var4 = method_3731(var1);
         class_669.method_3890("Storing hashed adid.");
         FileOutputStream var5 = this.mContext.openFileOutput("gaClientIdData", 0);
         var5.write(var4.getBytes());
         var5.close();
         this.field_3418 = var4;
         return true;
      } catch (FileNotFoundException var6) {
         class_669.method_3888("Error creating hash file.");
         return false;
      } catch (IOException var7) {
         class_669.method_3888("Error writing to hash file.");
         return false;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.ads.identifier.AdvertisingIdClient$Info, com.google.android.gms.ads.identifier.AdvertisingIdClient$Info) boolean
   private boolean method_3733(AdvertisingIdClient.Info param1, AdvertisingIdClient.Info param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: p (android.content.Context) com.google.android.gms.analytics.m
   public static class_138 method_3734(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: q (android.content.Context) java.lang.String
   static String method_3735(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: cf () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   AdvertisingIdClient.Info method_3736() {
      try {
         AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
         return var6;
      } catch (IllegalStateException var7) {
         class_669.method_3891("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added \'<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\' to your application manifest file. See http://goo.gl/naFqQk for details.");
         return null;
      } catch (GooglePlayServicesRepairableException var8) {
         class_669.method_3891("GooglePlayServicesRepairableException getting Ad Id Info");
         return null;
      } catch (IOException var9) {
         class_669.method_3891("IOException getting Ad Id Info");
         return null;
      } catch (GooglePlayServicesNotAvailableException var10) {
         class_669.method_3891("GooglePlayServicesNotAvailableException getting Ad Id Info");
         return null;
      } catch (Exception var11) {
         class_669.method_3891("Unknown exception. Could not get the ad Id.");
         return null;
      }
   }

   public String getValue(String var1) {
      long var2 = System.currentTimeMillis();
      if(var2 - this.field_3417 > 1000L) {
         AdvertisingIdClient.Info var4 = this.method_3736();
         if(this.method_3733(this.field_3416, var4)) {
            this.field_3416 = var4;
         } else {
            this.field_3416 = new AdvertisingIdClient.Info("", false);
         }

         this.field_3417 = var2;
      }

      if(this.field_3416 != null) {
         if("&adid".equals(var1)) {
            return this.field_3416.getId();
         }

         if("&ate".equals(var1)) {
            if(this.field_3416.isLimitAdTrackingEnabled()) {
               return "0";
            }

            return "1";
         }
      }

      return null;
   }
}
