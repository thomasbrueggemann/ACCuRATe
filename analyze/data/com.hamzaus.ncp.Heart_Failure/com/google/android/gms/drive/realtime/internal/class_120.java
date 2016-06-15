package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.n
public interface class_120 extends IInterface {
   // $FF: renamed from: aP (java.lang.String) void
   void method_629(String var1) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   void method_630(Status var1) throws RemoteException;

   public abstract static class class_1051 extends Binder implements class_120 {
      // $FF: renamed from: ad (android.os.IBinder) com.google.android.gms.drive.realtime.internal.n
      public static class_120 method_3471(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
            return (class_120)(var1 != null && var1 instanceof class_120?(class_120)var1:new class_120.class_1052(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
            this.aP(var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
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
            var3.writeString("com.google.android.gms.drive.realtime.internal.IStringCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1052 implements class_120 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2919;

      class_1052(IBinder var1) {
         this.field_2919 = var1;
      }

      // $FF: renamed from: aP (java.lang.String) void
      public void method_629(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IStringCallback");
            var2.writeString(var1);
            this.field_2919.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.field_2919;
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_630(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
