package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.eq
public interface class_30 extends IInterface {
   void finishPurchase() throws RemoteException;

   String getProductId() throws RemoteException;

   Intent getPurchaseData() throws RemoteException;

   int getResultCode() throws RemoteException;

   boolean isVerified() throws RemoteException;

   public abstract static class class_1218 extends Binder implements class_30 {
      public class_1218() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
      }

      // $FF: renamed from: y (android.os.IBinder) com.google.android.gms.internal.eq
      public static class_30 method_2776(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            return (class_30)(var1 != null && var1 instanceof class_30?(class_30)var1:new class_30.class_1219(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            String var9 = this.getProductId();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            Intent var8 = this.getPurchaseData();
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            int var7 = this.getResultCode();
            var3.writeNoException();
            var3.writeInt(var7);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            boolean var5 = this.isVerified();
            var3.writeNoException();
            byte var6 = 0;
            if(var5) {
               var6 = 1;
            }

            var3.writeInt(var6);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.finishPurchase();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1219 implements class_30 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1853;

      class_1219(IBinder var1) {
         this.field_1853 = var1;
      }

      public IBinder asBinder() {
         return this.field_1853;
      }

      public void finishPurchase() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.field_1853.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String getProductId() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.field_1853.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public Intent getPurchaseData() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var7 = false;

         Intent var5;
         label36: {
            try {
               var7 = true;
               var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
               this.field_1853.transact(2, var1, var2, 0);
               var2.readException();
               if(var2.readInt() != 0) {
                  var5 = (Intent)Intent.CREATOR.createFromParcel(var2);
                  var7 = false;
                  break label36;
               }

               var7 = false;
            } finally {
               if(var7) {
                  var2.recycle();
                  var1.recycle();
               }
            }

            var5 = null;
         }

         var2.recycle();
         var1.recycle();
         return var5;
      }

      public int getResultCode() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.field_1853.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isVerified() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.field_1853.transact(4, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
            var8 = false;
         } finally {
            if(var8) {
               var2.recycle();
               var1.recycle();
            }
         }

         boolean var6 = false;
         if(var5 != 0) {
            var6 = true;
         }

         var2.recycle();
         var1.recycle();
         return var6;
      }
   }
}
