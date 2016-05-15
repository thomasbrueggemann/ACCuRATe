package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.analytics.internal.zzaj;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public class zza extends zzd {
   public static boolean zzPV;
   private AdvertisingIdClient.Info zzPW;
   private final zzaj zzPX;
   private String zzPY;
   private boolean zzPZ = false;
   private Object zzQa = new Object();

   zza(zzf var1) {
      super(var1);
      this.zzPX = new zzaj(var1.zzjl());
   }

   private boolean zza(AdvertisingIdClient.Info param1, AdvertisingIdClient.Info param2) {
      // $FF: Couldn't be decompiled
   }

   private static String zzbb(String var0) {
      MessageDigest var1 = zzam.zzbv("MD5");
      if(var1 == null) {
         return null;
      } else {
         Locale var2 = Locale.US;
         Object[] var3 = new Object[]{new BigInteger(1, var1.digest(var0.getBytes()))};
         return String.format(var2, "%032X", var3);
      }
   }

   private boolean zzbc(String var1) {
      try {
         String var3 = zzbb(var1);
         this.zzbd("Storing hashed adid.");
         FileOutputStream var4 = this.getContext().openFileOutput("gaClientIdData", 0);
         var4.write(var3.getBytes());
         var4.close();
         this.zzPY = var3;
         return true;
      } catch (IOException var5) {
         this.zze("Error creating hash file", var5);
         return false;
      }
   }

   private AdvertisingIdClient.Info zziZ() {
      // $FF: Couldn't be decompiled
   }

   protected void zziJ() {
   }

   public boolean zziU() {
      this.zzjv();
      AdvertisingIdClient.Info var1 = this.zziZ();
      boolean var2 = false;
      if(var1 != null) {
         boolean var3 = var1.isLimitAdTrackingEnabled();
         var2 = false;
         if(!var3) {
            var2 = true;
         }
      }

      return var2;
   }

   public String zziY() {
      this.zzjv();
      AdvertisingIdClient.Info var1 = this.zziZ();
      String var2;
      if(var1 != null) {
         var2 = var1.getId();
      } else {
         var2 = null;
      }

      return TextUtils.isEmpty(var2)?null:var2;
   }

   protected AdvertisingIdClient.Info zzja() {
      AdvertisingIdClient.Info var3;
      AdvertisingIdClient.Info var5;
      try {
         var5 = AdvertisingIdClient.getAdvertisingIdInfo(this.getContext());
      } catch (IllegalStateException var6) {
         this.zzbg("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added \'<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\' to your application manifest file. See http://goo.gl/naFqQk for details.");
         return null;
      } catch (Throwable var7) {
         boolean var2 = zzPV;
         var3 = null;
         if(var2) {
            return var3;
         }

         zzPV = true;
         this.zzd("Error getting advertiser id", var7);
         return null;
      }

      var3 = var5;
      return var3;
   }

   protected String zzjb() {
      // $FF: Couldn't be decompiled
   }
}
