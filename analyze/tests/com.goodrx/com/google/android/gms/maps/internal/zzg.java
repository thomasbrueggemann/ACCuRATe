package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzg extends IInterface {
   void onIndoorBuildingFocused() throws RemoteException;

   void zza(com.google.android.gms.maps.model.internal.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzg {
      public static zzg zzcC(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (zzg)(var1 != null && var1 instanceof zzg?(zzg)var1:new zzg.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.onIndoorBuildingFocused();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.zza(com.google.android.gms.maps.model.internal.zzd.zza.zzdg(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzg {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onIndoorBuildingFocused() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void zza(com.google.android.gms.maps.model.internal.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
