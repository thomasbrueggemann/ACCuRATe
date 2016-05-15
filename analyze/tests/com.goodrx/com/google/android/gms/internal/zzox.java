package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SyncInfoResult;

public interface zzox extends IInterface {
   void zza(SyncInfoResult var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzox {
      public static zzox zzbS(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            return (zzox)(var1 != null && var1 instanceof zzox?(zzox)var1:new zzox.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            SyncInfoResult var5;
            if(var2.readInt() != 0) {
               var5 = (SyncInfoResult)SyncInfoResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.ISyncInfoCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzox {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(SyncInfoResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
