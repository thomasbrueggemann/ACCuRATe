package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh extends IInterface {
   void zzh(com.google.android.gms.maps.model.internal.zzf var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzh {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      }

      public static zzh zzcD(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (zzh)(var1 != null && var1 instanceof zzh?(zzh)var1:new zzh.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            this.zzh(com.google.android.gms.maps.model.internal.zzf.zza.zzdi(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzh {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zzh(com.google.android.gms.maps.model.internal.zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
