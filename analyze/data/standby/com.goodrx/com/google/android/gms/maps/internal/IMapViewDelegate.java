package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzo;

public interface IMapViewDelegate extends IInterface {
   IGoogleMapDelegate getMap() throws RemoteException;

   void getMapAsync(zzo var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd getView() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onEnterAmbient(Bundle var1) throws RemoteException;

   void onExitAmbient() throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   public abstract static class zza extends Binder implements IMapViewDelegate {
      public static IMapViewDelegate zzcz(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            return (IMapViewDelegate)(var1 != null && var1 instanceof IMapViewDelegate?(IMapViewDelegate)var1:new IMapViewDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            IGoogleMapDelegate var13 = this.getMap();
            var3.writeNoException();
            IBinder var14 = null;
            if(var13 != null) {
               var14 = var13.asBinder();
            }

            var3.writeStrongBinder(var14);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            int var11 = var2.readInt();
            Bundle var12 = null;
            if(var11 != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onCreate(var12);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            int var9 = var2.readInt();
            Bundle var10 = null;
            if(var9 != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onSaveInstanceState(var10);
            var3.writeNoException();
            if(var10 != null) {
               var3.writeInt(1);
               var10.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            com.google.android.gms.dynamic.zzd var7 = this.getView();
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.getMapAsync(zzo.zza.zzcK(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            int var5 = var2.readInt();
            Bundle var6 = null;
            if(var5 != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            this.onEnterAmbient(var6);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.onExitAmbient();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements IMapViewDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public IGoogleMapDelegate getMap() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IGoogleMapDelegate var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(1, var1, var2, 0);
            var2.readException();
            var5 = IGoogleMapDelegate.zza.zzcv(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void getMapAsync(zzo param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onEnterAmbient(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onExitAmbient() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(4, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            this.zzoz.transact(3, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
