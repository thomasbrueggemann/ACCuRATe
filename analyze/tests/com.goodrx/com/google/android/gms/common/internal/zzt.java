package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ResolveAccountResponse;

public interface zzt extends IInterface {
   void zza(ResolveAccountResponse var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzt {
      public static zzt zzaT(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return (zzt)(var1 != null && var1 instanceof zzt?(zzt)var1:new zzt.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            ResolveAccountResponse var5;
            if(var2.readInt() != 0) {
               var5 = (ResolveAccountResponse)ResolveAccountResponse.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.zza(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzt {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(ResolveAccountResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
