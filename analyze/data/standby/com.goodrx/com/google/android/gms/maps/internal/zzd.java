package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {
   com.google.android.gms.dynamic.zzd zzb(com.google.android.gms.maps.model.internal.zzf var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd zzc(com.google.android.gms.maps.model.internal.zzf var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzd {
      public static zzd zzcw(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (zzd)(var1 != null && var1 instanceof zzd?(zzd)var1:new zzd.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            com.google.android.gms.dynamic.zzd var7 = this.zzb(com.google.android.gms.maps.model.internal.zzf.zza.zzdi(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            com.google.android.gms.dynamic.zzd var5 = this.zzc(com.google.android.gms.maps.model.internal.zzf.zza.zzdi(var2.readStrongBinder()));
            var3.writeNoException();
            IBinder var6 = null;
            if(var5 != null) {
               var6 = var5.asBinder();
            }

            var3.writeStrongBinder(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzd {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public com.google.android.gms.dynamic.zzd zzb(com.google.android.gms.maps.model.internal.zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd zzc(com.google.android.gms.maps.model.internal.zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
