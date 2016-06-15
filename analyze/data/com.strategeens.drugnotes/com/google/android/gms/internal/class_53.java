package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.da
public interface class_53 extends IInterface {
   void onAdClicked() throws RemoteException;

   void onAdClosed() throws RemoteException;

   void onAdFailedToLoad(int var1) throws RemoteException;

   void onAdLeftApplication() throws RemoteException;

   void onAdLoaded() throws RemoteException;

   void onAdOpened() throws RemoteException;

   public abstract static class class_1150 extends Binder implements class_53 {
      public class_1150() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
      }

      // $FF: renamed from: p (android.os.IBinder) com.google.android.gms.internal.da
      public static class_53 method_2893(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            return (class_53)(var1 != null && var1 instanceof class_53?(class_53)var1:new class_53.class_1151(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdClicked();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdClosed();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdFailedToLoad(var2.readInt());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdLeftApplication();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdOpened();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.onAdLoaded();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1151 implements class_53 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3564;

      class_1151(IBinder var1) {
         this.field_3564 = var1;
      }

      public IBinder asBinder() {
         return this.field_3564;
      }

      public void onAdClicked() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.field_3564.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onAdClosed() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.field_3564.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onAdFailedToLoad(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            var2.writeInt(var1);
            this.field_3564.transact(3, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void onAdLeftApplication() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.field_3564.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onAdLoaded() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.field_3564.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onAdOpened() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
            this.field_3564.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
