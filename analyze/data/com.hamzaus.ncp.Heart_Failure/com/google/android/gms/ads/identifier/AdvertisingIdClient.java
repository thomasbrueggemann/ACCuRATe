package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_665;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_62;
import java.io.IOException;

public final class AdvertisingIdClient {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.common.a) com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
   static AdvertisingIdClient.Info method_3146(Context var0, class_665 var1) throws IOException {
      AdvertisingIdClient.Info var9;
      try {
         class_62 var8 = class_62.class_821.method_1817(var1.method_3853());
         var9 = new AdvertisingIdClient.Info(var8.getId(), var8.method_333(true));
      } catch (RemoteException var17) {
         Log.i("AdvertisingIdClient", "GMS remote exception ", var17);
         throw new IOException("Remote exception");
      } catch (InterruptedException var18) {
         throw new IOException("Interrupted exception");
      } finally {
         try {
            var0.unbindService(var1);
         } catch (IllegalArgumentException var16) {
            Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", var16);
         }

      }

      return var9;
   }

   // $FF: renamed from: g (android.content.Context) com.google.android.gms.common.a
   static class_665 method_3147(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var7) {
         throw new GooglePlayServicesNotAvailableException(9);
      }

      try {
         GooglePlayServicesUtil.method_3846(var0);
      } catch (GooglePlayServicesNotAvailableException var6) {
         throw new IOException(var6);
      }

      class_665 var4 = new class_665();
      Intent var5 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var5.setPackage("com.google.android.gms");
      if(var0.bindService(var5, var4, 1)) {
         return var4;
      } else {
         throw new IOException("Connection failure");
      }
   }

   public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
      class_347.method_2165("Calling this from your main thread can lead to deadlock");
      return method_3146(var0, method_3147(var0));
   }

   public static final class Info {
      // $FF: renamed from: kx java.lang.String
      private final String field_4257;
      // $FF: renamed from: ky boolean
      private final boolean field_4258;

      public Info(String var1, boolean var2) {
         this.field_4257 = var1;
         this.field_4258 = var2;
      }

      public String getId() {
         return this.field_4257;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.field_4258;
      }
   }
}
