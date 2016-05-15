package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzfv extends IInterface {
   void onBackPressed() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onPause() throws RemoteException;

   void onRestart() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   void onStart() throws RemoteException;

   void onStop() throws RemoteException;

   void zzaD() throws RemoteException;

   boolean zzfn() throws RemoteException;

   public abstract static class zza extends Binder implements zzfv {
      public zza() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
      }

      public static zzfv zzL(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return (zzfv)(var1 != null && var1 instanceof zzfv?(zzfv)var1:new zzfv.zza(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            int var9 = var2.readInt();
            Bundle var10 = null;
            if(var9 != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onCreate(var10);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onRestart();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onStart();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onResume();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onPause();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            int var7 = var2.readInt();
            Bundle var8 = null;
            if(var7 != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onSaveInstanceState(var8);
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onStop();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzaD();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.onBackPressed();
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            boolean var5 = this.zzfn();
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
            var3.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements zzfv {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void onBackPressed() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(10, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onPause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onRestart() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onResume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onStart() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(3, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onStop() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void zzaD() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(9, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean zzfn() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            this.zzoz.transact(11, var1, var2, 0);
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
