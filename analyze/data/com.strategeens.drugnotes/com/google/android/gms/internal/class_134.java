package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// $FF: renamed from: com.google.android.gms.internal.ma
public interface class_134 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
   void method_736(ListSubscriptionsResult var1) throws RemoteException;

   public abstract static class class_1181 extends Binder implements class_134 {
      public class_1181() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
      }

      // $FF: renamed from: aw (android.os.IBinder) com.google.android.gms.internal.ma
      public static class_134 method_3049(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (class_134)(var1 != null && var1 instanceof class_134?(class_134)var1:new class_134.class_1182(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            ListSubscriptionsResult var5;
            if(var2.readInt() != 0) {
               var5 = (ListSubscriptionsResult)ListSubscriptionsResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1182 implements class_134 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3116;

      class_1182(IBinder var1) {
         this.field_3116 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
      public void method_736(ListSubscriptionsResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3116;
      }
   }
}
