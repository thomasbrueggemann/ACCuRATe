package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;

public interface zzk extends IInterface {
   void zzc(DataPoint var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzk {
      public static zzk zzbt(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (zzk)(var1 != null && var1 instanceof zzk?(zzk)var1:new zzk.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            DataPoint var5;
            if(var2.readInt() != 0) {
               var5 = (DataPoint)DataPoint.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zzc(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzk {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zzc(DataPoint param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
