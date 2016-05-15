package com.google.ads.conversiontracking;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.ads.conversiontracking.class_0;
import com.google.ads.conversiontracking.class_78;
import com.google.ads.conversiontracking.class_81;
import com.google.ads.conversiontracking.class_83;
import com.google.ads.conversiontracking.class_84;
import com.google.ads.conversiontracking.class_85;
import java.io.IOException;

// $FF: renamed from: com.google.ads.conversiontracking.i
public final class class_77 {
   // $FF: renamed from: a (android.content.Context) com.google.ads.conversiontracking.i$a
   public static class_77.class_100 method_519(Context var0) throws IOException, IllegalStateException, class_78, class_83 {
      class_85.method_561("Calling this from your main thread can lead to deadlock");
      return method_520(var0, method_521(var0));
   }

   // $FF: renamed from: a (android.content.Context, com.google.ads.conversiontracking.n) com.google.ads.conversiontracking.i$a
   static class_77.class_100 method_520(Context var0, class_81 var1) throws IOException {
      class_77.class_100 var9;
      try {
         class_0 var8 = class_0.class_114.method_352(var1.method_549());
         var9 = new class_77.class_100(var8.method_24(), var8.method_27(true));
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

   // $FF: renamed from: b (android.content.Context) com.google.ads.conversiontracking.n
   private static class_81 method_521(Context var0) throws IOException, class_78, class_83 {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var7) {
         throw new class_78(9);
      }

      try {
         class_84.method_558(var0);
      } catch (class_78 var6) {
         throw new IOException(var6);
      }

      class_81 var4 = new class_81();
      Intent var5 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var5.setPackage("com.google.android.gms");
      if(var0.bindService(var5, var4, 1)) {
         return var4;
      } else {
         throw new IOException("Connection failure");
      }
   }

   public static final class class_100 {
      // $FF: renamed from: a java.lang.String
      private final String field_214;
      // $FF: renamed from: b boolean
      private final boolean field_215;

      public class_100(String var1, boolean var2) {
         this.field_214 = var1;
         this.field_215 = var2;
      }

      // $FF: renamed from: a () java.lang.String
      public String method_169() {
         return this.field_214;
      }

      // $FF: renamed from: b () boolean
      public boolean method_170() {
         return this.field_215;
      }
   }
}
