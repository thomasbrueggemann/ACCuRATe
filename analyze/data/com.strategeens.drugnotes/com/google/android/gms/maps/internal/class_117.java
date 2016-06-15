package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.k
public interface class_117 extends IInterface {
   void onMapLoaded() throws RemoteException;

   public abstract static class class_1490 extends Binder implements class_117 {
      public class_1490() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
      }

      // $FF: renamed from: be (android.os.IBinder) com.google.android.gms.maps.internal.k
      public static class_117 method_3953(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            return (class_117)(var1 != null && var1 instanceof class_117?(class_117)var1:new class_117.class_1491(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            this.onMapLoaded();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1491 implements class_117 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3663;

      class_1491(IBinder var1) {
         this.field_3663 = var1;
      }

      public IBinder asBinder() {
         return this.field_3663;
      }

      public void onMapLoaded() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            this.field_3663.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
