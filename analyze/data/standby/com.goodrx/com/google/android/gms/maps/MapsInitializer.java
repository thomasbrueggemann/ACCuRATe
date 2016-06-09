package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
   private static boolean zznY = false;

   public static int initialize(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static void zza(zzc var0) {
      try {
         CameraUpdateFactory.zza(var0.zzAe());
         BitmapDescriptorFactory.zza(var0.zzAf());
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }
}
