package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public interface zzor extends IInterface {
   void zza(ListSubscriptionsResult var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzor {
      public static zzor zzbM(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (zzor)(var1 != null && var1 instanceof zzor?(zzor)var1:new zzor.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            ListSubscriptionsResult var5;
            if(var2.readInt() != 0) {
               var5 = (ListSubscriptionsResult)ListSubscriptionsResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzor {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(ListSubscriptionsResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
