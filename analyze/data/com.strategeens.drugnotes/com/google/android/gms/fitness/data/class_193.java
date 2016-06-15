package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;

// $FF: renamed from: com.google.android.gms.fitness.data.k
public interface class_193 extends IInterface {
   // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
   void method_1063(DataPoint var1) throws RemoteException;

   public abstract static class class_1212 extends Binder implements class_193 {
      public class_1212() {
         this.attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
      }

      // $FF: renamed from: aq (android.os.IBinder) com.google.android.gms.fitness.data.k
      public static class_193 method_3082(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (class_193)(var1 != null && var1 instanceof class_193?(class_193)var1:new class_193.class_1213(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            DataPoint var5;
            if(var2.readInt() != 0) {
               var5 = (DataPoint)DataPoint.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.c(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1213 implements class_193 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3763;

      class_1213(IBinder var1) {
         this.field_3763 = var1;
      }

      public IBinder asBinder() {
         return this.field_3763;
      }

      // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
      public void method_1063(DataPoint param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
