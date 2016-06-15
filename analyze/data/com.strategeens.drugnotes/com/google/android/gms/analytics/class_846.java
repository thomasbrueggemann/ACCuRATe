package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.analytics.class_1055;
import com.google.android.gms.analytics.class_172;
import com.google.android.gms.analytics.class_863;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.analytics.a
class class_846 implements class_172 {
   // $FF: renamed from: xO java.lang.Object
   private static Object field_3512 = new Object();
   // $FF: renamed from: xP com.google.android.gms.analytics.a
   private static class_846 field_3513;
   private Context mContext;
   // $FF: renamed from: xQ com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   private AdvertisingIdClient.Info field_3514;
   // $FF: renamed from: xR long
   private long field_3515;
   // $FF: renamed from: xS java.lang.String
   private String field_3516;
   // $FF: renamed from: xT boolean
   private boolean field_3517 = false;
   // $FF: renamed from: xU java.lang.Object
   private Object field_3518 = new Object();

   class_846(Context var1) {
      this.mContext = var1.getApplicationContext();
   }

   // $FF: renamed from: a (com.google.android.gms.ads.identifier.AdvertisingIdClient$Info, com.google.android.gms.ads.identifier.AdvertisingIdClient$Info) boolean
   private boolean method_4670(AdvertisingIdClient.Info param1, AdvertisingIdClient.Info param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: aa (java.lang.String) java.lang.String
   static String method_4671(String var0) {
      MessageDigest var1 = class_1055.method_5798("MD5");
      if(var1 == null) {
         return null;
      } else {
         Locale var2 = Locale.US;
         Object[] var3 = new Object[]{new BigInteger(1, var1.digest(var0.getBytes()))};
         return String.format(var2, "%032X", var3);
      }
   }

   // $FF: renamed from: ab (java.lang.String) boolean
   private boolean method_4672(String var1) {
      try {
         String var4 = method_4671(var1);
         class_863.method_4841("Storing hashed adid.");
         FileOutputStream var5 = this.mContext.openFileOutput("gaClientIdData", 0);
         var5.write(var4.getBytes());
         var5.close();
         this.field_3516 = var4;
         return true;
      } catch (FileNotFoundException var6) {
         class_863.method_4839("Error creating hash file.");
         return false;
      } catch (IOException var7) {
         class_863.method_4839("Error writing to hash file.");
         return false;
      }
   }

   // $FF: renamed from: w (android.content.Context) com.google.android.gms.analytics.q
   public static class_172 method_4673(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: x (android.content.Context) java.lang.String
   static String method_4674(Context param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: dP () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   AdvertisingIdClient.Info method_4675() {
      try {
         AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
         return var6;
      } catch (IllegalStateException var7) {
         class_863.method_4842("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added \'<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\' to your application manifest file. See http://goo.gl/naFqQk for details.");
         return null;
      } catch (GooglePlayServicesRepairableException var8) {
         class_863.method_4842("GooglePlayServicesRepairableException getting Ad Id Info");
         return null;
      } catch (IOException var9) {
         class_863.method_4842("IOException getting Ad Id Info");
         return null;
      } catch (GooglePlayServicesNotAvailableException var10) {
         class_863.method_4842("GooglePlayServicesNotAvailableException getting Ad Id Info");
         return null;
      } catch (Throwable var11) {
         class_863.method_4842("Unknown exception. Could not get the ad Id.");
         return null;
      }
   }

   public String getValue(String var1) {
      long var2 = System.currentTimeMillis();
      if(var2 - this.field_3515 > 1000L) {
         AdvertisingIdClient.Info var4 = this.method_4675();
         if(this.method_4670(this.field_3514, var4)) {
            this.field_3514 = var4;
         } else {
            this.field_3514 = new AdvertisingIdClient.Info("", false);
         }

         this.field_3515 = var2;
      }

      if(this.field_3514 != null) {
         if("&adid".equals(var1)) {
            return this.field_3514.getId();
         }

         if("&ate".equals(var1)) {
            if(this.field_3514.isLimitAdTrackingEnabled()) {
               return "0";
            }

            return "1";
         }
      }

      return null;
   }
}
