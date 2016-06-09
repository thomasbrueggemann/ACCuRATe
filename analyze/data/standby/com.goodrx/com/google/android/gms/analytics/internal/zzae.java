package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzs;
import com.google.android.gms.analytics.internal.zzy;

@Deprecated
public class zzae {
   private static volatile Logger zzSV;

   static {
      setLogger(new zzs());
   }

   public static Logger getLogger() {
      return zzSV;
   }

   public static void setLogger(Logger var0) {
      zzSV = var0;
   }

   // $FF: renamed from: v (java.lang.String) void
   public static void method_303(String var0) {
      zzaf var1 = zzaf.zzlx();
      if(var1 != null) {
         var1.zzbd(var0);
      } else if(zzQ(0)) {
         Log.v((String)zzy.zzRL.get(), var0);
      }

      Logger var3 = zzSV;
      if(var3 != null) {
         var3.verbose(var0);
      }

   }

   public static boolean zzQ(int var0) {
      Logger var1 = getLogger();
      boolean var2 = false;
      if(var1 != null) {
         int var3 = getLogger().getLogLevel();
         var2 = false;
         if(var3 <= var0) {
            var2 = true;
         }
      }

      return var2;
   }

   public static void zzaJ(String var0) {
      zzaf var1 = zzaf.zzlx();
      if(var1 != null) {
         var1.zzbf(var0);
      } else if(zzQ(1)) {
         Log.i((String)zzy.zzRL.get(), var0);
      }

      Logger var3 = zzSV;
      if(var3 != null) {
         var3.info(var0);
      }

   }

   public static void zzaK(String var0) {
      zzaf var1 = zzaf.zzlx();
      if(var1 != null) {
         var1.zzbg(var0);
      } else if(zzQ(2)) {
         Log.w((String)zzy.zzRL.get(), var0);
      }

      Logger var3 = zzSV;
      if(var3 != null) {
         var3.warn(var0);
      }

   }

   public static void zzf(String var0, Object var1) {
      zzaf var2 = zzaf.zzlx();
      if(var2 != null) {
         var2.zze(var0, var1);
      } else if(zzQ(3)) {
         String var3;
         if(var1 != null) {
            var3 = var0 + ":" + var1;
         } else {
            var3 = var0;
         }

         Log.e((String)zzy.zzRL.get(), var3);
      }

      Logger var5 = zzSV;
      if(var5 != null) {
         var5.error(var0);
      }

   }
}
