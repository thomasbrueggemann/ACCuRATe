package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public interface zzog extends IInterface {
   void zza(DailyTotalResult var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzog {
      public static zzog zzbB(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            return (zzog)(var1 != null && var1 instanceof zzog?(zzog)var1:new zzog.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            DailyTotalResult var5;
            if(var2.readInt() != 0) {
               var5 = (DailyTotalResult)DailyTotalResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IDailyTotalCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzog {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(DailyTotalResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
