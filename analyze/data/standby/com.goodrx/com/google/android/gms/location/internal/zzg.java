package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.internal.FusedLocationProviderResult;

public interface zzg extends IInterface {
   void zza(FusedLocationProviderResult var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzg {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
      }

      public static zzg zzch(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            return (zzg)(var1 != null && var1 instanceof zzg?(zzg)var1:new zzg.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            FusedLocationProviderResult var5;
            if(var2.readInt() != 0) {
               var5 = (FusedLocationProviderResult)FusedLocationProviderResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
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

      public void zza(FusedLocationProviderResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
