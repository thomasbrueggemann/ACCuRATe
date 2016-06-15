package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.e
public interface class_110 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator[]) void
   void method_611(ParcelableCollaborator[] var1) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   void method_612(Status var1) throws RemoteException;

   public abstract static class class_1028 extends Binder implements class_110 {
      // $FF: renamed from: U (android.os.IBinder) com.google.android.gms.drive.realtime.internal.e
      public static class_110 method_3173(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            return (class_110)(var1 != null && var1 instanceof class_110?(class_110)var1:new class_110.class_1029(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            this.a((ParcelableCollaborator[])var2.createTypedArray(ParcelableCollaborator.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.o(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1029 implements class_110 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2887;

      class_1029(IBinder var1) {
         this.field_2887 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator[]) void
      public void method_611(ParcelableCollaborator[] var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            var2.writeTypedArray(var1, 0);
            this.field_2887.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_2887;
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_612(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
