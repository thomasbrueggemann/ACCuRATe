package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.i
public interface class_124 extends IInterface {
   // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
   void method_674(Status var1) throws RemoteException;

   public abstract static class class_1164 extends Binder implements class_124 {
      // $FF: renamed from: ah (android.os.IBinder) com.google.android.gms.drive.realtime.internal.i
      public static class_124 method_5446(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
            return (class_124)(var1 != null && var1 instanceof class_124?(class_124)var1:new class_124.class_1165(var0));
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

            this.n(var5);
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

   private static class class_1165 implements class_124 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1725;

      class_1165(IBinder var1) {
         this.field_1725 = var1;
      }

      public IBinder asBinder() {
         return this.field_1725;
      }

      // $FF: renamed from: n (com.google.android.gms.common.api.Status) void
      public void method_674(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
