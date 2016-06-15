package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.de
public interface class_49 extends IInterface {
   void onActivityResult(int var1, int var2, Intent var3) throws RemoteException;

   void onCreate() throws RemoteException;

   void onDestroy() throws RemoteException;

   public abstract static class class_848 extends Binder implements class_49 {
      public class_848() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
      }

      // $FF: renamed from: r (android.os.IBinder) com.google.android.gms.internal.de
      public static class_49 method_2521(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            return (class_49)(var1 != null && var1 instanceof class_49?(class_49)var1:new class_49.class_849(var0));
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

   private static class class_849 implements class_49 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_1815;

      class_849(IBinder var1) {
         this.field_1815 = var1;
      }

      public IBinder asBinder() {
         return this.field_1815;
      }

      public void onActivityResult(int param1, int param2, Intent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onCreate() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
            this.field_1815.transact(1, var1, var2, 0);
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
            this.field_1815.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
