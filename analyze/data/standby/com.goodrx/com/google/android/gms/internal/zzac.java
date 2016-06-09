package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zzl;
import com.google.android.gms.internal.zzt;
import com.google.android.gms.internal.zzv;
import com.google.android.gms.internal.zzw;
import com.google.android.gms.internal.zzy;
import com.google.android.gms.internal.zzz;
import java.io.File;

public class zzac {
   public static zzl zza(Context var0) {
      return zza(var0, (zzy)null);
   }

   public static zzl zza(Context var0, zzy var1) {
      File var2 = new File(var0.getCacheDir(), "volley");
      String var3 = "volley/0";

      label20: {
         String var9;
         try {
            String var7 = var0.getPackageName();
            PackageInfo var8 = var0.getPackageManager().getPackageInfo(var7, 0);
            var9 = var7 + "/" + var8.versionCode;
         } catch (NameNotFoundException var10) {
            break label20;
         }

         var3 = var9;
      }

      if(var1 == null) {
         if(VERSION.SDK_INT >= 9) {
            var1 = new zzz();
         } else {
            var1 = new zzw(AndroidHttpClient.newInstance(var3));
         }
      }

      zzt var5 = new zzt((zzy)var1);
      zzl var6 = new zzl(new zzv(var2), var5);
      var6.start();
      return var6;
   }
}
