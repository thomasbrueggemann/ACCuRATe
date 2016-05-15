package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzge extends IInterface {
   void onActivityResult(int var1, int var2, Intent var3) throws RemoteException;

   void onCreate() throws RemoteException;

   void onDestroy() throws RemoteException;

   public abstract static class zza extends Binder implements zzge {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
      }

      public static zzge zzQ(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            return (zzge)(var1 != null && var1 instanceof zzge?(zzge)var1:new zzge.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.onCreate();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            int var5 = var2.readInt();
            int var6 = var2.readInt();
            Intent var7;
            if(var2.readInt() != 0) {
               var7 = (Intent)Intent.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.onActivityResult(var5, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzge {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onActivityResult(int param1, int param2, Intent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onCreate() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
