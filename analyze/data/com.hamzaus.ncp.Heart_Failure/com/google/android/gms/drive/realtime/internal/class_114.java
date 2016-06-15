package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.i
public interface class_114 extends IInterface {
   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   void method_618(Status var1) throws RemoteException;

   public abstract static class class_863 extends Binder implements class_114 {
      // $FF: renamed from: Y (android.os.IBinder) com.google.android.gms.drive.realtime.internal.i
      public static class_114 method_4314(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
            return (class_114)(var1 != null && var1 instanceof class_114?(class_114)var1:new class_114.class_864(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
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
            var3.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_864 implements class_114 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2052;

      class_864(IBinder var1) {
         this.field_2052 = var1;
      }

      public IBinder asBinder() {
         return this.field_2052;
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_618(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
