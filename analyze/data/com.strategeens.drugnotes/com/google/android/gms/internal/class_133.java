package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

// $FF: renamed from: com.google.android.gms.internal.mb
public interface class_133 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
   void method_735(SessionReadResult var1) throws RemoteException;

   public abstract static class class_1407 extends Binder implements class_133 {
      public class_1407() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
      }

      // $FF: renamed from: ax (android.os.IBinder) com.google.android.gms.internal.mb
      public static class_133 method_5281(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return (class_133)(var1 != null && var1 instanceof class_133?(class_133)var1:new class_133.class_1408(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            SessionReadResult var5;
            if(var2.readInt() != 0) {
               var5 = (SessionReadResult)SessionReadResult.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1408 implements class_133 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4248;

      class_1408(IBinder var1) {
         this.field_4248 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
      public void method_735(SessionReadResult param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_4248;
      }
   }
}
