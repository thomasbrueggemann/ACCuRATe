package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class BitmapDescriptorFactory {
   private static com.google.android.gms.maps.model.internal.zza zzaSW;

   public static BitmapDescriptor fromBitmap(Bitmap var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(zzAi().zzc(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   private static com.google.android.gms.maps.model.internal.zza zzAi() {
      return (com.google.android.gms.maps.model.internal.zza)zzx.zzb(zzaSW, "IBitmapDescriptorFactory is not initialized");
   }

   public static void zza(com.google.android.gms.maps.model.internal.zza var0) {
      if(zzaSW == null) {
         zzaSW = (com.google.android.gms.maps.model.internal.zza)zzx.zzz(var0);
      }
   }
}
