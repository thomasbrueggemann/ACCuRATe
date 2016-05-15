package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.PointOfInterest;

public interface zzt extends IInterface {
   void zza(PointOfInterest var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzt {
      public static zzt zzcP(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
            return (zzt)(var1 != null && var1 instanceof zzt?(zzt)var1:new zzt.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnPoiClickListener");
            PointOfInterest var5;
            if(var2.readInt() != 0) {
               var5 = PointOfInterest.CREATOR.zzfB(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnPoiClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzt {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(PointOfInterest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
