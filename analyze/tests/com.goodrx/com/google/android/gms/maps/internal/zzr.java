package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzr extends IInterface {
   boolean onMyLocationButtonClick() throws RemoteException;

   public abstract static class zza extends Binder implements zzr {
      public static zzr zzcN(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            return (zzr)(var1 != null && var1 instanceof zzr?(zzr)var1:new zzr.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            boolean var5 = this.onMyLocationButtonClick();
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzr {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public boolean onMyLocationButtonClick() throws RemoteException {
         boolean var1 = true;
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var8 = false;

         int var6;
         try {
            var8 = true;
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            this.zzoz.transact(1, var2, var3, 0);
            var3.readException();
            var6 = var3.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var3.recycle();
               var2.recycle();
            }
         }

         if(var6 == 0) {
            var1 = false;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }
   }
}
