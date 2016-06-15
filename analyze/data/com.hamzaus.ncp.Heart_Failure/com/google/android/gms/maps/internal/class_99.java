package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;

// $FF: renamed from: com.google.android.gms.maps.internal.s
public interface class_99 extends IInterface {
   // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
   void method_597(class_157 var1) throws RemoteException;

   void onSnapshotReady(Bitmap var1) throws RemoteException;

   public abstract static class class_1183 extends Binder implements class_99 {
      public class_1183() {
         this.attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
      }

      // $FF: renamed from: aS (android.os.IBinder) com.google.android.gms.maps.internal.s
      public static class_99 method_3462(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ISnapshotReadyCallback");
            return (class_99)(var1 != null && var1 instanceof class_99?(class_99)var1:new class_99.class_1184(var0));
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
            this.g(class_157.class_1317.method_4176(var2.readStrongBinder()));
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

   private static class class_1184 implements class_99 {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3615;

      class_1184(IBinder var1) {
         this.field_3615 = var1;
      }

      public IBinder asBinder() {
         return this.field_3615;
      }

      // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
      public void method_597(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSnapshotReady(Bitmap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
