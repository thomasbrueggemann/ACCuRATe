package com.comscore.utils;

import android.util.Log;
import com.comscore.utils.Constants;

public class CSLog {
   // $FF: renamed from: d (java.lang.Class, java.lang.String) void
   public static void method_371(Class<? extends Object> var0, String var1) {
      if(Constants.DEBUG) {
         Log.d(var0.getSimpleName(), var1);
      }

   }

   // $FF: renamed from: d (java.lang.Object, java.lang.String) void
   public static void method_372(Object var0, String var1) {
      if(Constants.DEBUG) {
         method_371(var0.getClass(), var1);
      }

   }

   // $FF: renamed from: e (java.lang.Class, java.lang.String) void
   public static void method_373(Class<? extends Object> var0, String var1) {
      if(Constants.DEBUG) {
         Log.e(var0.getSimpleName(), var1);
      }

   }

   // $FF: renamed from: e (java.lang.Object, java.lang.String) void
   public static void method_374(Object var0, String var1) {
      if(Constants.DEBUG) {
         method_373(var0.getClass(), var1);
      }

   }

   public static void printStackTrace(Exception var0) {
      if(Constants.DEBUG) {
         var0.printStackTrace();
      }

   }

   // $FF: renamed from: v (java.lang.Class, java.lang.String) void
   public static void method_375(Class<? extends Object> var0, String var1) {
      if(Constants.DEBUG) {
         Log.v(var0.getSimpleName(), var1);
      }

   }

   // $FF: renamed from: v (java.lang.Object, java.lang.String) void
   public static void method_376(Object var0, String var1) {
      if(Constants.DEBUG) {
         method_375(var0.getClass(), var1);
      }

   }
}
