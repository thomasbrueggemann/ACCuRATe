package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_55;

// $FF: renamed from: com.google.android.gms.maps.internal.g
public interface class_103 extends IInterface {
   // $FF: renamed from: e (com.google.android.gms.maps.model.internal.f) void
   void method_601(class_55 var1) throws RemoteException;

   public abstract static class class_866 extends Binder implements class_103 {
      public class_866() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      }

      // $FF: renamed from: aF (android.os.IBinder) com.google.android.gms.maps.internal.g
      public static class_103 method_3116(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (class_103)(var1 != null && var1 instanceof class_103?(class_103)var1:new class_103.class_867(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            this.e(class_55.class_1174.method_3352(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_867 implements class_103 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_2073;

      class_867(IBinder var1) {
         this.field_2073 = var1;
      }

      public IBinder asBinder() {
         return this.field_2073;
      }

      // $FF: renamed from: e (com.google.android.gms.maps.model.internal.f) void
      public void method_601(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
