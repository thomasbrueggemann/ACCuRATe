package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.AppContentReceivedResult;

public interface zza extends IInterface {
   void zza(AppContentReceivedResult var1) throws RemoteException;

   String zzfC(String var1) throws RemoteException;

   public abstract static class zza extends Binder implements zza {
      public static zza zzdF(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            return (zza)(var1 != null && var1 instanceof zza?(zza)var1:new zza.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            String var6 = this.zzfC(var2.readString());
            var3.writeNoException();
            var3.writeString(var6);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            AppContentReceivedResult var5;
            if(var2.readInt() != 0) {
               var5 = (AppContentReceivedResult)AppContentReceivedResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zza {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(AppContentReceivedResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String zzfC(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         String var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            var2.writeString(var1);
            this.zzoz.transact(1, var2, var3, 0);
            var3.readException();
            var6 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }
   }
}
