package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.maps.model.internal.d
public interface class_58 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.maps.model.internal.d) boolean
   boolean method_327(class_58 var1) throws RemoteException;

   int getActiveLevelIndex() throws RemoteException;

   int getDefaultLevelIndex() throws RemoteException;

   List<IBinder> getLevels() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   boolean isUnderground() throws RemoteException;

   public abstract static class class_1211 extends Binder implements class_58 {
      // $FF: renamed from: ba (android.os.IBinder) com.google.android.gms.maps.model.internal.d
      public static class_58 method_3947(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            return (class_58)(var1 != null && var1 instanceof class_58?(class_58)var1:new class_58.class_1212(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            int var12 = this.getActiveLevelIndex();
            var3.writeNoException();
            var3.writeInt(var12);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            int var11 = this.getDefaultLevelIndex();
            var3.writeNoException();
            var3.writeInt(var11);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            List var10 = this.getLevels();
            var3.writeNoException();
            var3.writeBinderList(var10);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            boolean var8 = this.isUnderground();
            var3.writeNoException();
            byte var9 = 0;
            if(var8) {
               var9 = 1;
            }

            var3.writeInt(var9);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            boolean var6 = this.b(method_3947(var2.readStrongBinder()));
            var3.writeNoException();
            byte var7 = 0;
            if(var6) {
               var7 = 1;
            }

            var3.writeInt(var7);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            int var5 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1212 implements class_58 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3268;

      class_1212(IBinder var1) {
         this.field_3268 = var1;
      }

      public IBinder asBinder() {
         return this.field_3268;
      }

      // $FF: renamed from: b (com.google.android.gms.maps.model.internal.d) boolean
      public boolean method_327(class_58 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getActiveLevelIndex() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.field_3268.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public int getDefaultLevelIndex() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.field_3268.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public List<IBinder> getLevels() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         ArrayList var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.field_3268.transact(3, var1, var2, 0);
            var2.readException();
            var5 = var2.createBinderArrayList();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public int hashCodeRemote() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.field_3268.transact(6, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public boolean isUnderground() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            this.field_3268.transact(4, var1, var2, 0);
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
