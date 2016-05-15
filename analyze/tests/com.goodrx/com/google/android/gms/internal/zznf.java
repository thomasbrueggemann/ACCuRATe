package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Binder;
import java.util.Iterator;
import java.util.List;

public class zznf {
   private static String zza(StackTraceElement[] var0, int var1) {
      if(var1 + 4 >= var0.length) {
         return "<bottom of call stack>";
      } else {
         StackTraceElement var2 = var0[var1 + 4];
         return var2.getClassName() + "." + var2.getMethodName() + ":" + var2.getLineNumber();
      }
   }

   public static String zzaz(Context var0) {
      return zzi(var0, Binder.getCallingPid());
   }

   public static String zzi(Context var0, int var1) {
      List var2 = ((ActivityManager)var0.getSystemService("activity")).getRunningAppProcesses();
      if(var2 != null) {
         Iterator var3 = var2.iterator();

         while(var3.hasNext()) {
            RunningAppProcessInfo var4 = (RunningAppProcessInfo)var3.next();
            if(var4.pid == var1) {
               return var4.processName;
            }
         }
      }

      return null;
   }

   public static String zzn(int var0, int var1) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      StringBuffer var3 = new StringBuffer();

      for(int var4 = var1 + var0; var0 < var4; ++var0) {
         var3.append(zza(var2, var0)).append(" ");
      }

      return var3.toString();
   }
}
