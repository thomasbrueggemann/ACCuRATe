package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzfw extends IInterface {
   IBinder zze(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzfw {
      public static zzfw zzM(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (zzfw)(var1 != null && var1 instanceof zzfw?(zzfw)var1:new zzfw.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            IBinder var5 = this.zze(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzfw {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IBinder zze(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
