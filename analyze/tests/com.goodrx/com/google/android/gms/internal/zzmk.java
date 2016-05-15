package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzmk extends IInterface {
   void zzcb(int var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzmk {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
      }

      public static zzmk zzaX(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return (zzmk)(var1 != null && var1 instanceof zzmk?(zzmk)var1:new zzmk.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            this.zzcb(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzmk {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zzcb(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            var2.writeInt(var1);
            this.zzoz.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
