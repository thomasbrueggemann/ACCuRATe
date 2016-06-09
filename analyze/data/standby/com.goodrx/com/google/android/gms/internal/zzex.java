package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzey;

public interface zzex extends IInterface {
   zzey zzaf(String var1) throws RemoteException;

   boolean zzag(String var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzex {
      public static zzex zzE(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (zzex)(var1 != null && var1 instanceof zzex?(zzex)var1:new zzex.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            zzey var7 = this.zzaf(var2.readString());
            var3.writeNoException();
            IBinder var8;
            if(var7 != null) {
               var8 = var7.asBinder();
            } else {
               var8 = null;
            }

            var3.writeStrongBinder(var8);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            boolean var5 = this.zzag(var2.readString());
            var3.writeNoException();
            byte var6;
            if(var5) {
               var6 = 1;
            } else {
               var6 = 0;
            }

            var3.writeInt(var6);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzex {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public zzey zzaf(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         zzey var6;
         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.zzoz.transact(1, var2, var3, 0);
            var3.readException();
            var6 = zzey.zza.zzF(var3.readStrongBinder());
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var6;
      }

      public boolean zzag(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var9 = false;

         int var6;
         try {
            var9 = true;
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            var2.writeString(var1);
            this.zzoz.transact(2, var2, var3, 0);
            var3.readException();
            var6 = var3.readInt();
            var9 = false;
         } finally {
            if(var9) {
               var3.recycle();
               var2.recycle();
            }
         }

         boolean var7 = false;
         if(var6 != 0) {
            var7 = true;
         }

         var3.recycle();
         var2.recycle();
         return var7;
      }
   }
}
