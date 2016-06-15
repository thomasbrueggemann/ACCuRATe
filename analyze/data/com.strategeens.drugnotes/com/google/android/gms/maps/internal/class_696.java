package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.internal.class_118;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.x
public class class_696 {
   private static Context alI;
   private static class_118 alJ;

   // $FF: renamed from: S (android.content.Context) com.google.android.gms.maps.internal.c
   public static class_118 method_3989(Context var0) throws GooglePlayServicesNotAvailableException {
      class_335.method_2311(var0);
      if(alJ != null) {
         return alJ;
      } else {
         method_3990(var0);
         alJ = method_3991(var0);

         try {
            alJ.method_660(class_960.method_5293(getRemoteContext(var0).getResources()), 6587000);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }

         return alJ;
      }
   }

   // $FF: renamed from: T (android.content.Context) void
   private static void method_3990(Context var0) throws GooglePlayServicesNotAvailableException {
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      switch(var1) {
      case 0:
         return;
      default:
         throw new GooglePlayServicesNotAvailableException(var1);
      }
   }

   // $FF: renamed from: U (android.content.Context) com.google.android.gms.maps.internal.c
   private static class_118 method_3991(Context var0) {
      if(method_3994()) {
         Log.i(x.class.getSimpleName(), "Making Creator statically");
         return (class_118)method_3993(method_3995());
      } else {
         Log.i(x.class.getSimpleName(), "Making Creator dynamically");
         return class_118.class_1306.method_4164((IBinder)method_3992(getRemoteContext(var0).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
      }
   }

   // $FF: renamed from: a (java.lang.ClassLoader, java.lang.String) java.lang.Object
   private static <T> T method_3992(ClassLoader var0, String var1) {
      try {
         Object var3 = method_3993(((ClassLoader)class_335.method_2311(var0)).loadClass(var1));
         return var3;
      } catch (ClassNotFoundException var4) {
         throw new IllegalStateException("Unable to find dynamic class " + var1);
      }
   }

   // $FF: renamed from: c (java.lang.Class) java.lang.Object
   private static <T> T method_3993(Class<?> var0) {
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
      if(alI == null) {
         if(method_3994()) {
            alI = var0.getApplicationContext();
         } else {
            alI = GooglePlayServicesUtil.getRemoteContext(var0);
         }
      }

      return alI;
   }

   // $FF: renamed from: nY () boolean
   public static boolean method_3994() {
      return false;
   }

   // $FF: renamed from: nZ () java.lang.Class
   private static Class<?> method_3995() {
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
