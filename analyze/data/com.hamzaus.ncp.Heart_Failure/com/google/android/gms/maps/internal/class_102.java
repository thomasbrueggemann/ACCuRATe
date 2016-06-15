package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_58;

// $FF: renamed from: com.google.android.gms.maps.internal.f
public interface class_102 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.d) void
   void method_600(class_58 var1) throws RemoteException;

   void onIndoorBuildingFocused() throws RemoteException;

   public abstract static class class_1139 extends Binder implements class_102 {
      public class_1139() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      }

      // $FF: renamed from: aE (android.os.IBinder) com.google.android.gms.maps.internal.f
      public static class_102 method_4059(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (class_102)(var1 != null && var1 instanceof class_102?(class_102)var1:new class_102.class_1140(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.onIndoorBuildingFocused();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.a(class_58.class_1211.method_3947(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1140 implements class_102 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3147;

      class_1140(IBinder var1) {
         this.field_3147 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.d) void
      public void method_600(class_58 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3147;
      }

      public void onIndoorBuildingFocused() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.field_3147.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
