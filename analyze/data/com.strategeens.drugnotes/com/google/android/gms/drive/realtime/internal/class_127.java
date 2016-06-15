package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.l
public interface class_127 extends IInterface {
   // $FF: renamed from: ct (int) void
   void method_679(int var1) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   void method_680(Status var1) throws RemoteException;

   public abstract static class class_1279 extends Binder implements class_127 {
      // $FF: renamed from: ak (android.os.IBinder) com.google.android.gms.drive.realtime.internal.l
      public static class_127 method_3233(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
            return (class_127)(var1 != null && var1 instanceof class_127?(class_127)var1:new class_127.class_1280(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
            this.ct(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIntCallback");
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
            var3.writeString("com.google.android.gms.drive.realtime.internal.IIntCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1280 implements class_127 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3836;

      class_1280(IBinder var1) {
         this.field_3836 = var1;
      }

      public IBinder asBinder() {
         return this.field_3836;
      }

      // $FF: renamed from: ct (int) void
      public void method_679(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIntCallback");
            var2.writeInt(var1);
            this.field_3836.transact(1, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_680(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
