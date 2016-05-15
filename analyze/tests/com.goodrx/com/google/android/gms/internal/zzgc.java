package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzgc extends IInterface {
   String getProductId() throws RemoteException;

   void recordPlayBillingResolution(int var1) throws RemoteException;

   void recordResolution(int var1) throws RemoteException;

   public abstract static class zza extends Binder implements zzgc {
      public static zzgc zzO(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            return (zzgc)(var1 != null && var1 instanceof zzgc?(zzgc)var1:new zzgc.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            String var5 = this.getProductId();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            this.recordResolution(var2.readInt());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            this.recordPlayBillingResolution(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzgc {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public String getProductId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void recordPlayBillingResolution(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            var2.writeInt(var1);
            this.zzoz.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void recordResolution(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            var2.writeInt(var1);
            this.zzoz.transact(2, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
