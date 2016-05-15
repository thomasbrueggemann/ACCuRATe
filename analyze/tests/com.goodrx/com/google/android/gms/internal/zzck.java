package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzck extends IInterface {
   IBinder zza(com.google.android.gms.dynamic.zzd var1, com.google.android.gms.dynamic.zzd var2, com.google.android.gms.dynamic.zzd var3, int var4) throws RemoteException;

   public abstract static class zza extends Binder implements zzck {
      public static zzck zzv(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return (zzck)(var1 != null && var1 instanceof zzck?(zzck)var1:new zzck.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            IBinder var5 = this.zza(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzck {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IBinder zza(com.google.android.gms.dynamic.zzd param1, com.google.android.gms.dynamic.zzd param2, com.google.android.gms.dynamic.zzd param3, int param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
