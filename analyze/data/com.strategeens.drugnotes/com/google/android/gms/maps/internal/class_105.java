package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_63;

// $FF: renamed from: com.google.android.gms.maps.internal.o
public interface class_105 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.maps.model.internal.l) void
   void method_646(class_63 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.maps.model.internal.l) void
   void method_647(class_63 var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.maps.model.internal.l) void
   void method_648(class_63 var1) throws RemoteException;

   public abstract static class class_1499 extends Binder implements class_105 {
      public class_1499() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
      }

      // $FF: renamed from: bi (android.os.IBinder) com.google.android.gms.maps.internal.o
      public static class_105 method_3712(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (class_105)(var1 != null && var1 instanceof class_105?(class_105)var1:new class_105.class_1500(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.b(class_63.class_1674.method_5294(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.d(class_63.class_1674.method_5294(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.c(class_63.class_1674.method_5294(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1500 implements class_105 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4269;

      class_1500(IBinder var1) {
         this.field_4269 = var1;
      }

      public IBinder asBinder() {
         return this.field_4269;
      }

      // $FF: renamed from: b (com.google.android.gms.maps.model.internal.l) void
      public void method_646(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.maps.model.internal.l) void
      public void method_647(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.maps.model.internal.l) void
      public void method_648(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
