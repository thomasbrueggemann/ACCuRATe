package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

// $FF: renamed from: com.google.android.gms.internal.lx
public interface class_138 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
   void method_740(DataSourcesResult var1) throws RemoteException;

   public abstract static class class_1198 extends Binder implements class_138 {
      public class_1198() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
      }

      // $FF: renamed from: at (android.os.IBinder) com.google.android.gms.internal.lx
      public static class_138 method_3071(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return (class_138)(var1 != null && var1 instanceof class_138?(class_138)var1:new class_138.class_1199(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            DataSourcesResult var5;
            if(var2.readInt() != 0) {
               var5 = (DataSourcesResult)DataSourcesResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1199 implements class_138 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_2818;

      class_1199(IBinder var1) {
         this.field_2818 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
      public void method_740(DataSourcesResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_2818;
      }
   }
}
