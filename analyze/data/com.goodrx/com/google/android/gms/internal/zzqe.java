package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

public interface zzqe extends IInterface {
   void onDisconnected() throws RemoteException;

   void onError(int var1) throws RemoteException;

   void zzEc() throws RemoteException;

   void zza(Device var1, byte[] var2) throws RemoteException;

   void zzfw(String var1) throws RemoteException;

   void zzfx(String var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzqe {
      public static zzqe zzdq(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            return (zzqe)(var1 != null && var1 instanceof zzqe?(zzqe)var1:new zzqe.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            Device var5;
            if(var2.readInt() != 0) {
               var5 = (Device)Device.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5, var2.createByteArray());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.onDisconnected();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.onError(var2.readInt());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.zzfw(var2.readString());
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.zzEc();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.zzfx(var2.readString());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzqe {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onDisconnected() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.zzoz.transact(2, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void onError(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            var2.writeInt(var1);
            this.zzoz.transact(3, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void zzEc() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            this.zzoz.transact(5, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void zza(Device param1, byte[] param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzfw(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            var2.writeString(var1);
            this.zzoz.transact(4, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void zzfx(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IConnectionListener");
            var2.writeString(var1);
            this.zzoz.transact(6, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }
   }
}
