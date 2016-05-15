package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public interface zzw extends IInterface {
   void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzw {
      public static zzw zzcS(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return (zzw)(var1 != null && var1 instanceof zzw?(zzw)var1:new zzw.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            StreetViewPanoramaCamera var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaCamera.CREATOR.zzfE(var2);
            } else {
               var5 = null;
            }

            this.onStreetViewPanoramaCameraChange(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzw {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
