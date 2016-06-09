package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzr extends IInterface {
   void zza(int var1, IBinder var2, Bundle var3) throws RemoteException;

   void zzb(int var1, Bundle var2) throws RemoteException;

   public abstract static class zza extends Binder implements zzr {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
      }

      public static zzr zzaR(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return (zzr)(var1 != null && var1 instanceof zzr?(zzr)var1:new zzr.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            int var8 = var2.readInt();
            IBinder var9 = var2.readStrongBinder();
            int var10 = var2.readInt();
            Bundle var11 = null;
            if(var10 != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zza(var8, var9, var11);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            int var5 = var2.readInt();
            int var6 = var2.readInt();
            Bundle var7 = null;
            if(var6 != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.zzb(var5, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzr {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void zza(int param1, IBinder param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void zzb(int param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
