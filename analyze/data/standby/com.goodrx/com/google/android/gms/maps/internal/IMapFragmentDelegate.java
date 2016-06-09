package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzo;

public interface IMapFragmentDelegate extends IInterface {
   IGoogleMapDelegate getMap() throws RemoteException;

   void getMapAsync(zzo var1) throws RemoteException;

   boolean isReady() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   com.google.android.gms.dynamic.zzd onCreateView(com.google.android.gms.dynamic.zzd var1, com.google.android.gms.dynamic.zzd var2, Bundle var3) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onDestroyView() throws RemoteException;

   void onEnterAmbient(Bundle var1) throws RemoteException;

   void onExitAmbient() throws RemoteException;

   void onInflate(com.google.android.gms.dynamic.zzd var1, GoogleMapOptions var2, Bundle var3) throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   public abstract static class zza extends Binder implements IMapFragmentDelegate {
      public static IMapFragmentDelegate zzcy(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return (IMapFragmentDelegate)(var1 != null && var1 instanceof IMapFragmentDelegate?(IMapFragmentDelegate)var1:new IMapFragmentDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            IGoogleMapDelegate var18 = this.getMap();
            var3.writeNoException();
            IBinder var19;
            if(var18 != null) {
               var19 = var18.asBinder();
            } else {
               var19 = null;
            }

            var3.writeStrongBinder(var19);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            com.google.android.gms.dynamic.zzd var15 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            GoogleMapOptions var16;
            if(var2.readInt() != 0) {
               var16 = GoogleMapOptions.CREATOR.zzft(var2);
            } else {
               var16 = null;
            }

            Bundle var17;
            if(var2.readInt() != 0) {
               var17 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            this.onInflate(var15, var16, var17);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            Bundle var14;
            if(var2.readInt() != 0) {
               var14 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var14 = null;
            }

            this.onCreate(var14);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            com.google.android.gms.dynamic.zzd var9 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            com.google.android.gms.dynamic.zzd var10 = com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder());
            Bundle var11;
            if(var2.readInt() != 0) {
               var11 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            com.google.android.gms.dynamic.zzd var12 = this.onCreateView(var9, var10, var11);
            var3.writeNoException();
            IBinder var13 = null;
            if(var12 != null) {
               var13 = var12.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onDestroyView();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            Bundle var8;
            if(var2.readInt() != 0) {
               var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
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
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            boolean var6 = this.isReady();
            var3.writeNoException();
            byte var7;
            if(var6) {
               var7 = 1;
            } else {
               var7 = 0;
            }

            var3.writeInt(var7);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.getMapAsync(zzo.zza.zzcK(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            Bundle var5;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onEnterAmbient(var5);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.onExitAmbient();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class zza implements IMapFragmentDelegate {
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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

      public boolean isReady() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
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

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.zzd onCreateView(com.google.android.gms.dynamic.zzd param1, com.google.android.gms.dynamic.zzd param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onDestroyView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(7, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(14, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onInflate(com.google.android.gms.dynamic.zzd param1, GoogleMapOptions param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(9, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(6, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.zzoz.transact(5, var1, var2, 0);
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
