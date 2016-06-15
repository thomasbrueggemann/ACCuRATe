package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.kh
public interface class_143 extends IInterface {
   // $FF: renamed from: aI (int) void
   void method_767(int var1) throws RemoteException;

   public abstract static class class_1097 extends Binder implements class_143 {
      public class_1097() {
         this.attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
      }

      // $FF: renamed from: U (android.os.IBinder) com.google.android.gms.internal.kh
      public static class_143 method_2294(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return (class_143)(var1 != null && var1 instanceof class_143?(class_143)var1:new class_143.class_1098(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            this.aI(var2.readInt());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1098 implements class_143 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3451;

      class_1098(IBinder var1) {
         this.field_3451 = var1;
      }

      // $FF: renamed from: aI (int) void
      public void method_767(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            var2.writeInt(var1);
            this.field_3451.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_3451;
      }
   }
}
