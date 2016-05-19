package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

// $FF: renamed from: com.nostra13.universalimageloader.utils.L
public final class class_52 {
   private static volatile boolean writeDebugLogs = false;
   private static volatile boolean writeLogs = true;

   // $FF: renamed from: d (java.lang.String, java.lang.Object[]) void
   public static void method_329(String var0, Object... var1) {
      if(writeDebugLogs) {
         log(3, (Throwable)null, var0, var1);
      }

   }

   // $FF: renamed from: e (java.lang.String, java.lang.Object[]) void
   public static void method_330(String var0, Object... var1) {
      log(6, (Throwable)null, var0, var1);
   }

   // $FF: renamed from: e (java.lang.Throwable) void
   public static void method_331(Throwable var0) {
      log(6, var0, (String)null, new Object[0]);
   }

   // $FF: renamed from: i (java.lang.String, java.lang.Object[]) void
   public static void method_332(String var0, Object... var1) {
      log(4, (Throwable)null, var0, var1);
   }

   private static void log(int var0, Throwable var1, String var2, Object... var3) {
      if(writeLogs) {
         if(var3.length > 0) {
            var2 = String.format(var2, var3);
         }

         String var5;
         if(var1 == null) {
            var5 = var2;
         } else {
            String var4;
            if(var2 == null) {
               var4 = var1.getMessage();
            } else {
               var4 = var2;
            }

            var5 = String.format("%1$s\n%2$s", new Object[]{var4, Log.getStackTraceString(var1)});
         }

         Log.println(var0, ImageLoader.TAG, var5);
      }
   }

   // $FF: renamed from: w (java.lang.String, java.lang.Object[]) void
   public static void method_333(String var0, Object... var1) {
      log(5, (Throwable)null, var0, var1);
   }

   public static void writeDebugLogs(boolean var0) {
      writeDebugLogs = var0;
   }
}
