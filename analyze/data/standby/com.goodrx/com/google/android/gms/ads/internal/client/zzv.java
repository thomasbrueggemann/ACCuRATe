package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzex;

public interface zzv extends IInterface {
   IBinder zza(zzd var1, AdSizeParcel var2, String var3, zzex var4, int var5) throws RemoteException;

   IBinder zza(zzd var1, AdSizeParcel var2, String var3, zzex var4, int var5, int var6) throws RemoteException;

   public abstract static class zza extends Binder implements zzv {
      public static zzv zzl(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (zzv)(var1 != null && var1 instanceof zzv?(zzv)var1:new zzv.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            zzd var9 = zzd.zza.zzbs(var2.readStrongBinder());
            int var10 = var2.readInt();
            AdSizeParcel var11 = null;
            if(var10 != 0) {
               var11 = AdSizeParcel.CREATOR.zzc(var2);
            }

            IBinder var12 = this.zza(var9, var11, var2.readString(), zzex.zza.zzE(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            zzd var5 = zzd.zza.zzbs(var2.readStrongBinder());
            int var6 = var2.readInt();
            AdSizeParcel var7 = null;
            if(var6 != 0) {
               var7 = AdSizeParcel.CREATOR.zzc(var2);
            }

            IBinder var8 = this.zza(var5, var7, var2.readString(), zzex.zza.zzE(var2.readStrongBinder()), var2.readInt(), var2.readInt());
            var3.writeNoException();
            var3.writeStrongBinder(var8);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzv {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IBinder zza(zzd param1, AdSizeParcel param2, String param3, zzex param4, int param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder zza(zzd param1, AdSizeParcel param2, String param3, zzex param4, int param5, int param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
