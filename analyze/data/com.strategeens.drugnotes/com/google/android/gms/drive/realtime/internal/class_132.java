package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.o
public interface class_132 extends IInterface {
   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   void method_728(Status var1) throws RemoteException;

   void onSuccess() throws RemoteException;

   public abstract static class class_1583 extends Binder implements class_132 {
      // $FF: renamed from: an (android.os.IBinder) com.google.android.gms.drive.realtime.internal.o
      public static class_132 method_4166(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return (class_132)(var1 != null && var1 instanceof class_132?(class_132)var1:new class_132.class_1584(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            this.onSuccess();
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.n(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1584 implements class_132 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3997;

      class_1584(IBinder var1) {
         this.field_3997 = var1;
      }

      public IBinder asBinder() {
         return this.field_3997;
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_728(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSuccess() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            this.field_3997.transact(1, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
