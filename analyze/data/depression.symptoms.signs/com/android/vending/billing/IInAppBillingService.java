package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IInAppBillingService extends IInterface {
   int consumePurchase(int var1, String var2, String var3) throws RemoteException;

   Bundle getBuyIntent(int var1, String var2, String var3, String var4, String var5) throws RemoteException;

   Bundle getPurchases(int var1, String var2, String var3, String var4) throws RemoteException;

   Bundle getSkuDetails(int var1, String var2, String var3, Bundle var4) throws RemoteException;

   int isBillingSupported(int var1, String var2, String var3) throws RemoteException;

   public abstract static class Stub extends Binder implements IInAppBillingService {
      private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
      static final int TRANSACTION_consumePurchase = 5;
      static final int TRANSACTION_getBuyIntent = 3;
      static final int TRANSACTION_getPurchases = 4;
      static final int TRANSACTION_getSkuDetails = 2;
      static final int TRANSACTION_isBillingSupported = 1;

      public Stub() {
         this.attachInterface(this, "com.android.vending.billing.IInAppBillingService");
      }

      public static IInAppBillingService asInterface(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            return (IInAppBillingService)(var1 != null && var1 instanceof IInAppBillingService?(IInAppBillingService)var1:new IInAppBillingService.Proxy(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.android.vending.billing.IInAppBillingService");
            int var13 = this.isBillingSupported(var2.readInt(), var2.readString(), var2.readString());
            var3.writeNoException();
            var3.writeInt(var13);
            return true;
         case 2:
            var2.enforceInterface("com.android.vending.billing.IInAppBillingService");
            int var8 = var2.readInt();
            String var9 = var2.readString();
            String var10 = var2.readString();
            Bundle var11;
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            Bundle var12 = this.getSkuDetails(var8, var9, var10, var11);
            var3.writeNoException();
            if(var12 != null) {
               var3.writeInt(1);
               var12.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 3:
            var2.enforceInterface("com.android.vending.billing.IInAppBillingService");
            Bundle var7 = this.getBuyIntent(var2.readInt(), var2.readString(), var2.readString(), var2.readString(), var2.readString());
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 4:
            var2.enforceInterface("com.android.vending.billing.IInAppBillingService");
            Bundle var6 = this.getPurchases(var2.readInt(), var2.readString(), var2.readString(), var2.readString());
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 5:
            var2.enforceInterface("com.android.vending.billing.IInAppBillingService");
            int var5 = this.consumePurchase(var2.readInt(), var2.readString(), var2.readString());
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("com.android.vending.billing.IInAppBillingService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IInAppBillingService {
      private IBinder mRemote;

      Proxy(IBinder var1) {
         this.mRemote = var1;
      }

      public IBinder asBinder() {
         return this.mRemote;
      }

      public int consumePurchase(int var1, String var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         int var8;
         try {
            var4.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            var4.writeInt(var1);
            var4.writeString(var2);
            var4.writeString(var3);
            this.mRemote.transact(5, var4, var5, 0);
            var5.readException();
            var8 = var5.readInt();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }

      public Bundle getBuyIntent(int var1, String var2, String var3, String var4, String var5) throws RemoteException {
         Parcel var6 = Parcel.obtain();
         Parcel var7 = Parcel.obtain();
         boolean var12 = false;

         Bundle var10;
         label36: {
            try {
               var12 = true;
               var6.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
               var6.writeInt(var1);
               var6.writeString(var2);
               var6.writeString(var3);
               var6.writeString(var4);
               var6.writeString(var5);
               this.mRemote.transact(3, var6, var7, 0);
               var7.readException();
               if(var7.readInt() != 0) {
                  var10 = (Bundle)Bundle.CREATOR.createFromParcel(var7);
                  var12 = false;
                  break label36;
               }

               var12 = false;
            } finally {
               if(var12) {
                  var7.recycle();
                  var6.recycle();
               }
            }

            var10 = null;
         }

         var7.recycle();
         var6.recycle();
         return var10;
      }

      public String getInterfaceDescriptor() {
         return "com.android.vending.billing.IInAppBillingService";
      }

      public Bundle getPurchases(int var1, String var2, String var3, String var4) throws RemoteException {
         Parcel var5 = Parcel.obtain();
         Parcel var6 = Parcel.obtain();
         boolean var11 = false;

         Bundle var9;
         label36: {
            try {
               var11 = true;
               var5.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
               var5.writeInt(var1);
               var5.writeString(var2);
               var5.writeString(var3);
               var5.writeString(var4);
               this.mRemote.transact(4, var5, var6, 0);
               var6.readException();
               if(var6.readInt() != 0) {
                  var9 = (Bundle)Bundle.CREATOR.createFromParcel(var6);
                  var11 = false;
                  break label36;
               }

               var11 = false;
            } finally {
               if(var11) {
                  var6.recycle();
                  var5.recycle();
               }
            }

            var9 = null;
         }

         var6.recycle();
         var5.recycle();
         return var9;
      }

      public Bundle getSkuDetails(int param1, String param2, String param3, Bundle param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int isBillingSupported(int var1, String var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();
         Parcel var5 = Parcel.obtain();

         int var8;
         try {
            var4.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
            var4.writeInt(var1);
            var4.writeString(var2);
            var4.writeString(var3);
            this.mRemote.transact(1, var4, var5, 0);
            var5.readException();
            var8 = var5.readInt();
         } finally {
            var5.recycle();
            var4.recycle();
         }

         return var8;
      }
   }
}
