package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_63;

// $FF: renamed from: com.google.android.gms.maps.internal.h
public interface class_114 extends IInterface {
   // $FF: renamed from: e (com.google.android.gms.maps.model.internal.l) void
   void method_655(class_63 var1) throws RemoteException;

   public abstract static class class_1492 extends Binder implements class_114 {
      public class_1492() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
      }

      // $FF: renamed from: bb (android.os.IBinder) com.google.android.gms.maps.internal.h
      public static class_114 method_3714(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            return (class_114)(var1 != null && var1 instanceof class_114?(class_114)var1:new class_114.class_1493(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            this.e(class_63.class_1674.method_5294(var2.readStrongBinder()));
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

   private static class class_1493 implements class_114 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4307;

      class_1493(IBinder var1) {
         this.field_4307 = var1;
      }

      public IBinder asBinder() {
         return this.field_4307;
      }

      // $FF: renamed from: e (com.google.android.gms.maps.model.internal.l) void
      public void method_655(class_63 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
