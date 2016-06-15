package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.maps.internal.h
public interface class_104 extends IInterface {
   // $FF: renamed from: k (com.google.android.gms.dynamic.d) void
   void method_602(class_157 var1) throws RemoteException;

   public abstract static class class_1141 extends Binder implements class_104 {
      // $FF: renamed from: aG (android.os.IBinder) com.google.android.gms.maps.internal.h
      public static class_104 method_4514(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return (class_104)(var1 != null && var1 instanceof class_104?(class_104)var1:new class_104.class_1142(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            this.k(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1142 implements class_104 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4162;

      class_1142(IBinder var1) {
         this.field_4162 = var1;
      }

      public IBinder asBinder() {
         return this.field_4162;
      }

      // $FF: renamed from: k (com.google.android.gms.dynamic.d) void
      public void method_602(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
