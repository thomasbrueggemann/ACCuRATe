package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.class_287;
import com.google.android.gms.internal.class_814;
import com.google.android.gms.internal.class_815;
import com.google.android.gms.internal.class_818;

// $FF: renamed from: com.google.android.gms.internal.op
public class class_819 {
   private final class_287 amU;
   private class_814 amV;

   public class_819(Context var1, int var2, String var3, String var4, class_819.class_1659 var5, boolean var6) {
      String var7 = var1.getPackageName();

      int var10;
      try {
         var10 = var1.getPackageManager().getPackageInfo(var7, 0).versionCode;
      } catch (NameNotFoundException var11) {
         Log.wtf("PlayLogger", "This can\'t happen.");
         var10 = 0;
      }

      this.amV = new class_814(var7, var10, var2, var3, var4, var6);
      this.amU = new class_287(var1, new class_815(var5));
   }

   // $FF: renamed from: a (long, java.lang.String, byte[], java.lang.String[]) void
   public void method_4474(long var1, String var3, byte[] var4, String... var5) {
      this.amU.method_1835(this.amV, new class_818(var1, var3, var4, var5));
   }

   // $FF: renamed from: b (java.lang.String, byte[], java.lang.String[]) void
   public void method_4475(String var1, byte[] var2, String... var3) {
      this.method_4474(System.currentTimeMillis(), var1, var2, var3);
   }

   public void start() {
      this.amU.start();
   }

   public void stop() {
      this.amU.stop();
   }

   public interface class_1659 {
      // $FF: renamed from: d (android.app.PendingIntent) void
      void method_921(PendingIntent var1);

      // $FF: renamed from: on () void
      void method_922();

      // $FF: renamed from: oo () void
      void method_923();
   }
}
