package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_55;

// $FF: renamed from: com.google.android.gms.maps.internal.m
public interface class_93 extends IInterface {
   // $FF: renamed from: b (com.google.android.gms.maps.model.internal.f) void
   void method_593(class_55 var1) throws RemoteException;

   // $FF: renamed from: c (com.google.android.gms.maps.model.internal.f) void
   void method_594(class_55 var1) throws RemoteException;

   // $FF: renamed from: d (com.google.android.gms.maps.model.internal.f) void
   void method_595(class_55 var1) throws RemoteException;

   public abstract static class class_1185 extends Binder implements class_93 {
      public class_1185() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
      }

      // $FF: renamed from: aL (android.os.IBinder) com.google.android.gms.maps.internal.m
      public static class_93 method_3114(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (class_93)(var1 != null && var1 instanceof class_93?(class_93)var1:new class_93.class_1186(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.b(class_55.class_1174.method_3352(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.d(class_55.class_1174.method_3352(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            this.c(class_55.class_1174.method_3352(var2.readStrongBinder()));
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

   private static class class_1186 implements class_93 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3337;

      class_1186(IBinder var1) {
         this.field_3337 = var1;
      }

      public IBinder asBinder() {
         return this.field_3337;
      }

      // $FF: renamed from: b (com.google.android.gms.maps.model.internal.f) void
      public void method_593(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: c (com.google.android.gms.maps.model.internal.f) void
      public void method_594(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: d (com.google.android.gms.maps.model.internal.f) void
      public void method_595(class_55 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
