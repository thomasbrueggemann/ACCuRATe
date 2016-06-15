package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.c
public interface class_128 extends IInterface {
   // $FF: renamed from: N (boolean) void
   void method_681(boolean var1) throws RemoteException;

   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   void method_682(Status var1) throws RemoteException;

   public abstract static class class_1070 extends Binder implements class_128 {
      // $FF: renamed from: ab (android.os.IBinder) com.google.android.gms.drive.realtime.internal.c
      public static class_128 method_1631(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
            return (class_128)(var1 != null && var1 instanceof class_128?(class_128)var1:new class_128.class_1071(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
            boolean var6;
            if(var2.readInt() != 0) {
               var6 = true;
            } else {
               var6 = false;
            }

            this.N(var6);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
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
            var3.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1071 implements class_128 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4447;

      class_1071(IBinder var1) {
         this.field_4447 = var1;
      }

      // $FF: renamed from: N (boolean) void
      public void method_681(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4447;
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_682(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
