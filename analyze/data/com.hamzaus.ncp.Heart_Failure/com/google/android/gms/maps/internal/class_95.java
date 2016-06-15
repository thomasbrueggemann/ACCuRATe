package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.maps.internal.o
public interface class_95 extends IInterface {
   // $FF: renamed from: f (com.google.android.gms.dynamic.d) void
   void method_596(class_157 var1) throws RemoteException;

   public abstract static class class_1189 extends Binder implements class_95 {
      public class_1189() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
      }

      // $FF: renamed from: aN (android.os.IBinder) com.google.android.gms.maps.internal.o
      public static class_95 method_4058(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (class_95)(var1 != null && var1 instanceof class_95?(class_95)var1:new class_95.class_1190(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            this.f(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1190 implements class_95 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_4118;

      class_1190(IBinder var1) {
         this.field_4118 = var1;
      }

      public IBinder asBinder() {
         return this.field_4118;
      }

      // $FF: renamed from: f (com.google.android.gms.dynamic.d) void
      public void method_596(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
