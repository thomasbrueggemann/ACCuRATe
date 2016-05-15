package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

public interface zzq extends IInterface {
   void onDeviceFound(BleDevice var1) throws RemoteException;

   void onScanStopped() throws RemoteException;

   public abstract static class zza extends Binder implements zzq {
      public static zzq zzbU(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (zzq)(var1 != null && var1 instanceof zzq?(zzq)var1:new zzq.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            BleDevice var5;
            if(var2.readInt() != 0) {
               var5 = (BleDevice)BleDevice.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onDeviceFound(var5);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            this.onScanStopped();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzq {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onDeviceFound(BleDevice param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onScanStopped() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
            this.zzoz.transact(2, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }
   }
}
