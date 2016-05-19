package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public interface zzqi extends IInterface {
   void onError(int var1) throws RemoteException;

   void onScanStopped() throws RemoteException;

   void zza(Device var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzqi {
      public static zzqi zzdu(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            return (zzqi)(var1 != null && var1 instanceof zzqi?(zzqi)var1:new zzqi.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            Device var5;
            if(var2.readInt() != 0) {
               var5 = (Device)Device.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            this.onScanStopped();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            this.onError(var2.readInt());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzqi {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onError(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            var2.writeInt(var1);
            this.zzoz.transact(3, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void onScanStopped() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            this.zzoz.transact(2, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void zza(Device param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
