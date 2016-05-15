package com.google.android.gms.ads.internal.reward.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzex;

public interface zzc extends IInterface {
   IBinder zza(zzd var1, zzex var2, int var3) throws RemoteException;

   public abstract static class zza extends Binder implements zzc {
      public static zzc zzab(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            return (zzc)(var1 != null && var1 instanceof zzc?(zzc)var1:new zzc.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            IBinder var5 = this.zza(zzd.zza.zzbs(var2.readStrongBinder()), zzex.zza.zzE(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzc {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IBinder zza(zzd param1, zzex param2, int param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
