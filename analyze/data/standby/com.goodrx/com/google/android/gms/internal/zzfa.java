package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzfa extends IInterface {
   int zzeD() throws RemoteException;

   public abstract static class zza extends Binder implements zzfa {
      public static zzfa zzH(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            return (zzfa)(var1 != null && var1 instanceof zzfa?(zzfa)var1:new zzfa.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            int var5 = this.zzeD();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzfa {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public int zzeD() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
