package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzad {
   private static Context zzaSU;
   private static zzc zzaSV;

   private static Context getRemoteContext(Context var0) {
      if(zzaSU == null) {
         if(zzAg()) {
            zzaSU = var0.getApplicationContext();
         } else {
            zzaSU = GooglePlayServicesUtil.getRemoteContext(var0);
         }
      }

      return zzaSU;
   }

   public static boolean zzAg() {
      return false;
   }

   private static Class<?> zzAh() {
      try {
         Class var1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
         return var1;
      } catch (ClassNotFoundException var2) {
         throw new RuntimeException(var2);
      }
   }

   private static <T> T zza(ClassLoader var0, String var1) {
      try {
         Object var3 = zzd(((ClassLoader)com.google.android.gms.common.internal.zzx.zzz(var0)).loadClass(var1));
         return var3;
      } catch (ClassNotFoundException var4) {
         throw new IllegalStateException("Unable to find dynamic class " + var1);
      }
   }

   public static zzc zzaO(Context var0) throws GooglePlayServicesNotAvailableException {
      com.google.android.gms.common.internal.zzx.zzz(var0);
      if(zzaSV != null) {
         return zzaSV;
      } else {
         zzaP(var0);
         zzaSV = zzaQ(var0);

         try {
            zzaSV.zzd(com.google.android.gms.dynamic.zze.zzC(getRemoteContext(var0).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
         } catch (RemoteException var3) {
            throw new RuntimeRemoteException(var3);
         }

         return zzaSV;
      }
   }

   private static void zzaP(Context var0) throws GooglePlayServicesNotAvailableException {
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      switch(var1) {
      case 0:
         return;
      default:
         throw new GooglePlayServicesNotAvailableException(var1);
      }
   }

   private static zzc zzaQ(Context var0) {
      if(zzAg()) {
         Log.i(zzad.class.getSimpleName(), "Making Creator statically");
         return (zzc)zzd(zzAh());
      } else {
         Log.i(zzad.class.getSimpleName(), "Making Creator dynamically");
         return zzc.zza.zzcu((IBinder)zza(getRemoteContext(var0).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
      }
   }

   private static <T> T zzd(Class<?> var0) {
      try {
         Object var3 = var0.newInstance();
         return var3;
      } catch (InstantiationException var4) {
         throw new IllegalStateException("Unable to instantiate the dynamic class " + var0.getName());
      } catch (IllegalAccessException var5) {
         throw new IllegalStateException("Unable to call the default constructor of " + var0.getName());
      }
   }
}
