package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
   private static ICameraUpdateFactoryDelegate zzaRq;

   public static CameraUpdate newCameraPosition(CameraPosition var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(zzzI().newCameraPosition(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(zzzI().newLatLngBounds(var0, var1));
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static void zza(ICameraUpdateFactoryDelegate var0) {
      zzaRq = (ICameraUpdateFactoryDelegate)zzx.zzz(var0);
   }

   private static ICameraUpdateFactoryDelegate zzzI() {
      return (ICameraUpdateFactoryDelegate)zzx.zzb(zzaRq, "CameraUpdateFactory is not initialized");
   }
}
