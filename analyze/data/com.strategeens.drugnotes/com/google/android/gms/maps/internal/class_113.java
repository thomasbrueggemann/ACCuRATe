package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_65;

// $FF: renamed from: com.google.android.gms.maps.internal.g
public interface class_113 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.j) void
   void method_654(class_65 var1) throws RemoteException;

   void onIndoorBuildingFocused() throws RemoteException;

   public abstract static class class_1171 extends Binder implements class_113 {
      public class_1171() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      }

      // $FF: renamed from: ba (android.os.IBinder) com.google.android.gms.maps.internal.g
      public static class_113 method_5118(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (class_113)(var1 != null && var1 instanceof class_113?(class_113)var1:new class_113.class_1172(var0));
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
            this.a(class_65.class_1648.method_5864(var2.readStrongBinder()));
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

   private static class class_1172 implements class_113 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1747;

      class_1172(IBinder var1) {
         this.field_1747 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.model.internal.j) void
      public void method_654(class_65 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_1747;
      }

      public void onIndoorBuildingFocused() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.field_1747.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
