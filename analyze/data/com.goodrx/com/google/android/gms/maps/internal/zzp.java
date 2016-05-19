package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzp extends IInterface {
   boolean zzd(com.google.android.gms.maps.model.internal.zzf var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzp {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
      }

      public static zzp zzcL(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return (zzp)(var1 != null && var1 instanceof zzp?(zzp)var1:new zzp.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            boolean var5 = this.zzd(com.google.android.gms.maps.model.internal.zzf.zza.zzdi(var2.readStrongBinder()));
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzp {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public boolean zzd(com.google.android.gms.maps.model.internal.zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
