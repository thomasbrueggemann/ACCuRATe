package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzh extends IInterface {
   void onPermissionChanged(boolean var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzh {
      public static zzh zzdC(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            return (zzh)(var1 != null && var1 instanceof zzh?(zzh)var1:new zzh.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.onPermissionChanged(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzh {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onPermissionChanged(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
