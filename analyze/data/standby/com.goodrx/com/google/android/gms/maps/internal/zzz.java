package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface zzz extends IInterface {
   void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzz {
      public static zzz zzcV(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
            return (zzz)(var1 != null && var1 instanceof zzz?(zzz)var1:new zzz.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
            StreetViewPanoramaOrientation var5;
            if(var2.readInt() != 0) {
               var5 = StreetViewPanoramaOrientation.CREATOR.zzfH(var2);
            } else {
               var5 = null;
            }

            this.onStreetViewPanoramaLongClick(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzz {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
