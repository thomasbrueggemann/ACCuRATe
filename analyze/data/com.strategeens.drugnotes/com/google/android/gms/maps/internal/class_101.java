package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;

// $FF: renamed from: com.google.android.gms.maps.internal.v
public interface class_101 extends IInterface {
   // $FF: renamed from: h (com.google.android.gms.dynamic.d) void
   void method_643(class_198 var1) throws RemoteException;

   void onSnapshotReady(Bitmap var1) throws RemoteException;

   public abstract static class class_1505 extends Binder implements class_101 {
      public class_1505() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      }

      // $FF: renamed from: bq (android.os.IBinder) com.google.android.gms.maps.internal.v
      public static class_101 method_5120(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (class_101)(var1 != null && var1 instanceof class_101?(class_101)var1:new class_101.class_1506(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            Bitmap var5;
            if(var2.readInt() != 0) {
               var5 = (Bitmap)Bitmap.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onSnapshotReady(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            this.h(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1506 implements class_101 {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_4217;

      class_1506(IBinder var1) {
         this.field_4217 = var1;
      }

      public IBinder asBinder() {
         return this.field_4217;
      }

      // $FF: renamed from: h (com.google.android.gms.dynamic.d) void
      public void method_643(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSnapshotReady(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
