package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.internal.md
public interface class_135 extends IInterface {
   // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
   void method_737(Status var1) throws RemoteException;

   public abstract static class class_1365 extends Binder implements class_135 {
      public class_1365() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.IStatusCallback");
      }

      // $FF: renamed from: az (android.os.IBinder) com.google.android.gms.internal.md
      public static class_135 method_3888(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
            return (class_135)(var1 != null && var1 instanceof class_135?(class_135)var1:new class_135.class_1366(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IStatusCallback");
            Status var5;
            if(var2.readInt() != 0) {
               var5 = Status.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.j(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IStatusCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1366 implements class_135 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2758;

      class_1366(IBinder var1) {
         this.field_2758 = var1;
      }

      public IBinder asBinder() {
         return this.field_2758;
      }

      // $FF: renamed from: j (com.google.android.gms.common.api.Status) void
      public void method_737(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
