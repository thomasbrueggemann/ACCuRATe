package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.b
public interface class_119 extends IInterface {
   void onCancel() throws RemoteException;

   void onFinish() throws RemoteException;

   public abstract static class class_1488 extends Binder implements class_119 {
      public class_1488() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.ICancelableCallback");
      }

      // $FF: renamed from: aR (android.os.IBinder) com.google.android.gms.maps.internal.b
      public static class_119 method_3921(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICancelableCallback");
            return (class_119)(var1 != null && var1 instanceof class_119?(class_119)var1:new class_119.class_1489(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
            this.onFinish();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ICancelableCallback");
            this.onCancel();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ICancelableCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1489 implements class_119 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4071;

      class_1489(IBinder var1) {
         this.field_4071 = var1;
      }

      public IBinder asBinder() {
         return this.field_4071;
      }

      public void onCancel() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
            this.field_4071.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onFinish() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
            this.field_4071.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
