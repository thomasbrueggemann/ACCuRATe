package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.hh
public interface class_33 extends IInterface {
   void cancel() throws RemoteException;

   public abstract static class class_902 extends Binder implements class_33 {
      // $FF: renamed from: J (android.os.IBinder) com.google.android.gms.internal.hh
      public static class_33 method_3432(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return (class_33)(var1 != null && var1 instanceof class_33?(class_33)var1:new class_33.class_903(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
            this.cancel();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.ICancelToken");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_903 implements class_33 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2141;

      class_903(IBinder var1) {
         this.field_2141 = var1;
      }

      public IBinder asBinder() {
         return this.field_2141;
      }

      public void cancel() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
            this.field_2141.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
