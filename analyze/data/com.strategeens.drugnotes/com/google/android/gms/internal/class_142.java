package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_143;

// $FF: renamed from: com.google.android.gms.internal.ki
public interface class_142 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.internal.kh) void
   void method_766(class_143 var1) throws RemoteException;

   public abstract static class class_1146 extends Binder implements class_142 {
      // $FF: renamed from: V (android.os.IBinder) com.google.android.gms.internal.ki
      public static class_142 method_5781(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (class_142)(var1 != null && var1 instanceof class_142?(class_142)var1:new class_142.class_1147(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
            this.a(class_143.class_1097.method_2294(var2.readStrongBinder()));
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1147 implements class_142 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_1473;

      class_1147(IBinder var1) {
         this.field_1473 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kh) void
      public void method_766(class_143 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_1473;
      }
   }
}
