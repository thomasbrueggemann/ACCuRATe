package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzz extends IInterface {
   IBinder zza(zzd var1, int var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzz {
      public static zzz zzp(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            return (zzz)(var1 != null && var1 instanceof zzz?(zzz)var1:new zzz.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            IBinder var5 = this.zza(zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzz {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IBinder zza(zzd param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
