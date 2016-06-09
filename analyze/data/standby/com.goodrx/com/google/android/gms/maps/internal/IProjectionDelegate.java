package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public interface IProjectionDelegate extends IInterface {
   LatLng fromScreenLocation(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   VisibleRegion getVisibleRegion() throws RemoteException;

   com.google.android.gms.dynamic.zzd toScreenLocation(LatLng var1) throws RemoteException;

   public abstract static class zza extends Binder implements IProjectionDelegate {
      public static IProjectionDelegate zzcX(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            return (IProjectionDelegate)(var1 != null && var1 instanceof IProjectionDelegate?(IProjectionDelegate)var1:new IProjectionDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            LatLng var9 = this.fromScreenLocation(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            LatLng var6;
            if(var2.readInt() != 0) {
               var6 = LatLng.CREATOR.zzfz(var2);
            } else {
               var6 = null;
            }

            com.google.android.gms.dynamic.zzd var7 = this.toScreenLocation(var6);
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            VisibleRegion var5 = this.getVisibleRegion();
            var3.writeNoException();
            if(var5 != null) {
               var3.writeInt(1);
               var5.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IProjectionDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements IProjectionDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public LatLng fromScreenLocation(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public VisibleRegion getVisibleRegion() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         VisibleRegion var5;
         label42: {
            VisibleRegion var6;
            label41: {
               try {
                  var8 = true;
                  var1.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
                  this.zzoz.transact(3, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = VisibleRegion.CREATOR.zzfK(var2);
                     var8 = false;
                     break label41;
                  }

                  var8 = false;
               } finally {
                  if(var8) {
                     var2.recycle();
                     var1.recycle();
                  }
               }

               var5 = null;
               break label42;
            }

            var5 = var6;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public com.google.android.gms.dynamic.zzd toScreenLocation(LatLng param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
