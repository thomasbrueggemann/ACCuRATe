package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.maps.model.internal.k
public interface class_66 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.k) boolean
   boolean method_374(class_66 var1) throws RemoteException;

   void activate() throws RemoteException;

   String getName() throws RemoteException;

   String getShortName() throws RemoteException;

   int hashCodeRemote() throws RemoteException;

   public abstract static class class_1101 extends Binder implements class_66 {
      // $FF: renamed from: bz (android.os.IBinder) com.google.android.gms.maps.model.internal.k
      public static class_66 method_5036(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            return (class_66)(var1 != null && var1 instanceof class_66?(class_66)var1:new class_66.class_1102(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            String var9 = this.getName();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            String var8 = this.getShortName();
            var3.writeNoException();
            var3.writeString(var8);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.activate();
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            boolean var6 = this.a(method_5036(var2.readStrongBinder()));
            var3.writeNoException();
            byte var7;
            if(var6) {
               var7 = 1;
            } else {
               var7 = 0;
            }

            var3.writeInt(var7);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            int var5 = this.hashCodeRemote();
            var3.writeNoException();
            var3.writeInt(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1102 implements class_66 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_896;

      class_1102(IBinder var1) {
         this.field_896 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.k) boolean
      public boolean method_374(class_66 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void activate() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.field_896.transact(3, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_896;
      }

      public String getName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.field_896.transact(1, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public String getShortName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.field_896.transact(2, var1, var2, 0);
            var2.readException();
            var5 = var2.readString();
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
            var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
            this.field_896.transact(5, var1, var2, 0);
            var2.readException();
            var5 = var2.readInt();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }
   }
}
