package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

// $FF: renamed from: com.google.android.gms.internal.mp
public interface class_153 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
   void method_816(BleDevicesResult var1) throws RemoteException;

   public abstract static class class_1451 extends Binder implements class_153 {
      public class_1451() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
      }

      // $FF: renamed from: aA (android.os.IBinder) com.google.android.gms.internal.mp
      public static class_153 method_2713(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            return (class_153)(var1 != null && var1 instanceof class_153?(class_153)var1:new class_153.class_1452(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            BleDevicesResult var5;
            if(var2.readInt() != 0) {
               var5 = (BleDevicesResult)BleDevicesResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1452 implements class_153 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3213;

      class_1452(IBinder var1) {
         this.field_3213 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
      public void method_816(BleDevicesResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3213;
      }
   }
}
