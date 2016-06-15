package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.g
public interface class_112 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
   void method_615(DataHolder var1, ParcelableEventList var2) throws RemoteException;

   // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
   void method_616(Status var1) throws RemoteException;

   public abstract static class class_1280 extends Binder implements class_112 {
      // $FF: renamed from: W (android.os.IBinder) com.google.android.gms.drive.realtime.internal.g
      public static class_112 method_3946(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            return (class_112)(var1 != null && var1 instanceof class_112?(class_112)var1:new class_112.class_1281(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            DataHolder var7;
            if(var2.readInt() != 0) {
               var7 = DataHolder.CREATOR.method_4283(var2);
            } else {
               var7 = null;
            }

            ParcelableEventList var8;
            if(var2.readInt() != 0) {
               var8 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            this.a(var7, var8);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            int var5 = var2.readInt();
            Status var6 = null;
            if(var5 != 0) {
               var6 = Status.CREATOR.createFromParcel(var2);
            }

            this.o(var6);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1281 implements class_112 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3946;

      class_1281(IBinder var1) {
         this.field_3946 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
      public void method_615(DataHolder param1, ParcelableEventList param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3946;
      }

      // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
      public void method_616(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
