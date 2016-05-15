package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzqf extends IInterface {
   void onError(int var1) throws RemoteException;

   void zzs(byte[] var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzqf {
      public static zzqf zzdr(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            return (zzqf)(var1 != null && var1 instanceof zzqf?(zzqf)var1:new zzqf.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            this.zzs(var2.createByteArray());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            this.onError(var2.readInt());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzqf {
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
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            var2.writeInt(var1);
            this.zzoz.transact(2, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void zzs(byte[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IDataListener");
            var2.writeByteArray(var1);
            this.zzoz.transact(1, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }
   }
}
