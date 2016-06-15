package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

public interface IMapFragmentDelegate extends IInterface {
   IGoogleMapDelegate getMap() throws RemoteException;

   boolean isReady() throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   class_157 onCreateView(class_157 var1, class_157 var2, Bundle var3) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onDestroyView() throws RemoteException;

   void onInflate(class_157 var1, GoogleMapOptions var2, Bundle var3) throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   public abstract static class class_1271 extends Binder implements IMapFragmentDelegate {
      // $FF: renamed from: aB (android.os.IBinder) com.google.android.gms.maps.internal.IMapFragmentDelegate
      public static IMapFragmentDelegate method_3862(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return (IMapFragmentDelegate)(var1 != null && var1 instanceof IMapFragmentDelegate?(IMapFragmentDelegate)var1:new IMapFragmentDelegate.class_1272(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            IGoogleMapDelegate var17 = this.getMap();
            var3.writeNoException();
            IBinder var18;
            if(var17 != null) {
               var18 = var17.asBinder();
            } else {
               var18 = null;
            }

            var3.writeStrongBinder(var18);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            class_157 var14 = class_157.class_1317.method_4176(var2.readStrongBinder());
            GoogleMapOptions var15;
            if(var2.readInt() != 0) {
               var15 = GoogleMapOptions.CREATOR.createFromParcel(var2);
            } else {
               var15 = null;
            }

            Bundle var16;
            if(var2.readInt() != 0) {
               var16 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var16 = null;
            }

            this.onInflate(var14, var15, var16);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            Bundle var13;
            if(var2.readInt() != 0) {
               var13 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            this.onCreate(var13);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            class_157 var8 = class_157.class_1317.method_4176(var2.readStrongBinder());
            class_157 var9 = class_157.class_1317.method_4176(var2.readStrongBinder());
            Bundle var10;
            if(var2.readInt() != 0) {
               var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var10 = null;
            }

            class_157 var11 = this.onCreateView(var8, var9, var10);
            var3.writeNoException();
            IBinder var12 = null;
            if(var11 != null) {
               var12 = var11.asBinder();
            }

            var3.writeStrongBinder(var12);
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
            Bundle var7;
            if(var2.readInt() != 0) {
               var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var7 = null;
            }

            this.onSaveInstanceState(var7);
            var3.writeNoException();
            if(var7 != null) {
               var3.writeInt(1);
               var7.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            boolean var5 = this.isReady();
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
            var3.writeString("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1272 implements IMapFragmentDelegate {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3753;

      class_1272(IBinder var1) {
         this.field_3753 = var1;
      }

      public IBinder asBinder() {
         return this.field_3753;
      }

      public IGoogleMapDelegate getMap() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         IGoogleMapDelegate var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.field_3753.transact(1, var1, var2, 0);
            var2.readException();
            var5 = IGoogleMapDelegate.class_942.method_2733(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isReady() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.field_3753.transact(11, var1, var2, 0);
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

      public class_157 onCreateView(class_157 param1, class_157 param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.field_3753.transact(8, var1, var2, 0);
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
            this.field_3753.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onInflate(class_157 param1, GoogleMapOptions param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IMapFragmentDelegate");
            this.field_3753.transact(9, var1, var2, 0);
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
            this.field_3753.transact(6, var1, var2, 0);
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
            this.field_3753.transact(5, var1, var2, 0);
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