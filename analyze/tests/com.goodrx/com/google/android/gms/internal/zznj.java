package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzni;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zznj {
   private static final Method zzaol = zzsp();
   private static final Method zzaom = zzsq();
   private static final Method zzaon = zzsr();
   private static final Method zzaoo = zzss();
   private static final Method zzaop = zzst();

   public static int zza(WorkSource var0) {
      if(zzaon != null) {
         try {
            int var3 = ((Integer)zzaon.invoke(var0, new Object[0])).intValue();
            return var3;
         } catch (Exception var4) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", var4);
         }
      }

      return 0;
   }

   public static String zza(WorkSource var0, int var1) {
      if(zzaop != null) {
         try {
            Method var4 = zzaop;
            Object[] var5 = new Object[]{Integer.valueOf(var1)};
            String var6 = (String)var4.invoke(var0, var5);
            return var6;
         } catch (Exception var7) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", var7);
         }
      }

      return null;
   }

   public static void zza(WorkSource var0, int var1, String var2) {
      if(zzaom != null) {
         if(var2 == null) {
            var2 = "";
         }

         try {
            Method var10 = zzaom;
            Object[] var11 = new Object[]{Integer.valueOf(var1), var2};
            var10.invoke(var0, var11);
         } catch (Exception var13) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", var13);
            return;
         }
      } else if(zzaol != null) {
         try {
            Method var5 = zzaol;
            Object[] var6 = new Object[]{Integer.valueOf(var1)};
            var5.invoke(var0, var6);
            return;
         } catch (Exception var12) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", var12);
            return;
         }
      }

   }

   public static boolean zzaA(Context var0) {
      if(var0 != null) {
         PackageManager var1 = var0.getPackageManager();
         if(var1 != null && var1.checkPermission("android.permission.UPDATE_DEVICE_STATS", var0.getPackageName()) == 0) {
            return true;
         }
      }

      return false;
   }

   public static List<String> zzb(WorkSource var0) {
      int var1 = 0;
      int var2;
      if(var0 == null) {
         var2 = 0;
      } else {
         var2 = zza(var0);
      }

      Object var3;
      if(var2 == 0) {
         var3 = Collections.EMPTY_LIST;
      } else {
         for(var3 = new ArrayList(); var1 < var2; ++var1) {
            String var4 = zza(var0, var1);
            if(!zzni.zzcV(var4)) {
               ((List)var3).add(var4);
            }
         }
      }

      return (List)var3;
   }

   public static WorkSource zzf(int var0, String var1) {
      WorkSource var2 = new WorkSource();
      zza(var2, var0, var1);
      return var2;
   }

   public static WorkSource zzl(Context var0, String var1) {
      if(var0 != null && var0.getPackageManager() != null) {
         ApplicationInfo var4;
         try {
            var4 = var0.getPackageManager().getApplicationInfo(var1, 0);
         } catch (NameNotFoundException var5) {
            Log.e("WorkSourceUtil", "Could not find package: " + var1);
            return null;
         }

         if(var4 == null) {
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + var1);
            return null;
         } else {
            return zzf(var4.uid, var1);
         }
      } else {
         return null;
      }
   }

   private static Method zzsp() {
      try {
         Class[] var1 = new Class[]{Integer.TYPE};
         Method var2 = WorkSource.class.getMethod("add", var1);
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   private static Method zzsq() {
      boolean var0 = zzne.zzsj();
      Method var1 = null;
      if(var0) {
         Method var4;
         try {
            Class[] var3 = new Class[]{Integer.TYPE, String.class};
            var4 = WorkSource.class.getMethod("add", var3);
         } catch (Exception var5) {
            return null;
         }

         var1 = var4;
      }

      return var1;
   }

   private static Method zzsr() {
      try {
         Method var1 = WorkSource.class.getMethod("size", new Class[0]);
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   private static Method zzss() {
      try {
         Class[] var1 = new Class[]{Integer.TYPE};
         Method var2 = WorkSource.class.getMethod("get", var1);
         return var2;
      } catch (Exception var3) {
         return null;
      }
   }

   private static Method zzst() {
      boolean var0 = zzne.zzsj();
      Method var1 = null;
      if(var0) {
         Method var4;
         try {
            Class[] var3 = new Class[]{Integer.TYPE};
            var4 = WorkSource.class.getMethod("getName", var3);
         } catch (Exception var5) {
            return null;
         }

         var1 = var4;
      }

      return var1;
   }
}
