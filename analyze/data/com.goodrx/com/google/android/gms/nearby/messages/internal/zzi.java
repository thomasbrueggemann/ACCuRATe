package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzi extends IInterface {
   void onExpired() throws RemoteException;

   public abstract static class zza extends Binder implements zzi {
      public static zzi zzdD(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            return (zzi)(var1 != null && var1 instanceof zzi?(zzi)var1:new zzi.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            this.onExpired();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzi {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onExpired() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            this.zzoz.transact(1, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }
   }
}
