package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.internal.class_108;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.u
public class class_590 {
   private static Context aag;
   private static class_108 aah;

   // $FF: renamed from: E (android.content.Context) com.google.android.gms.maps.internal.c
   public static class_108 method_3324(Context var0) throws GooglePlayServicesNotAvailableException {
      class_347.method_2170(var0);
      if(aah != null) {
         return aah;
      } else {
         method_3325(var0);
         aah = method_3326(var0);

         try {
            aah.method_605(class_741.method_4178(getRemoteContext(var0).getResources()), 5077000);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }

         return aah;
      }
   }

   // $FF: renamed from: F (android.content.Context) void
   private static void method_3325(Context var0) throws GooglePlayServicesNotAvailableException {
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      switch(var1) {
      case 0:
         return;
      default:
         throw new GooglePlayServicesNotAvailableException(var1);
      }
   }

   // $FF: renamed from: G (android.content.Context) com.google.android.gms.maps.internal.c
   private static class_108 method_3326(Context var0) {
      if(method_3329()) {
         Log.i(u.class.getSimpleName(), "Making Creator statically");
         return (class_108)method_3328(method_3330());
      } else {
         Log.i(u.class.getSimpleName(), "Making Creator dynamically");
         return class_108.class_988.method_3478((IBinder)method_3327(getRemoteContext(var0).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
      }
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.lang.String) java.lang.Object
   private static <T> T method_3327(ClassLoader var0, String var1) {
      try {
         Object var3 = method_3328(((ClassLoader)class_347.method_2170(var0)).loadClass(var1));
         return var3;
      } catch (ClassNotFoundException var4) {
         throw new IllegalStateException("Unable to find dynamic class " + var1);
      }
   }

   // $FF: renamed from: c (java.lang.Class) java.lang.Object
   private static <T> T method_3328(Class<?> var0) {
      try {
         Object var3 = var0.newInstance();
         return var3;
      } catch (InstantiationException var4) {
         throw new IllegalStateException("Unable to instantiate the dynamic class " + var0.getName());
      } catch (IllegalAccessException var5) {
         throw new IllegalStateException("Unable to call the default constructor of " + var0.getName());
      }
   }

   private static Context getRemoteContext(Context var0) {
      if(aag == null) {
         if(method_3329()) {
            aag = var0.getApplicationContext();
         } else {
            aag = GooglePlayServicesUtil.getRemoteContext(var0);
         }
      }

      return aag;
   }

   // $FF: renamed from: jE () boolean
   private static boolean method_3329() {
      return false;
   }

   // $FF: renamed from: jF () java.lang.Class
   private static Class<?> method_3330() {
      try {
         if(VERSION.SDK_INT < 15) {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
         } else {
            Class var1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
            return var1;
         }
      } catch (ClassNotFoundException var2) {
         throw new RuntimeException(var2);
      }
   }
}
