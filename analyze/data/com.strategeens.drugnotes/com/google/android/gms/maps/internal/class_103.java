package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

// $FF: renamed from: com.google.android.gms.maps.internal.m
public interface class_103 extends IInterface {
   // $FF: renamed from: a (com.google.android.gms.maps.internal.IGoogleMapDelegate) void
   void method_644(IGoogleMapDelegate var1) throws RemoteException;

   public abstract static class class_1497 extends Binder implements class_103 {
      public class_1497() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapReadyCallback");
      }

      // $FF: renamed from: bg (android.os.IBinder) com.google.android.gms.maps.internal.m
      public static class_103 method_4908(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return (class_103)(var1 != null && var1 instanceof class_103?(class_103)var1:new class_103.class_1498(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            this.a(IGoogleMapDelegate.class_1237.method_3164(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1498 implements class_103 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3398;

      class_1498(IBinder var1) {
         this.field_3398 = var1;
      }

      // $FF: renamed from: a (com.google.android.gms.maps.internal.IGoogleMapDelegate) void
      public void method_644(IGoogleMapDelegate param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3398;
      }
   }
}
